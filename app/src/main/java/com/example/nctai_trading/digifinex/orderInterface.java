package com.example.nctai_trading.digifinex;

import com.example.nctai_trading.digifinex.order.orderResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import com.example.nctai_trading.digifinex.openOrders.openOrder;
import com.example.nctai_trading.digifinex.orderHistory.orderHistory;

public interface orderInterface {

    @POST("https://openapi.digifinex.vip/v2/trade")
    Call<orderResponse> placeLimitOrder(@Body Map<String,Object> body);

    @GET("https://openapi.digifinex.vip/v2/open_orders")
    Call<openOrder> getOpenOrders(@QueryMap Map<String,Object> queries);

    @GET("https://openapi.digifinex.vip/v2/order_history")
    Call<orderHistory> getOrderHistory(@QueryMap Map<String,Object> queries);

}
