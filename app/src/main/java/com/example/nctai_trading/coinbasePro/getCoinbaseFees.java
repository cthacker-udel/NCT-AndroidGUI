package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface getCoinbaseFees {

    @GET("https://api.pro.coinbase.com/fees")
    Call<coinbaseFees> getFees(@HeaderMap Map<String,String> authMap);

}
