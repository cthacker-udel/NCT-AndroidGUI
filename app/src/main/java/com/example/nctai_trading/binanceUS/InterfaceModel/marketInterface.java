package com.example.nctai_trading.binanceUS.InterfaceModel;

import com.example.nctai_trading.binanceUS.Controller.MarketAPI.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.HashMap;
import java.util.List;

public interface marketInterface {

    @GET("https://api.binance.us/api/v3/depth")
    Call<OrderBook> getOrderBook(@QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/trades")
    Call<List<RecentTrade>> getRecentTrade(@QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/historicalTrades")
    Call<List<RecentTrade>> getOldTrade(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/aggTrades")
    Call<List<AggOrCompressedTrade>> getAggOrCompressedTrades(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/klines")
    Call<List<List<Integer>>> getKlineData(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/avgPrice")
    Call<AvgPrice> getAveragePrice(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/ticker/24hr")
    Call<TwentyFourPriceChange> getTwentyFourHourChange(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/ticker/price")
    Call<List<PriceTicker>> getPriceTicker(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/ticker/bookTicker")
    Call<List<OrderBookTicker>> getOrderBookPrice(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
