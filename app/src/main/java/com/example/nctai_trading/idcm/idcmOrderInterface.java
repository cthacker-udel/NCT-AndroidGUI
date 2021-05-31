package com.example.nctai_trading.idcm;

import com.example.nctai_trading.idcm.OrderInfo.OrderInfo;
import com.example.nctai_trading.idcm.UserInfo.UserInfo;

import java.util.Map;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface idcmOrderInterface {

    @POST("https://api.IDCM.cc:8323/api/v1/trade")
    Call<idcmOrderResponse> placeOrder(@Header("X-IDCM-APIKEY") String apiKey, @Header("X-IDCM-SIGNATURE") String signature, @Header("X-IDCM-INPUT") String encodedParams, @Body Map<String,Object> body);

    @POST("https://api.IDCM.cc:8323/api/v1/getuserinfo")
    Call<UserInfo> getAccountInfo(@Header("X-IDCM-APIKEY") String apiKey, @Header("X-IDCM-SIGNATURE") String signature, @Header("X-IDCM-INPUT") String encodedParams, @Body Map<String,Object> body);

    @POST("https://api.IDCM.cc:8323/api/v1/gethistoryorder")
    Call<OrderInfo> getHistoricalOrderInfo(@Header("X-IDCM-APIKEY") String apiKey, @Header("X-IDCM-SIGNATURE") String signature, @Header("X-IDCM-INPUT") String encodedParams, @Body Map<String,Object> body);

}
