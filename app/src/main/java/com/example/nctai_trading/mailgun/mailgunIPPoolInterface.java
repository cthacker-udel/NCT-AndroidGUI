package com.example.nctai_trading.mailgun;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface mailgunIPPoolInterface {

    @POST("https://api.mailgun.net/v1/ip_pools")
    Call<mailgunDeleteDomainResponse> createIPPool(@HeaderMap Map<String,String> authMap, @Body Map<String,String> body);

    @GET("https://api.mailgun.net/v1/ip_pools")
    Call<mailgunIPList> getIPPools(@HeaderMap Map<String,String> authHeaders);

    @PATCH("https://api.mailgun.net/v1/ip_pools/{poolId}")
    Call<mailgunDeleteDomainResponse> updateIPPool(@Path("poolId") String poolId, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeaders);

    @DELETE("https://api.mailgun.net/v1/ip_pools/{poolId}")
    Call<mailgunDeleteDomainResponse> deleteIPPool(@Path("poolId") String poolId, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.mailgun.net/v3/domains/{domain}/ips")
    Call<mailgunDeleteDomainResponse> linkIPPool(@Path("domain") String domainName, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

    @DELETE("https://api.mailgun.net/v3/domains/{domain}/ips/ip_pool")
    Call<mailgunDeleteDomainResponse> unlinkIPPool(@Path("domain") String domainName, @Body Map<String,String> body, @HeaderMap Map<String,String> authHeader);

}
