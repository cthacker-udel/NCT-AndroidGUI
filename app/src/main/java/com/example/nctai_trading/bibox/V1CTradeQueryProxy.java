package com.example.nctai_trading.bibox;


import java.io.IOException;
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

    public String cQueryAssets() throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryAssetsCmd());
    }

    public String cQueryDeals(String index, String pair, Integer size) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryDealsGetCmd(index,pair, size));
    }

    public String cQueryOrder(String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryOrderCmd(pair));
    }

    public String cQueryOrderAll(String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryOrderAllCmd(pair));
    }

    public String cQueryOrderPending(CQueryOrderPendingParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryOrderPendingCmd(params));
    }

    public String cQueryOrderPendingByIds(List<Long> ids) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryOrderPendingCmd(ids));
    }

    public String cQueryOrderList(CQueryOrderListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createCQueryOrderListCmd(params));
    }
}
