package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface getCoinBaseDeposit {

    @GET("https://api.pro.coinbase.com/transfers/:{id}")
    Call<coinbaseProDeposit> getSingleDeposit(@Path("id") String transferId, @HeaderMap Map<String,String> authMap);

}
