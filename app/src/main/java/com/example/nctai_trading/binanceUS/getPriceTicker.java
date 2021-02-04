package com.example.nctai_trading.binanceUS;

import com.example.nctai_trading.PriceTicker;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface getPriceTicker {

    @GET("https://api.binance.us/api/v3/ticker/price")
    Call<PriceTicker> getPriceTicker(@QueryMap Map<String,String> map);
}
