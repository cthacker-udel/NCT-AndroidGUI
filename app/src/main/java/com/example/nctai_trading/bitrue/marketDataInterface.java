package com.example.nctai_trading.bitrue;

import com.example.nctai_trading.bitrue.orderBook.marketDataOrderBook;
import com.example.nctai_trading.bitrue.recentTrades.marketDataRecentTrades;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface marketDataInterface {

    @GET("https://www.bitrue.com/api/v1/depth")
    Call<marketDataOrderBook> getOrderBook(@Query("symbol") String symbol);

    @GET("https://www.bitrue.com/api/v1/trades")
    Call<marketDataRecentTrades> getRecentTrades(@Query("symbol") String symbol);

    @GET("https://www.bitrue.com/api/v1/historicalTrades")
    Call<marketDataRecentTrades> getPastTrades(@Query("symbol") String symbol);


}
