package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.Signature;
import java.util.Base64;

public class RSASHA256 {

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String signSHA256RSA(String input, String strPk) throws Exception {
        // Remove markers and new line characters in private key
        String realPK = strPk.replaceAll("\n", "");

        byte[] b1 = Base64.getDecoder().decode(realPK);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
        KeyFactory kf = KeyFactory.getInstance("RSA");

        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(kf.generatePrivate(spec));
        privateSignature.update(input.getBytes("UTF-8"));
        byte[] s = privateSignature.sign();
        return Base64.getEncoder().encodeToString(s);
    }

}
