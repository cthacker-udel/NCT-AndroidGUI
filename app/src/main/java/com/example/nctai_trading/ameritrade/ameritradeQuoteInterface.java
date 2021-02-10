package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface ameritradeQuoteInterface {

    @GET("https://api.tdameritrade.com/v1/marketdata/{symbol}/quotes")
    Response getQuoteForSymbol(@Path("symbol") String symbol, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

    @GET("https://api.tdameritrade.com/v1/marketdata/quotes")
    Response getQuotesForSymbols(@Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);


}
