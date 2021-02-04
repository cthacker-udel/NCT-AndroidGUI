package com.example.nctai_trading.coinbasePro;

import android.os.Build;

import androidx.annotation.RequiresApi;

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



}





























