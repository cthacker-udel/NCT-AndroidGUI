package com.example.nctai_trading;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface getOpenOrderList {

    @GET("https://api.binance.us/api/v3/openOrderList")
    Call<OpenOrderList> openOrderListQuery(@QueryMap Map<String,String> strMap, @Header("X-MBX-APIKEY") String theHeader);

}
