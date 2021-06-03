package com.example.nctai_trading.bitcoincom;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface bitcoincomOrderInterface {
    @POST("https://api.exchange.bitcoin.com/api/2/order")
    Call<bitcoincomOrderResponse> placeOrder(@Header("Authorization") String auth, @Body Map<String,Object> body);

    @DELETE("https://api.exchange.bitcoin.com/api/2/order")
    Call<List<DeletedOrder>> cancelAllOrders(@Header("Authorization") String auth);


}
