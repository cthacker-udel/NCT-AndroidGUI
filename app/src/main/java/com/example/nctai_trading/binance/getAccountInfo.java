package com.example.nctai_trading.binance;



import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface getAccountInfo {

    @GET("https://api.binance.us/api/v3/account")
    Call<Account> getAccount(@QueryMap Map<String,String> filters, @Header ("X-MBX-APIKEY") String apiKey);
}
