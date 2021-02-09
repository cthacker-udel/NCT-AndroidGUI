package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface ameritradeMarketHours {

    @GET("https://api.tdameritrade.com/v1/marketdata/hours")
    Call<ameritradeGetMultipleMarketHoursResponse> getHoursForMultipleMarkets(@Body Map<String,String>body, @HeaderMap Map<String,String> map);

    @GET("https://api.tdameritrade.com/v1/marketdata/{market}/hours")
    Call<ameritradeGetMultipleMarketHoursResponse> getHoursForSingleMarket(@Path("market") String market, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);


}
