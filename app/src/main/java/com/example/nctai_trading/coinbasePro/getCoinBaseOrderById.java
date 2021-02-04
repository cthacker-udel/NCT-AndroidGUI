package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface getCoinBaseOrderById {

    @GET("https://api.pro.coinbase.com/orders/{id}")
    Call<coinBaseProSingleOrder> getSingleOrder(@Path("id") String id, @HeaderMap Map<String,String> authMap);

}
