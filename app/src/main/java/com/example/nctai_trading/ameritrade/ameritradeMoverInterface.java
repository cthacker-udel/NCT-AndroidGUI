package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface ameritradeMoverInterface {

    @GET("https://api.tdameritrade.com/v1/marketdata/{index}/movers")
    Call<ameritradeGetMoversResponse> getMovers(@Path("index") String index, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

}
