package com.example.nctai_trading.bitrue;

import com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface bitrueMarketDataInterface {

    @GET("https://www.bitrue.com/api/v1/depth")
    Call<exchangeInfoResponse> getExchangeInfo(@Query("symbol") String symbol);

}
