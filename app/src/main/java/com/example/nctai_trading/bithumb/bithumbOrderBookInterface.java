package com.example.nctai_trading.bithumb;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface bithumbOrderBookInterface {

    @GET("https://global-openapi.bithumb.pro/openapi/v1/spot/orderBook")
    Call<bithumbOrderBookResponse> getOrderBook(@HeaderMap Map<String,String> authHeader);

}
