package com.example.nctai_trading;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface getCoinBaseAccount {

    @GET("https://api.pro.coinbase.com/accounts/{id}")
    Call<coinBaseAccount> getCoinBaseAccountCall(@Path("id") String id, @HeaderMap Map<String,String> authMap);


}
