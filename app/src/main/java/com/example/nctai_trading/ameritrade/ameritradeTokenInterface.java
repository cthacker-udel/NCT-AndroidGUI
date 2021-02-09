package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ameritradeTokenInterface {

    @POST("https://api.tdameritrade.com/v1/oauth2/token")
    Call<ameritradeAuthorizationTokenResponse> getAuthorizationToken(@Body Map<String,String> body);

    @POST("https://api.tdameritrade.com/v1/oauth2/token")
    Call<ameritradeAuthorizationTokenResponse> getRefreshToken(@Body Map<String,String> body);
}
