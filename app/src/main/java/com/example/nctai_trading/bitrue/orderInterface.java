package com.example.nctai_trading.bitrue;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface orderInterface {

    @POST("https://www.bitrue.com/api/v1/order")
    Call<bitrueOrderResponse> placeOrder(@Query("symbol") String symbol, @Query("side") String side, @Query("type") String type, @Query("quantity") Double quantity, @Query("timestamp") Long timestamp, @Query("signature") String signature);

}
