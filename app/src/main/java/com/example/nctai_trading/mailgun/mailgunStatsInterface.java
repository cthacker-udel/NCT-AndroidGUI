package com.example.nctai_trading.mailgun;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface mailgunStatsInterface {

    @GET("https://api.mailgun.net/{domain}/stats/total")
    Call<List<mailgunDomainStat>> getDomainStats(@Path("domain") String domainName, @HeaderMap Map<String,String> authHeader, @Body Map<String,String> body);


}
