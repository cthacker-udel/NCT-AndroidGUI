package com.example.nctai_trading.bibox;

import com.alibaba.fastjson.JSON;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ChannelUtils
{
    public static String getKLineChannel(KLinePeriodEnum period, String pair)
    {
        return String.format("bibox_sub_spot_%s_kline_%s", pair, period.getPeriod());
    }

    public static String getMarketALLChannel()
    {
        return "bibox_sub_spot_ALL_ALL_market";
    }

    public static String getDepthChannel(String pair)
    {
        return String.format("bibox_sub_spot_%s_depth", pair);
    }

    public static String getTickerChannel(String pair)
    {
        return String.format("bibox_sub_spot_%s_ticker", pair);
    }

    public static String getDealsChannel(String pair)
    {
        return String.format("bibox_sub_spot_%s_deals", pair);
    }

    public static String getLoginChannel()
    {
        return "bibox_sub_spot_ALL_ALL_login";
    }

    public static String getIndexMarket()
    {
        return "bibox_sub_spot_ALL_ALL_indexMarket";
    }

    public static String getContractPriceLimit()
    {
        return "bibox_sub_spot_ALL_ALL_contractPriceLimit";
    }

    public static String removeChannelMessage(String channel)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("event", "removeChannel");
        map.put("channel", channel);
        return JSON.toJSONString(map);
    }

    public static String subChannelMessage(String channel)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("event", "addChannel");
        map.put("channel", channel);
        return JSON.toJSONString(map);
    }

    public static String loginSubChannel(String apiKey, String secret) throws InvalidKeyException, NoSuchAlgorithmException {
        Map<String, String> params = new TreeMap<>();
        params.put("event", "addChannel");
        params.put("channel", "bibox_sub_spot_ALL_ALL_login");
        params.put("apikey", apiKey);
        params.put("sign", ApiKeyUtils.sign(secret, JSON.toJSONString(params)));
        return JSON.toJSONString(params);
    }
}
