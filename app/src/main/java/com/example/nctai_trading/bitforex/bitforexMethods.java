package com.example.nctai_trading.bitforex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bitforexMethods {

    String apiKey = "3f368cf10638f297810615ae156f12a9";
    String secretKey = "e7a3ea02da128f2b74f332fba15c2b31";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateSignaturePOST(String path, Map<String,Object> params){

        /*

        @param String(path) Form -> /path + ?
        @param Map<String,Object> params : values passed with post request

         */

        path = path + "?";

        params.put("accessKey",apiKey);

        String[] sortedKeys = params.keySet().stream().sorted().toArray(String[]::new);

        ArrayList<String> urlList = new ArrayList<>();

        String url = "";

        for(String eachString: sortedKeys){
            urlList.add(String.format("%s=%s",eachString,params.get(eachString)));
        }

        url = path + String.join("&",urlList);

        HMAC256 hmac256 = new HMAC256();

        String result = hmac256.hmacDigest(url,secretKey,"HmacSHA256");

        return result;

    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTimeStamp(){

        return Instant.now().getEpochSecond() + "";

    }



}
