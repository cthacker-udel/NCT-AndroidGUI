package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface particleWebhookInterface {

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/integrations")
    Call<particleWebhookCreationResponse> createWebhook(@Field("integration_type") String integrationType,
                                                        @Field("event") String event,
                                                        @Field("url") String url,
                                                        @Field("requestType") String requestType
    );

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/integrations")
    Call<particleWebhookAzureResponse> createAzureWebhook(@Field("integration_type") String integrationType,
                                                          @Field("event") String event,
                                                          @Field("hub_name") String hubName,
                                                          @Field("policy_name") String policyName,
                                                          @Field("policy_key") String policyKey
    );

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/integrations")
    Call<particleGoogleCloudResponse> createGoogleCloudWebhook(@Field("integration_type") String integrationType,
                                                               @Field("event") String event,
                                                               @Field("topic") String topic
    );

}
