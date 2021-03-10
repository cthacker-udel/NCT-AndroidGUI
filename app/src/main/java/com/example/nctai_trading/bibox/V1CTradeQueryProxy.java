package com.example.nctai_trading.bibox;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class V1CTradeQueryProxy extends BaseProxy
{

    public V1CTradeQueryProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_C_QUERY);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryAssets() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryAssetsCmd());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryDeals(String index, String pair, Integer size) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryDealsGetCmd(index,pair, size));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryOrder(String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryOrderCmd(pair));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryOrderAll(String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryOrderAllCmd(pair));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryOrderPending(CQueryOrderPendingParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryOrderPendingCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryOrderPendingByIds(List<Long> ids) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryOrderPendingCmd(ids));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String cQueryOrderList(CQueryOrderListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCQueryOrderListCmd(params));
    }
}
