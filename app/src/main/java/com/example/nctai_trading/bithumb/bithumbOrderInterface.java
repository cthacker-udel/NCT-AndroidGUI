package com.example.nctai_trading.bithumb;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface bithumbOrderInterface {

    @GET("https://global-openapi.bithumb.pro/openapi/v1/spot/placeOrder")
    Call<bithumbVirtualCoinOrder> placeVirtualCoinOrder(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/spot/cancelOrder")
    Call<Void> cancelVirtualCoinOrder(@HeaderMap Map<String,String> authHeader);

    @GET("https://global-openapi.bithumb.pro/openapi/v1/spot/assetList")
    Call<bithumbVirtualCoinAsset> getVirtualCoinAssets(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/spot/cancelOrder/batch")
    Call<Void> batchCancelOrders(@HeaderMap Map<String,String> authHeader);

}
