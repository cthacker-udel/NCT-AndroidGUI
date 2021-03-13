package com.example.nctai_trading.bkex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bkexMethods {

    String apikey = "";
    String secretKey = "";
    String baseUrl = "https://api.bkex.vip";

    public String getSignature(String params) throws InvalidKeyException, NoSuchAlgorithmException {
        HMAC256 hmac256 = new HMAC256();
        return hmac256.HMAC256Algorithm(secretKey,params);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(Map<String,String> params){

        ArrayList<String> paramList = new ArrayList<>();
        for(String eachKey: params.keySet()){
            paramList.add(String.format("%s=%s",eachKey,params.get(eachKey)));
        }
        return String.join("&",paramList);
    }



    public class exchangeRequests{

        public void getExchangeInfo(){

            String url = baseUrl + "/v1/exchangeInfo/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();




        }



    }



}
