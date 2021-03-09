package com.example.nctai_trading.wbf;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface wbfTransactionInterface {

    @GET("https://openapi.wbf.live/open/api/all_trade")
    Call<wbfTransactionRecords> getTransactionRecords(@Header("Content-Type") String contentType, @Query("symbol") String symbol);



}
