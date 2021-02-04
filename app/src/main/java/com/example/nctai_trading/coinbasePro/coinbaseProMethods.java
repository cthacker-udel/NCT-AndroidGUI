package com.example.nctai_trading.coinbasePro;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits.TransferLimits;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*

@author - Cameron Thacker

coinbasePro API methods


 */ //

public class coinbaseProMethods {

    public String secretKey = "ufOMqTBzARwhCbNQmrazgDAk6ir4xjUyU1cH0kkV8k6b0X1hRI8ipcKs1beTwAQuoWDPUJ7dnhuqanAxKEVrXw==";
    public String apiKey = "17e5d0f33c9074a2f67c95cf0436fca9";
    public String baseUrl = "https://api.pro.coinbase.com";
    public String passPhrase = "NCTAI09AKATBE";

    public coinbaseProMethods(String newApi, String newSecret, String newPassphrase){
        this.secretKey = newSecret;
        this.apiKey = newApi;
        this.passPhrase = newPassphrase;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public HashMap<String,String> getAuthHeadersPOST(String method, String requestPath, Map<String,Object> newBody, String passPhrase) throws IOException {

        HashMap<String,String> data = new HashMap<>();
        data.put("accept","application/json");
        data.put("CB-ACCESS-KEY",apiKey);
        String timeStamp2 = Instant.now().getEpochSecond() + "";
        data.put("CB-ACCESS-SIGN",generateSignature(timeStamp2,method,requestPath,jsonStringifyMap(newBody)));
        data.put("CB-ACCESS-TIMESTAMP",timeStamp2);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);
        data.put("User-Agent","Java Client");
        data.put("content-type","Application/JSON");

        return data;
    }

    public String toJson(Object object){
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try{
            String json = objectMapper.writeValueAsString(object);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to serialize");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public HashMap<String,String> getAuthHeadersGET(String method, String requestPath, String passPhrase) throws IOException {


        String body = "";
        String timeStamp = getTimeStamp();
        String signature = generateSignature(timeStamp,method,requestPath,body);
        HashMap<String,String> data = new HashMap<>();
        data.put("Content-Type","Application/JSON");
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-TIMESTAMP",timeStamp);
        data.put("CB-ACCESS-KEY",apiKey);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);

        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public HashMap<String,String> getAuthHeadersBASE(String requestPath) throws IOException {

        String body = "";
        String method = "";
        String timeStamp = getTimeStamp();
        String signature = generateSignature(timeStamp,method,requestPath,body);
        HashMap<String,String> data = new HashMap<>();
        data.put("Content-Type","Application/JSON");
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-TIMESTAMP",timeStamp);
        data.put("CB-ACCESS-KEY",this.apiKey);
        data.put("CB-ACCESS-PASSPHRASE",this.passPhrase);

        return data;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateSignature(String timestamp, String method, String requestPath, String body){
        try{
            String prehash = timestamp + method.toUpperCase() + requestPath + body;
            byte[] secretDecoded = Base64.getDecoder().decode(secretKey);
            SecretKeySpec keySpec = new SecretKeySpec(secretDecoded, Mac.getInstance("HmacSHA256").getAlgorithm());
            Mac sha256 = Mac.getInstance("HmacSHA256");
            sha256.init(keySpec);
            return Base64.getEncoder().encodeToString(sha256.doFinal(prehash.getBytes()));
        }
        catch(InvalidKeyException | NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new RuntimeException(new Error("Cannot set up auth headers"));
        }
    }

    public Double getServerTime() throws IOException {

        String url = baseUrl + "/time/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCoinBaseProServerTime getCoinBaseProServerTime = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseProServerTime.class);
        Call<coinBaseProServerResponse> serverResponseCall = getCoinBaseProServerTime.getCoinBaseProServerTime();
        Response<coinBaseProServerResponse> serverResponseResponse = serverResponseCall.execute();
        return serverResponseResponse.body().getEpoch();

    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getTimeStamp() throws IOException {
        return String.valueOf(Instant.now().getEpochSecond());
    }

    public boolean isNumber(String value){
        try{
            Double.parseDouble(value);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public HashMap<String,String> call(String method1, String requestPath, HashMap<String,String> callData) throws IOException {
        String timestamp = getTimeStamp();
        String method = method1;
        if(callData != null) {
            String message = String.join("", new String[]{timestamp, method, requestPath,callData.toString().replaceAll(" ","")});
        }
        else{
            String message = String.join("",new String[]{timestamp,method,requestPath,"0"});
        }
        return new HashMap<String,String>();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public TreeMap<String,String[]> getAccountList() throws IOException {

        String url = this.baseUrl + "/accounts/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCoinBaseProAccounts getCoinBaseProAccounts = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseProAccounts.class);


        Call<List<coinBaseListAccount>> coinBaseProAccountsCall = getCoinBaseProAccounts.getAccounts(getAuthHeadersGET("GET","/accounts",passPhrase));

        Response<List<coinBaseListAccount>> coinBaseProAccountsResponse = coinBaseProAccountsCall.execute();

        List<coinBaseListAccount> accountList = coinBaseProAccountsResponse.body();

        double amount = 0;
        TreeMap<String,String[]> account = new TreeMap<>();
        for(coinBaseListAccount eachAccount: accountList){
            amount = Double.parseDouble(eachAccount.getBalance());
            if(amount <= 0){
                continue;
            }
            account.put(eachAccount.getId(),new String[]{eachAccount.getCurrency(),eachAccount.getBalance()});
        }
        return account;

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public ArrayList<String> getAccount(String id) throws IOException {

        String url = this.baseUrl + String.format("/accounts/%s/",id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCoinBaseAccount getCoinBaseAccount = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseAccount.class);

        Call<coinBaseAccount> getCoinBaseAccountCall = getCoinBaseAccount.getCoinBaseAccountCall(id, getAuthHeadersGET("GET",String.format("/accounts/%s",id),passPhrase));

        Response<coinBaseAccount> coinBaseAccountResponse = getCoinBaseAccountCall.execute();

        coinBaseAccount coinBaseAccount = coinBaseAccountResponse.body();

        ArrayList<String> accountDetails = new ArrayList<>();
        accountDetails.add(String.format("----------------\n Account ID : %s \n Currency : %s \n Balance %s \n Available : %s \n Holds : %s \n -------------------------\n",coinBaseAccount.getId(),coinBaseAccount.getCurrency(),coinBaseAccount.getBalance(),coinBaseAccount.getAvailable(),coinBaseAccount.getHolds()));
        return accountDetails;
    }

    class buyCurrency {

        private String buyCurrencyApiKey = "";
        private String buyCurrencySecretKey = "";
        private String passphrase = "";

        public buyCurrency() {
            super();
        }

        public buyCurrency(String newApi, String newSecret, String newPassPhrase) {
            this.buyCurrencyApiKey = newApi;
            this.buyCurrencySecretKey = newSecret;
            this.passphrase = newPassPhrase;
        }

        public void setBuyCurrencyApikey(String newKey) {
            this.buyCurrencyApiKey = newKey;
        }

        public void setBuyCurrencySecretKey(String newKey) {
            this.buyCurrencySecretKey = newKey;
        }

        public void setPassphrase(String newPassPhrase) {
            this.passphrase = newPassPhrase;
        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeOrderMarket(BigDecimal funds, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.coinbasePro.buyCoinBaseCurrency.class);

            HashMap<String, Object> data = new LinkedHashMap<>();
            String productId = "";
            if (currency2 == null) {
                productId = currency1 + "-USD";
            } else {
                productId = currency1 + "-" + currency2;
            }


            data.put("product_id", "BTC-USD");
            data.put("side", "buy");
            data.put("type", "market");
            data.put("funds", funds);
            String requestPath = "/orders";
            String method = "POST";

            HashMap<String, String> authHeaders = getAuthHeadersPOST(method, requestPath, data, passPhrase);

            Call<coinBaseProPurchase> getCoinBasePurchase = buyCoinBaseCurrency.buyCoinBasePro(authHeaders, data);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = getCoinBasePurchase.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getCreatedAt());
            System.out.println(result.getExecutedValue());

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeOrderLimit(BigDecimal price, BigDecimal size, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.coinbasePro.buyCoinBaseCurrency.class);

            HashMap<String,Object> data = new LinkedHashMap<>();
            String productId = "";
            if(currency2 == null){
                productId = currency1 + "-USD";
            }
            else{
                productId = currency1 + "-" + currency2;
            }

            data.put("product_id",productId);
            data.put("side","buy");
            data.put("type","limit");
            data.put("price",price);
            data.put("size",size);
            String requestPath = "/orders";
            String method = "POST";

            HashMap<String,String> authHeaders = getAuthHeadersPOST(method,requestPath,data,passPhrase);

            Call<coinBaseProPurchase> coinBaseProPurchaseCall = buyCoinBaseCurrency.buyCoinBasePro(authHeaders,data);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = coinBaseProPurchaseCall.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getExecutedValue());

        }

    }

    class sellCurrency{

        private String sellCurrencyApiKey = "";
        private String sellCurrencySecretKey = "";
        private String passphrase = "";

        public sellCurrency() {
            super();
        }

        public sellCurrency(String newApi, String newSecret, String newPassPhrase) {
            this.sellCurrencyApiKey = newApi;
            this.sellCurrencySecretKey = newSecret;
            this.passphrase = newPassPhrase;
        }

        public void setSellCurrencyApikey(String newKey) {
            this.sellCurrencyApiKey = newKey;
        }

        public void setSellCurrencySecretKey(String newKey) {
            this.sellCurrencySecretKey = newKey;
        }

        public void setPassphrase(String newPassPhrase) {
            this.passphrase = newPassPhrase;
        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeSellMarket(BigDecimal funds, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.coinbasePro.buyCoinBaseCurrency.class);

            HashMap<String, Object> data = new LinkedHashMap<>();
            String productId = "";
            if (currency2 == null) {
                productId = currency1 + "-USD";
            } else {
                productId = currency1 + "-" + currency2;
            }


            data.put("product_id", "BTC-USD");
            data.put("side", "sell");
            data.put("type", "market");
            data.put("funds", funds);
            String requestPath = "/orders";
            String method = "POST";

            HashMap<String, String> authHeaders = getAuthHeadersPOST(method, requestPath, data, passPhrase);

            Call<coinBaseProPurchase> getCoinBasePurchase = buyCoinBaseCurrency.buyCoinBasePro(authHeaders, data);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = getCoinBasePurchase.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getCreatedAt());
            System.out.println(result.getExecutedValue());

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeSellLimit(BigDecimal price, BigDecimal size, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.coinbasePro.buyCoinBaseCurrency.class);

            HashMap<String,Object> data = new LinkedHashMap<>();
            String productId = "";
            if(currency2 == null){
                productId = currency1 + "-USD";
            }
            else{
                productId = currency1 + "-" + currency2;
            }

            data.put("product_id",productId);
            data.put("side","sell");
            data.put("type","limit");
            data.put("price",price);
            data.put("size",size);
            String requestPath = "/orders";
            String method = "POST";

            HashMap<String,String> authHeaders = getAuthHeadersPOST(method,requestPath,data,passPhrase);

            Call<coinBaseProPurchase> coinBaseProPurchaseCall = buyCoinBaseCurrency.buyCoinBasePro(authHeaders,data);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = coinBaseProPurchaseCall.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getExecutedValue());

        }
    }

    class cancelOrder{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";


        public cancelOrder(){
            super();
        }

        public cancelOrder(String newApiKey, String newSecretKey, String newPassPhrase){
            cancelOrder.this.apiKey = newApiKey;
            cancelOrder.this.secretKey = newSecretKey;
            cancelOrder.this.passPhrase = newPassPhrase;
        }

        public boolean cancelId(String id){

            String url = baseUrl + String.format("/orders/%s/",id);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            cancelCoinBaseOrder cancelCoinBaseOrder = retrofit.create(com.example.nctai_trading.coinbasePro.cancelCoinBaseOrder.class);

            Response cancelCoinbaseOrder = cancelCoinBaseOrder.cancelCoinbaseOrder(id);


            assert cancelCoinbaseOrder.errorBody() != null;
            return cancelCoinbaseOrder.errorBody().contentLength() <= 0;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public boolean cancelAll() throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            cancelAllCoinBaseOrders cancelAllCoinBaseOrders = retrofit.create(com.example.nctai_trading.coinbasePro.cancelAllCoinBaseOrders.class);

            Call<List<String>> cancelAllOrders = cancelAllCoinBaseOrders.cancelAllOrders(getAuthHeadersBASE("/orders"));

            Response<List<String>> response = cancelAllOrders.execute();

            List<String> result = response.body();

            return result != null;
        }
    }

    class orderRequests{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";

        public orderRequests(){
            super();
        }

        public orderRequests(String ApiKey, String SecretKey, String PassPhrase){
            orderRequests.this.apiKey = ApiKey;
            orderRequests.this.secretKey = SecretKey;
            orderRequests.this.passPhrase = PassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public List<coinbaseOpenOrderListOrder> getOpenOrderList() throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinBaseOpenOrderList getCoinBaseOpenOrderList = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseOpenOrderList.class);

            HashMap<String,String> authHeaders = getAuthHeadersGET("GET","/orders",this.passPhrase);

            Call<List<coinbaseOpenOrderListOrder>> openOrders = getCoinBaseOpenOrderList.getCoinBaseOpenOrderList(authHeaders);

            Response<List<coinbaseOpenOrderListOrder>> response = openOrders.execute();

            List<coinbaseOpenOrderListOrder> openOrderList = response.body();

            if(openOrderList == null){
                return null;
            }

            for(coinbaseOpenOrderListOrder eachOrder: openOrderList){
                System.out.println(eachOrder.getId());
            }

            return openOrderList;

        }


        @RequiresApi(api = Build.VERSION_CODES.R)
        public coinBaseProSingleOrder getOrderById(String id) throws IOException {

            String url = baseUrl + String.format("/orders/%s/",id);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinBaseOrderById getCoinBaseOrderById = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseOrderById.class);

            HashMap<String,String> authHeaders = getAuthHeadersGET("GET",String.format("/orders/%s",id),passPhrase);

            Call<coinBaseProSingleOrder> getOrderById = getCoinBaseOrderById.getSingleOrder(id,authHeaders);

            Response<coinBaseProSingleOrder> response = getOrderById.execute();

            coinBaseProSingleOrder result = response.body();

            if(result == null){
                return null;
            }

            return result;




        }








    }

    class fillRequests{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";

        public fillRequests(){
            super();
        }

        public fillRequests(String newApi, String newSecret, String newPassPhrase){
            fillRequests.this.apiKey = newApi;
            fillRequests.this.secretKey = newSecret;
            fillRequests.this.passPhrase = newPassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public List<coinBaseListFillsFill> getListFills() throws IOException {

            String url = baseUrl + "/fills/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getListFills getListFills = retrofit.create(com.example.nctai_trading.coinbasePro.getListFills.class);

            HashMap<String,String> authHeaders = getAuthHeadersGET("GET","/fills",passPhrase);

            Call<List<coinBaseListFillsFill>> getListOfFills = getListFills.getListFills(authHeaders);

            Response<List<coinBaseListFillsFill>> getListOfFillsResponse = getListOfFills.execute();

            List<coinBaseListFillsFill> listOfFills = getListOfFillsResponse.body();

            if(listOfFills == null){
                return null;
            }

            return listOfFills;

        }


    }

    class exchangeLimitRequests{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";

        public exchangeLimitRequests(){
            super();
        }

        public exchangeLimitRequests(String newApi, String newSecret, String newPassPhrase){
            exchangeLimitRequests.this.apiKey = newApi;
            exchangeLimitRequests.this.secretKey = newSecret;
            exchangeLimitRequests.this.passPhrase = newPassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public TransferLimits getExchangeLimits() throws IOException {

            String url = baseUrl + "/users/self/exchange-limits/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinBaseProExchangeLimits getCoinBaseProExchangeLimits = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseProExchangeLimits.class);

            Call<TransferLimits> getTransferLimits = getCoinBaseProExchangeLimits.getExchangeLimits(getAuthHeadersGET("GET","/users/self/exchange-limits",passPhrase));

            Response<TransferLimits>  getTransferLimitsResponse = getTransferLimits.execute();

            TransferLimits transferLimits = getTransferLimitsResponse.body();

            if(transferLimits == null){
                return null;
            }

            return transferLimits;
        }



    }

    class depositRequests{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";

        public depositRequests(){
            super();
        }

        public depositRequests(String newApi, String newSecretKey, String newPassPhrase){
            depositRequests.this.apiKey = newApi;
            depositRequests.this.secretKey = newSecretKey;
            depositRequests.this.passPhrase = newPassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public List<coinbaseProDeposit> getListOfDeposits() throws IOException {

            String url = baseUrl + "/transfers/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinBaseDeposits getCoinBaseDeposits = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseDeposits.class);

            HashMap<String,String> authHeaders = getAuthHeadersGET("GET","/transfers",passPhrase);

            Call<List<coinbaseProDeposit>> coinbaseProDepositCall = getCoinBaseDeposits.getCoinBaseProDeposits(authHeaders);

            Response<List<coinbaseProDeposit>> coinbaseProDepositResponse = coinbaseProDepositCall.execute();

            List<coinbaseProDeposit> coinbaseProDeposit = coinbaseProDepositResponse.body();

            if(coinbaseProDeposit == null){
                return null;
            }

            return coinbaseProDeposit;

        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public coinbaseProDeposit getSingleDeposit(String transferId) throws IOException {

            String url = baseUrl + String.format("/transfers/:%s",transferId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinBaseDeposit getCoinBaseDeposit = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinBaseDeposit.class);

            HashMap<String,String> authHeaders = getAuthHeadersGET("GET","/transfers/:" + transferId,passPhrase);

            Call<coinbaseProDeposit> coinbaseProDepositCall = getCoinBaseDeposit.getSingleDeposit(transferId,authHeaders);

            Response<coinbaseProDeposit> coinbaseProDepositResponse = coinbaseProDepositCall.execute();

            coinbaseProDeposit result = coinbaseProDepositResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public coinbaseProPaymentDeposit depositFunds(BigDecimal amount, String currency, String payment_method_id) throws IOException {

            String url = baseUrl + "/deposits/payment-method/";

            HashMap<String,Object> data = new LinkedHashMap<>();

            data.put("amount",amount);
            data.put("currency",currency);
            data.put("payment_method_id",payment_method_id);

            String requestPath = "/deposits/payment-method";
            String method = "POST";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            coinbaseDepositFunds coinbaseDepositFunds = retrofit.create(com.example.nctai_trading.coinbasePro.coinbaseDepositFunds.class);

            Call<coinbaseProPaymentDeposit> coinbaseProPaymentDepositCall = coinbaseDepositFunds.coinbaseDepositPayment(getAuthHeadersPOST(method,requestPath,data,passPhrase),data);

            Response<coinbaseProPaymentDeposit> coinbaseProPaymentDepositResponse = coinbaseProPaymentDepositCall.execute();

            coinbaseProPaymentDeposit paymentDeposit = coinbaseProPaymentDepositResponse.body();

            return paymentDeposit;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public coinBaseProCoinbaseDeposit coinbaseProCoinbaseDeposit(BigDecimal amount, String currency, String coinbaseAccountId) throws IOException {
            String url = baseUrl + "/deposits/coinbase-account/";

            HashMap<String,Object> body = new LinkedHashMap<>();

            body.put("amount",amount);
            body.put("currency",currency);
            body.put("coinbase_account_id",coinbaseAccountId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            coinbaseDepositCoinbaseAcctFunds coinbaseDepositCoinbaseAcctFunds = retrofit.create(com.example.nctai_trading.coinbasePro.coinbaseDepositCoinbaseAcctFunds.class);

            Call<coinBaseProCoinbaseDeposit> coinbaseDepositCall = coinbaseDepositCoinbaseAcctFunds.depositCoinbaseProFunds(getAuthHeadersPOST("POST","/deposits/coinbase-account",body,passPhrase),body);

            Response<coinBaseProCoinbaseDeposit> coinBaseProCoinbaseDepositResponse = coinbaseDepositCall.execute();

            coinBaseProCoinbaseDeposit deposit = coinBaseProCoinbaseDepositResponse.body();

            return deposit;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public coinbaseCryptoDepositAddress getCryptoDepositAddresses(String coinbaseAccountID) throws IOException {

            String url = baseUrl + "/coinbase-account/" + coinbaseAccountID + "/addresses/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinbaseCryptoAcctAddress getCoinbaseCryptoAcctAddress = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinbaseCryptoAcctAddress.class);

            HashMap<String,String> authHeaders = getAuthHeadersPOST("POST","/coinbase-accounts/" + coinbaseAccountID + "/addresses",new HashMap<String,Object>(),passPhrase);

            // post request with no body?, should I just pass an empty HashMap<String,Object>() as body.

            Call<coinbaseCryptoDepositAddress> coinbaseCryptoDepositAddressCall = getCoinbaseCryptoAcctAddress.getCoinbaseCryptoDepositAddress(authHeaders);

            Response<coinbaseCryptoDepositAddress> coinbaseCryptoDepositAddressResponse = coinbaseCryptoDepositAddressCall.execute();

            coinbaseCryptoDepositAddress result = coinbaseCryptoDepositAddressResponse.body();

            return result;
        }





    }

    class withdrawRequests{

        private String apiKey = "";
        private String secretKey = "";
        private String passPhrase = "";

        public withdrawRequests(){
            super();
        }

        public withdrawRequests(String newApi, String newSecretKey, String newPassPhrase){
            withdrawRequests.this.apiKey = newApi;
            withdrawRequests.this.secretKey = newApi;
            withdrawRequests.this.passPhrase = newPassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public coinbaseProWithdrawl getListOfWithdrawls() throws IOException {

            String url = baseUrl + "/transfers";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getCoinbaseWithdrawList getCoinbaseWithdrawList = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinbaseWithdrawList.class);

            HashMap<String,String> authMap = getAuthHeadersGET("GET","/transfers",passPhrase);

            Call<coinbaseProWithdrawl> withdrawlCall = getCoinbaseWithdrawList.getCoinbaseWithdrawList(authMap);

            Response<coinbaseProWithdrawl> coinbaseProWithdrawlResponse = withdrawlCall.execute();

            coinbaseProWithdrawl result = coinbaseProWithdrawlResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.R)
        public coinbaseProWithdrawl getSingleWithdrawl(String withdrawID) throws IOException {

            String url = baseUrl + "/transfers/:" + withdrawID + "/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            getCoinbaseWithdrawl getCoinbaseWithdrawl = retrofit.create(com.example.nctai_trading.coinbasePro.getCoinbaseWithdrawl.class);

            HashMap<String,String> authMap = getAuthHeadersGET("GET","/transfers/:" + withdrawID,passPhrase);

            Call<coinbaseProWithdrawl> withdrawlCall = getCoinbaseWithdrawl.getSingleWithdrawl(withdrawID,authMap);

            Response<coinbaseProWithdrawl> coinbaseProWithdrawlResponse = withdrawlCall.execute();

            coinbaseProWithdrawl result = coinbaseProWithdrawlResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public coinbaseProWithdrawToPaymentResponse coinbaseWithdrawToPaymentMethod(BigDecimal amount, String currency, String paymentMethodId) throws IOException {

            HashMap<String,Object> body = new LinkedHashMap<>();

            body.put("amount",amount);
            body.put("currency",currency);
            body.put("payment_method_id",paymentMethodId);

            String url = baseUrl + "/withdrawls/payment-method/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            coinbaseWithdrawToPayment coinbaseWithdrawToPayment = retrofit.create(com.example.nctai_trading.coinbasePro.coinbaseWithdrawToPayment.class);

            Call<coinbaseProWithdrawToPaymentResponse> coinbaseProWithdrawToPaymentResponseCall = coinbaseWithdrawToPayment.withdrawToPayment(getAuthHeadersPOST("POST","/withdrawls/payment-method",body,passPhrase),body);

            Response<coinbaseProWithdrawToPaymentResponse> coinbaseProWithdrawToPaymentResponseResponse = coinbaseProWithdrawToPaymentResponseCall.execute();

            coinbaseProWithdrawToPaymentResponse result = coinbaseProWithdrawToPaymentResponseResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public coinbaseWithdrawToCoinbaseResponse coinbaseWithdrawToCoinbase(BigDecimal amount, String currency, String coinbaseAcctID) throws IOException {

            HashMap<String,Object> body = new LinkedHashMap<>();

            body.put("amount",amount);
            body.put("currency",currency);
            body.put("coinbase_account_id",coinbaseAcctID);

            String url = baseUrl + "/withdrawls/coinbase-account/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            coinbaseWithdrawToCoinbase coinbaseWithdrawToCoinbase = retrofit.create(com.example.nctai_trading.coinbasePro.coinbaseWithdrawToCoinbase.class);

            Call<coinbaseWithdrawToCoinbaseResponse> coinbaseWithdrawToCoinbaseResponseCall = coinbaseWithdrawToCoinbase.withdrawToCoinbaseAcct(getAuthHeadersPOST("POST","/withdrawls/coinbase-account",body,passPhrase),body);

            Response<coinbaseWithdrawToCoinbaseResponse> coinbaseWithdrawToCoinbaseResponseResponse = coinbaseWithdrawToCoinbaseResponseCall.execute();

            coinbaseWithdrawToCoinbaseResponse result = coinbaseWithdrawToCoinbaseResponseResponse.body();

            return result;


        }




    }



}






























