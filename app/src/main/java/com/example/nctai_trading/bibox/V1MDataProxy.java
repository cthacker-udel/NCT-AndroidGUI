package com.example.nctai_trading.bibox;



import java.io.IOException;

public class V1MDataProxy extends BaseProxy
{

    public V1MDataProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_MDATA_URL);
    }

    public String ping() throws IOException
    {
        return post(V1ParamsUtils.createPingCmd());
    }

    public String pairList() throws IOException
    {
        return post(V1ParamsUtils.createAPIPairListCmd());
    }

    public String kline(String pair, KLinePeriodEnum period, Integer size) throws IOException
    {
        return post(V1ParamsUtils.createKLineCmd(pair, period, size));
    }

    public String marketAll() throws IOException
    {
        return post(V1ParamsUtils.createMarketAllCmd());
    }

    public String market(String pair) throws IOException
    {
        return post(V1ParamsUtils.createMarketCmd(pair));
    }

    public String depth(String pair, Integer size) throws IOException
    {
        return post(V1ParamsUtils.createDepthCmd(pair, size));
    }

    public String deals(String pair, Integer size) throws IOException
    {
        return post(V1ParamsUtils.createDealsCmd(pair, size));
    }

    public String ticker(String pair) throws IOException
    {
        return post(V1ParamsUtils.createTickerCmd(pair));
    }
}
