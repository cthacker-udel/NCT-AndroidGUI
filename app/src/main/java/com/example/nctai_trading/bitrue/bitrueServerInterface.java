package com.example.nctai_trading.bitrue;

import com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface bitrueServerInterface {

    @GET("https://www.bitrue.com/api/v1/ping")
    Call<Object> serverPing();

    @GET("https://www.bitrue.com/api/v1/time")
    Call<com.example.nctai_trading.bitrue.serverObject.serverTimeResponse> getServerTime();

    @GET("https://www.bitrue.com/api/v1/exchangeInfo")
    Call<exchangeInfoResponse> getExchangeInfo();


}
