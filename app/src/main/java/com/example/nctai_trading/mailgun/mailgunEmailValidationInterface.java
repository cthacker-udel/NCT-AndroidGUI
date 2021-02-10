package com.example.nctai_trading.mailgun;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface mailgunEmailValidationInterface {

    @GET("https://api.mailgun.net/v4/address/validate")
    Call<mailgunSingleEmailValidation> singleEmailValidation(@Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

    @FormUrlEncoded
    @POST("https://api.mailgun.net/v4/address/validate")
    Call<mailgunSingleEmailValidation> singleEmailValidationPOST(@Field("address") String emailAddress, @HeaderMap Map<String,String> authHeader);



}
