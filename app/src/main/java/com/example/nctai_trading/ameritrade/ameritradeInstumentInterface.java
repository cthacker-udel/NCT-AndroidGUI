package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface ameritradeInstumentInterface {

    @GET("https://api.tdameritrade.com/v1/instruments")
    Call<ameritradeSearchInstrumentInstrument> searchInstruments(@Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);



}
