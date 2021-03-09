package com.example.nctai_trading.binance;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface getAveragePrice {

    @GET("https://api.binance.us/api/v3/avgPrice")
    Call<AveragePrice> getAvgPrice(@QueryMap Map<String,String> map);

}
