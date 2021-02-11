package com.example.nctai_trading.basefex;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface basefexOrdersInterface {

    @GET("https://api.basefex.com/orders/{orderId}")
    Call<basefexGetOrderId> getOrderId(@Path("orderId") String orderId, @Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @POST("https://api.basefex.com/orders")
    Call<basefexPlaceOrderResponse> placeOrder(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature, @Body Map<String,Object> body);

    @DELETE("https://api.basefex.com/orders/{orderId}")
    Response cancelOrder(@Path("orderId") String orderId, @Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://api.basefex.com/orders")
    Call<List<basefexOrderListOrder>> getOrderList(@Header("api-expires") String timestamp, @Header("api-key") String apikey, @Header("api-signature") String signature);

}
