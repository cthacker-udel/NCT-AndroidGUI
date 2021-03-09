package com.example.nctai_trading.binance;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface binanceTradesInterface {

    @GET("https://api.binance.us/api/v3/historicalTrades")
    Call<List<binanceHistoricalTrade>> getHistoricalTrades(@QueryMap Map<String, String> filters, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/aggTrades")
    Call<List<binanceAggTrade>> getAggTrades(@QueryMap Map<String,String> filters, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/avgPrice")
    Call<binanceAveragePrice> getAvgPrice(@QueryMap Map<String,String> filters, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/ticker/24hr")
    Call<List<binance24HourChange>> get24HourChangeNoSymbol(@Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/ticker/24hr")
    Call<binance24HourChange> get24HourChangeSymbol(@QueryMap Map<String,String> filters, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/ticker/bookTicker")
    Call<List<binanceBookTicker>> getBookTickerNoSymbol(@Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/ticker/bookTicker")
    Call<binanceBookTicker> getBookTickerSymbol(@QueryMap Map<String,String> data, @Header("X-MBX-APIKEY") String apiKey);



}
