package com.example.nctai_trading.coinbasePro;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.HeaderMap;

public interface cancelAllCoinBaseOrders {

    @DELETE("https://api.pro.coinbase.com/orders")
    Call<List<String>> cancelAllOrders(@HeaderMap Map<String,String> authHeaders);

}
