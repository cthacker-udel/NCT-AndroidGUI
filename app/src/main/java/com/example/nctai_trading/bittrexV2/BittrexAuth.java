package com.example.nctai_trading.bittrexV2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class BittrexAuth extends BittrexClient{

    public String calculateHash(String secret, String data, String algorithm) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac shaHmac = Mac.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), algorithm);
        shaHmac.init(secretKey);
        byte[] hash = shaHmac.doFinal(data.getBytes());
        return new String(Hex.encodeHex(hash));
        //return Hex.encodeHexString(hash);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateNonce() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(System.currentTimeMillis());
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        String nonce = new String(Base64.getEncoder().encode(nonceBytes), "UTF-8");
        return nonce;
    }

}
