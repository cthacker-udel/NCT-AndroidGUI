package com.example.nctai_trading.mailgun;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface mailgunIPInterface {

    @GET("https://api.mailgun.net/ips")
    Call<mailgunIPList> getListIPS(@HeaderMap Map<String,String> authHeader);

    @GET("https://api.mailgun.net/ips/{ip}")
    Call<mailgunSpecificIP> getSpecificIP(@Path("ip") String ip, @HeaderMap Map<String,String> authHeader);

    @GET("https://api.mailgun.net/domains/{domain}/ips")
    Call<mailgunIPList> getDomainIPS(@Path("domain") String domainName, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.mailgun.net/domains/{domain}/ips")
    Call<mailgunDeleteDomainResponse> assignDomainIP(@Path("domain") String domainName, @HeaderMap Map<String,String> authHeaders, @Body Map<String,String> ipAddress);

    @DELETE("https://api.mailgun.net/domains/{domain}/ips/{ip}")
    Call<mailgunDeleteDomainResponse> unassignDomainIP(@Path("domain") String domainName, @Path("ip") String ipAddress, @HeaderMap Map<String,String> authHeader);

}
