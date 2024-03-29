package com.example.nctai_trading.bibox;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class V2AssetsTransferSpotProxy extends BaseProxy
{

    public V2AssetsTransferSpotProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V2_ASSETS_TRANSFER_SPOT);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferSpot(String symbol, String amount, TransferSpotTypeEnum type) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        params.put("amount", amount);
        params.put("type", type.getFlag());
        String jsonParams = JSON.toJSONString(params);
        //        return helper.postForm(getUrl(), params);
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("body", jsonParams);
        postBody.put("apikey", config.getApiKey());
        postBody.put("sign", ApiKeyUtils.sign(config.getSecret(), jsonParams));
        return helper.postBodyJson(getUrl(), JSON.toJSONString(postBody));
    }
}
