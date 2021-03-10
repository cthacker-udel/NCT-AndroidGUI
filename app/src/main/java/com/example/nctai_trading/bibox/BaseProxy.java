package com.example.nctai_trading.bibox;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseProxy
{
    protected HttpClientHelper helper;
    protected BiBoxHttpClientConfig config;

    public abstract String getUrl();

    private Map<String, Object> postCmds(Map<String, Object> body)
    {
        List<Map<String, Object>> cmds = new ArrayList<>();
        cmds.add(body);
        Map<String, Object> params = new HashMap<>();
        params.put("cmds", JSON.toJSONString(cmds));
        return params;
    }

    private Map<String, Object> postSignCmds(Map<String, Object> body) throws InvalidKeyException, NoSuchAlgorithmException {
        if ("".equals(config.getApiKey())) {
            throw new ApiKeyException("ApiKey is require");
        }
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> cmds = new ArrayList<>();
        cmds.add(body);
        params.put("cmds", JSON.toJSONString(cmds));
        params.put("apikey", config.getApiKey());
        params.put("sign", ApiKeyUtils.sign(config.getSecret(), JSON.toJSONString(cmds)));
        return params;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected String post(Map<String, Object> body) throws IOException
    {
        return helper.postForm(getUrl(), postCmds(body));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected String postSign(Map<String, Object> body) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        return helper.postForm(getUrl(), postSignCmds(body));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected String get(Map<String, Object> params) throws IOException
    {
        return helper.get(getUrl(), params);
    }
}
