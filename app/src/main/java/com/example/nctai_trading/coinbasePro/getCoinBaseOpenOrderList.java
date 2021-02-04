package com.example.nctai_trading.coinbasePro;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface getCoinBaseOpenOrderList {

    @GET("https://api.pro.coinbase.com/orders")
    Call<List<coinbaseOpenOrderListOrder>> getCoinBaseOpenOrderList(@HeaderMap Map<String,String> authMap);

}
