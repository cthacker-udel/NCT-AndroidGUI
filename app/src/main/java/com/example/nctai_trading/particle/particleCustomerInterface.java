package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface particleCustomerInterface {

    @POST("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleCreateCustomerResponse> createCustomerToken(@Path("productId") String productId, @Body Map<String,String> body);

    @POST("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleCreateCustomerResponse> createCustomerCredentials(@Path("productId") String productId, @HeaderMap Map<String,String> authHeader, @Body Map<String,String> body);

    @GET("https://api.particle.io/v1/products/{productId}/customers")
    Call<particleProductCustomerList> getProductCustomerList(@Path("productId") String productId, @HeaderMap Map<String,String> authHeader);


}
