package com.example.nctai_trading.particle;



import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.particle.android.sdk.cloud.ApiDefs;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.di.CloudModule;
import retrofit.converter.GsonConverter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class particleMethods {

    String baseUrl = "https://api.particle.io";

    String username = "particle";
    String password = "particle";

    String accessToken = "1234";

    public String getSignature(){

        String readyToEncode = username + ":" + password;
        byte[] result = Base64.encodeBase64(readyToEncode.getBytes());
        String encodedString = new String(result);
        return encodedString;

    }

    public Map<String,String> getAuthHeaders(){

        Map<String,String> authHeader = new HashMap<>();
        authHeader.put("Authorization",getSignature());
        return authHeader;

    }

    public Map<String,String> getTokenQueryString(){

        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("access_token",accessToken);
        return queryMap;

    }


    public String getContentHeaders(){

        return "Content-Type: application/json";
        // -H = header
        // -d = body like in coinbasepro
        // There are three ways to send your access token in a request.
        //
        //In an HTTP Authorization header (always works)
        //In the URL query string (only works with GET requests)
        //In the request body (only works for POST, PUT and DELETE when body is form encoded)

    }

    public class accessTokenRequests{

        public particleAccessTokenResponse getAccessToken(String grantType, String username, String password) throws IOException {

            Map<String,String> authHeader = getAuthHeaders();

            Map<String,String> body = new HashMap<>();

            body.put("grant_type",grantType);
            body.put("username",username);
            body.put("password",password);

            String url = baseUrl + "/oauth/token/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(particleAuthenticationInterface.class);

            Call<particleErrorResponse> getToken = particleAuthenticationInterface.getAccessToken(authHeader,body);

            Response<particleErrorResponse> tokenResponseResponse = getToken.execute();

            System.out.println(tokenResponseResponse.errorBody().toString());

            particleErrorResponse response = tokenResponseResponse.body();

            System.out.println(response.getErrorDescription());

            return null;

        }

        public void getListOfAccessTokens(String otp) throws IOException {

            Map<String,String> body = new HashMap<>();
            body.put("otp",otp);

            String url = baseUrl + "/v1/access_tokens/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            Call<List<particleAccessTokenListAccessToken>> call = particleAuthenticationInterface.getListOfAccessToken(getAuthHeaders(),body);

            Response<List<particleAccessTokenListAccessToken>> response = call.execute();

            List<particleAccessTokenListAccessToken> result = response.body();

            return;



        }

        public particleDeleteTokenResponse deleteAccessToken(String token) throws IOException {

            String url = baseUrl + String.format("/v1/access_tokens/%s/",token);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            HashMap<String,String> body = new HashMap<>();

            body.put("token",token);

            Call<particleDeleteTokenResponse> deleteTokenCall = particleAuthenticationInterface.deleteAccessToken(token,getAuthHeaders(),body);

            Response<particleDeleteTokenResponse> deleteTokenResponse = deleteTokenCall.execute();

            particleDeleteTokenResponse response = deleteTokenResponse.body();

            return response;


        }

        public void deleteAllActiveAccessTokens(String... accessTokens) throws IOException {

            String url = baseUrl + "/v1/access_tokens/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            List<HashMap<String,String>> tokens = new ArrayList<HashMap<String, String>>();

            for(String eachToken: accessTokens){
                HashMap<String,String> tokenMap = new HashMap<>();
                tokenMap.put("access_token",eachToken);
                tokens.add(tokenMap);
            }

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            Call<particleDeleteTokenResponse> call = particleAuthenticationInterface.deleteAllAccessTokens(tokens);

            Response<particleDeleteTokenResponse> response = call.execute();

            particleDeleteTokenResponse result = response.body();

            System.out.println(result.getOk());

        }

        public particleDeleteTokenResponse deleteCurrentToken(String token) throws IOException {

            String url = baseUrl + "/v1/access_tokens/current/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();
            body.put("access_token",token);

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            Call<particleDeleteTokenResponse> call = particleAuthenticationInterface.deleteCurrentToken(body);

            Response<particleDeleteTokenResponse> response = call.execute();

            particleDeleteTokenResponse result = response.body();

            return result;

        }

        public particleCurrentTokenInformation getCurrentTokenInformation(String token) throws IOException {

            HashMap<String,String> currentToken = new HashMap<>();
            currentToken.put("access_token",token);

            String url = baseUrl + "/v1/access_tokens/current/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            Call<particleCurrentTokenInformation> currentInfoCall = particleAuthenticationInterface.getCurrentTokenInfo(currentToken);

            Response<particleCurrentTokenInformation> currentInfoResponse = currentInfoCall.execute();

            particleCurrentTokenInformation currentInfo = currentInfoResponse.body();

            return currentInfo;


        }

    }

    public class oAuthRequests{

        public particleClientList getAllOAuthClients(String token) throws IOException {

            HashMap<String,String> data = new HashMap<>();
            data.put("access_token",token);

            String url = baseUrl + "/v1/clients/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Call<particleClientList> clientListCall = particleOAuthInterface.getAllOAuthClients(data);

            Response<particleClientList> clientListResponse = clientListCall.execute();

            particleClientList clientList = clientListResponse.body();

            return clientList;

        }

        public particleCreateClientResponse createAClient(String name, String type, String accessToken) throws IOException {

            HashMap<String,String> body = new HashMap<>();

            body.put("name",name);
            body.put("type",type);
            body.put("access_token",accessToken);

            String url = baseUrl + "/v1/clients/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Call<particleCreateClientResponse> call = particleOAuthInterface.createOAuthClient(body);

            Response<particleCreateClientResponse> response = call.execute();

            particleCreateClientResponse result = response.body();

            return result;
        }

        public String updateAClient(String clientID) throws IOException {

            String url = baseUrl + String.format("/v1/clients/%s",clientID);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("clientId",clientID);

            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Call<particleCreateClientResponse> call = particleOAuthInterface.updateOAuthClient(clientID,body);

            Response<particleCreateClientResponse> response = call.execute();

            particleCreateClientResponse result = response.body();

            return result.getClient().getName();

        }

        public boolean deleteAClient(String clientID){

            String url = baseUrl + String.format("/v1/clients/%s",clientID);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            HashMap<String,String> body = new HashMap<>();

            body.put("clientId",clientID);


            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Response response = particleOAuthInterface.deleteOAuthClient(clientID,body);

            return response.errorBody().contentLength() < 1;
        }

    }

    public class deviceRequests{

        public List<particleDeviceListDevice> getListOfDevices() throws IOException {

            String url = baseUrl + "/v1/devices/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<List<particleDeviceListDevice>> call = particleDeviceInterface.getDeviceList();

            Response<List<particleDeviceListDevice>> response = call.execute();

            List<particleDeviceListDevice> deviceList = response.body();

            return deviceList;

        }

        public particleProductListDeviceList getListOfDevicesPartOfProduct(String productID) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/devices/",productID);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Map<String,String> queryMap = getTokenQueryString();

            Call<particleProductListDeviceList> call = particleDeviceInterface.getProductDevices(productID,queryMap);

            Response<particleProductListDeviceList> response = call.execute();

            particleProductListDeviceList result = response.body();

            return result;

        }

        public particleDeviceImportResponse importDeviceIntoProduct(String productId) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/devices/",productId);

            Map<String,String> queryMap = getTokenQueryString();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<particleDeviceImportResponse> call = particleDeviceInterface.importProductDevice(productId,queryMap);

            Response<particleDeviceImportResponse> response = call.execute();

            particleDeviceImportResponse result = response.body();

            return result;

        }

        public particleDeviceInformation getDeviceInformation(String deviceId) throws IOException {

            String url = baseUrl + String.format("/v1/devices/%s/",deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<particleDeviceInformation> call = particleDeviceInterface.getDeviceInformation(deviceId,getTokenQueryString());

            Response<particleDeviceInformation> response = call.execute();

            particleDeviceInformation result = response.body();

            return result;
        }

        public particleDeviceInformation getProductDeviceInformation(String deviceId, String productId) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/devices/%s/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<particleDeviceInformation> call = particleDeviceInterface.getProductDeviceInformation(productId,deviceId,getTokenQueryString());

            Response<particleDeviceInformation> response = call.execute();

            particleDeviceInformation result = response.body();

            return result;
        }


        public particleDevicePingResponse pingDevice(String deviceId) throws IOException {

            String url = baseUrl + String.format("/v1/devices/%s/ping/",deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<particleDevicePingResponse> call = particleDeviceInterface.pingDevice(deviceId,getTokenQueryString());

            Response<particleDevicePingResponse> response = call.execute();

            particleDevicePingResponse result = response.body();

            return result;
        }

        public boolean removeDeviceFromProduct(String productId, String deviceId){

            String url = baseUrl + String.format("/v1/products/%s/devices/%s/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Response call = particleDeviceInterface.removeDevice(productId,deviceId,getAuthHeaders());

            return call.errorBody().contentLength() < 1;
        }

        public particleDeviceSignalResponse signalDevice(String deviceId, String signal) throws IOException {

            String url = baseUrl + String.format("/v1/devices/%s/",deviceId);

            Map<String,String> queryMap = getTokenQueryString();

            queryMap.put("signal",signal);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceInterface particleDeviceInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceInterface.class);

            Call<particleDeviceSignalResponse> call = particleDeviceInterface.signalDevice(deviceId,queryMap);

            Response<particleDeviceSignalResponse> response = call.execute();

            particleDeviceSignalResponse result = response.body();

            return result;


        }





    }

    public class userRequests{

        public userRequests(){
            super();
        }


        public particleGetCurrentUserResponse getUser() throws IOException {

            String url = baseUrl + "/v1/user/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleGetCurrentUserResponse> call = particleUserInterface.getCurrentUser(getTokenQueryString());

            Response<particleGetCurrentUserResponse> response = call.execute();

            particleGetCurrentUserResponse result = response.body();

            return result;

        }

        public particleUpdateUserResponse updateCurrentUser(String newPassword, String newUsername, String newAccountInfoFirstName, String newAccountInfolastName, String currentPassword) throws IOException {

            Map<String,String> newInfo = new HashMap<String,String>();

            newInfo.put("password",newPassword);
            newInfo.put("current_password",currentPassword);
            newInfo.put("username",newUsername);
            newInfo.put("account_info[first_name]",newAccountInfoFirstName);
            newInfo.put("account_info[last_name]",newAccountInfolastName);
            newInfo.put("access_token",accessToken);

            String url = baseUrl + "/v1/user/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleUpdateUserResponse> call = particleUserInterface.updateCurrentUser(newInfo);

            Response<particleUpdateUserResponse> response = call.execute();

            particleUpdateUserResponse result = response.body();

            return result;


        }

        public particleUpdateUserResponse userPasswordReset(String username) throws IOException {

            Map<String,String> info = new HashMap<>();
            info.put("username",username);

            String url = baseUrl + "/v1/user/password-reset";

            // use mailgun to send email token

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleUpdateUserResponse> call = particleUserInterface.passwordReset(info);

            Response<particleUpdateUserResponse> response = call.execute();

            particleUpdateUserResponse result = response.body();

            return result;

        }


    }

    public class eventRequests{

        public eventRequests(){
            super();
        }


        public particleStreamOfEventsResponse openStreamOfServerEvents(String eventPrefix) throws IOException {

            String url = baseUrl + String.format("/v1/events/%s/",eventPrefix);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleStreamOfEventsResponse> startEventStream = particleEventsInterface.startStreamOfEvents(eventPrefix,getTokenQueryString());

            Response<particleStreamOfEventsResponse> response = startEventStream.execute();

            particleStreamOfEventsResponse result = response.body();

            return result;
        }

        public particleStreamOfEventsResponse openStreamOfServerSentEvents(String eventPrefix) throws IOException {

            String url = baseUrl + String.format("/v1/devices/events/%s",eventPrefix);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleStreamOfEventsResponse> call = particleEventsInterface.startServerSentStreamOfEvents(eventPrefix,getTokenQueryString());

            Response<particleStreamOfEventsResponse> response = call.execute();

            particleStreamOfEventsResponse result = response.body();

            return result;

        }

        public particleStreamOfEventsResponse getStreamOfEventsForDevice(String deviceId, String eventPrefix) throws IOException {

            String url = baseUrl + String.format("/v1/devices/%s/events/%s/",deviceId,eventPrefix);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface eventsInterface = retrofit.create(particleEventsInterface.class);

            Call<particleStreamOfEventsResponse> call = eventsInterface.startServerStreamForDevice(deviceId,eventPrefix,getTokenQueryString());

            Response<particleStreamOfEventsResponse> response = call.execute();

            particleStreamOfEventsResponse result = response.body();

            return result;


        }

        public particleStreamOfEventsResponse openStreamOfEventsProduct(String productId, String eventPrefix) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/events/%s/",productId,eventPrefix);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleStreamOfEventsResponse> call = particleEventsInterface.startServerStreamForProduct(productId,eventPrefix,getTokenQueryString());

            Response<particleStreamOfEventsResponse> response = call.execute();

            particleStreamOfEventsResponse result = response.body();

            return result;
        }

        public boolean publishAnEvent(String name) throws IOException {

            Map<String,String> data = new HashMap<>();

            data.put("name",name);

            String url = baseUrl + "/v1/devices/events/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleDeleteTokenResponse> call = particleEventsInterface.publishEvent(data);

            Response<particleDeleteTokenResponse> response = call.execute();

            particleDeleteTokenResponse result = response.body();

            return result.getOk();



        }

        public boolean publishProductEvent(String name, String productId) throws IOException {

            Map<String,String> data = new HashMap<>();

            data.put("name",name);

            String url = baseUrl + String.format("/v1/products/%s/events/",name);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleDeleteTokenResponse> call = particleEventsInterface.publishProductEvent(productId,data);

            Response<particleDeleteTokenResponse> response = call.execute();

            particleDeleteTokenResponse result = response.body();

            return result.getOk();

        }

    }

    public class webhookRequests{

        public webhookRequests(){
            super();
        }

        public particleWebhookCreationResponse createWebhook(String integrationType, String event, String newUrl, String requestType) throws IOException {

            String url = baseUrl + "/v1/integrations/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("integration_type",integrationType);
            body.put("event",event);
            body.put("url",newUrl);
            body.put("requestType",requestType);

            particleWebhookInterface particleWebhookInterface = retrofit.create(com.example.nctai_trading.particle.particleWebhookInterface.class);

            Call<particleWebhookCreationResponse> call = particleWebhookInterface.createWebhook(body);

            Response<particleWebhookCreationResponse> response = call.execute();

            particleWebhookCreationResponse result = response.body();

            return result;


        }

        public particleWebhookAzureResponse enableAzureIOTWebhookIntegration(String integrationType, String event, String hubName, String policyName, String policyKey) throws IOException {

            String url = baseUrl + "/v1/integrations/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleWebhookInterface particleWebhookInterface = retrofit.create(com.example.nctai_trading.particle.particleWebhookInterface.class);

            HashMap<String,String> body = new HashMap<>();
            body.put("integration_type",integrationType);
            body.put("event",event);
            body.put("hub_name",hubName);
            body.put("policy_name",policyName);
            body.put("policy_key",policyKey);

            Call<particleWebhookAzureResponse> call = particleWebhookInterface.createAzureWebhook(body);

            Response<particleWebhookAzureResponse> response = call.execute();

            particleWebhookAzureResponse result = response.body();

            return result;

        }

        public particleGoogleCloudResponse enableGoogleCloudPlatformIntegration(String integrationType, String event, String topic) throws IOException {

            HashMap<String,String> body = new HashMap<>();
            body.put("integration_type",integrationType);
            body.put("event",event);
            body.put("topic",topic);

            String url = baseUrl + "/v1/integrations/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleWebhookInterface particleWebhookInterface = retrofit.create(com.example.nctai_trading.particle.particleWebhookInterface.class);

            Call<particleGoogleCloudResponse> call = particleWebhookInterface.createGoogleCloudWebhook(body);

            Response<particleGoogleCloudResponse> response = call.execute();

            particleGoogleCloudResponse result = response.body();

            return result;




        }

    }

    public class firmwareRequests{

        public boolean updateFirmwareDeviceID(String deviceId){

            String url = baseUrl + String.format("/v1/devices/%s/",deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Map<String,String> body = new HashMap<>();

            body.put("deviceId",deviceId);

            Response response = particleFirmwareInterface.updateDeviceFirmware(deviceId,body);

            return response.errorBody().contentLength() < 1;

        }

        public particleListFirmwareAllPlatformsResponse listFirmwareAllPlatforms(String featured) throws IOException {

            String url = baseUrl + "/v1/build_targets/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> body = new HashMap<>();
            body.put("featured",featured);

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleListFirmwareAllPlatformsResponse> call = particleFirmwareInterface.listAllProductFirmware(body,getTokenQueryString());

            Response<particleListFirmwareAllPlatformsResponse> response = call.execute();

            particleListFirmwareAllPlatformsResponse result = response.body();

            return result;

        }

        public particleLockProductFirmware lockProductDeviceFirmware(String deviceId, String productId, String desiredFirmwareVersion) throws IOException {

            String url = baseUrl + String.format("/v1/product/%s/devices/%s/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> body = new HashMap<>();

            body.put("deviceId",deviceId);
            body.put("productIdOrSlug",productId);
            body.put("desired_firmware_version",desiredFirmwareVersion);
            body.put("access_token",accessToken);

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.lockProductFirmware(body);

            Response<particleLockProductFirmware> response = call.execute();

            particleLockProductFirmware result = response.body();

            return result;



        }

        public particleLockProductFirmware unlockProductDeviceFirmware(String deviceId, String productId, String desiredFirmwareVerison) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/devices/%s/",deviceId,productId);

            Map<String,String> body = new HashMap<>();
            body.put("deviceId",deviceId);
            body.put("productIdOrSlug",productId);
            body.put("desired_firmware_version",desiredFirmwareVerison);
            body.put("access_token",accessToken);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.unlockProductFirmware(productId,deviceId,body);

            Response<particleLockProductFirmware> response = call.execute();

            particleLockProductFirmware result = response.body();

            return result;

        }

        public particleLockProductFirmware markUnmarkDevelopmentDevice(String deviceId, String productId, boolean development) throws IOException {

            String url = baseUrl + String.format("/v1/proudcts/%s/devices/%s/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Map<String,String> body = new HashMap<>();
            if(development){
                body.put("development","true");
            }
            else{
                body.put("development","false");
            }

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.markProductDevelopmentDevice(productId,deviceId,body,getTokenQueryString());

            Response<particleLockProductFirmware> response = call.execute();

            particleLockProductFirmware result = response.body();

            return result;
        }

        public particleProductFirmwareResponse productFirmware(String productId, String version) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/firmware/%s/",productId,version);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleProductFirmwareResponse> call = particleFirmwareInterface.getProductFirmware(productId,version,getTokenQueryString());

            Response<particleProductFirmwareResponse> response = call.execute();

            particleProductFirmwareResponse result = response.body();

            return result;



        }

        public List<particleProductListAllFirmwareResponse> listAllProductFirmwares(String productId) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/firmware",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<List<particleProductListAllFirmwareResponse>> call = particleFirmwareInterface.getAllProductFirmware(productId,getTokenQueryString());

            Response<List<particleProductListAllFirmwareResponse>> response = call.execute();

            List<particleProductListAllFirmwareResponse> allProductFirmware = response.body();

            return allProductFirmware;

        }



    }

    public class deviceGroupRequests{

        public particleGetDeviceGroup getDeviceGroup(String productId, String groupName) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/groups/%s/",productId,groupName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<particleGetDeviceGroup> call = particleDeviceGroupInterface.getDeviceGroup(productId,groupName,getTokenQueryString());

            Response<particleGetDeviceGroup> response = call.execute();

            particleGetDeviceGroup group = response.body();

            return group;

        }

        public List<particleDeviceGroupList> getListDeviceGroups(String productId) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/groups/",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<List<particleDeviceGroupList>> call = particleDeviceGroupInterface.getDeviceGroupList(productId,getTokenQueryString());

            Response<List<particleDeviceGroupList>> response = call.execute();

            List<particleDeviceGroupList> result = response.body();

            return result;
        }

        public particleGetDeviceGroup createDeviceGroup(String productId, String name) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/groups/",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> body = new HashMap<>();
            body.put("name",name);


            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<particleGetDeviceGroup> call = particleDeviceGroupInterface.createDeviceGroup(productId,body);

            Response<particleGetDeviceGroup> response = call.execute();

            return response.body();



        }

        public particleGetDeviceGroup editDeviceGroup(String productId, String groupName) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/groups/%s/",productId,groupName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> body = new HashMap<>();

            body.put("name","name2");
            body.put("access_token",accessToken);

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<particleGetDeviceGroup> call = particleDeviceGroupInterface.editDeviceGroup(productId,groupName,body);

            Response<particleGetDeviceGroup> response = call.execute();

            particleGetDeviceGroup result = response.body();

            return result;


        }

        public boolean deleteDeviceGroup(String productId, String groupName){

            String url = baseUrl + String.format("/v1/products/%s/groups/%s/",productId,groupName);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Response deleteDeviceGroup = particleDeviceGroupInterface.delteDeviceGroup(productId,groupName,getTokenQueryString());

            return deleteDeviceGroup.errorBody().contentLength() < 1;
        }

        public particleDeviceGroupAssignGroupsToDeviceResponse assignGroupsToDevice(String deviceId, String productId, String... groups) throws IOException {

            String url = baseUrl + String.format("/v1/products/{productId}/devices/{deviceId}/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Map<String,Object> body = new HashMap<>();

            body.put("groups",groups);

            Call<particleDeviceGroupAssignGroupsToDeviceResponse> call = particleDeviceGroupInterface.assignGroupsToDevice(productId,deviceId,body);

            Response<particleDeviceGroupAssignGroupsToDeviceResponse> response = call.execute();

            particleDeviceGroupAssignGroupsToDeviceResponse result = response.body();

            return result;
        }


    }

    public class customerRequests{

        public particleCreateCustomerResponse createCustomerAccessToken(String productId, String email, String password) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers/",productId);

            Map<String,String> body = new HashMap<>();

            body.put("access_token",accessToken);
            body.put("email",email);
            body.put("password",password);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleCreateCustomerResponse> call = particleCustomerInterface.createCustomerToken(productId,body);

            Response<particleCreateCustomerResponse> response = call.execute();

            return response.body();

        }

        public particleCreateCustomerResponse createCustomerClientCredentials(String productId, String clientId, String clientSecret, String email) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> body = new HashMap<>();

            body.put("client_id",clientId);
            body.put("client_secret",clientSecret);
            body.put("email",email);

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleCreateCustomerResponse> call = particleCustomerInterface.createCustomerCredentials(productId,getAuthHeaders(),body);

            Response<particleCreateCustomerResponse> response = call.execute();

            particleCreateCustomerResponse result = response.body();

            return result;


        }

        public particleProductCustomerList listCustomersForAProduct(String productId) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers/");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleProductCustomerList> call = particleCustomerInterface.getProductCustomerList(productId,getAuthHeaders());

            Response<particleProductCustomerList> response = call.execute();

            particleProductCustomerList result = response.body();

            return result;

        }

    }

}
