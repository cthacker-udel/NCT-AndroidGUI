package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface getCoinbaseConversion {

    @POST("https://api.pro.coinbase.com/conversions")
    Call<coinbaseConversionResponse> getConversionResponse(@HeaderMap Map<String,String> authMap, @Body Map<String,Object> body);

}
