package com.example.nctai_trading.alpaca;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface alpacaOrderInterface {

    @GET("https://paper-api.alpaca.markets/v2/orders")
    Call<List<alpacaOrderListOrder>> getListOfOrders(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @POST("https://paper-api.alpaca.markets/v2/orders")
    Call<alpacaOrderListOrder> placeOrder(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey, @Body Map<Object,Object> body);

    @GET("https://paper-api.alpaca.markets/v2/orders/{orderId}")
    Call<alpacaOrderListOrder> getOrderOrderId(@Path("orderId") String orderId, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @GET("https://paper-api.alpaca.markets/v2/orders:{clientOrderId}")
    Call<alpacaOrderListOrder> getOrderClientOrderId(@Path("clientOrderId") String clientOrderId, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @PATCH("https://paper-api.alpaca.markets/v2/orders/{orderId}")
    Call<alpacaOrderListOrder> replaceOrder(@Path("orderId") String orderId, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey, @Body Map<Object,Object> body);

    @DELETE("https://paper-api.alpaca.markets/v2/orders")
    Response deleteAllOrders(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @DELETE("https://paper-api.alpaca.markets/v2/orders/{orderId}")
    Response deleteOrder(@Path("orderId") String orderId, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);
}
