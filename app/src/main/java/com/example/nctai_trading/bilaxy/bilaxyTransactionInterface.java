package com.example.nctai_trading.bilaxy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bilaxyTransactionInterface {

    @GET("https://api.bilaxy.com/v1/orders")
    Call<List<bilaxyRecentTransaction>> getRecentTransactions(@Field("symbol") String symbol, @Field("size") Integer size, @Header("key") String apiKey, @Header("sign") String signature);

}
