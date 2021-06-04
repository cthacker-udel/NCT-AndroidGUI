package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface bitmexFundingInterface {

    @GET("https://www.bitmex.com/api/v1/funding")
    Call<List<bitmexFunding>> getFunding(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @DELETE("https://www.bitmex.com/api/v1/order/cancelAllAfter")
    Call<Void> cancelAllOrders(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature, @Query("timeout") Integer timeout);

}
