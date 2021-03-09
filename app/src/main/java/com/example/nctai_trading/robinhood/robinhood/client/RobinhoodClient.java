package com.example.nctai_trading.robinhood.robinhood.client;

import android.os.Build;

import androidx.annotation.RequiresApi;


import com.example.nctai_trading.robinhood.http.client.*;
import com.example.nctai_trading.robinhood.RobinhoodAPI;
import com.example.nctai_trading.robinhood.robinhood.exception.RobinhoodException;
import com.example.nctai_trading.robinhood.robinhood.data.*;
import com.example.nctai_trading.robinhood.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

@Data
@Slf4j
public class RobinhoodClient implements RobinhoodAPI {

    private final HashMap<String, String> headers = new HashMap<String, String>() {{
        put("Accept", "*/*");
        put("Accept-Encoding", "gzip, deflate");
        put("Accept-Language", "en;q=1, fr;q=0.9, de;q=0.8, ja;q=0.7, nl;q=0.6, it;q=0.5");
        put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        put("X-Robinhood-API-Version", "1.70.0");
        put("Connection", "keep-alive");
        put("User-Agent", "Robinhood/823 (iPhone; iOS 7.1.2; Scale/2.00)");
    }};

    private final HashMap<String, String> endpoints = new HashMap<String, String>() {{
        //put("login", "https://api.robinhood.com/api-token-auth/");
        put("login", "https://api.robinhood.com/oauth2/token/");
        put("investment_profile", "https://api.robinhood.com/user/investment_profile/");
        put("accounts", "https://api.robinhood.com/accounts/");
        put("ach_iav_auth", "https://api.robinhood.com/ach/iav/auth/");
        put("ach_relationships", "https://api.robinhood.com/ach/relationships/");
        put("ach_transfers", "https://api.robinhood.com/ach/transfers/");
        put("applications", "https://api.robinhood.com/applications/");
        put("dividends", "https://api.robinhood.com/dividends/");
        put("edocuments", "https://api.robinhood.com/documents/");
        put("instruments", "https://api.robinhood.com/instruments/");
        put("margin_upgrades", "https://api.robinhood.com/margin/upgrades/");
        put("markets", "https://api.robinhood.com/markets/");
        put("notifications", "https://api.robinhood.com/notifications/");
        put("orders", "https://api.robinhood.com/orders/");
        put("password_reset", "https://api.robinhood.com/password_reset/request/");
        put("quotes", "https://api.robinhood.com/quotes/");
        put("document_requests", "https://api.robinhood.com/upload/document_requests/");
        put("user", "https://api.robinhood.com/user/");
        put("user/additional_info", "https://api.robinhood.com/user/additional_info/");
        put("user/basic_info", "https://api.robinhood.com/user/basic_info/");
        put("user/employment", "https://api.robinhood.com/user/employment/");
        put("user/investment_profile", "https://api.robinhood.com/user/investment_profile/");
        put("watchlists", "https://api.robinhood.com/watchlists/");
    }};

    private static final List<String> REQUIRED_ENDPOINT_KEYS = ImmutableList.of("positions", "portfolio", "account");

    private final HTTPClient httpClient = new HTTPClient();

    private String username;
    private String password;

    public RobinhoodClient(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    private boolean isLoggedIn() {
        if (!headers.containsKey("Authorization")) {
            return false;
        }

        for (final String key : REQUIRED_ENDPOINT_KEYS) {
            if (!endpoints.containsKey(key)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void doLoginRoutine() {
        try {
            this.doLogin();
            this.acquireAccountInfo();

        } catch (final Exception e) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void verifyLoginStatus() throws RobinhoodException {
        if (!isLoggedIn()) {
            doLoginRoutine();
        }
        if (!isLoggedIn()) {
            throw new RobinhoodException("Login failed!");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void doLogin() throws RobinhoodException {


        Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPPostRequest(new HTTPQuery(endpoints.get("login"), ImmutableMap.of("username", username, "password", password), headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final String jsonData = httpResult.get().getBody();

        Optional<Map<String, String>> responseMap =
                JSONUtil.deserializeString(jsonData, new TypeReference<Map<String, String>>() {});

        if (!responseMap.isPresent()) {
            throw new RobinhoodException(String.format("Unable to deserialize response of [%s]", httpResult));
        }

        headers.put("Authorization", "Token " + responseMap.get().get("token"));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void acquireAccountInfo() throws RobinhoodException {


        final Optional<HTTPResult> getResponse = this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("accounts"), ImmutableMap.of(), headers));

        if (!getResponse.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        Optional<Map<String, List<Map<String, Object>>>> callResults =
                JSONUtil.deserializeString(getResponse.get().getBody(), new TypeReference<Map<String, List<Map<String, Object>>>>() {});

        if (!callResults.isPresent()) {
            throw new RobinhoodException(String.format("Unable to deserialize response of [%s]", getResponse));
        }

        Map<String, List<Map<String, Object>>> accountsMap = callResults.get();

        final String positionsUrlStr = (String) accountsMap.get("results").get(0).get("positions");
        final String portfolioUrlStr = (String) accountsMap.get("results").get(0).get("portfolio");
        final String accountUrlStr = (String) accountsMap.get("results").get(0).get("url");

        final String accountNumber = (String) accountsMap.get("results").get(0).get("account_number");
        final String portfolioHistoricals = "https://api.robinhood.com/portfolios/historicals/" + accountNumber;

        endpoints.put("positions", positionsUrlStr);
        endpoints.put("portfolio", portfolioUrlStr);
        endpoints.put("portfolios_historicals", portfolioHistoricals);
        endpoints.put("account", accountUrlStr);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Order placeLimitOrder(final String symbol, final int shares, final String side, final double limit) throws RobinhoodException, JSONException {
        final Optional<Instrument> instrumentOptional = getInstrumentForSymbol(symbol);

        if (!instrumentOptional.isPresent()) {
            throw new RobinhoodException(String.format("Unable to determine instrument for symbol %s", symbol));
        }

        final Instrument instrument = instrumentOptional.get();

        final String maxPriceStr = String.format("%.2f", limit);



        final Map<String, String> params =
                ImmutableMap.<String, String>builder().put("account", endpoints.get("account"))
                        .put("extended_hours", "true")
                        .put("override_dtbp_checks", "false")
                        .put("instrument", instrument.getUrl())
                        .put("side", side)
                        .put("quantity", String.valueOf(shares))
                        .put("symbol", symbol)
                        .put("time_in_force", "gfd")
                        .put("trigger", "immediate")
                        .put("price", maxPriceStr)
                        .put("type", "limit")
                        .build();

        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPPostRequest(new HTTPQuery(endpoints.get("orders"), params, headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final String jsonData = httpResult.get().getBody();



        JSONObject jsonObj = new JSONObject(jsonData);

        if (jsonObj.has("non_field_errors")) {

            throw new RobinhoodException("Bad response from Robinhood.");
        }

        if (jsonObj.has("detail")) {
            throw new RobinhoodException(String.format("Got unexpected response from Robinhood [%s]", jsonObj));
        }

        if (!jsonObj.isNull("reject_reason")) {
            throw new RobinhoodException(String.format("Got unexpected response from Robinhood [%s]", jsonObj));
        }

        final Optional<Order> placedOrder = JSONUtil.deserializeObject(jsonData, Order.class);

        if (!placedOrder.isPresent()) {

            throw new RobinhoodException(String.format("Got unexpected response from Robinhood [%s]", jsonObj));
        }

        final Order order = placedOrder.get();

        if (StringUtils.isEmpty(order.getId())) {

            throw new RobinhoodException(String.format("Got unexpected response from Robinhood [%s]", jsonObj));
        }

        return order;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Order buyShares(final String symbol, final int shares, final double limit) throws RobinhoodException, JSONException {
        verifyLoginStatus();
        return placeLimitOrder(symbol, shares, "buy", limit);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Order sellShares(final String symbol, final int shares, final double limit) throws RobinhoodException, JSONException {
        verifyLoginStatus();
        return placeLimitOrder(symbol, shares, "sell", limit);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Order> getOrderFromURL(final String orderURL) throws RobinhoodException {
        final Optional<HTTPResult> httpResult = this.httpClient.executeHTTPGetRequest(new HTTPQuery(orderURL, ImmutableMap.of(), headers));


        if (!httpResult.isPresent()) {
            return Optional.empty();
        }

        Optional<Order> orderOptional = JSONUtil.deserializeObject(httpResult.get().getBody(), Order.class);

        return orderOptional;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<EquityHistorical> getHistoricalValues(final String span, final String interval, final String bounds) throws RobinhoodException, JSONException {
        verifyLoginStatus();

        final List<EquityHistorical> historicalValues = new ArrayList<>();

        Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("portfolios_historicals"),
                        ImmutableMap.of("span", span,
                                "interval", interval,
                                "bounds", bounds), headers));

        final JSONObject jsonObj = new JSONObject(httpResult.get().getBody());

        final JSONArray equitiesListObj = jsonObj.getJSONArray("equity_historicals");


        for(int i = 0; i < equitiesListObj.length(); i++) {
            if (!(equitiesListObj.getJSONObject(i) instanceof JSONObject)) {
                continue;
            }

            final Optional<EquityHistorical> equityOptional = JSONUtil.deserializeObject(equitiesListObj.getJSONObject(i).toString(), EquityHistorical.class);

            if (!equityOptional.isPresent()) {
                continue;
            }

            historicalValues.add(equityOptional.get());
        }

        return historicalValues;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Quote> getQuotes(final Collection<String> symbols) throws RobinhoodException {
        if (CollectionUtils.isEmpty(symbols)) {
            return Collections.emptyList();
        }

        Map<String, String> params = ImmutableMap.of("symbols", Joiner.on(',').join(symbols));
        Optional<HTTPResult> httpResult = this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("quotes"), params, headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final String jsonData = httpResult.get().getBody();

        final Optional<Map<String, List<Quote>>> mapResult =
                JSONUtil.deserializeString(jsonData, new TypeReference<Map<String, List<Quote>>>() {});

        if (!mapResult.isPresent()) {
            throw new RobinhoodException(String.format("Unable to deserialize response of [%s]", jsonData));
        }

        final List<Quote> quotes = mapResult.get().get("results");

        quotes.removeIf(Objects::isNull);

        return quotes;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Quote getQuote(final String symbol) throws RobinhoodException {
        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("quotes"), ImmutableMap.of("symbols", symbol), headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response when getting quotes!");
        }

        final String jsonData = httpResult.get().getBody();

        final Optional<Map<String, List<Quote>>> mapResult =
                JSONUtil.deserializeString(jsonData, new TypeReference<Map<String, List<Quote>>>() {});

        if (!mapResult.isPresent()) {
            throw new RobinhoodException(String.format("Unable to deserialize response of [%s]", jsonData));
        }

        return mapResult.get().get("results").get(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Instrument> getInstrumentFromURL(final String instrumentURL) {
        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(instrumentURL, ImmutableMap.of(), headers));

        if (!httpResult.isPresent()) {
            return Optional.empty();
        }

        Optional<Instrument> instrumentOptional = JSONUtil.deserializeObject(httpResult.get().getBody(), Instrument.class);

        return instrumentOptional;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Portfolio getPortfolio() throws RobinhoodException {
        verifyLoginStatus();

        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("portfolio"), ImmutableMap.of(), headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final Optional<Portfolio> portfolioOptional = JSONUtil.deserializeObject(httpResult.get().getBody(), Portfolio.class);

        if (!portfolioOptional.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        return portfolioOptional.get();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Instrument> getInstrumentForSymbol(final String symbol) throws JSONException {
        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("instruments"), ImmutableMap.of("symbol", symbol), headers));

        if (!httpResult.isPresent()) {
            return Optional.empty();
        }

        final JSONObject jsonObj = new JSONObject(httpResult.get().getBody());

        final JSONArray jsonArray = jsonObj.getJSONArray("results");

        if (jsonArray.length() <= 0) {
            return Optional.empty();
        }

        final JSONObject jsonInstrumentObj = jsonArray.getJSONObject(0);

        final Optional<Instrument> instrumentOptional = JSONUtil.deserializeObject(jsonInstrumentObj.toString(), Instrument.class);

        return instrumentOptional;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public MarginBalances getMarginBalances() throws RobinhoodException, JSONException {
        verifyLoginStatus();

        final Optional<HTTPResult> httpResult =
                this.httpClient.executeHTTPGetRequest(new HTTPQuery(endpoints.get("account"), ImmutableMap.of(), headers));

        if (!httpResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final JSONObject jsonObj = new JSONObject(httpResult.get().getBody());

        Optional<MarginBalances> marginBalancesOptional = Optional.empty();

        if (!jsonObj.isNull("margin_balances")) {
            final JSONObject marginBalancesObj = jsonObj.getJSONObject("margin_balances");
            marginBalancesOptional = JSONUtil.deserializeObject(marginBalancesObj.toString(), MarginBalances.class);
        }

        if (!marginBalancesOptional.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }



        return marginBalancesOptional.get();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Set<Instrument> getAllInstruments() throws JSONException {

        String instrumentsURL = endpoints.get("instruments");

        final Set<Instrument> allInstruments = new HashSet<>();

        final Collection<HTTPResult> httpResults = scrapePaginatedAPI(instrumentsURL, ImmutableMap.of(), headers);

        for (final HTTPResult httpResult : httpResults) {
            final JSONObject callResult = new JSONObject(httpResult.getBody());

            final JSONArray instrumentsListObj = callResult.getJSONArray("results");

            for (int i = 0; i < instrumentsListObj.length(); i++){
                if (!(instrumentsListObj.getJSONObject(i) instanceof JSONObject)) {
                    continue;
                }

                Optional<Instrument> instrumentOptional = JSONUtil.deserializeObject(instrumentsListObj.getJSONObject(i).toString(), Instrument.class);

                if (!instrumentOptional.isPresent()) {

                    continue;
                }

                allInstruments.add(instrumentOptional.get());
            }
        }

        return allInstruments;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Collection<HTTPResult> scrapePaginatedAPI(final String url, final Map<String, String> parameters, final Map<String, String> headers) throws JSONException {
        final Set<HTTPResult> httpResults = new HashSet<>();

        String urlToQuery = url;

        while (urlToQuery != null && !"null".equalsIgnoreCase(urlToQuery)) {


            final Optional<HTTPResult> getResult = this.httpClient.executeHTTPGetRequest(new HTTPQuery(urlToQuery, parameters, headers));

            if (!getResult.isPresent()) {
                break;
            }

            final JSONObject callResult = new JSONObject(getResult.get().getBody());

            final int sleepSeconds = Integer.valueOf(getResult.get().getHeaders().getOrDefault("Retry-After", "0"));

            if (sleepSeconds > 0) {
                try {
                    Thread.sleep(sleepSeconds * 1000);
                } catch (final InterruptedException e) {

                }
                continue;
            }

            httpResults.add(getResult.get());

            urlToQuery = String.valueOf(callResult.get("next"));
        }

        return httpResults;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Position> getPositions() throws RobinhoodException, JSONException {
        verifyLoginStatus();



        final List<Position> positions = new ArrayList<>();

        final Collection<HTTPResult> httpResults = scrapePaginatedAPI(endpoints.get("positions"), ImmutableMap.of(), headers);

        for (final HTTPResult httpResult : httpResults) {
            final JSONObject jsonResult = new JSONObject(httpResult.getBody());

            final JSONArray instrumentsListObj = jsonResult.getJSONArray("results");



            for(int i = 0; i < instrumentsListObj.length(); i++){
                if (!(instrumentsListObj.getJSONObject(i) instanceof JSONObject)) {
                    continue;
                }

                Optional<Position> positionOptional = JSONUtil.deserializeObject(instrumentsListObj.getJSONObject(i).toString(), Position.class);

                if (!positionOptional.isPresent()) {

                    continue;
                }

                final Position position = positionOptional.get();

                if (Double.valueOf(position.getQuantity()).equals(0d)) {
                    continue;
                }

                positions.add(position);
            }
        }

        return positions;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Collection<Order> getOrdersAfterDate(final Date date) throws RobinhoodException, JSONException {
        verifyLoginStatus();

        final Collection<Order> allOrders = new HashSet<>();

        final String dateStr = TimeUtil.createStrFromDate(date, "yyyy-MM-dd'T'HH:mm:ss.000000'Z'");

        final Collection<HTTPResult> httpResults = scrapePaginatedAPI(endpoints.get("orders"), ImmutableMap.of("updated_at[gte]", dateStr), headers);

        for (final HTTPResult httpResult : httpResults) {


            final JSONObject callResult = new JSONObject(httpResult.getBody());

            final JSONArray ordersListObj = callResult.getJSONArray("results");


            for(int i = 0; i < ordersListObj.length(); i++){
                if (!(ordersListObj.getJSONObject(i) instanceof JSONObject)) {
                    continue;
                }

                Optional<Order> order = JSONUtil.deserializeObject(ordersListObj.getJSONObject(i).toString(), Order.class);

                if (!order.isPresent()) {

                    continue;
                }

                allOrders.add(order.get());
            }
        }

        return allOrders;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public MarketState getMarketStateForDate(final DateTime dateTime) throws RobinhoodException {

        final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        final String dateString = formatter.print(dateTime);
        final String url = String.format("%s%s%s", endpoints.get("markets"), "XNAS/hours/", dateString);

        final Optional<HTTPResult> getResult = this.httpClient.executeHTTPGetRequest(new HTTPQuery(url, ImmutableMap.of(), headers));

        if (!getResult.isPresent()) {
            throw new RobinhoodException("Bad response from Robinhood.");
        }

        final Optional<Map<String, String>> responseObject =
                JSONUtil.deserializeString(getResult.get().getBody(), new TypeReference<Map<String, String>>() {});

        if (!responseObject.isPresent()) {
            throw new RobinhoodException(String.format("Unable to deserialize response of [%s]", getResult));
        }

        return new MarketState(responseObject.get());
    }

}
