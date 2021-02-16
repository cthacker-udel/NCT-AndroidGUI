package com.example.nctai_trading.particle;

import com.squareup.okhttp.ResponseBody;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;

public interface particleEventsInterface {

    //@Streaming
    //@GET("https://api.particle.io/v1/events/{eventPrefix}")
    //Call<Observable<ResponseBody>> startStreamOfEvents(@Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    //@Streaming
    //@GET("https://api.particle.io/v1/events/{eventPrefix}")
    //Observable<ResponseBody> altStartStreamOfEvents(@Path("eventPrefix") String eventPrefix, @Query("access_token") String accesstoken);

    @GET("https://api.particle.io/v1/devices/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerSentStreamOfEvents(@Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/devices/{deviceId}/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerStreamForDevice(@Path("deviceId") String deviceId, @Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/products/{productId}/events/{eventPrefix}")
    Call<particleStreamOfEventsResponse> startServerStreamForProduct(@Path("productId") String productId, @Path("eventPrefix") String eventPrefix, @QueryMap Map<String,String> queryMap);

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/devices/events")
    Call<particleDeleteTokenResponse> publishEvent(@Field("name") String name, @Field("data") String data, @Field("private") boolean publicVar, @Field("ttl") int time, @Field("access_token") String accessToken);

    @POST("https://api.particle.io/v1/products/{productid}/events")
    Call<particleDeleteTokenResponse> publishProductEvent(@Path("productid") String productId, @Body Map<String,String> body);

}
