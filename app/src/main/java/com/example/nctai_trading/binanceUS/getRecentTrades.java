package com.example.nctai_trading.binanceUS;

import com.example.nctai_trading.Trades;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface getRecentTrades {

    @GET("https://api.binance.us/api/v3/trades")
    Call<List<Trades>> getRecentTrades(@QueryMap Map<String,String> map);

}
