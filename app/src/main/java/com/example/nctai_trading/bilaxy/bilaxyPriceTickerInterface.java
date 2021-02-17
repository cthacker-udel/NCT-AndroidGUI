package com.example.nctai_trading.bilaxy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bilaxyPriceTickerInterface {

    @GET("https://api.bilaxy.com/v1/ticker")
    Call<bilaxySinglePriceTicker> getSinglePriceTicker(@Field("symbol") String symbol, @Header("key") String apiKey, @Header("sign") String signature);

    @GET("https://api.bilaxy.com/v1/tickers")
    Call<List<bilaxySinglePriceTicker>> getPriceTickers(@Field("symbol") String symbol, @Header("key") String key, @Header("sign") String signature);

}
