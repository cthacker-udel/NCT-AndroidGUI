package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitmexExecutionInterface {

    @GET("https://www.bitmex.com/api/v1/execution")
    Call<List<bitmexRawExecution>> getRawExecution(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://www.bitmex.com/api/v1/execution/tradeHistory")
    Call<List<bitmexRawExecution>> getExecutionTradeHistory(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

}
