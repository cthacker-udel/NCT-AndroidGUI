package com.example.nctai_trading.particle;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface particleOAuthInterface {

    @GET("https://api.particle.io/v1/clients")
    Call<particleClientList> getAllOAuthClients(@QueryMap Map<String,String> map);

    @FormUrlEncoded
    @POST("https://api.particle.io/v1/clients")
    Call<particleCreateClientResponse> createOAuthClient(@Field("name") String name,
                                                         @Field("type") String type,
                                                         @Field("access_token") String accessToken

    );

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/clients/{clientID}")
    Call<particleCreateClientResponse> updateOAuthClient(@Path("clientID") String clientID, @Field("name") String newName,
                                                         @Field("access_token") String accessToken);

    @DELETE("https://api.particle.io/v1/clients/{clientID}")
    Response deleteOAuthClient(@Path("clientID") String clientId, @Body Map<String,String> body);

}
