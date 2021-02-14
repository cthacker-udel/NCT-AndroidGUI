package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitmexInstrumentInterface {

    @GET("https://www.bitmex.com/api/v1/instrument")
    Call<List<bitmexInstrument>> getInstruments(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

}
