package com.example.nctai_trading.bkex;

import com.example.nctai_trading.bkex.exchangeInfo.exchangeInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bkexExchangeInfoInterface {

    @GET("https://api.bkex.com/v1/exchangeInfo")
    Call<exchangeInfoResponse> getExchangeInfo();

}
