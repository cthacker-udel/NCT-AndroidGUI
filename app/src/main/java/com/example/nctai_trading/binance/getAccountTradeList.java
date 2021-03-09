package com.example.nctai_trading.binance;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface getAccountTradeList {

    @GET("https://api.binance.us/api/v3/myTrades")
    Call<List<TradeListTrade>> getAccountTradeListQuery(@QueryMap Map<String,String> map, @Header("X-MBX-APIKEY") String header);

}
