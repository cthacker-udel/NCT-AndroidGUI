package com.example.nctai_trading.bithumb;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bithumbConfigInterface {

    @GET("https://global-openapi.bithumb.pro/openapi/v1/serverTime/spot/config")
    Call<bithumbConfigResponse> getConfig();

}
