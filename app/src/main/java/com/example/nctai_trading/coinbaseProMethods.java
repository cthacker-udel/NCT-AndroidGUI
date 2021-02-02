package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.spec.SecretKeySpec;

public class coinbaseProMethods {

    public String secretKey = "";
    public String apiKey = "17e5d0f33c9074a2f67c95cf0436fca9";
    public String baseUrl = "";
    public String passPhrase = "";


    @RequiresApi(api = Build.VERSION_CODES.O)
    public HashMap<String,String> getAuthHeaders(String timeStamp, String message, String apiKey, String secretKey, String passPhrase) throws UnsupportedEncodingException {
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();

        byte[] encodedMessageAscii = message.getBytes(StandardCharsets.US_ASCII);
        //byte[] hmacKey = decoder.decode(secretKey);
        String hmacKey = secretKey;
        HMAC256 hmac256 = new HMAC256();
        String signature = new String(encoder.encode(hmac256.hmacDigest(hmacKey,message,"Hmac256").getBytes()),"UTF-8");
        HashMap<String,String> data = new HashMap<>();
        data.put("Content-Type","Application/JSON");
        data.put("CB-ACCESS-SIGN",signature);
        data.put("CB-ACCESS-KEY",apiKey);
        data.put("CB-ACCESS-PASSPHRASE",passPhrase);

        return data;
    }

    // Json stringify in example = {"price":"1.0","size":"1.0","side":"buy","product_id":"BTC-USD"}

    public String getTimeStamp(){
        return String.valueOf(System.currentTimeMillis());
    }

    // typically for get
    // callData = hashMap = {"price":"1.0", "size": 1.0", "side": "buy", "product_id": "BTC-USD"}
    @RequiresApi(api = Build.VERSION_CODES.R)
    public HashMap<String,String> call(String method1, String requestPath, HashMap<String,String> callData) throws UnsupportedEncodingException {
        String timestamp = getTimeStamp();
        String method = method1;
        if(callData != null) {
            String message = String.join("", new String[]{timestamp, method, requestPath,callData.toString().replaceAll(" ","")});
            HashMap<String,String> headers = getAuthHeaders(timestamp,message,apiKey,secretKey,passPhrase);
            return headers;
        }
        else{
            String message = String.join("",new String[]{timestamp,method,requestPath,"0"});
            HashMap<String,String> headers = getAuthHeaders(timestamp,message,apiKey,secretKey,passPhrase);
            return headers;
        }
    }



}
