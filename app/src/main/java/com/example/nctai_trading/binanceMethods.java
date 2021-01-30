package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.spongycastle.crypto.Digest;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class binanceMethods {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getSignature(HashMap<String,Object> theHashMap,String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("data","dataexample");
        hashMap.put("side","sideexample");
        hashMap.put("type","typeexample");
        hashMap.put("quantity",1111111);
        hashMap.put("timestamp","figureouthowtomaketimestamp");
        hashMap.put("recvwindow",10000);

        String signature = "";
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: hashMap.keySet()){
            signatureList.add(String.format("%b=%b",eachKey,hashMap.get(eachKey)));
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
}
