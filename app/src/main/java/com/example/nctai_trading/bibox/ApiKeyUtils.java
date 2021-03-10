package com.example.nctai_trading.bibox;

import com.alibaba.fastjson.JSON;
import com.example.nctai_trading.HMAC256;


import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ApiKeyUtils
{
    public static String createParams(String cmd, Map<String, Object> params)
    {
        List<Map<String, Serializable>> data = new ArrayList<>();
        Map<String, Serializable> cmdMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>(params);
        cmdMap.put("cmd", cmd);
        cmdMap.put("body", bodyMap);
        data.add(cmdMap);
        return JSON.toJSONString(data);
    }

    /**
     * data sign
     *
     * @param secret
     * @param data
     * @return
     */
    public static String sign(String secret, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        if (StringUtils.isEmpty(secret)) {
            throw new ApiKeyException("API secret is require");
        }
        HMAC256 hmac256 = new HMAC256();
        return hmac256.hmacDigest(data,secret,"HMACMD5");
    }
}
