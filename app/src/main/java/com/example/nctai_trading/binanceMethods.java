package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import jersey.repackaged.com.google.common.collect.ImmutableMap;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class binanceMethods {

    public static String baseUrl = "https://api.binance.us";
    public static String secretKey = "mM57MtfNnRG1UrrZs6uGbKNNx1VIU7UktgwqPxelhXkI0cqjXaSCTOvXZY8vMTxj";
    public static String apiKey = "lISh9SeQdCT1HGPeo3Z6p8jWAsOJ6tmjoG7LeMsMNGCGBT0HRhfyfEvHJdjn49IG";

    public static OkHttpClient defaultHttpClient = new OkHttpClient();

    public static okhttp3.OkHttpClient defaultHttpClient2 = new okhttp3.OkHttpClient();


    public static okhttp3.OkHttpClient getDefaultHttpClient2(){
        defaultHttpClient2.networkInterceptors().add(new okhttp3.Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request().newBuilder().
                        addHeader("secretKey",secretKey)
                        .build();
                return chain.proceed(request);
            }
        });
        return binanceMethods.defaultHttpClient2;
    }

    public static OkHttpClient getDefaultHttpClient() {
        defaultHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("secretKey",secretKey).build();
                return chain.proceed(request);
            }
        });
        return defaultHttpClient;
    }

    static{
        defaultHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("secretKey",secretKey).build();
                return chain.proceed(request);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getSignature(String url,HashMap<String,String> theHashMap) throws NoSuchAlgorithmException, InvalidKeyException {

        String signature = "";
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: theHashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(theHashMap.get(eachKey))));
        }

        signature = String.join("&",signatureList);
        HMAC256 test = new HMAC256();
        return test.hmacDigest(signature,secretKey,"HmacSHA256");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(HashMap<String,String> hashMap){
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: hashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(hashMap.get(eachKey))));
        }
        return "?" + String.join("&",signatureList);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String url = this.baseUrl + "/api/v3/account/";

        HashMap<String,String> data = new HashMap<>();
        data.put("recvWindow","10000");
        data.put("timestamp",String.valueOf(synchronize()));
        String signature = getSignature(url,data);
        data.put("signature",signature);
        String queryString = generateQueryString(data);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        getAccountInfo accountInfoGet = retrofit.create(getAccountInfo.class);

        ///   ONLY PROBLEM IS THE GENERATE SIGNATURE METHOD

        ImmutableMap<String,String> immutableMap = ImmutableMap.of("recvWindow",String.valueOf(data.get("recvWindow")),"timestamp",String.valueOf(data.get("timestamp")),"signature",data.get("signature"));

        Call<com.example.nctai_trading.Account> accountCall = accountInfoGet.getAccount(immutableMap,apiKey);
        try {
            System.out.println("Reached account info");
            Response<com.example.nctai_trading.Account> responseAccount = accountCall.execute();
            com.example.nctai_trading.Account result = responseAccount.body();
            HashMap<String,String> balanceMap = new HashMap<>();
            List<Balance> balanceList = result.getBalances();
            for(Balance eachBalance: balanceList){
                balanceMap.put(eachBalance.getAsset(),eachBalance.getFree());
            }
            String accountType = result.getAccountType();
            Integer makerCommision = result.getMakerCommission();
            System.out.println(balanceMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String displayCurrentPrice(String symbol) throws IOException {
        AveragePrice result;
        HashMap<String,String> data = new HashMap<>();
        data.put("symbol",symbol);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.binance.us/api/v3/avgPrice/").addConverterFactory(GsonConverterFactory.create()).build();

        getAveragePrice avgPriceGet = retrofit.create(getAveragePrice.class);

        Call<AveragePrice> avgPriceObject = avgPriceGet.getAvgPrice(data);

        Response<AveragePrice> responseAvgPrice = avgPriceObject.execute();
        try {
            result = responseAvgPrice.body();
        }
        catch(NullPointerException nullPointerException){
            // fix bug
            return "Not available";
        }
        return String.format("%s : %s","1",result.getPrice());
    }

    public long getServerTime() throws IOException {
        String url = this.baseUrl + "/api/v3/time/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getTheServerTime theServerTime = retrofit.create(getTheServerTime.class);

        Call<serverTime> serverTimeCall = theServerTime.gettheServerTime();

        Response<serverTime> serverTimeResponse = serverTimeCall.execute();

        serverTime result = serverTimeResponse.body();

        System.out.println(result.getServerTime());

        return result.getServerTime();
    }

    public long synchronize() throws IOException {
        long serverTime = getServerTime();
        long systemTime = System.currentTimeMillis() * 1000;
        long offset = systemTime - serverTime + 500;
        return systemTime - offset;
    }
}
