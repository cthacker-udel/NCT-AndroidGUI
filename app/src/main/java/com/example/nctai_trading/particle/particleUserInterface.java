package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;

public interface particleUserInterface {

    @GET("https://api.particle.io/v1/user")
    Call<particleGetCurrentUserResponse> getCurrentUser(@QueryMap Map<String,String> queryMap);

    @PUT("https://api.particle.io/v1/user")
    Call<particleUpdateUserResponse> updateCurrentUser(@Body Map<String,String> body);

    @POST("https://api.particle.io/v1/user/password-reset")
    Call<particleUpdateUserResponse> passwordReset(@Body Map<String,String> body);


}
