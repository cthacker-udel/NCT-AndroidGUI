package com.example.nctai_trading.particle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface particleAuthenticationInterface {

    @POST("https://api.particle.io/oauth/token")
    Call<particleErrorResponse> getAccessToken(@HeaderMap Map<String,String> authHeader, @Body Map<String,String> body);

    @GET("https://api.particle.io/v1/access_tokens")
    Call<List<particleAccessTokenListAccessToken>> getListOfAccessToken(@HeaderMap Map<String,String> authHeader, @QueryMap Map<String,String> otp);

    @DELETE("https://api.particle.io/v1/access_tokens/{token}")
    Call<particleDeleteTokenResponse> deleteAccessToken(@Path("token") String theToken, @HeaderMap Map<String,String> authHeader, @Body Map<String,String> body);

    @DELETE("https://api.particle.io/v1/access_tokens")
    Call<particleDeleteTokenResponse> deleteAllAccessTokens(@QueryMap List<HashMap<String,String>> query);

    @DELETE("https://api.particle.io/v1/access_tokens/current")
    Call<particleDeleteTokenResponse> deleteCurrentToken(@QueryMap Map<String,String> map);

    @GET("https://api.particle.io/v1/access_tokens/current")
    Call<particleCurrentTokenInformation> getCurrentTokenInfo(@QueryMap Map<String,String> map);

}
