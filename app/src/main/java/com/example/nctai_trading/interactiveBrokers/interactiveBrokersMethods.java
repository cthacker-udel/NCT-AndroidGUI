package com.example.nctai_trading.interactiveBrokers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.apache.commons.codec.binary.Base64;
import org.spongycastle.util.encoders.Base64Encoder;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class interactiveBrokersMethods {

    String consumerKey = "";
    String signatureMethod = "RSA-SHA256";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTimeStamp(){
        return Instant.now().getEpochSecond() + "";
    }

    public String getNonce(String timestamp){
        byte[] nonceByte = timestamp.getBytes();
        return new String(Base64.encodeBase64(nonceByte), StandardCharsets.UTF_8);
    }





}
