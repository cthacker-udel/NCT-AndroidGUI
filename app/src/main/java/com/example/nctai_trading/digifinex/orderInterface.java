package com.example.nctai_trading.digifinex;

import com.example.nctai_trading.digifinex.order.orderResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface orderInterface {

    @POST("https://openapi.digifinex.vip/v2/trade")
    Call<orderResponse> placeLimitOrder(@Body Map<String,Object> body);

}
