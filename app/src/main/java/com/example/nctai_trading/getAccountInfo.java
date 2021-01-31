package com.example.nctai_trading;

import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface getAccountInfo {

    @GET("https://api.binance.us/api/v3/account")
    Call<Account> getAccount(@QueryMap Map<String,String> filters, @Header ("X-MBX-APIKEY") String apiKey);
}
