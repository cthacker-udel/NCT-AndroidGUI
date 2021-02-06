package com.example.nctai_trading.mailgun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface mailgunSuppressionInterface {

    @GET("https://api.mailgun.net/{domain}/bounces")
    Call<mailgunSuppressionRequest> getBounces(@Path("domain") String domainName, @HeaderMap Map<String,String> authMap);

    @GET("https://api.mailgun.net/{domain}/bounces/{address}")
    Call<mailgunSuppressionSingleBouncer> getSingleBouner(@Path("domain") String domainName, @Path("address") String domainAddress, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.mailgun.net/{domain}/bounces")
    Call<mailgunAddSingleBouncer> addSingleBouncer(@Path("domain") String domainName, @Body Map<String,String> body, @HeaderMap Map<String,String> headerMap);

    @POST("https://api.mailgun.net/{domain}/bounces")
    Call<mailgunDeleteDomainResponse> addMultipleBouncers(@Path("domain") String domainName, @Body List<HashMap<String,String>> body, @HeaderMap Map<String,String> authMap);
}
