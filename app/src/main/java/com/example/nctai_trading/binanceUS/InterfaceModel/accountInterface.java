package com.example.nctai_trading.binanceUS.InterfaceModel;

import com.example.nctai_trading.binanceUS.Controller.AccountAPI.CancelOrder;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.NewOrder;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.OpenOrder;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.Order;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.QueryOrder;

import com.example.nctai_trading.binanceUS.Controller.AccountAPI.OCO.OCOTrade;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.OpenOCO.OpenOCO;
import com.example.nctai_trading.binanceUS.Controller.AccountAPI.AccountInfo.AccountInfo;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface accountInterface {

    @POST("https://api.binance.us/api/v3/order")
    Call<NewOrder> placeNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.binance.us/api/v3/order/test")
    Call<Void> testNewOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/order")
    Call<QueryOrder> queryOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @DELETE("https://api.binance.us/api/v3/order")
    Call<CancelOrder> cancelOrder(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @DELETE("https://api.binance.us/api/v3/openOrders")
    Call<List<CancelOrder>> cancelAllActiveOrdersOnSymbol(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/openOrders")
    Call<List<OpenOrder>> getCurrentOpenOrders(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @POST("https://api.binance.us/api/v3/order/oco")
    Call<OCOTrade> placeNewOCO(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @DELETE("https://api.binance.us/api/v3/orderList")
    Call<OCOTrade> cancelOCO(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/orderList")
    Call<OCOTrade> queryOCO(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/allOrderList")
    Call<List<OCOTrade>> queryAllOCO(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/openOrderList")
    Call<List<OpenOCO>> queryOpenOCO(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

    @GET("https://api.binance.us/api/v3/account")
    Call<AccountInfo> getAccountInformation(@Header("X-MBX-APIKEY") String apiKey, @QueryMap HashMap<String,Object> queries);

}
