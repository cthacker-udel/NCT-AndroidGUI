package com.example.nctai_trading;

import org.apache.commons.lang3.CharSet;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC256 {


    private String secretKey;
    private String applicationString;

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setApplicationString(String applicationString) {
        this.applicationString = applicationString;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getApplicationString() {
        return applicationString;
    }

    public HMAC256(){
    }

    public String HMAC256Algorithm(String key, String applyString) throws NoSuchAlgorithmException, InvalidKeyException {
        final Charset utf8 = StandardCharsets.UTF_8;
        final Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secretKey = new SecretKeySpec(utf8.encode(key).array(),"HmacSHA256");
        sha256HMAC.init(secretKey);
        final byte[] macData = sha256HMAC.doFinal(utf8.encode(applyString).array());
        StringBuilder result = new StringBuilder();
        for(final byte element: macData){
            result.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public String hmacDigest(String msg, String keyString, String algo){
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return digest;
    }



}
