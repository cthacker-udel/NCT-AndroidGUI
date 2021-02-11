package com.example.nctai_trading.alpaca;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface alpacaOrderInterface {

    @GET("https://paper-api.alpaca.markets/v2/orders")
    Call<List<alpacaOrderListOrder>> getListOfOrders(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    //@FormUrlEncoded
    //@POST("https://paper-api.alpaca.markets/v2/orders")
    //Call<alpacaOrderListOrder> placeOrder(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey, @Field("symbol") String symbol, @Field("qty") Integer quantity, @Field("side") String side, @Field("type") String type, @Field("time_in_force") String timeInForce);

    @POST("https://paper-api.alpaca.markets/v2/orders")
    Call<alpacaOrderListOrder> placeOrder(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey, @Body Map<Object,Object> body);

}
