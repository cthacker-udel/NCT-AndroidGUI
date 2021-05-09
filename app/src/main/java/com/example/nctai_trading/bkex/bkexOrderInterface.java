package com.example.nctai_trading.bkex;

import com.example.nctai_trading.bkex.order.placeOrderResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface bkexOrderInterface {

    @POST("https://api.bkex.com/v1/u/trade/order/create")
    Call<placeOrderResponse> placeOrder(@Body Map<String,Object> body, @Header("X_ACCESS_KEY") String apikey, @Header("X_SIGNATURE") String signature);

    @POST("https://api.bkex.com/v1/u/trade/order/create")
    Call<Object> cancelOrder(@Body Map<String,Object> body, @Header("X_ACCESS_KEY") String apiKey, @Header("X_SIGNATURE") String signature);

    @GET("https://api.bkex.com/v1/u/trade/order/history")
    Call<Object> getOrderHistory(@Header("X_ACCESS_KEY") String apiKey, @Header("X_SIGNATURE") String signature);

    @GET("https://api.bkex.com/v1/u/trade/order/listUnfinished")
    Call<Object> getOpenOrders(@Header("X_ACCESS_KEY") String apiKey, @Header("X_SIGNATURE") String signature);
}
