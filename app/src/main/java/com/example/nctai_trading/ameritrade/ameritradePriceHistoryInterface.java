package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface ameritradePriceHistoryInterface {

    @GET("https://api.tdameritrade.com/v1/marketdata/{symbol}/pricehistory")
    Call<ameritradePriceHistoryResponse> getPriceHistory(@Path("symbol") String symbol, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

}
