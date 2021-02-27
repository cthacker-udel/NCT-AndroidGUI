package com.example.nctai_trading.bitforex;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface bitforexOrderInterface {

    @POST("https://api.bitforex.com/api/v1/trade/placeOrder")
    Call<bitforexOrderResponse> placeOrder(@Query("accessKey") String apiKey, @Query("amount") Double amount, @Query("nonce") Long nonce, @Query("price") Double price, @Query("symbol") String symbol, @Query("signData") String signature);

    @POST("https://api.bitforex.com/api/v1/trade/cancelOrder")
    Call<bitforexCancelOrderResponse> cancelOrder(@Query("accessKey") String apiKey, @Query("nonce") Long nonce, @Query("orderId") Long orderId, @Query("signData") String signData, @Query("symbol") String symbol);

}
