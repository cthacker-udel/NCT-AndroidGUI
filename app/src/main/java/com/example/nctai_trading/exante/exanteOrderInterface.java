package com.example.nctai_trading.exante;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface exanteOrderInterface {

    @POST("https://api-demo.exante.eu/trade/")
    Call<exanteOrderResponse> placeOrder(@Header("Authorization") String applicationId, @Header("Authorization") String AccessKey, @Body Map<String,Object> body);


}
