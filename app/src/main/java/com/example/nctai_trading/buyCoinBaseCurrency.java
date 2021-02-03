package com.example.nctai_trading;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface buyCoinBaseCurrency {
    @POST("https://api.pro.coinbase.com/orders")
    Call<coinBaseProPurchase> buyCoinBasePro(@Body Map<String,String> body, @HeaderMap Map<String,String> authMap);

}
