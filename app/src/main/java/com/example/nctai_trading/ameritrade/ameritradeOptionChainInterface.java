package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface ameritradeOptionChainInterface {

    @GET("https://api.tdameritrade.com/v1/marketdata/chains")
    Response getOptionChain(@Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

}
