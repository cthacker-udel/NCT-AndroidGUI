package com.example.nctai_trading.binance;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface binanceOrdersInterface {

    @DELETE("https://api.binance.us/api/v3/order")
    Call<binanceCancelOrder> cancelOrder(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @DELETE("https://api.binance.us/api/v3/openOrders")
    Response cancelAllOrdersSymbol(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/openOrders")
    Call<List<binanceOrderListOrder>> getAllOpenOrdersNoSymbol(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/openOrders")
    Call<List<binanceOrderListOrder>> getAllOpenOrdersSymbol(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/allOrders")
    Call<List<binanceOrderListOrder>> getAllOpenOrdersAcct(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @POST("https://api.binance.us/api/v3/order/oco")
    Call<binanceOCOTrade> createOCOTrade(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @DELETE("https://api.binance.us/api/v3/orderList")
    Call<binanceOCOTrade> cancelOCOTradeOrderListId(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @DELETE("https://api.binance.us/api/v3/orderList")
    Call<binanceSpecificOCO> cancelSpecificOCOTradeOrder(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @DELETE("https://api.binance.us/api/v3/allOrderList")
    Call<List<binanceSpecificOCO>> cancelAllSpecificOCO(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

    @GET("https://api.binance.us/api/v3/openOrderList")
    Call<List<binanceSpecificOCO>> getAllOpenOCO(@QueryMap Map<String,String> authMap, @Header("X-MBX-APIKEY") String apiKey);

}
