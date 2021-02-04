package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface getCoinbaseWithdrawl {

    @GET("https://api.pro.coinbase.com/transfers/:{id}")
    Call<coinbaseProWithdrawl> getSingleWithdrawl(@Path("id") String transferID, @HeaderMap Map<String,String> authMap);

}
