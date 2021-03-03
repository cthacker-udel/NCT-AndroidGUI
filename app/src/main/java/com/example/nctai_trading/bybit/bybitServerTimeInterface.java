package com.example.nctai_trading.bybit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bybitServerTimeInterface {

    @GET("https:/api.bybit.com/v2/public/time")
    Call<bybitServerTimeResponse> getServerTime();

}
