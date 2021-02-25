package com.example.nctai_trading.bitforex;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface bitforexTickerInterface {


    @GET("https://api.bitforex.com/api/v1/market/ticker")
    //Call<bitforexTickerInformation> getTickerInformation(@Query("accessKey") String apiKey, @Query("signData") String signature);
    Call<bitforexTickerInformation> getTickerInformation(@Query("symbol") String symbol);

}
