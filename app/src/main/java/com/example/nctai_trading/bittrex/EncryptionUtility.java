/*
 * *
 *  This file is part of the bittrex4j project.
 *
 *  @author CCob
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 * /
 */

package com.example.nctai_trading.bittrex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

class EncryptionUtility {

    static String calculateHash(String secret, String data, String algorithm) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac shaHmac = Mac.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), algorithm);
        shaHmac.init(secretKey);
        byte[] hash = shaHmac.doFinal(data.getBytes());
        return new String(Hex.encodeHex(hash));
        //return Hex.encodeHexString(hash);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static String generateNonce() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(System.currentTimeMillis());
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        String nonce = new String(Base64.getEncoder().encode(nonceBytes), "UTF-8");
        return nonce;
    }
}
