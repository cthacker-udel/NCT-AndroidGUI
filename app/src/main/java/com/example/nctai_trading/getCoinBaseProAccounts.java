package com.example.nctai_trading;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface getCoinBaseProAccounts {

    @GET("https://api.pro.coinbase.com")
    Call<List<coinBaseListAccount>> getAccounts(@QueryMap Map<String,String> queryString, @Header ("secretkey") String theSecretKey);

}
