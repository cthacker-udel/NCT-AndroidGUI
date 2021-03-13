package com.example.nctai_trading.btse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface btseOrderInterface {

    @POST("https://testapi.btse.io/spot/api/v3.2/order")
    Call<btseOrderResponse> placeOrder(@Body Map<String,Object> body, @Header("btse-nonce") Long timestamp, @Header("btse-api") String apiKey, @Header("btse-sign") String signature);

}
