package com.example.nctai_trading.bilaxy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface bilaxyInterfacesInterface {

    @GET("https://api.bilaxy.com/v1/coin_address")
    Call<bilaxyDepositAddress> getDepositAddress(@Field("symbol") String symbol, @Header("key") String apiKey, @Header("sign") String signature);

    @GET("https://api.bilaxy.com/v1/trade_list")
    Call<List<bilaxyOrderQuery>> getOrderQueries(@Field("symbol") String symbol, @Field("since") String timestamp, @Field("type") String type, @Header("key") String apiKey, @Header("sign") String signature);

    @GET("https://api.bilaxy.com/v1/trade_view")
    Call<bilaxyOrderQuery> getOrderQuery(@Field("id") String orderId, @Header("key") String apiKey, @Header("sign") String signature);

    @POST("https://api.bilaxy.com/v1/cancel_trade")
    Call<bilaxyDepositAddress> cancelOrder(@Field("id") String orderId, @Header("key") String apiKey, @Header("sign") String signature);

    @POST("https://api.bilaxy.com/v1/trade")
    Call<bilaxyDepositAddress> placeOrder(@Field("symbol") String symbol, @Field("amount") String amount, @Field("price") Double price, @Field("type") String type, @Header("key") String apiKey, @Header("sign") String signature);



}
