package com.example.nctai_trading.bilaxy;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bilaxyMarketDepthInterface {

    @GET("https://api.bilaxy.com/v1/depth")
    Call<bilaxyMarketDepth> getMarketDepth(@Field("symbol") String symbol, @Field("merge") Integer merge, @Header("key") String apiKey, @Header("sign") String signature);

}
