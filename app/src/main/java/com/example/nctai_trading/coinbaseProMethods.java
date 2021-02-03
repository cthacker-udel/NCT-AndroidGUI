package com.example.nctai_trading;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
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

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
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
    public HashMap<String,String> getAuthHeadersPOST(String method, String requestPath, NewMarketOrderSingle newBody, String passPhrase) throws IOException {

        String timeStamp = "1612316366963";

        //temp
        //byte[] ascii = jsonStringifyMap(body).getBytes(StandardCharsets.US_ASCII);
        //String asciiString = new String(ascii,StandardCharsets.UTF_8);
        //String signature = generateSignature(timeStamp2,method,requestPath,jsonStringifyMap(body));
        String body = toJson(newBody);
        //100000POST/orders{"product_id": "BTC-USD", "side": "buy", "type": "market", "funds": 1}
        //                 {"product_id": "BTC-USD", "side": "buy", "type": "market", "funds": 1}
        //System.out.println(timeStamp2);
        //String signature = generateSignature(timeStamp2,method,requestPath,jsonStringifyMap(body).trim());
        System.out.println(toJson(body));
        // above works then it has to be the retrofit call
        HashMap<String,String> data = new HashMap<>();
        data.put("accept","application/json");
        data.put("CB-ACCESS-KEY",apiKey);
        String timeStamp2 = Instant.now().getEpochSecond() + "";
        data.put("CB-ACCESS-SIGN",generateSignature(timeStamp2,method,requestPath,toJson(body)));
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

    @RequiresApi(api = Build.VERSION_CODES.O)
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateSignature(String timestamp, String method, String requestPath, String body){
        try{
            String prehash = timestamp + method.toUpperCase() + requestPath + body;
            byte[] secretDecoded = Base64.getDecoder().decode(secretKey);
            SecretKeySpec keySpec = new SecretKeySpec(secretDecoded, Mac.getInstance("HmacSHA256").getAlgorithm());
            //Mac sha256 = (Mac) Mac.getInstance("HmacSHA256").clone();
            Mac sha256 = Mac.getInstance("HmacSHA256");
            sha256.init(keySpec);
            return Base64.getEncoder().encodeToString(sha256.doFinal(prehash.getBytes()));
        }
        catch(InvalidKeyException | NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new RuntimeException(new Error("Cannot set up auth headers"));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String tempGenerateSignature(String timestamp, String method, String requestPath, String body){
        try{
            String prehash = timestamp + method.toUpperCase() + requestPath + body;
            byte[] secretDecoded = Base64.getDecoder().decode(secretKey);
            SecretKeySpec keySpec = new SecretKeySpec(secretDecoded, Mac.getInstance("HmacSHA256").getAlgorithm());
            //Mac sha256 = (Mac) Mac.getInstance("HmacSHA256").clone();
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

        getCoinBaseProServerTime getCoinBaseProServerTime = retrofit.create(com.example.nctai_trading.getCoinBaseProServerTime.class);
        Call<coinBaseProServerResponse> serverResponseCall = getCoinBaseProServerTime.getCoinBaseProServerTime();
        Response<coinBaseProServerResponse> serverResponseResponse = serverResponseCall.execute();
        return serverResponseResponse.body().getEpoch();

    }

    // Json stringify in example = {"price":"1.0","size":"1.0","side":"buy","product_id":"BTC-USD"}
    // hashmap.toString().
    //hashmap string = "{method=/orders, timestamp=1000000}"

    public String jsonStringifyMap(Map<String,String> map){
        LinkedHashMap<String,String> baseMap = new LinkedHashMap<>();
        for(String eachKey: map.keySet()){
            if(isNumber(map.get(eachKey))){
                baseMap.put(String.format("\"%s\"",eachKey),String.valueOf(map.get(eachKey)));
            }
            else {
                baseMap.put(String.format("\"%s\"", eachKey), String.format("\"%s\"", String.valueOf(map.get(eachKey))));
            }
        }
        //"{method=/orders, timestamp=1000000}"
        //100000POST/orders{"product_id": "BTC-USD", "side": "buy", "type": "market", "funds": 1}
        return baseMap.toString().replace("=",": ");
    }

    public String getTimeStamp() throws IOException {
        return String.valueOf(System.currentTimeMillis() / 1000);
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


    public String getTimeStamp2(){
        //return new BigDecimal(System.currentTimeMillis() + "").divide(BigDecimal.valueOf(1000)).toString();
        return new BigDecimal(System.currentTimeMillis() + "").divide(BigDecimal.valueOf(1000)).toString();
    }

    //public Double synchronize() throws IOException {          -deprecated
    //    double servertime = getServerTime();
    //    double systemtime = System.currentTimeMillis() * 1000;
    //    double offset = systemtime - servertime + 500;
    //    return systemtime - offset;
    //}

    // typically for get
    // callData = hashMap = {"price":"1.0", "size": 1.0", "side": "buy", "product_id": "BTC-USD"}
    @RequiresApi(api = Build.VERSION_CODES.R)
    public HashMap<String,String> call(String method1, String requestPath, HashMap<String,String> callData) throws IOException {
        String timestamp = getTimeStamp();
        String method = method1;
        if(callData != null) {
            String message = String.join("", new String[]{timestamp, method, requestPath,callData.toString().replaceAll(" ","")});
            //HashMap<String,String> headers = getAuthHeaders(timestamp,message,apiKey,secretKey,passPhrase);
            //return headers;
        }
        else{
            String message = String.join("",new String[]{timestamp,method,requestPath,"0"});
            //HashMap<String,String> headers = getAuthHeaders(timestamp,message,apiKey,secretKey,passPhrase);
            //return headers;
        }
        return new HashMap<String,String>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TreeMap<String,String[]> getAccountList() throws IOException {

        String url = this.baseUrl + "/accounts/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCoinBaseProAccounts getCoinBaseProAccounts = retrofit.create(com.example.nctai_trading.getCoinBaseProAccounts.class);


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

        getCoinBaseAccount getCoinBaseAccount = retrofit.create(com.example.nctai_trading.getCoinBaseAccount.class);

        Call<coinBaseAccount> getCoinBaseAccountCall = getCoinBaseAccount.getCoinBaseAccountCall(id, getAuthHeadersGET("GET",String.format("/accounts/%s",id),passPhrase));

        Response<coinBaseAccount> coinBaseAccountResponse = getCoinBaseAccountCall.execute();

        coinBaseAccount coinBaseAccount = coinBaseAccountResponse.body();

        ArrayList<String> accountDetails = new ArrayList<>();
        accountDetails.add(String.format("----------------\n Account ID : %s \n Currency : %s \n Balance %s \n Available : %s \n Holds : %s \n -------------------------\n",coinBaseAccount.getId(),coinBaseAccount.getCurrency(),coinBaseAccount.getBalance(),coinBaseAccount.getAvailable(),coinBaseAccount.getHolds()));
        return accountDetails;
    }

    private NewMarketOrderSingle createNewMarketOrder(String product, String action, double size) {
        NewMarketOrderSingle marketOrder = new NewMarketOrderSingle(size);
        marketOrder.setProduct_id(product);
        marketOrder.setSide(action);
        return marketOrder;
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
        public void placeOrderMarket(String size, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.buyCoinBaseCurrency.class);

            HashMap<String, String> data = new LinkedHashMap<>();
            // size == how much of currency1 do you want to trade anything < 1 cent is not allowed
            String productId = "";
            if (currency2 == null) {
                productId = currency1 + "-USD";
            } else {
                productId = currency1 + "-" + currency2;
            }

            coinBaseBody body = new coinBaseBody();

            body.setPrice(1.0);
            body.setProduct_id("BTC-USD");
            body.setSide("buy");
            body.setSize(1.0);

            NewMarketOrderSingle order = createNewMarketOrder(productId,"buy",0.1);

            data.put("product_id", "BTC-USD");
            data.put("side", "buy");
            data.put("type", "market");
            data.put("funds", "1");
            //data.put("side","buy");
            //data.put("type","market");
            String requestPath = "/orders";
            String method = "POST";
            HashMap<String, String> authHeaders = getAuthHeadersPOST(method, requestPath, order, passPhrase);

            //Call<coinBaseProPurchase> getCoinBasePurchase = buyCoinBaseCurrency.buyCoinBasePro(body,authHeaders);
            Call<coinBaseProPurchase> getCoinBasePurchase = buyCoinBaseCurrency.buyCoinBasePro(authHeaders, data);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = getCoinBasePurchase.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getCreatedAt());
            System.out.println(result.getExecutedValue());


            // add header onto call request in interface with
        }







































        /*

        @author - Preethi

         */

        public void placeOrdermarket(BigDecimal price, BigDecimal size, String currency1, String currency2) throws IOException {
            coinBaseNewLimitOrderSingle2 order = new coinBaseNewLimitOrderSingle2();
            order.setPrice(price);
            String productId = "";
            if(currency2 == null){
                productId = currency1 + "-USD";
            }
            else{
                productId = currency1 + "-" + currency2;
            }
            order.setProduct_id(productId);
            order.setSide("buy");
            order.setSize(size);
            Retrofit retrofit = getClient();
            coinBaseLimitOrder limitOrder = retrofit.create(coinBaseLimitOrder.class);
            Call<coinBaseProPurchase> getCoinBasePurchase = limitOrder.createorder2(order);

            Response<coinBaseProPurchase> purchase = getCoinBasePurchase.execute();

            coinBaseProPurchase body = purchase.body();

            System.out.println(body.getId());

        }

        /*

        @author - Preethi


         */
        public String bodyToString(final RequestBody request) {
            try {
                final RequestBody copy = request;
                final Buffer buffer = new Buffer();
                if (copy != null)
                    copy.writeTo(buffer);
                else
                    return "";
                return buffer.readUtf8();
            } catch (final IOException e) {
                return "did not work";
            }
        }

        /*

        @author - Preethi

         */
        Retrofit getClient() {
            final String baseUrl = "https://api.pro.coinbase.com";
            Retrofit retrofit;

            Interceptor securityInterceptor = new Interceptor() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    String timestamp = Instant.now().getEpochSecond() + "";
                    Log.i("Retro", timestamp);
                    String endpoint = request.url().toString();
                    Log.i("Retro", endpoint);
                    String resource = endpoint.replace(baseUrl, "");
                    Log.i("Retro", resource);
                    String method = request.method();
                    Log.i("Retro", method);
                    RequestBody requestBody = request.body();
                    String jsonBody = "";
                    if (requestBody != null) {
                        jsonBody = bodyToString(requestBody);
                    }
                    Log.i("Retro", jsonBody);

                    String cbsAccessSign = generateSignature(timestamp,method,resource,jsonBody);//generateSignature(resource, method, jsonBody, timestamp, "ufOMqTBzARwhCbNQmrazgDAk6ir4xjUyU1cH0kkV8k6b0X1hRI8ipcKs1beTwAQuoWDPUJ7dnhuqanAxKEVrXw");
                    Request newRequest = request.newBuilder().addHeader("CB-ACCESS-KEY", "17e5d0f33c9074a2f67c95cf0436fca9").
                            addHeader("CB-ACCESS-SIGN", cbsAccessSign).
                            addHeader("CB-ACCESS-TIMESTAMP", timestamp).addHeader("CB-ACCESS-PASSPHRASE", "NCTAI09AKATBE").build();
                    return chain.proceed(newRequest);
                }
            };
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(securityInterceptor).addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


            return retrofit;
        }

    }
}






























