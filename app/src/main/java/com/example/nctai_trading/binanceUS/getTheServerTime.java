package com.example.nctai_trading.binanceUS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getTheServerTime {

    @GET("/api/v3/time")
    Call<serverTime> gettheServerTime();

}