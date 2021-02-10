package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface particleUserInterface {

    @GET("https://api.particle.io/v1/user")
    Call<particleGetCurrentUserResponse> getCurrentUser(@QueryMap Map<String,String> queryMap);

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/user")
    Call<particleUpdateUserResponse> updateCurrentUser(@Query("password") String newPassword,
                                                       @Query("username") String newUsername,
                                                       @Query("account_info[first_name]") String accountInfoFirstName,
                                                       @Query("account_info[last_name]") String accountInfoLastName,
                                                       @Query("current_password") String currentPassword,
                                                       @Query("access_token") String accessToken
                                                       );
    @FormUrlEncoded
    @POST("https://api.particle.io/v1/user/password-reset")
    Call<particleUpdateUserResponse> passwordReset(@Field("username") String username);

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/user")
    Call<particleDeleteUserResponse> deleteUser(@Query("password") String password,
                                                @Query("access_token") String accessToken);


}
