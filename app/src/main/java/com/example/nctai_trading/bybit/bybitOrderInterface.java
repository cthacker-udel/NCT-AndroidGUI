package com.example.nctai_trading.bybit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface bybitOrderInterface {

    @POST("https://api-testnet.bybit.com/private/linear/order/create")
    Call<bybitOrderResponse> placeOrder(@Header("api_key") String api, @Header("timestamp") Object timestamp, @Header("sign") String signature, @Body Map<String,String> body);

}
