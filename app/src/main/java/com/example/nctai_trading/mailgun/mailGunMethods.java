package com.example.nctai_trading.mailgun;


import android.os.Build;

import androidx.annotation.RequiresApi;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class mailGunMethods {

    public String baseUrl = "https://api.mailgun.net";
    public String username = "api";
    public String password = "117cf22399d9675b2414b45aab0ccf17-9b1bf5d3-d9673505";

    public mailGunMethods(){
        super();
    }



    public String getSignature(){


        String readyToEncode  = "api:" + password;

        return "BASIC" + " " + Base64.encodeToString(readyToEncode.getBytes(), Base64.NO_WRAP);

    }

    public HashMap<String,String> getAuthHeaders(){

        HashMap<String,String> authHeader = new HashMap<>();
        authHeader.put("api",getSignature());
        return authHeader;

    }

    public class messageRequests{

        // 401 : UNAUTHORIZED
        @RequiresApi(api = Build.VERSION_CODES.N)
        public mailgunMessageResponse sendMessage(String to, String from, String subject, String text) throws IOException {

            String url = baseUrl + "/v3/sales.nextcapitaltech.com/messages/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunMessageInterface mailgunMessageInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunMessageInterface.class);

            Call<mailgunMessageResponse> response = mailgunMessageInterface.sendMessage(getSignature(),from,to,subject,text);

            Response<mailgunMessageResponse> mailgunMessageResponseResponse = response.execute();

            mailgunMessageResponse messageResponse = mailgunMessageResponseResponse.body();

            return messageResponse;

        }

    }

    public class domainRequests{

        public mailGunDomainResponse getDomainsUnderAccount() throws IOException {

            String url = baseUrl + "/domains/";

            Gson gson = new GsonBuilder().setLenient().create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            Map<String,String> authMap = new HashMap<>();
            authMap.put("Authorization",getSignature());

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailGunDomainResponse> mailGunDomainResponseCall = mailgunDomainInterface.getDomains(getSignature());

            Response<mailGunDomainResponse> mailGunDomainResponseResponse = mailGunDomainResponseCall.execute();

            mailGunDomainResponse response = mailGunDomainResponseResponse.body();

            return response;

        }

        public mailgunSingleDomainResponse getSpecificDomain(String domain) throws IOException {

            String url = baseUrl + String.format("/domains/%s",domain);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailgunSingleDomainResponse> responseCall = mailgunDomainInterface.getSingleDomain(domain,authHeader);

            Response<mailgunSingleDomainResponse> responseResponse = responseCall.execute();

            mailgunSingleDomainResponse result = responseResponse.body();

            return result;

        }

        public mailgunCreateDomainResponse createDomain(String name, String password) throws IOException {

            String url = baseUrl + "/domains";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> authHeader = new HashMap<>();
            authHeader.put("api",getSignature());

            HashMap<String,String> postBody = new HashMap<>();

            postBody.put("name",name);
            postBody.put("smtp_password",password);

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailgunCreateDomainResponse> domainResponse = mailgunDomainInterface.createDomain(authHeader,postBody);

            Response<mailgunCreateDomainResponse> responseResponse = domainResponse.execute();

            mailgunCreateDomainResponse createDomainResponse = responseResponse.body();

            return createDomainResponse;

        }

        public mailgunDeleteDomainResponse deleteDomain(String domainName) throws IOException {

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            String url = baseUrl + String.format("/domains/%s",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailgunDeleteDomainResponse> deleteDomainResponseCall = mailgunDomainInterface.deleteDomain(domainName,authHeader);

            Response<mailgunDeleteDomainResponse> deleteDomainResponseResponse = deleteDomainResponseCall.execute();

            mailgunDeleteDomainResponse response = deleteDomainResponseResponse.body();

            return response;

        }

        public mailgunSMTPCredentials getDomainSMTPCredentials(String domainName) throws IOException {

            String url = baseUrl + String.format("/domains/%s/credentials/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> authHeader = new HashMap<>();
            authHeader.put("api",getSignature());

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailgunSMTPCredentials> getCredentials = mailgunDomainInterface.getDomainSMTPCredentials(domainName,authHeader);

            Response<mailgunSMTPCredentials> mailgunSMTPCredentialsResponse = getCredentials.execute();

            mailgunSMTPCredentials credentials = mailgunSMTPCredentialsResponse.body();

            return credentials;

        }

        public String createDomainSMTPCredentials(String login, String password, String domainName) throws IOException {

            String url = baseUrl + String.format("/domains/%s/credentials/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            HashMap<String,String> data = new HashMap<>();

            data.put("login",login);
            data.put("password",password);

            Call<mailgunDeleteDomainResponse> createSMTPCredentialsCall = mailgunDomainInterface.createNewSMTPCredentials(domainName,authHeader,data);

            Response<mailgunDeleteDomainResponse> response = createSMTPCredentialsCall.execute();

            mailgunDeleteDomainResponse createCredentialsResponse = response.body();

            return createCredentialsResponse.getMessage();

        }

        public String updateDomainSMTPCredentials(String domainName, String login, String password) throws IOException {

            String url = baseUrl + String.format("/domains/%s/credentials/%s/",domainName,login);

            HashMap<String,String> updateMap = new HashMap<>();

            updateMap.put("password",password);

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            Call<mailgunDeleteDomainResponse> updatePassword = mailgunDomainInterface.updateSMTPDomainCredentials(domainName,login,authHeader,updateMap);

            Response<mailgunDeleteDomainResponse> updatePasswordResponse = updatePassword.execute();

            mailgunDeleteDomainResponse response = updatePasswordResponse.body();

            return response.getMessage();

        }

        public mailgunDeleteSMTPCredentials deleteSpecificDomainSMTPCredentials(String domainName, String login) throws IOException {

            String url = baseUrl + String.format("/domains/%s/credentials/%s/",domainName,login);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            Call<mailgunDeleteSMTPCredentials> deleteSMTPCredentialsCall = mailgunDomainInterface.delteSMTPDomainCredentials(domainName,login,authHeader);

            Response<mailgunDeleteSMTPCredentials> response = deleteSMTPCredentialsCall.execute();

            mailgunDeleteSMTPCredentials result = response.body();

            return result;

        }



    }

    public class ipRequests{

        public mailgunIPList getAllIps() throws IOException {

            String url = baseUrl + "/ips/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPInterface mailgunIPInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPInterface.class);

            HashMap<String,String> authHeader = new HashMap<>();
            authHeader.put("api",getSignature());

            Call<mailgunIPList> mailgunIPListCall = mailgunIPInterface.getListIPS(authHeader);

            Response<mailgunIPList> mailgunIPListResponse = mailgunIPListCall.execute();

            mailgunIPList IPList = mailgunIPListResponse.body();

            return IPList;

        }

        public mailgunSpecificIP getSpecficiIP(String ipAddress) throws IOException{

            String url = baseUrl + String.format("/ips/%s",ipAddress);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPInterface mailgunIPInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPInterface.class);

            Call<mailgunSpecificIP> mailgunSpecificIPCall = mailgunIPInterface.getSpecificIP(ipAddress,getAuthHeaders());

            Response<mailgunSpecificIP> mailgunSpecificIPResponse = mailgunSpecificIPCall.execute();

            mailgunSpecificIP result = mailgunSpecificIPResponse.body();

            return result;

        }

        public mailgunIPList getDomainIPList(String domain) throws IOException{

            String url = baseUrl + String.format("/domains/%s/ips/",domain);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPInterface mailgunIPInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPInterface.class);

            Call<mailgunIPList> mailgunIPListCall = mailgunIPInterface.getDomainIPS(domain, getAuthHeaders());

            Response<mailgunIPList> mailgunIPListResponse = mailgunIPListCall.execute();

            mailgunIPList result = mailgunIPListResponse.body();

            return result;

        }

        public String assignIPToDomain(String domain, String ip) throws IOException {

            String url = baseUrl + String.format("/domains/%s/ips",domain);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("ip",ip);

            mailgunIPInterface mailgunIPInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPInterface.class);

            Call<mailgunDeleteDomainResponse> mailgunDeleteDomainResponseCall = mailgunIPInterface.assignDomainIP(domain,getAuthHeaders(),body);

            Response<mailgunDeleteDomainResponse> response = mailgunDeleteDomainResponseCall.execute();

            mailgunDeleteDomainResponse result = response.body();

            return result.getMessage();

        }

        public String unassignIPToDomain(String domain, String ip) throws IOException {

            String url = baseUrl + String.format("/domains/%s/ips/%s",domain,ip);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPInterface mailgunIPInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPInterface.class);

            Call<mailgunDeleteDomainResponse> responseCall = mailgunIPInterface.unassignDomainIP(domain,ip,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> response = responseCall.execute();

            mailgunDeleteDomainResponse result = response.body();

            return result.getMessage();
        }

    }

    public class ipPoolRequests{

        public String createIPPool(String name) throws IOException {

            String url = baseUrl + "/v1/ip_pools/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();
            body.put("name",name);

            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            Call<mailgunDeleteDomainResponse> createIpPool = mailgunIPPoolInterface.createIPPool(getAuthHeaders(),body);

            Response<mailgunDeleteDomainResponse> response = createIpPool.execute();

            mailgunDeleteDomainResponse result = response.body();

            return result.getMessage();

        }

        public mailgunIPList getIpPools() throws IOException {

            String url = baseUrl + "/v1/ip_pools/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            Call<mailgunIPList> mailgunIPListCall = mailgunIPPoolInterface.getIPPools(getAuthHeaders());

            Response<mailgunIPList> mailgunIPListResponse = mailgunIPListCall.execute();

            mailgunIPList result = mailgunIPListResponse.body();

            return result;

        }

        public String updateIpPools(String name, String description, String addIp, String removeIp) throws IOException {

            String url = baseUrl + String.format("/v1/ip_pools/%s/",name);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("name",name);
            body.put("description",description);
            body.put("add_ip",addIp);
            body.put("remove_ip",removeIp);

            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            Call<mailgunDeleteDomainResponse> mailgunDeleteDomainResponseCall = mailgunIPPoolInterface.updateIPPool(name,body,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> response = mailgunDeleteDomainResponseCall.execute();

            mailgunDeleteDomainResponse mailgunDeleteDomainResponse = response.body();

            return mailgunDeleteDomainResponse.getMessage();


        }

        public String deleteIpPool(String ip, String poolId) throws IOException {

            String url = baseUrl + String.format("/v1/ip_pools/%s/",poolId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("ip",ip);
            body.put("pool_id",poolId);

            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            Call<mailgunDeleteDomainResponse> responseCall = mailgunIPPoolInterface.deleteIPPool(poolId,body,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> response = responseCall.execute();

            mailgunDeleteDomainResponse result = response.body();

            return result.getMessage();

        }

        public String linkIpPool(String domainName, String poolId) throws IOException {

            String url = baseUrl + String.format("/v3/domains/%s/ips/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("pool_id",poolId);


            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            Call<mailgunDeleteDomainResponse> responseCall = mailgunIPPoolInterface.linkIPPool(domainName,body,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> deleteDomainResponseResponse = responseCall.execute();

            mailgunDeleteDomainResponse result = deleteDomainResponseResponse.body();

            return result.getMessage();


        }

        public String unlinkIpPool(String domainName, String ip, String poolId) throws IOException {

            String url = baseUrl + String.format("/v3/domains/%s/ips/ip_pool/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunIPPoolInterface mailgunIPPoolInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunIPPoolInterface.class);

            HashMap<String,String> body = new HashMap<>();

            body.put("ip",ip);
            body.put("pool_id",poolId);

            Call<mailgunDeleteDomainResponse> mailgunDeleteDomainResponseCall = mailgunIPPoolInterface.unlinkIPPool(domainName,body,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> response = mailgunDeleteDomainResponseCall.execute();

            mailgunDeleteDomainResponse result = response.body();


            return result.getMessage();

        }

    }

    public class eventsRequests{

        public eventsRequests(){
            super();
        }


        public List<mailgunDomainEvents> getRecentDomainEvents(String domainName) throws IOException {

            String url = baseUrl + String.format("/%s/events/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunEventsInterface mailgunEventsInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunEventsInterface.class);

            Call<List<mailgunDomainEvents>> getRecentEvents = mailgunEventsInterface.getDomainEvents(domainName,getAuthHeaders());

            Response<List<mailgunDomainEvents>> recentEvents = getRecentEvents.execute();

            List<mailgunDomainEvents> result = recentEvents.body();

            return result;

        }


    }

    public class statsRequests{

        public statsRequests(){
            super();
        }

        public List<mailgunDomainStat> getDomainStats(String domainName, String filterEvent) throws IOException {

            String url = baseUrl + String.format("/%s/stats/total/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("event",filterEvent);
            body.put("resolution","1m");

            mailgunStatsInterface mailgunStatsInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunStatsInterface.class);

            Call<List<mailgunDomainStat>> statsCall = mailgunStatsInterface.getDomainStats(domainName,getAuthHeaders(),body);

            Response<List<mailgunDomainStat>> statsResponse = statsCall.execute();

            List<mailgunDomainStat> stats = statsResponse.body();

            return stats;

        }


    }

    public class suppressionRequests{

        public suppressionRequests(){
            super();
        }

        public mailgunSuppressionRequest getAllBounces(String domainName) throws IOException {

            String url = baseUrl + String.format("/%s/bounces/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunSuppressionInterface mailgunSuppressionInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunSuppressionInterface.class);

            Call<mailgunSuppressionRequest> getBouncers = mailgunSuppressionInterface.getBounces(domainName,getAuthHeaders());

            Response<mailgunSuppressionRequest> request = getBouncers.execute();

            mailgunSuppressionRequest result = request.body();

            return result;

        }

        public mailgunSuppressionSingleBouncer getSingleBouncer(String domain, String address) throws IOException {

            String url = baseUrl + String.format("/%s/bounces/%s/",domain,address);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunSuppressionInterface mailgunSuppressionInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunSuppressionInterface.class);

            Call<mailgunSuppressionSingleBouncer> mailgunSuppressionSingleBouncerCall = mailgunSuppressionInterface.getSingleBouner(domain,address,getAuthHeaders());

            Response<mailgunSuppressionSingleBouncer> mailgunSuppressionSingleBouncerResponse = mailgunSuppressionSingleBouncerCall.execute();

            mailgunSuppressionSingleBouncer singleBouncer = mailgunSuppressionSingleBouncerResponse.body();

            return singleBouncer;
        }

        public mailgunAddSingleBouncer addSingleBouncer(String domain, String address) throws IOException {

            String url = baseUrl + String.format("/%s/bounces",domain);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("address",address);

            mailgunSuppressionInterface mailgunSuppressionInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunSuppressionInterface.class);

            Call<mailgunAddSingleBouncer> mailgunAddSingleBouncerCall = mailgunSuppressionInterface.addSingleBouncer(domain,body,getAuthHeaders());

            Response<mailgunAddSingleBouncer> response = mailgunAddSingleBouncerCall.execute();

            mailgunAddSingleBouncer result = response.body();

            return result;
        }

        public String addMultipleBouncers(String domainName, String... domainNames) throws IOException {

            ArrayList<HashMap<String,String>> bounceList = new ArrayList<HashMap<String, String>>();

            for(String eachArg: domainNames){

                HashMap<String,String> bouncerMap = new HashMap<>();
                bouncerMap.put("address",eachArg);
                bounceList.add(bouncerMap);

            }

            String url = baseUrl + String.format("/%s/bounces/",domainName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunSuppressionInterface mailgunSuppressionInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunSuppressionInterface.class);

            Call<mailgunDeleteDomainResponse> call = mailgunSuppressionInterface.addMultipleBouncers(domainName,bounceList,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> result = call.execute();

            mailgunDeleteDomainResponse res = result.body();

            return res.getMessage();



        }

        public mailgunDeleteDomainResponse deleteSpecificBouncer(String domainName, String address) throws IOException {

            String url = baseUrl + String.format("/%s/bounces/%s/",domainName,address);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunSuppressionInterface mailgunSuppressionInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunSuppressionInterface.class);

            Call<mailgunDeleteDomainResponse> call = mailgunSuppressionInterface.deleteSingleBounce(domainName,address,getAuthHeaders());

            Response<mailgunDeleteDomainResponse> response = call.execute();

            mailgunDeleteDomainResponse result = response.body();

            return result;
        }




    }

    public class validationRequests{

        public validationRequests(){
            super();
        }


        public com.example.nctai_trading.mailgun.mailgunSingleEmailValidation singleValidationGET(String address) throws IOException {

            String url = baseUrl + "/v4/address/validate/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunEmailValidationInterface mailgunEmailValidationInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunEmailValidationInterface.class);

            HashMap<String,String> body = new HashMap<>();

            body.put("address",address);

            Call<mailgunSingleEmailValidation> mailgunSingleEmailValidation = mailgunEmailValidationInterface.singleEmailValidation(body,getAuthHeaders());

            Response<mailgunSingleEmailValidation> mailgunSingleEmailValidationResponse = mailgunSingleEmailValidation.execute();

            com.example.nctai_trading.mailgun.mailgunSingleEmailValidation result = mailgunSingleEmailValidationResponse.body();

            return result;


        }

        public mailgunSingleEmailValidation singleEmailValidationPOST(String address) throws IOException{

            String url = baseUrl + "/v4/address/validate/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunEmailValidationInterface emailValidationInterface = retrofit.create(mailgunEmailValidationInterface.class);

            Call<mailgunSingleEmailValidation> emailValidationCall = emailValidationInterface.singleEmailValidationPOST(address,getSignature());

            Response<mailgunSingleEmailValidation> emailValidationResponse = emailValidationCall.execute();

            mailgunSingleEmailValidation result = emailValidationResponse.body();

            return result;

        }



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String generateCode(){

        return new Random().ints(0,10).limit(6).mapToObj(String::valueOf).reduce((e1, e2) -> e1+e2).get();

    }

}
