package com.example.nctai_trading.basefex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Map;

public class basefexMethods {

    String apiKey = "5ce82c1b-c9e7-4e9e-0006-139ff42b18d2";
    String secretKey = "njB3bdJ0xtrY5J8eg9G4LCsb+DV1wyiBvOKmHFd7/e8=";
    HMAC256 signatureGenerator = new HMAC256();

    public String generateSignature(String secretKey, String method, String path, String expires, String data) throws InvalidKeyException, NoSuchAlgorithmException {

        String signature = signatureGenerator.hmacDigest(method + path + expires + data,secretKey,"HmacSHA256");

        return signature;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long getTimeStamp(){
        return Instant.now().getEpochSecond();
    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

    public void test() throws NoSuchAlgorithmException, InvalidKeyException {

        String result = generateSignature("OJJFq6qugIyvLBOyvg8WBPriSs0Dfw7Mi3QjLYin8is=","GET","/accounts","1563148118","");


    }




}
