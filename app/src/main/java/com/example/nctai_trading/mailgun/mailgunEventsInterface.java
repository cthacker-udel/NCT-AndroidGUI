package com.example.nctai_trading.mailgun;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface mailgunEventsInterface {

    @GET("https://api.mailgun.net/{domain}/events")
    Call<List<mailgunDomainEvents>> getDomainEvents(@Path("domain") String domainName, @HeaderMap Map<String,String> authMap);

    @GET("https://api.mailgun.net/v3/domains/{domain}/messages/{key}")
    Call<mailgunDeleteDomainResponse> getStoredMessage(@Path("domain") String domainName, @Path("key") String keyName, @HeaderMap Map<String,String> authMap);




}
