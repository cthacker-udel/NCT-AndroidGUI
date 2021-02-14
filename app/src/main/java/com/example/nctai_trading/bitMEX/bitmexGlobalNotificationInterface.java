package com.example.nctai_trading.bitMEX;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitmexGlobalNotificationInterface {

    @GET("https://www.bitmex.com/api/v1/globalNotification")
    Call<bitmexGlobalNotification> getGlobalNotification(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

}
