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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String generateCode(){

        return new Random().ints().limit(6).mapToObj(String::valueOf).reduce((e1, e2) -> e1+e2).get();

    }

}
