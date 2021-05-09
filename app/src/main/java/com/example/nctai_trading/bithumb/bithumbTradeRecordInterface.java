package com.example.nctai_trading.bithumb;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface bithumbTradeRecordInterface {

    @GET("https://global-openapi.bithumb.pro/openapi/v1/spot/trades")
    Call<bithumbTradeRecordResponse> getTradeRecord(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/spot/myTrades")
    Call<List<bithumbmyTrades>> getMyTrades(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/spot/openOrders")
    Call<List<bithumbOpenOrder>> getOpenOrders(@HeaderMap Map<String,String> authHeader);

}
