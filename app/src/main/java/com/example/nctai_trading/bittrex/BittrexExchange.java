/*
 * *
 *  This file is part of the bittrex4j project.
 *
 *  @author CCob
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 * /
 */

package com.example.nctai_trading.bittrex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.bidesk.domain.market.OrderBookEntry;
import com.example.nctai_trading.kiteConnect.Tick;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.signalr4j.client.ConnectionState;
import com.github.signalr4j.client.hubs.HubConnection;
import com.github.signalr4j.client.hubs.HubProxy;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.DeflateInputStream;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

import com.example.nctai_trading.bittrex.OrderBook.TYPE;

public class BittrexExchange implements AutoCloseable {


    public enum Interval{
        oneMin,
        fiveMin,
        thirtyMin,
        hour,
        day
    }

    private static Logger log = LoggerFactory.getLogger(BittrexExchange.class);
    private static Logger log_sockets = LoggerFactory.getLogger(BittrexExchange.class.getName().concat(".WebSockets"));
    private static final String MARKET = "market", MARKETS = "markets", CURRENCY = "currency", CURRENCIES = "currencies", ACCOUNT = "account", PUBLIC="public";
    private static final List<String> terminalErrors = Arrays.asList("INSUFFICIENT_FUNDS","APIKEY_INVALID");

    private ApiKeySecret apiKeySecret;
    private ObjectMapper mapper;
    private HttpClient httpClient;
    private HubConnection hubConnection;
    private HubProxy hubProxy;
    private HttpClientContext httpClientContext;
    private HttpFactory httpFactory;
    private List<String> marketSubscriptions = new ArrayList<>();
    private Observable<UpdateExchangeState> updateExchangeStateBroker = new Observable<>();
    private Observable<ExchangeSummaryState> exchangeSummaryStateBroker = new Observable<>();
    private Observable<OrderDelta> orderDeltaStateBroker = new Observable<>();
    private Observable<Throwable> websockerErrorListener = new Observable<>();
    private Observable<ConnectionStateChange> websocketStateChangeListener = new Observable<>();
    private Observable<BalanceDelta> balanceDeltaStateBroker = new Observable<>();
    private Runnable connectedHandler;

    private JavaType updateExchangeStateType;
    private JavaType exchangeSummaryStateType;
    private JavaType orderDeltaStateType;
    private JavaType balanceDeltaStateType;

    private Timer reconnectTimer = new Timer();

    private int retries;
    private boolean reconnect;

    private class ReconnectTimerTask extends TimerTask{
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            log.info("Attempting to reconnect to web socket");
            startConnection();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public BittrexExchange() {
        this(5);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public BittrexExchange(String apikey, String secret) {
        this(5,apikey,secret,new HttpFactory());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public BittrexExchange(int retries) {
        this(retries,null,null);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public BittrexExchange(int retries, String apikey, String secret) {
        this(retries,apikey,secret,new HttpFactory());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public BittrexExchange(int retries, String apikey, String secret, HttpFactory httpFactory) {
        this.apiKeySecret = new ApiKeySecret(apikey,secret);
        this.httpFactory = httpFactory;
        this.retries = retries;
        this.reconnect = retries > 0;

        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ZonedDateTime.class, new DateTimeDeserializer());
        mapper.registerModule(module);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        updateExchangeStateType = mapper.getTypeFactory().constructType(UpdateExchangeState.class);
        exchangeSummaryStateType = mapper.getTypeFactory().constructType(ExchangeSummaryState.class);
        orderDeltaStateType = mapper.getTypeFactory().constructType(OrderDelta.class);
        balanceDeltaStateType = mapper.getTypeFactory().constructType(BalanceDelta.class);

        httpClient = httpFactory.createClient();
        httpClientContext = httpFactory.createClientContext();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean performCloudFlareAuthorization() throws IOException {

        try {
            httpClientContext = httpFactory.createClientContext();
            CloudFlareAuthorizer cloudFlareAuthorizer = new CloudFlareAuthorizer(httpClient,httpClientContext);
            return cloudFlareAuthorizer.getAuthorizationResult("https://bittrex.com");
        } catch (Exception e) {
            log.error("Failed to perform CloudFlare authorization",e);
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void prepareHubConnectionForCloudFlare(){
        String cookies = httpClientContext.getCookieStore().getCookies()
                .stream()
                .map(cookie -> String.format("%s=%s", cookie.getName(), cookie.getValue()))
                .collect(Collectors.joining(";"));

        hubConnection.getHeaders().put("Cookie",cookies);
        hubConnection.getHeaders().put(HttpHeaders.USER_AGENT, Utils.getUserAgent());
    }

    @Override
    public void close() throws IOException {
        disconnectFromWebSocket();
    }

    public void onUpdateSummaryState(UpdateSummaryStateListener exchangeSummaryState){
        exchangeSummaryStateBroker.addObserver(exchangeSummaryState);
    }

    public void onUpdateExchangeState(UpdateExchangeStateListener listener){
        updateExchangeStateBroker.addObserver(listener);
    }

    public void onWebsocketError(Listener<Throwable> listener){
        websockerErrorListener.addObserver(listener);
    }

    public void onWebsocketStateChange(Listener<ConnectionStateChange> listener){
        websocketStateChangeListener.addObserver(listener);
    }

    public void onOrderStateChange(Listener<OrderDelta> listener){
        orderDeltaStateBroker.addObserver(listener);
    }

    public void onBalanceStateChange(Listener<BalanceDelta> listener){
        balanceDeltaStateBroker.addObserver(listener);
    }

    private InputStream decode(String wireData) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decodeBase64(wireData.getBytes()));
        return new DeflateInputStream(bais);
    }

    @SuppressWarnings("unchecked")
    private  void registerForEvent(String eventName, JavaType deltasType, Observable broker){
        hubProxy.on(eventName, deltas -> {
            try {
                broker.notifyObservers(mapper.readerFor(deltasType).readValue(decode(deltas)));
            } catch (IOException e) {
                log.error("Failed to parse response",e);
            }
        }, String.class);
    }


    public void subscribeToExchangeDeltas(String marketName, InvocationResult<Boolean> invocationResult) {
        hubProxy.invoke(Boolean.class,"subscribeToExchangeDeltas", marketName)
                .done(result -> {
                    marketSubscriptions.add(marketName);
                    if(invocationResult != null) {
                        invocationResult.complete(result);
                    }
                });
    }

    public void subscribeToMarketSummaries(InvocationResult<Boolean> invocationResult) {
        hubProxy.invoke(Boolean.class, "SubscribeToSummaryDeltas")
                .done(result -> {if(invocationResult != null) invocationResult.complete(result);});
    }

    public void queryExchangeState(String marketName, UpdateExchangeStateListener updateExchangeStateListener) {
        hubProxy.invoke(String.class, "queryExchangeState", marketName)
                .done(exchangeState -> {
                    //exchangeState.putIfAbsent("MarketName", marketName);
                    updateExchangeStateListener
                            .onEvent(mapper.readerFor(updateExchangeStateType).readValue(decode(exchangeState)));
                });
    }

    public void disconnectFromWebSocket(){
        hubConnection.stop();
    }

    private void connectedToWebSocket(){

        if(apiKeySecret != null && apiKeySecret.getKey() != null && apiKeySecret.getSecret() != null) {
            hubProxy.invoke(String.class,"GetAuthContext",apiKeySecret.getKey())
                    .done(challenge -> {
                        String signature = EncryptionUtility.calculateHash(apiKeySecret.getSecret(),challenge,"HmacSHA512");
                        hubProxy.invoke(Boolean.class,"Authenticate",apiKeySecret.getKey(),signature)
                                .done(authenticated -> {
                                    if(!authenticated){
                                        log.error("Failed to authenticate for account-level notifications");
                                    }else{
                                        log.debug("Successfully authenticated for account-level notifications");
                                    }
                                    connectedHandler.run();
                                });
                    })
                    .onError(error -> {
                        log.error("Failed to authenticate on websocket, is the API key valid?  Auth");
                    });
        }else{
            connectedHandler.run();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void startConnection(){
        try {
            SignalRCriticalLogger logger = new SignalRCriticalLogger(log_sockets);
            hubConnection = httpFactory.createHubConnection("https://socket.bittrex.com",null,true, logger);

            hubConnection.setReconnectOnError(false);

            hubProxy = hubConnection.createHubProxy("c2");
            hubConnection.connected(this::connectedToWebSocket);

            registerForEvent("uS", exchangeSummaryStateType,exchangeSummaryStateBroker);
            registerForEvent("uE", updateExchangeStateType,updateExchangeStateBroker);
            registerForEvent("uO", orderDeltaStateType,orderDeltaStateBroker);
            registerForEvent("uB", balanceDeltaStateType,balanceDeltaStateBroker);

            setupErrorHandler();
            setupStateChangeHandler();

            while(!performCloudFlareAuthorization()){}
            prepareHubConnectionForCloudFlare();

            hubConnection.start();

        } catch (IOException e) {
            if(log.isDebugEnabled()){
                log.error("Failed to perform CloudFlare authorization on startup", e);
            } else {
                log.error("Failed to perform CloudFlare authorization on startup: {}", e.toString());
            }
            if (reconnect)
                reconnectTimer.schedule(new ReconnectTimerTask(),5000);
        }
    }

    private void setupErrorHandler(){
        hubConnection.error( er -> websockerErrorListener.notifyObservers(er));
    }

    private void setupStateChangeHandler() {
        hubConnection.stateChanged((oldState, newState) -> {
                    if (newState == ConnectionState.Disconnected) {
                        if (reconnect)
                            reconnectTimer.schedule(new ReconnectTimerTask(), 5000);
                    }
                    websocketStateChangeListener.notifyObservers(new ConnectionStateChange(oldState, newState));
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void connectToWebSocket(Runnable connectedHandler) throws IOException {
        this.connectedHandler = connectedHandler;
        startConnection();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getTicks(String market, Interval tickInterval){
        return getResponse(new TypeReference<Response<com.example.nctai_trading.kiteConnect.Tick[]>>(){}, UrlBuilder.v2()
                .withGroup(MARKET)
                .withMethod("getticks")
                .withArgument("marketname",market)
                .withArgument("tickInterval",tickInterval.toString()));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getLatestTick(String market, Interval tickInterval){
        return getResponse(new TypeReference<Response<Tick[]>>(){}, UrlBuilder.v2()
                .withGroup(MARKET)
                .withMethod("getlatesttick")
                .withArgument("marketname",market)
                .withArgument("tickInterval",tickInterval.toString()));
    }

    /*
     * v2 version of getMarketSummary seems to return a different market than requested on occassion,
     * so both v1 and v2 flavors are available
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarketSummary(String market) {
        return getResponse(new TypeReference<Response<MarketSummary>>(){}, UrlBuilder.v2()
                .withGroup(MARKET)
                .withMethod("getmarketsummary")
                .withArgument("marketname",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarketSummaryV1(String market) {
        return getResponse(new TypeReference<Response<MarketSummary[]>>(){}, UrlBuilder.v1_1()
                .withGroup(PUBLIC)
                .withMethod("getmarketsummary")
                .withArgument("market",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<?> getOrderBook(String market, OrderBook.TYPE type) {
        if (type == TYPE.buy || type == TYPE.sell) {
            return getResponse(new TypeReference<Response<OrderBookEntry[]>>(){}, UrlBuilder.v1_1()
                    .withGroup(PUBLIC)
                    .withMethod("getorderbook")
                    .withArgument("market", market)
                    .withArgument("type", type.toString()));
        } else {
            return getResponse(new TypeReference<Response<OrderBook>>(){}, UrlBuilder.v1_1()
                    .withGroup(PUBLIC)
                    .withMethod("getorderbook")
                    .withArgument("market", market)
                    .withArgument("type", TYPE.both.toString()));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarketOrderBook(String market) {
        return getResponse(new TypeReference<Response<MarketOrdersResult>>(){}, UrlBuilder.v2()
                .withGroup(MARKET)
                .withMethod("getmarketorderbook")
                .withArgument("marketname",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarketHistory(String market) {
        return getResponse(new TypeReference<Response<CompletedOrder[]>>(){}, UrlBuilder.v1_1()
                .withGroup(PUBLIC)
                .withMethod("getmarkethistory")
                .withArgument("market",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOpenOrders(String market){
        return getOpenOrders(market,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOpenOrders(String market, ApiKeySecret credentials){
        return getResponse(new TypeReference<Response<Order[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(credentials.getKey(),credentials.getSecret())
                .withGroup(MARKET)
                .withMethod("getopenorders")
                .withArgument("marketname",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOpenOrders(){
        return getOpenOrders(apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOpenOrders(ApiKeySecret apiKeySecret){
        return getResponse(new TypeReference<Response<Order[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(), apiKeySecret.getSecret())
                .withGroup(MARKET)
                .withMethod("getopenorders"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarketSummaries() {
        return getResponse(new TypeReference<Response<MarketSummaryResult[]>>(){}, UrlBuilder.v2()
                .withGroup(MARKETS)
                .withMethod("getmarketsummaries"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getMarkets() {
        return getResponse(new TypeReference<Response<Market[]>>(){}, UrlBuilder.v1_1()
                .withGroup(PUBLIC)
                .withMethod("getmarkets"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Currency[]> getCurrencies() {
        return getResponse(new TypeReference<retrofit2.Response<Currency[]>>(){}, UrlBuilder.v2()
                .withGroup(CURRENCIES)
                .withMethod("getcurrencies"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getTicker(String market) {
        return getResponse(new TypeReference<Response<Ticker>>(){}, UrlBuilder.v1_1()
                .withGroup(PUBLIC)
                .withMethod("getticker"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getWalletHealth() {
        return getResponse(new TypeReference<Response<WalletHealthResult[]>>(){}, UrlBuilder.v2()
                .withGroup(CURRENCIES)
                .withMethod("getwallethealth"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOrderHistory(String market) {
        return getOrderHistory(market,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOrderHistory(String market, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<Order[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getorderhistory")
                .withArgument("market",market));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOrderHistoryNoArg(ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<Order[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getorderhistory"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getBalances() {
        return getBalances(apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getBalances(ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<Balance[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getbalances"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getBalance(String currency) {
        return getBalance(currency,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getBalance(String currency, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<Balance>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getbalance")
                .withArgument("currency",currency));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOrder(String uuid) {
        return getOrder(uuid,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getOrder(String uuid, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<Order>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getorder")
                .withArgument("uuid",uuid));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getDepositAddress(String currency) {
        return getDepositAddress(currency,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getDepositAddress(String currency, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<DepositAddress>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getdepositaddress")
                .withArgument("currency",currency));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getWithdrawalHistory(String currency) {
        return getWithdrawalHistory(currency,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getWithdrawalHistory(String currency, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<WithdrawalDeposit[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getwithdrawalhistory")
                .withArgument("currency",currency));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getDepositHistory(String currency) {
        return getDepositHistory(currency,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> getDepositHistory(String currency, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<WithdrawalDeposit[]>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("getdeposithistory")
                .withArgument("currency",currency));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> withdraw(String currency, double quantity, String address) {
        return withdraw(currency,quantity,address,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> withdraw(String currency, double quantity, String address, ApiKeySecret apiKeySecret) {
        return getResponse(new TypeReference<Response<UuidResult>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(ACCOUNT)
                .withMethod("withdraw")
                .withArgument("currency",currency)
                .withArgument("quantity", BigDecimal.valueOf(quantity).toString())
                .withArgument("address",address));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> buyLimit(String market, double quantity, double rate){
        return buyLimit(market,quantity,rate,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> buyLimit(String market, double quantity, double rate, ApiKeySecret apiKeySecret){
        return getResponse(new TypeReference<Response<UuidResult>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(MARKET)
                .withMethod("buylimit")
                .withArgument("market",market)
                .withArgument("quantity",Double.toString(quantity))
                .withArgument("rate",Double.toString(rate)));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> sellLimit(String market, double quantity, double rate){
        return sellLimit(market,quantity,rate,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<Object> sellLimit(String market, double quantity, double rate, ApiKeySecret apiKeySecret){
        return getResponse(new TypeReference<Response<UuidResult>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(MARKET)
                .withMethod("selllimit")
                .withArgument("market",market)
                .withArgument("quantity",Double.toString(quantity))
                .withArgument("rate",Double.toString(rate)));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<?> cancel(String orderUuid){
        return cancel(orderUuid,apiKeySecret);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public retrofit2.Response<?> cancel(String orderUuid, ApiKeySecret apiKeySecret){
        return getResponse(new TypeReference<retrofit2.Response<?>>(){}, UrlBuilder.v1_1()
                .withApiKey(apiKeySecret.getKey(),apiKeySecret.getSecret())
                .withGroup(MARKET)
                .withMethod("cancel")
                .withArgument("uuid",orderUuid));
    }

    private boolean isTerminalError(String message){
        return terminalErrors.contains(message);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private <Result> retrofit2.Response<Result> getResponse(TypeReference resultType, UrlBuilder urlBuilder ) {

        int triesLeft = retries;
        retrofit2.Response<Result> result = getResponseBody(resultType, urlBuilder);

        while(!result.isSuccessful() && triesLeft-- > 0 && !isTerminalError(result.message())){
            log.warn("Request to URL {} failed with error {}, retries left: {}",urlBuilder.build(),result.message(),triesLeft);
            result = getResponseBody(resultType, urlBuilder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        if(!result.isSuccessful()){
            log.warn("Request to URL {} failed with error {}",urlBuilder.build(),result.message());
        }

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private <Result> retrofit2.Response<Result> getResponseBody(TypeReference resultType, UrlBuilder urlBuilder) {

        CloseableHttpResponse httpResponse = null;

        try {
            HttpGet request;
            String url;

            if(urlBuilder.isSecure()) {
                ApiKeySecret builderApiSecret = urlBuilder.getApiKeySecret();
                urlBuilder.withArgument("nonce",EncryptionUtility.generateNonce());
                url = urlBuilder.build();
                request = new HttpGet(url);
                request.addHeader("apisign", EncryptionUtility.calculateHash(builderApiSecret.getSecret(), url, "HmacSHA512")); // Attaches signature as a header
            }else{
                request = new HttpGet(urlBuilder.build());
            }

            request.addHeader("accept", "application/json");

            int hardTimeout = 60; // seconds
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    request.abort();
                }
            };
            new Timer(true).schedule(task, hardTimeout * 1000);

            log.debug("Executing HTTP request: {}",request.toString());
            httpResponse = (CloseableHttpResponse)httpClient.execute(request,httpClientContext);

            int responseCode = httpResponse.getStatusLine().getStatusCode();
            if(responseCode == 200) {
                String json = Utils.convertStreamToString(httpResponse.getEntity().getContent());
                log.trace("REST JSON result: {}",json);
                task.cancel();
                return mapper.readerFor(resultType).readValue(json);
            }else{
                log.warn("HTTP request failed with error code {} and reason {}",responseCode,httpResponse.getStatusLine().getReasonPhrase());
                task.cancel();
                //return new retrofit2.Response<>(false,httpResponse.getStatusLine().getReasonPhrase(),null, "");
                return null;
            }

        } catch (NoSuchAlgorithmException | IOException | InvalidKeyException e) {
            //return new retrofit2.Response<>(false,e.getMessage(),null, "");
            return null;
        } finally {

            if(httpResponse != null){
                try {
                    httpResponse.getEntity().getContent().close();
                    httpResponse.close();
                } catch (IOException e) {
                    log.debug("Failed to cleanup HttpResponse",e);
                }
            }
        }
    }
}
