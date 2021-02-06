package com.example.nctai_trading.particle;

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


}
