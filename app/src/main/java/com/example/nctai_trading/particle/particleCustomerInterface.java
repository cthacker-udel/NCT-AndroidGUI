package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface particleCustomerInterface {

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleCreateCustomerResponse> createCustomerAccessToken(@Path("productId") String productId, @Field("email") String email,
                                                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleCreateCustomerResponse> createCustomerCredentials(@Path("productId") String productId, @HeaderMap Map<String,String> authHeader, @Field("client_id") String clientId,
                                                                   @Field("client_secret") String clientSecret,
                                                                   @Field("email") String email);

    @GET("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleProductCustomerList> getProductCustomerList(@Path("productId") String productId, @HeaderMap Map<String,String> authHeader);

    @FormUrlEncoded
    @POST("https://api.particle.io/oauth/token")
    Call<particleCreateCustomerTokenResponse> createCustomerToken(@HeaderMap Map<String,String> authHeader, @Field("client_id") String clientId,
                                                                  @Field("client_secret") String clientSecret,
                                                                  @Field("grant_type") String grantType,
                                                                  @Field("expires_in") long time);

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/products/{productId}/customers/{customerEmail}")
    Call<particleUpdateCustomerPasswordResponse> updateCustomer(@Path("productId") String productId, @Path("customerEmail") String customerEmail, @Query("password") String newPassword);

    @FormUrlEncoded
    @DELETE("https://api.particle.io/v1/products/{productId}/customers/{customerEmail}")
    Call<particleUpdateCustomerPasswordResponse> deleteCustomer(@Path("productId") String productId, @Path("customerEmail") String customerEmail, @Query("access_token") String accessToken);

}
