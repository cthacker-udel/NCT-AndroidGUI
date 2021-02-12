package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitmexAccouncementsInterface {

    @GET("https://www.bitmex.com/api/v1/announcement")
    Call<List<bitmexAnnouncement>> getAnnouncement(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

}
