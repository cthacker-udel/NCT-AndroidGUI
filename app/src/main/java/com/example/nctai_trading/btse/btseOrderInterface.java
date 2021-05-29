package com.example.nctai_trading.btse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface btseOrderInterface {

    @POST("https://testapi.btse.io/spot/api/v3.2/order")
    Call<btseOrderResponse> placeOrder(@Body Map<String,Object> body, @Header("btse-nonce") Long timestamp, @Header("btse-api") String apiKey, @Header("btse-sign") String signature);

    @GET("https://api.btse.io/spot/api/v3.2/user/open_orders")
    Call<List<openOrder>> getListOfOpenOrders(@QueryMap Map<String,Object> queries, @Header("btse-nonce") Long timestamp, @Header("btse-api") String apiKey, @Header("btse-sign") String signature);

    @GET("https://api.btse.com/spot/api/v3.2/user/trade_history")
    Call<List<historyTrade>> getTradeHistory(@Header("btse-nonce") Long timestamp, @Header("btse-api") String apiKey, @Header("btse-sign") String signature);

    @GET("https://api.btse.com/spot/api/v3.2/user/wallet_history")
    Call<List<walletHistory>> getWalletHistory(@Header("btse-nonce") Long timestamp, @Header("btse-api") String apiKey, @Header("btse-sign") String signature);
}


