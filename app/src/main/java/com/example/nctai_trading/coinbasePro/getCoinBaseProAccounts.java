package com.example.nctai_trading.coinbasePro;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface getCoinBaseProAccounts {

    @GET("https://api.pro.coinbase.com/accounts")
    Call<List<coinBaseListAccount>> getAccounts(@HeaderMap Map<String,String> strMap);

}
