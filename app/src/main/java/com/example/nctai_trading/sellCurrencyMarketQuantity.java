package com.example.nctai_trading;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface sellCurrencyMarketQuantity {

    @FormUrlEncoded
    @POST("https://api.binance.us/api/v3/order")
    Call<Sale> sellCurrencyMarketCall(@QueryMap Map<String,String> map, @Header("X-MBX-APIKEY") String apiKey);

}
