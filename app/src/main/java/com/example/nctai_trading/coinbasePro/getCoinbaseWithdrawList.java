package com.example.nctai_trading.coinbasePro;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface getCoinbaseWithdrawList {

    @GET("https://api.pro.coinbase.com/transfers")
    Call<List<coinbaseProWithdrawl>> getCoinbaseWithdrawList(@HeaderMap Map<String,String> authMap);

}
