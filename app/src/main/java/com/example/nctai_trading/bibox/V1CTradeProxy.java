package com.example.nctai_trading.bibox;



import java.io.IOException;
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


    public String orderOpen(CTradeOrderOpenParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderOpenCmd(params));
    }

    //fixme 批量下单有问题
    public String orderOpenBatch()
    {
        return null;
    }

    public String orderClose(String orderId) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderCloseCmd(orderId));
    }

    public String orderCloseBatch(List<String> orderId) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderCloseBatchCmd(orderId));
    }

    public String orderCloseAll(String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderCloseAllCmd(pair));
    }

    public String orderChangeLeverage(String pair, Integer leverage, Integer cross) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderChangeLeveragelCmd(pair, leverage, cross));
    }

    public String orderChangeMargin(String pair, Double margin) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeOrderChangeMarginCmd(pair, margin));
    }

    public String transferIn(String amount) throws IOException
    {
        return postSign(V1ParamsUtils.createCTradeTransferInCmd(amount));
    }
}
