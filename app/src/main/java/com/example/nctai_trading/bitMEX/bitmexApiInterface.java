package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitmexApiInterface {

    @GET("https://www.bitmex.com/api/v1/apiKey")
    Call<List<bitmexApiKey>> getApiKeys(@Header("api-expires") String timestamp, @Header("api-key") String key, @Header("api-signature") String signature);

}
