package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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


 */

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
    public HashMap<String,String> getAuthHeadersPOST(String method, String requestPath, HashMap<String,String> body, String passPhrase) throws IOException {


        String timeStamp = getTimeStamp();
        String signature = generateSignature(timeStamp,method,requestPath,body.toString());
        HashMap<String,String> data = new HashMap<>();
        data.put("CB-ACCESS-KEY",apiKey);
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-TIMESTAMP",timeStamp);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);
        data.put("Content-Type","Application/JSON");

        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public HashMap<String,String> getAuthHeadersGET(String method, String requestPath, String passPhrase) throws IOException {


        String body = "";
        String timeStamp = getTimeStamp();
        String signature = generateSignature(timeStamp,method,requestPath,body);
        HashMap<String,String> data = new HashMap<>();
        data.put("CB-ACCESS-KEY",apiKey);
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-TIMESTAMP",timeStamp);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);
        data.put("Content-Type","Application/JSON");

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
    // hashmap string = {method=/orders, timestamp=1000000}

    public String jsonStringifyMap(Map<String,String> map){
        Map<String,String> baseMap = new HashMap<>();
        for(String eachKey: map.keySet()){
            baseMap.put(String.format("\"%s\"",eachKey),String.format("\"%s\"",baseMap.get(eachKey)));
        }
        return baseMap.toString().replace("=",":").replace(" ","");
    }

    public String getTimeStamp() throws IOException {
        return String.valueOf(System.currentTimeMillis() / 1000);
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

    class buyCurrency{

        private String buyCurrencyApiKey = "";
        private String buyCurrencySecretKey = "";
        private String passphrase = "";

        public buyCurrency(){
            super();
        }

        public buyCurrency(String newApi, String newSecret, String newPassPhrase){
            this.buyCurrencyApiKey = newApi;
            this.buyCurrencySecretKey = newSecret;
            this.passphrase = newPassPhrase;
        }

        public void setBuyCurrencyApikey(String newKey){
            this.buyCurrencyApiKey = newKey;
        }

        public void setBuyCurrencySecretKey(String newKey){
            this.buyCurrencySecretKey = newKey;
        }

        public void setPassphrase(String newPassPhrase){
            this.passphrase = newPassPhrase;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeOrderMarket(String size, String currency1, String currency2) throws IOException {

            String url = baseUrl + "/orders/";

            HashMap<String,String> data = new LinkedHashMap<>();
            // size == how much of currency1 do you want to trade anything < 1 cent is not allowed
            String productId = "";
            if(currency2 == null){
                productId = currency1 + "-USD";
            }
            else{
                productId = currency1 + "-" + currency2;
            }
            data.put("size","1.0");
            data.put("price","0.100");
            data.put("side","buy");
            data.put("product_id","BTC-USD");
            //data.put("side","buy");
            //data.put("type","market");
            String requestPath = "/orders";
            String method = "POST";
            HashMap<String,String> authHeaders = getAuthHeadersPOST(method,requestPath,data,passPhrase);
            authHeaders.put("passphrase",passPhrase);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            buyCoinBaseCurrency buyCoinBaseCurrency = retrofit.create(com.example.nctai_trading.buyCoinBaseCurrency.class);

            Call<coinBaseProPurchase> getCoinBasePurchase = buyCoinBaseCurrency.buyCoinBasePro(authHeaders);

            Response<coinBaseProPurchase> coinBaseProPurchaseResponse = getCoinBasePurchase.execute();

            coinBaseProPurchase result = coinBaseProPurchaseResponse.body();

            System.out.println(result.getCreatedAt());
            System.out.println(result.getExecutedValue());


            // add header onto call request in interface with
        }

    }



}
