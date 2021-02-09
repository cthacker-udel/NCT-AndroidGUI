package com.example.nctai_trading.bithumb;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface bithumbServerInterface {

    @GET("https://global-openapi.bithumb.pro/openapi/v1/serverTime")
    Call<bithumbServerTimeResponse> getServerTime();

}
