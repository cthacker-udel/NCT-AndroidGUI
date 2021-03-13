package com.example.nctai_trading.bkex;

import com.example.nctai_trading.bkex.order.placeOrderResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface bkexOrderInterface {

    @POST("https://api.bkex.com/v1/u/trade/order/create")
    Call<placeOrderResponse> placeOrder(@Body Map<String,Object> body, @Header("X_ACCESS_KEY") String apikey, @Header("X_SIGNATURE") String signature);


}
