package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface particleEventsInterface {

    @GET("https://api.particle.io/v1/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startStreamOfEvents(@Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/devices/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerSentStreamOfEvents(@Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/devices/{deviceId}/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerStreamForDevice(@Path("deviceId") String deviceId, @Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/products/{productId}/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerStreamForProduct(@Path("productId") String productId, @Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @POST("https://api.particle.io/v1/devices/events")
    Call<particleDeleteTokenResponse> publishEvent(@Body Map<String,String> body);

    @POST("https://api.particle.io/v1/products/{productid}/events")
    Call<particleDeleteTokenResponse> publishProductEvent(@Path("productid") String productId, @Body Map<String,String> body);

}
