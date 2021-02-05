package com.example.nctai_trading.mailgun;

import android.database.Observable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;
import org.spongycastle.asn1.ocsp.ResponseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mailGunMethods {

    public String baseUrl = "https://api.mailgun.net";
    private String username = "api";
    private String password = "117cf22399d9675b2414b45aab0ccf17-9b1bf5d3-d9673505";

    public mailGunMethods(){
        super();
    }



    public String getSignature(){

        String readyToEncode = username + ":" + password;
        byte[] result = Base64.encodeBase64(readyToEncode.getBytes());
        String encodedString = new String(result);
        return encodedString;

    }

    public HashMap<String,String> getAuthHeaders(){

        HashMap<String,String> authHeader = new HashMap<>();
        authHeader.put("api",getSignature());
        return authHeader;

    }

    class messageRequests{

        public mailgunMessageResponse sendMessage(String to, String from, String subject, String text) throws IOException {

            String url = baseUrl + "/v3/sales.nextcapitaltech.com/messages/";

            HashMap<String,String> data = new HashMap<>();

            data.put("from",from);
            data.put("to",to);
            data.put("subject",subject);
            data.put("text",text);

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunMessageInterface mailgunMessageInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunMessageInterface.class);

            Call<mailgunMessageResponse> response = mailgunMessageInterface.sendMessage(authHeader,data);

            Response<mailgunMessageResponse> mailgunMessageResponseResponse = response.execute();

            mailgunMessageResponse messageResponse = mailgunMessageResponseResponse.body();

            return messageResponse;

        }

    }

    class domainRequests{

        public mailGunDomainResponse getDomainsUnderAccount() throws IOException {

            String url = baseUrl + "/domains/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mailgunDomainInterface mailgunDomainInterface = retrofit.create(com.example.nctai_trading.mailgun.mailgunDomainInterface.class);

            HashMap<String,String> authHeader = new HashMap<>();

            authHeader.put("api",getSignature());

            Call<mailGunDomainResponse> mailGunDomainResponseCall = mailgunDomainInterface.getDomains(authHeader);

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

    class ipRequests{

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

    class ipPoolRequests{

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String generateCode(){

        return new Random().ints().limit(6).mapToObj(String::valueOf).reduce((e1, e2) -> e1+e2).get();

    }

}
