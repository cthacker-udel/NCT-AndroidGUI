package com.example.nctai_trading.particle;









import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;


import com.here.oksse.OkSse;
import com.here.oksse.ServerSentEvent;
import com.launchdarkly.eventsource.EventSource;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.ResponseBody;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;




import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class particleMethods extends SimpleEventHandler {

    String baseUrl = "https://api.particle.io";

    String username = "noah13nelson@gmail.com";
    String password = "CompeteToWin*13";
    String secretKey = "2f7c82f8baca961fbff0e657c7edfb2ad7c9b110";
    String clientId = "nct-app-3115";
    String accesstoken = "597d74aa67e9c6200009a804f37c4252ce671fc1";
    String refreshToken = "529c17ca203cb064bd556ed10168cc6ecbd95f5f";

    final static String[] contents = {""};

    // new client id generate by create a client
    // clientid = nct-app-3115-1752
    // client name = nct-app-3115
    // client secret = e9cd02aa85689212244c3698ff333e388975a153
    // updated name -> Cameron-app

    public String getSignature(){

        String readyToEncode = username + ":" + password;
        byte[] result = Base64.encodeBase64(readyToEncode.getBytes());
        String encodedString = new String(result);
        return encodedString;

    }

    public String getSSEData(){
        if(super.messageContents.equals("")){
            return "";
        }
        else{
            return super.messageContents;
        }
    }

    public void setSSEData(String setter){
        contents[0] = setter;
    }

    public String getAuthString(){

        return String.format("%s:%s",username,password);

    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }



    public Map<String,String> getAuthHeaders(){

        Map<String,String> authHeader = new LinkedHashMap<>();
        authHeader.put("username",username);
        authHeader.put("password",secretKey);
        return authHeader;

    }

    public Map<String,String> getTokenQueryString(){

        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("access_token",accesstoken);
        return queryMap;

    }


    public String getContentHeaders(){

        return "Content-Type: application/json";

    }

    public class accessTokenRequests{

        public particleAccessTokenResponse getAccessToken(String grantType) throws IOException {//, String username, String password) throws IOException {

            String url = baseUrl + "/oauth/token/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(particleAuthenticationInterface.class);

            Call<particleAccessTokenResponse> getToken = particleAuthenticationInterface.getAccessToken(clientId,secretKey,grantType,username,password);

            Response<particleAccessTokenResponse> tokenResponseResponse = getToken.execute();

            particleAccessTokenResponse response = tokenResponseResponse.body();

            System.out.println(response.getAccessToken());

            System.out.println(response.getExpiresIn());

            System.out.println(response.getRefreshToken());

            return response;

        }

        // find the otp to test
        public void getListOfAccessTokens(String otp) throws IOException {


            String url = baseUrl + "/v1/access_tokens/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);

            Call<List<particleAccessTokenListAccessToken>> call = particleAuthenticationInterface.getListOfAccessToken(getAuthHeaders(),otp);

            Response<List<particleAccessTokenListAccessToken>> response = call.execute();

            List<particleAccessTokenListAccessToken> result = response.body();

            return;



        }


        // 401 : Unauthorized. You must send username and password
        public particleDeleteTokenResponse deleteAccessToken(String token) throws IOException {

            String url = baseUrl + String.format("/v1/access_tokens/%s/",token);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleAuthenticationInterface particleAuthenticationInterface = retrofit.create(com.example.nctai_trading.particle.particleAuthenticationInterface.class);


            Call<particleDeleteTokenResponse> deleteTokenCall = particleAuthenticationInterface.deleteAccessToken(token,getAuthString());

            Response<particleDeleteTokenResponse> deleteTokenResponse = deleteTokenCall.execute();

            particleDeleteTokenResponse response = deleteTokenResponse.body();

            return response;


        }

        // test
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

        // test
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

        // works
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

        // works
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

            String url = baseUrl + "/v1/clients/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Call<particleCreateClientResponse> call = particleOAuthInterface.createOAuthClient(name,type,accessToken);

            Response<particleCreateClientResponse> response = call.execute();

            particleCreateClientResponse result = response.body();

            return result;
        }

        public String updateAClient(String clientID, String newName, String accessToken) throws IOException {

            String url = baseUrl + String.format("/v1/clients/%s/",clientID);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> body = new HashMap<>();

            body.put("clientId",clientID);

            particleOAuthInterface particleOAuthInterface = retrofit.create(com.example.nctai_trading.particle.particleOAuthInterface.class);

            Call<particleCreateClientResponse> call = particleOAuthInterface.updateOAuthClient(clientID,newName, accessToken);

            Response<particleCreateClientResponse> response = call.execute();

            particleCreateClientResponse result = response.body();

            return result.getClient().getName();

        }

        // test
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

        // error - access token..
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
        // test
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
        // test
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
        // test
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
        // test
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

        //test
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
        //test
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
        //test
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

            /*

            firstname : Noah
            lastName : Nelson
            subscription Ids: 18695.0, 19896.0
            wifidevicecount : 1
            cellulardevicecount : 3
            username: noah13nelson@gmail.com

             */

        }

        // test
        public particleUpdateUserResponse updateCurrentUser(String newPassword, String newUsername, String newAccountInfoFirstName, String newAccountInfolastName, String currentPassword) throws IOException {

            //Map<String,String> newInfo = new HashMap<String,String>();

            //newInfo.put("password",newPassword);
            //newInfo.put("current_password",currentPassword);
            //newInfo.put("username",newUsername);
            //newInfo.put("account_info[first_name]",newAccountInfoFirstName);
            //newInfo.put("account_info[last_name]",newAccountInfolastName);
            //newInfo.put("access_token",accesstoken);

            String url = baseUrl + "/v1/user/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleUpdateUserResponse> call = particleUserInterface.updateCurrentUser(newPassword,newUsername,newAccountInfoFirstName,newAccountInfolastName,currentPassword,accesstoken);

            Response<particleUpdateUserResponse> response = call.execute();

            particleUpdateUserResponse result = response.body();

            return result;


        }

        // test
        public particleUpdateUserResponse userPasswordReset(String username) throws IOException {


            String url = baseUrl + "/v1/user/password-reset/";

            // use mailgun to send email token

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleUpdateUserResponse> call = particleUserInterface.passwordReset(username);

            Response<particleUpdateUserResponse> response = call.execute();

            particleUpdateUserResponse result = response.body();

            return result;

        }

        // test
        public particleDeleteUserResponse deleteUser(String password) throws IOException {

            String url = baseUrl + "/v1/user/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleUserInterface particleUserInterface = retrofit.create(com.example.nctai_trading.particle.particleUserInterface.class);

            Call<particleDeleteUserResponse> call = particleUserInterface.deleteUser(password,accesstoken);

            Response<particleDeleteUserResponse> response = call.execute();

            return response.body();
        }


    }

    public class eventRequests{

        public eventRequests(){
            super();
        }

        /*

        ----- DEPRECATED

        // error : malformedjsonException expected value at line 1 column 1 path $
        public particleStreamOfEventsResponse openStreamOfServerEvents(String prefix) throws IOException {

            String eventPrefix= prefix;
            String accesstoken = "597d74aa67e9c6200009a804f37c4252ce671fc1";
            HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s",eventPrefix)).newBuilder();
            urlBuilder.addQueryParameter("access_token",accesstoken);
            String urlokhttp3 = urlBuilder.build().toString();
            Log.i("Retro",urlokhttp3);
            ServerSentEvent.Listener listener=new ServerSentEvent.Listener() {
                @Override
                public void onOpen(ServerSentEvent sse, okhttp3.Response response)
                {
                    Log.i("Retro","OnOpen");
                }
                @Override
                public void onMessage(ServerSentEvent sse, String id, String event, String message) {
                    Log.i("Retro","OnMessage "+ id + "," +event +","+message);
                    String data = message.split("\\:")[1].split(",")[0].replaceAll("\"","");
                    System.out.println(data);
                }
                @Override
                public void onComment(ServerSentEvent sse, String comment) {
                    Log.i("Retro","Oncomment " + comment );
                }
                @Override
                public boolean onRetryTime(ServerSentEvent sse, long milliseconds) {
                    Log.i("Retro","OnRetryTime " + milliseconds );
                    return true;
                }
                @Override
                public boolean onRetryError(ServerSentEvent sse, Throwable throwable, okhttp3.Response response) {
                    Log.i("Retro","OnRetryError "  );
                    return true;
                }
                @Override
                public void onClosed(ServerSentEvent sse) {
                    Log.i("Retro","Onclose "  );
                }
                @Override
                public Request onPreRetry(ServerSentEvent sse, Request originalRequest) {
                    Log.i("Retro","OnPreRetry "  );
                    return originalRequest;
                }
            };
            Request request = new Request.Builder().url(urlokhttp3).build();
            OkSse okSse = new OkSse();
            ServerSentEvent sse = okSse.newServerSentEvent(request, listener);


            return null;
        }

        */




        // test
        /*
        public String openStreamOfServerSentEvents(String prefix) throws IOException {

            com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = new accessTokenRequests();

            String eventPrefix= prefix;
            String accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s",eventPrefix)).newBuilder();
            urlBuilder.addQueryParameter("access_token",accesstoken);
            String urlokhttp3 = urlBuilder.build().toString();
            Log.i("Retro",urlokhttp3);
            ServerSentEvent.Listener listener=new ServerSentEvent.Listener() {
                @Override
                public void onOpen(ServerSentEvent sse, okhttp3.Response response)
                {
                    Log.i("Retro","OnOpen");
                }
                @Override
                public void onMessage(ServerSentEvent sse, String id, String event, String message) {
                    Log.i("Retro","OnMessage "+ id + "," +event +","+message);
                    contents[0] = event + "," + message;
                    return;
                }
                @Override
                public void onComment(ServerSentEvent sse, String comment) {
                    Log.i("Retro","Oncomment " + comment );
                }
                @Override
                public boolean onRetryTime(ServerSentEvent sse, long milliseconds) {
                    Log.i("Retro","OnRetryTime " + milliseconds );
                    return true;
                }
                @Override
                public boolean onRetryError(ServerSentEvent sse, Throwable throwable, okhttp3.Response response) {
                    Log.i("Retro","OnRetryError "  );
                    return true;
                }
                @Override
                public void onClosed(ServerSentEvent sse) {
                    Log.i("Retro","Onclose "  );
                }
                @Override
                public Request onPreRetry(ServerSentEvent sse, Request originalRequest) {
                    Log.i("Retro","OnPreRetry "  );
                    return originalRequest;
                }
            };
            Request request = new Request.Builder().url(urlokhttp3).build();
            OkSse okSse = new OkSse();
            ServerSentEvent sse = okSse.newServerSentEvent(request, listener);

            return contents[0];


        }
        */



        @RequiresApi(api = Build.VERSION_CODES.O)
        public void getAllEvents() throws IOException {

            com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = new accessTokenRequests();

            SimpleEventHandler eventHandler = new SimpleEventHandler();

            String accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.particle.io/v1/events").newBuilder();
            urlBuilder.addQueryParameter("access_token",accesstoken);

            EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(urlBuilder.build().toString())).reconnectTime(Duration.ofMillis(3000));

            try(EventSource eventSource = builder.build()){
                eventSource.start();
                TimeUnit.MINUTES.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public void openStreamOfServerSentEvents(String prefix) throws IOException {

            SleepTask sleepTask = new SleepTask();
            Timer timer = new Timer();
            /*
            com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = new accessTokenRequests();

            SimpleEventHandler eventHandler = new SimpleEventHandler();

            String accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s",prefix)).newBuilder();
            urlBuilder.addQueryParameter("access_token",accesstoken);

            EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(urlBuilder.build().toString())).reconnectTime(Duration.ofMillis(3000));

            try(EventSource eventSource = builder.build()) {
                System.out.println("In event source try");
                eventSource.start();
                //timer.schedule(sleepTask,500);
            }
            */
            timer.schedule(sleepTask,500);

        }

        // test
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
        // test
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

        // works
        public boolean publishAnEvent(String name) throws IOException {

            String url = baseUrl + "/v1/devices/events/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleEventsInterface particleEventsInterface = retrofit.create(com.example.nctai_trading.particle.particleEventsInterface.class);

            Call<particleDeleteTokenResponse> call = particleEventsInterface.publishEvent(name,"HELLO WORLD",true, 100, accesstoken);

            Response<particleDeleteTokenResponse> response = call.execute();

            particleDeleteTokenResponse result = response.body();

            return result.getOk();
        }


        // test
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

            particleWebhookInterface particleWebhookInterface = retrofit.create(com.example.nctai_trading.particle.particleWebhookInterface.class);

            Call<particleWebhookCreationResponse> call = particleWebhookInterface.createWebhook(integrationType,event,newUrl,requestType);

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


            Call<particleWebhookAzureResponse> call = particleWebhookInterface.createAzureWebhook(integrationType,event,hubName,policyName,policyKey);

            Response<particleWebhookAzureResponse> response = call.execute();

            particleWebhookAzureResponse result = response.body();

            return result;

        }

        public particleGoogleCloudResponse enableGoogleCloudPlatformIntegration(String integrationType, String event, String topic) throws IOException {


            String url = baseUrl + "/v1/integrations/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleWebhookInterface particleWebhookInterface = retrofit.create(com.example.nctai_trading.particle.particleWebhookInterface.class);

            Call<particleGoogleCloudResponse> call = particleWebhookInterface.createGoogleCloudWebhook(integrationType,event,topic);

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

            Response response = particleFirmwareInterface.updateDeviceFirmware(deviceId);

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

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.lockProductFirmware(productId,deviceId,desiredFirmwareVersion,accesstoken);

            Response<particleLockProductFirmware> response = call.execute();

            particleLockProductFirmware result = response.body();

            return result;



        }

        public particleLockProductFirmware unlockProductDeviceFirmware(String deviceId, String productId, String desiredFirmwareVerison) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/devices/%s/",deviceId,productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.unlockProductFirmware(productId,deviceId,desiredFirmwareVerison,accesstoken);

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

            particleFirmwareInterface particleFirmwareInterface = retrofit.create(com.example.nctai_trading.particle.particleFirmwareInterface.class);

            Call<particleLockProductFirmware> call = particleFirmwareInterface.markProductDevelopmentDevice(productId,deviceId,development,accesstoken);

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

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<particleGetDeviceGroup> call = particleDeviceGroupInterface.createDeviceGroup(productId,name);

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
            body.put("access_token",accesstoken);

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

            Response deleteDeviceGroup = particleDeviceGroupInterface.delteDeviceGroup(productId,groupName,accesstoken);

            return deleteDeviceGroup.errorBody().contentLength() < 1;
        }

        public particleDeviceGroupAssignGroupsToDeviceResponse assignGroupsToDevice(String deviceId, String productId, String... groups) throws IOException {

            String url = baseUrl + String.format("/v1/products/{productId}/devices/{deviceId}/",productId,deviceId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleDeviceGroupInterface particleDeviceGroupInterface = retrofit.create(com.example.nctai_trading.particle.particleDeviceGroupInterface.class);

            Call<particleDeviceGroupAssignGroupsToDeviceResponse> call = particleDeviceGroupInterface.assignGroupsToDevice(productId,deviceId,groups);

            Response<particleDeviceGroupAssignGroupsToDeviceResponse> response = call.execute();

            particleDeviceGroupAssignGroupsToDeviceResponse result = response.body();

            return result;
        }


    }

    public class customerRequests{

        public particleCreateCustomerResponse createCustomerAccessToken(String productId, String email, String password) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers/",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleCreateCustomerResponse> call = particleCustomerInterface.createCustomerAccessToken(productId,email,password);

            Response<particleCreateCustomerResponse> response = call.execute();

            return response.body();

        }

        public particleCreateCustomerResponse createCustomerClientCredentials(String productId, String clientId, String clientSecret, String email) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers",productId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleCreateCustomerResponse> call = particleCustomerInterface.createCustomerCredentials(productId,getAuthHeaders(),clientId,clientSecret,email);

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

        public particleCreateCustomerTokenResponse generateACustomerToken(String clientId, String clientSecret, String grantType) throws IOException {

            String url = baseUrl + "/oauth/token/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleCreateCustomerTokenResponse> call = particleCustomerInterface.createCustomerToken(getAuthHeaders(),clientId,clientSecret,"client_credentials",7884000);

            Response<particleCreateCustomerTokenResponse> response = call.execute();

            particleCreateCustomerTokenResponse result = response.body();

            return result;

        }

        public particleUpdateCustomerPasswordResponse updateCustomerPassword(String productId, String customerEmail, String password) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers/%s/",productId,customerEmail);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleUpdateCustomerPasswordResponse> call = particleCustomerInterface.updateCustomer(productId,customerEmail,password);

            Response<particleUpdateCustomerPasswordResponse> response = call.execute();

            particleUpdateCustomerPasswordResponse result = response.body();

            return result;
        }

        public particleUpdateCustomerPasswordResponse deleteCustomer(String productId, String customerEmail) throws IOException {

            String url = baseUrl + String.format("/v1/products/%s/customers/%s",productId,customerEmail);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            particleCustomerInterface particleCustomerInterface = retrofit.create(com.example.nctai_trading.particle.particleCustomerInterface.class);

            Call<particleUpdateCustomerPasswordResponse> call = particleCustomerInterface.deleteCustomer(productId,customerEmail,accesstoken);

            Response<particleUpdateCustomerPasswordResponse> response = call.execute();

            particleUpdateCustomerPasswordResponse result = response.body();

            return result;

        }


    }

    public class SleepTask extends TimerTask {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            try {
                com.example.nctai_trading.particle.particleMethods.accessTokenRequests accessTokenRequests = new accessTokenRequests();

                SimpleEventHandler eventHandler = new SimpleEventHandler();

                String accesstoken = accessTokenRequests.getAccessToken("password").getAccessToken();
                HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("https://api.particle.io/v1/events/%s","test")).newBuilder();
                urlBuilder.addQueryParameter("access_token",accesstoken);

                EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(urlBuilder.build().toString())).reconnectTime(Duration.ofMillis(3000));

                try(EventSource eventSource = builder.build()) {
                    System.out.println("In event source try");
                    eventSource.start();
                    //timer.schedule(sleepTask,500);
                }
                System.out.println("Sleeptask try");
                Thread.sleep(120000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
