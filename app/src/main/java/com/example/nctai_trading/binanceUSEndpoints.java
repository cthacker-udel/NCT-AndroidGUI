package com.example.nctai_trading;

import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface binanceUSEndpoints {

    @GET("/serverSpeed")
    Call<Long> getServerSpeed();

    @GET("/orderBook")
    Call<OrderBook> getOrderBook();

    @GET("/orderBookAsks")
    Call<List<OrderBookEntry>> getOrderBookAsks();

}
