package com.example.nctai_trading.exante;

import com.example.nctai_trading.exante.accountDetail.AccountSummary;
import com.example.nctai_trading.exante.activeOrders.activeOrder;
import com.example.nctai_trading.exante.historicalOrders.historicalOrder;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface exanteOrderInterface {

    @POST("https://api-demo.exante.eu/trade/")
    Call<exanteOrderResponse> placeOrder(@Header("Authorization") String applicationId, @Header("Authorization") String AccessKey, @Body Map<String,Object> body);

    @GET("https://api.exante.eu/md/3.0/summary/{id}/{currency}")
    Call<AccountSummary> getAccountDetails(@Header("Authorization") String applicationId, @Header("Authorization") String AccessKey, @Path("id") String accountId, @Path("currency") String currency);

    @GET("https://api.exante.eu/trade/3.0/orders")
    Call<List<historicalOrder>> getHistoricalOrders(@Header("Authorization") String applicationId, @Header("Authorization") String AccessKey, @QueryMap Map<String,String> queries);

    @GET("https://api.exante.eu/trade/3.0/orders/active")
    Call<List<activeOrder>> getActiveOrders(@Header("Authorization") String applicationId, @Header("Authorization") String AccessKey, @QueryMap Map<String,String> queries);

}

