package com.example.nctai_trading.basefex;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface basefexTradesInterface {

    @GET("https://api.basefex.com/trades")
    Call<List<basefexTradeListTrade>> getTradeList(@Header("api-expires") String timestamp, @Header("api-key") String apikey, @Header("api-signature") String signature, @QueryMap Map<String,String> queryMap);

    @GET("https://api.basefex.com/trades/count")
    Call<basefexCountOrdersCount> getTradeCount(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature, @QueryMap Map<String,String> queryMap);

}
