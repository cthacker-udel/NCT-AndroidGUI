package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
    public HashMap<String,String> getAuthHeadersPOST(String method, String requestPath, LinkedHashMap<String,String> body, String passPhrase) throws IOException {

        //Base64.Decoder decoder = Base64.getDecoder();
        //Base64.Encoder encoder = Base64.getEncoder();

        //byte[] encodedMessageAscii = method.getBytes(StandardCharsets.US_ASCII);
        //byte[] hmacKey = decoder.decode(secretKey);
        //String hmacKey = secretKey;
        //HMAC256 hmac256 = new HMAC256();
        //String signature = new String(encoder.encode(hmac256.hmacDigest(hmacKey,message,"Hmac256").getBytes()),"UTF-8");
        String timeStamp = getTimeStamp();
        String signature = generateSignature(timeStamp,method,requestPath,body.toString());
        HashMap<String,String> data = new HashMap<>();
        data.put("Content-Type","Application/JSON");
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-KEY",apiKey);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);

        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public HashMap<String,String> getAuthHeadersGET(String method, String requestPath, String passPhrase) throws IOException {

        //Base64.Decoder decoder = Base64.getDecoder();
        //Base64.Encoder encoder = Base64.getEncoder();

        //byte[] encodedMessageAscii = method.getBytes(StandardCharsets.US_ASCII);
        //byte[] hmacKey = decoder.decode(secretKey);
        //String hmacKey = secretKey;
        //HMAC256 hmac256 = new HMAC256();
        //String signature = new String(encoder.encode(hmac256.hmacDigest(hmacKey,message,"Hmac256").getBytes()),"UTF-8");
        String body = "";
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
    public void getAccount() throws IOException {

        String url = this.baseUrl + "/accounts/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCoinBaseProAccounts getCoinBaseProAccounts = retrofit.create(com.example.nctai_trading.getCoinBaseProAccounts.class);


        Call<List<coinBaseListAccount>> coinBaseProAccountsCall = getCoinBaseProAccounts.getAccounts(getAuthHeadersGET("GET","/accounts",passPhrase));

        //Call<List<coinBaseListAccount>> coinBaseProAccountsCall = getCoinBaseProAccounts.getAccounts("Authorization");

        Response<List<coinBaseListAccount>> coinBaseProAccountsResponse = coinBaseProAccountsCall.execute();

        List<coinBaseListAccount> accountList = coinBaseProAccountsResponse.body();

        for(coinBaseListAccount eachAccount: accountList){
            System.out.println(eachAccount.getId());
            System.out.println(eachAccount.getBalance());
            System.out.println(eachAccount.getCurrency());
        }



    }

    class buyCurrency{

        private String buyCurrencyApiKey = "";
        private String buyCurrencySecretKey = "";

        public buyCurrency(){
            super();
        }

        public buyCurrency(String newApi, String newSecret){
            this.buyCurrencyApiKey = newApi;
            this.buyCurrencySecretKey = newSecret;
        }

        public void setBuyCurrencyApikey(String newKey){
            this.buyCurrencyApiKey = newKey;
        }

        public void setBuyCurrencySecretKey(String newKey){
            this.buyCurrencySecretKey = newKey;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void placeOrder(String price, String size, String side, String product_id) throws IOException {
            LinkedHashMap<String,String> data = new LinkedHashMap<>();
            data.put("price",price);
            data.put("size",size);
            data.put("side",side);
            data.put("product_id",product_id + "-USD");
            String timestamp = getTimeStamp();
            String requestPath = "/orders";
            String method = "POST";
            HashMap<String,String> authHeaders = getAuthHeadersPOST(method,requestPath,data,passPhrase);
            authHeaders.put("passphrase",passPhrase);
            // add header onto call request in interface with
        }

    }



}
