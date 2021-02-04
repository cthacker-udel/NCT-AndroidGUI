package com.example.nctai_trading.coinbasePro;

import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface cancelCoinBaseOrder {

    @DELETE("https://api.pro.coinbase.com/orders/{id}")
    Response cancelCoinbaseOrder(@Path("id") String orderId);

}
