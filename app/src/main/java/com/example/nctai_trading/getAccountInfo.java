package com.example.nctai_trading;

import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getAccountInfo {

    @GET("/api/v3/account")
    Call<Account> getAccount();
}
