package com.example.nctai_trading.bitMEX;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;

public class bitmexMethods {

    String apikey = "QL96zz4M6oj2aPGIZBeUGuyq";
    String secretKey = "aTkRoaagMp7S5edIjoy-bEb7jyubNZphikluLNRrS3Ktlwu4";
    HMAC256 hmac256;

    public String generateSignature(String verb, String path, String nonce, String data){
        String secretEncoded = new String(secretKey.getBytes(), StandardCharsets.UTF_8);
        String prehash = verb + path + nonce + data;
        String result = hmac256.hmacDigest(prehash,secretEncoded,"HmacSHA256");
        return result;
    }


    public static String nonceGenerator(){

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 13; i++){
            stringBuilder.append(secureRandom.nextInt(10));
        }
        String randomNumber = stringBuilder.toString();
        return randomNumber;
    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

}
