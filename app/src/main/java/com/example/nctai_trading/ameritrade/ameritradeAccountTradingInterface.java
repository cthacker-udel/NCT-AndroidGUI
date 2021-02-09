package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ameritradeAccountTradingInterface {

    @DELETE("https://api.tdameritrade.com/v1/accounts/{accountId}/orders/{orderId}")
    Response cancelOrder(@Path("accountId") String accountId, @Path("orderId") String orderId, @HeaderMap Map<String,String> authHeader);

    @GET("https://api.tdameritrade.com/v1/accounts/{accountId}/orders/{orderId}")
    Call<ameritradeGetOrderResponse> getSpecificAccountOrder(@Path("accountId") String accountId, @Path("orderId") String orderId, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.tdameritrade.com/v1/accounts/{accountId}/orders")
    Response placeOrder(@Path("accountId") String accountId, @Body Map<String,Object> body, @HeaderMap Map<String,String> authHeader);

    @PUT("https://api.tdameritrade.com/v1/accounts/{accountId}/orders/{orderId}")
    Response replaceOrderId(@Path("accountId") String accountId, @Path("orderId") String orderId, @Body Map<String,Object> body, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.tdameritrade.com/v1/accounts/{accountId}/savedorders")
    Response createSavedOrder(@Path("accountId") String accountId, @Body Map<String,Object> body, @HeaderMap Map<String,String> authHeader);

    @DELETE("https://api.tdameritrade.com/v1/accounts/{accountId}/savedorders/{savedOrderId}")
    Response deleteSavedOrder(@Path("accountId") String accountId, @Path("savedOrderId") String OrderId, @Body Map<String,Object> body, @HeaderMap Map<String,String> authHeader);

    @GET("https://api.tdameritrade.com/v1/accounts/{accountId}")
    Call<ameritradeGetAccountMarginAccount> getAccount(@Path("accountId") String accountId, @HeaderMap Map<String,String> authHeader);

}
