package com.example.nctai_trading.bitrue;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface orderInterface {

    @POST("https://www.bitrue.com/api/v1/order")
    Call<bitrueOrderResponse> placeOrder(@Header("X-MBX-APIKEY") String apiKey, @Query("symbol") String symbol, @Query("side") String side, @Query("type") String type, @Query("quantity") int quantity, @Query("timestamp") long timestamp, @Query("signature") String signature);

}
