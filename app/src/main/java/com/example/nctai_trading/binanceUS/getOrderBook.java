package com.example.nctai_trading.binanceUS;

import com.example.nctai_trading.OrderBook;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface getOrderBook {

    @GET("https://api.binance.us/api/v3/depth")
    Call<OrderBook> getOrderBook(@QueryMap Map<String,String> map);

}
