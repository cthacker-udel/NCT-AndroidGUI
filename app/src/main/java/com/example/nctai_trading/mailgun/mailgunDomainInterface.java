package com.example.nctai_trading.mailgun;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface mailgunDomainInterface {

    @GET("https://api.mailgun.net/domains")
    Call<mailGunDomainResponse> getDomains(@HeaderMap Map<String, String> authMap);

    @PUT("https://api.mailgun.net/domains/{id}")
    Call<mailgunSingleDomainResponse> getSingleDomain(@Path("id") String id, @HeaderMap Map<String,String> authHeader);

    @POST("https://api.mailgun.net/domains")
    Call<mailgunCreateDomainResponse> createDomain(@HeaderMap Map<String,String> authMap, @Body Map<String,String> body);

    @DELETE("https://api.mailgun.net/domains/{id}")
    Call<mailgunDeleteDomainResponse> deleteDomain(@Path("id") String domainId, @HeaderMap Map<String,String> authMap);

    @GET("https://api.mailgun.net/domains/{id}/credentials")
    Call<mailgunSMTPCredentials> getDomainSMTPCredentials(@Path("id") String domainId, @HeaderMap Map<String,String> authMap);

    @POST("https://api.mailgun.net/domains/{id}/credentials")
    Call<mailgunDeleteDomainResponse> createNewSMTPCredentials(@Path("id") String domainId, @HeaderMap Map<String,String> authMap, @Body Map<String,String> body);

    @DELETE("https://api.mailgun.net/domains/{id}/credentials/{cred}")
    Call<mailgunDeleteSMTPCredentials> delteSMTPDomainCredentials(@Path("id") String domainId, @Path("cred") String login, @HeaderMap Map<String,String> authMap);

    @PUT("https://api.mailgun.net/domains/{id}/credentials/{login}")
    Call<mailgunDeleteDomainResponse> updateSMTPDomainCredentials(@Path("id") String domainName, @Path("login") String login, @HeaderMap Map<String,String> authMap, @Body Map<String,String> body);

}
