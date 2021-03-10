package com.example.nctai_trading.bibox;



import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class V1CTradeProxy extends BaseProxy
{

    public V1CTradeProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_C_TRADE);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderOpen(CTradeOrderOpenParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderOpenCmd(params));
    }

    //fixme 批量下单有问题
    public String orderOpenBatch()
    {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderClose(String orderId) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderCloseCmd(orderId));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderCloseBatch(List<String> orderId) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderCloseBatchCmd(orderId));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderCloseAll(String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderCloseAllCmd(pair));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderChangeLeverage(String pair, Integer leverage, Integer cross) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderChangeLeveragelCmd(pair, leverage, cross));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderChangeMargin(String pair, Double margin) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeOrderChangeMarginCmd(pair, margin));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferIn(String amount) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCTradeTransferInCmd(amount));
    }
}
