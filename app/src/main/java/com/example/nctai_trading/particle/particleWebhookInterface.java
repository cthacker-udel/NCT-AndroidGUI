package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface particleWebhookInterface {


    @POST("https://api.particle.io/v1/integrations")
    Call<particleWebhookCreationResponse> createWebhook(@Body Map<String,String> body);

    @POST("https://api.particle.io/v1/integrations")
    Call<particleWebhookAzureResponse> createAzureWebhook(@Body Map<String,String> body);

    @POST("https://api.particle.io/v1/integrations")
    Call<particleGoogleCloudResponse> createGoogleCloudWebhook(@Body Map<String,String> body);

}
