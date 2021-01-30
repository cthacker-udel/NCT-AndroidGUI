package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.spongycastle.crypto.Digest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class binanceMethods {

    public String baseUrl = "https://api.binance.us";
    public String secretKey = "mM57MtfNnRG1UrrZs6uGbKNNx1VIU7UktgwqPxelhXkI0cqjXaSCTOvXZY8vMTxj";
    public String apiKey = "lISh9SeQdCT1HGPeo3Z6p8jWAsOJ6tmjoG7LeMsMNGCGBT0HRhfyfEvHJdjn49IG";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getSignature(String url,HashMap<String,Object> theHashMap) throws NoSuchAlgorithmException, InvalidKeyException {
        //HashMap<String,Object> hashMap = new HashMap<>();
        //hashMap.put("data","dataexample");
        //hashMap.put("side","sideexample");
        //hashMap.put("type","typeexample");
        //hashMap.put("quantity",1111111);
        //hashMap.put("timestamp","figureouthowtomaketimestamp");
        //hashMap.put("recvwindow",10000);

        String signature = "";
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: theHashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(theHashMap.get(eachKey))));
        }

        signature = String.join("&",signatureList);
        byte[] secretKeyByteArray = secretKey.getBytes();
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(keySpec);
        String utf8EncodedSecretKey = new String(secretKey.getBytes(), StandardCharsets.UTF_8);
        String utf8EncodedSignature = new String(signature.getBytes(),StandardCharsets.UTF_8);
        byte[] digest = mac.doFinal(utf8EncodedSignature.getBytes());
        // returns the hashed url
        System.out.println(DigestUtils.shaHex(digest));
        return DigestUtils.shaHex(digest);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(HashMap<String,Object> hashMap){
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: hashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(hashMap.get(eachKey))));
        }
        return "?" + String.join("&",signatureList);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String url = this.baseUrl + "/api/v3/account/";

        HashMap<String,Object> data = new HashMap<>();
        data.put("revWindow",10000);
        data.put("timestamp",synchronize());
        String signature = getSignature(url,data);
        data.put("signature",signature);
        String queryString = generateQueryString(data) + "/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        getAccountInfo accountInfoGet = retrofit.create(getAccountInfo.class);

        ///   ONLY PROBLEM IS THE GENERATE SIGNATURE METHOD

        Call<com.example.nctai_trading.Account> accountCall = accountInfoGet.getAccount(queryString);
        try {
            Response<com.example.nctai_trading.Account> responseAccount = accountCall.execute();
            com.example.nctai_trading.Account result = responseAccount.body();
            System.out.println(result.getBalances());
            System.out.println(result.getAccountType());
            System.out.println(result.getMakerCommission());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
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
        long systemTime = ((int)System.currentTimeMillis()) * 1000;
        long offset = systemTime - serverTime + 500;
        return systemTime - offset;
    }
}
