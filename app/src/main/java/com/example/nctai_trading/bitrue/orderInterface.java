package com.example.nctai_trading.bitrue;

import com.example.nctai_trading.bitrue.accountOrder.accountOrder;
import com.example.nctai_trading.bitrue.accountTradeList.accountTrade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface orderInterface {

    @POST("https://www.bitrue.com/api/v1/order")
    Call<bitrueOrderResponse> placeOrder(@Header("X-MBX-APIKEY") String apiKey, @Query("symbol") String symbol, @Query("side") String side, @Query("type") String type, @Query("quantity") int quantity, @Query("timestamp") long timestamp, @Query("signature") String signature);

    @GET("https://www.bitrue.com/api/v1/myTrades")
    Call<List<accountTrade>> getAccountTradeList(@Header("X-MBX-APIKEY") String apiKey,@Query("timestamp") long timestamp, @Query("signature") String signature);

    @GET("https://www.bitrue.com/api/v1/allOrders")
    Call<List<accountOrder>> getAccountOrders(@Header("X-MBX-APIKEY") String apiKey,@Query("timestamp") long timestamp,@Query("symbol") String symbol, @Query("signature") String signature);

    @DELETE("https://www.bitrue.com/api/v1/order")
    Call<bitrueCancelOrder> cancelOrder(@Header("X-MBX-APIKEY") String apiKey, @Query("timestamp") long timestamp, @Query("symbol") String symbol, @Query("signature") String signature);

}
