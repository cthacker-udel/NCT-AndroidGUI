package com.example.nctai_trading.bitMEX;

import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bitmexMethods {

    String apikey = "Zs8JDFABNcAlPQ8gWlWIZrJb";
    String secretKey = "_lVyrCU8vI_ngFkD7YgCGpBW90pFkJWjTe5x_DLCpCcNsELJ";
    String baseUrl = "https://www.bitmex.com/api/v1";
    HMAC256 hmac256 = new HMAC256();

    public bitmexMethods(String apikey, String secretkey){
        this.apikey = apikey;
        this.secretKey = secretkey;
    }

    public String generateSignature(String verb, String path, String timestamp, String data){
        String prehash = verb + path + timestamp + data;
        String result = hmac256.hmacDigest(prehash,secretKey,"HmacSHA256");
        return result;
    }

    public String encodeQueryString(String queryString) throws UnsupportedEncodingException {

        String result = URLEncoder.encode(queryString,"UTF-8");
        return result;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryParams(Map<String,Object> body){
        ArrayList<String> strList = new ArrayList<>();
        for(String eachKey: body.keySet()){
            strList.add(eachKey + "=" + body.get(eachKey));
        }
        return String.join("&",strList);

    }

    public String generateSingleQueryParam(Map<String,Object> body){

        String emptystring = "";
        for(String eachKey: body.keySet()){
            emptystring += eachKey + "=" + body.get(eachKey);
        }
        return emptystring;

    }

    public String temp(String path, String queryString) throws URISyntaxException {
        URI uri = new URI("https","www.bitmex.com",path,queryString,"");
        return uri.toASCIIString();
    }


    public static String nonceGenerator(){

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 13; i++){
            stringBuilder.append(secureRandom.nextInt(10));
        }
        String randomNumber = stringBuilder.toString();
        return randomNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTimeStamp(){

        return Instant.now().getEpochSecond() + 5 + "";

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<bitmexRawExecution> getAccountExecutionHistory() throws IOException {
        String url = baseUrl + "/user/executionHistory";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bitmexExecutionInterface bitmexExecutionInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexExecutionInterface.class);

        String timestamp = getTimeStamp();
        Call<List<bitmexRawExecution>> call = bitmexExecutionInterface.getAccountExecutionHistory(timestamp, apikey, generateSignature("GET", "/user/executionHistory", timestamp, ""));

        Response<List<bitmexRawExecution>> response = call.execute();

        return response.body();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<userWalletHistory> getAccountWalletHistory() throws IOException {
        String url = baseUrl + "/user/walletHistory";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bitmexExecutionInterface bitmexExecutionInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexExecutionInterface.class);

        String timestamp = getTimeStamp();
        Call<List<userWalletHistory>> call = bitmexExecutionInterface.getAccountWalletHistory(timestamp, apikey, generateSignature("GET", "/user/executionHistory", timestamp, ""));

        Response<List<userWalletHistory>> response = call.execute();

        return response.body();
    }



    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }



    public class announcementRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexAnnouncement> getAnnouncement() throws IOException {

            String url = baseUrl + "/announcement/";

            // fixed test

            String encoded = encodeQueryString("?filter={\"symbol\": \"XBTM15\"}");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexAccouncementsInterface bitmexAccouncementsInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexAccouncementsInterface.class);

            String timeStamp = getTimeStamp();
            Call<List<bitmexAnnouncement>> call = bitmexAccouncementsInterface.getAnnouncement(timeStamp,apikey,generateSignature("GET","/api/v1/announcement",timeStamp,""));

            Response<List<bitmexAnnouncement>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexAnnouncement> getUrgentAnnouncement() throws IOException {

            String url = baseUrl + "/accouncement/urgent/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexAccouncementsInterface bitmexAccouncementsInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexAccouncementsInterface.class);

            String timestamp = getTimeStamp();

            Call<List<bitmexAnnouncement>> call = bitmexAccouncementsInterface.getUrgentAnnouncement(timestamp,apikey,generateSignature("GET","/api/v1/announcement/urgent",timestamp,""));

            Response<List<bitmexAnnouncement>> response = call.execute();

            return response.body();

        }

    }

    public class apiKeyRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexApiKey> getApiKeys() throws IOException {

            String url = baseUrl + "/apiKey/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexApiInterface bitmexApiInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexApiInterface.class);

            String timestamp = getTimeStamp();

            Call<List<bitmexApiKey>> call = bitmexApiInterface.getApiKeys(timestamp,apikey,generateSignature("GET","/api/v1/apiKey",timestamp,""));

            Response<List<bitmexApiKey>> response = call.execute();

            return response.body();
        }

    }

    public class executionRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexRawExecution> getExecutionRequests() throws IOException {
            String url = baseUrl + "/execution/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexExecutionInterface bitmexExecutionInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexExecutionInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexRawExecution>> call = bitmexExecutionInterface.getRawExecution(timestamp, apikey, generateSignature("GET", "/api/v1/execution", timestamp, ""));

            Response<List<bitmexRawExecution>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexRawExecution> getExecutionTradeHistory() throws IOException {

            String url = baseUrl + "/execution/tradeHistory/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexExecutionInterface bitmexExecutionInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexExecutionInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexRawExecution>> call = bitmexExecutionInterface.getExecutionTradeHistory(timestamp,apikey,generateSignature("GET","/api/v1/execution/tradeHistory",timestamp,""));

            Response<List<bitmexRawExecution>> response = call.execute();

            return response.body();
        }
    }

    public class fundingRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexFunding> getFunding() throws IOException {

            String url = baseUrl + String.format("/funding/");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexFundingInterface bitmexFundingInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexFundingInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexFunding>> getFundingHistory = bitmexFundingInterface.getFunding(timestamp,apikey,generateSignature("GET","/api/v1/funding",timestamp,""));

            Response<List<bitmexFunding>> response = getFundingHistory.execute();

            return response.body();

        }

    }

    public class globalNotificationsRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitmexGlobalNotification getGlobalNotifications() throws IOException {

            String url = baseUrl + "/globalNotification/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexGlobalNotificationInterface bitmexGlobalNotificationInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexGlobalNotificationInterface.class);

            String timeStamp = getTimeStamp();
            Call<bitmexGlobalNotification> call = bitmexGlobalNotificationInterface.getGlobalNotification(timeStamp,apikey,generateSignature("GET","/api/v1/globalNotification",timeStamp,""));

            Response<bitmexGlobalNotification> response = call.execute();

            return response.body();
        }

    }

    public class instrumentRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexInstrument> getInstruments() throws IOException {

            String url = baseUrl + "/instrument/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexInstrumentInterface bitmexInstrumentInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexInstrumentInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexInstrument>> call = bitmexInstrumentInterface.getInstruments(timestamp,apikey,generateSignature("GET","/api/v1/instrument",timestamp,""));
            Response<List<bitmexInstrument>> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexInstrument> getActiveInstrument() throws IOException {

            String url = baseUrl + "/instrument/active/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexInstrumentInterface bitmexInstrumentInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexInstrumentInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexInstrument>>  call = bitmexInstrumentInterface.getActiveInstrument(timestamp,apikey,generateSignature("GET","/api/v1/instrument/active",timestamp,""));

            Response<List<bitmexInstrument>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bitmexInstrument> getActiveInstrumentAndIndices() throws IOException {

            String url = baseUrl + "/instrument/activeAndIndices/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexInstrumentInterface bitmexInstrumentInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexInstrumentInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexInstrument>> call = bitmexInstrumentInterface.getActiveIndiceInstrument(timestamp,apikey,generateSignature("GET","/api/v1/instrument/activeAndIndices",timestamp,""));

            Response<List<bitmexInstrument>> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitmexInstrumentActiveIntervals getActiveIntervals() throws IOException {

            String url = baseUrl + "/instrument/activeIntervals/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexInstrumentInterface bitmexInstrumentInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexInstrumentInterface.class);

            String timestamp = getTimeStamp();
            Call<bitmexInstrumentActiveIntervals> call = bitmexInstrumentInterface.getActiveIntervals(timestamp,apikey,generateSignature("GET","/api/v1/instrument/activeIntervals",timestamp,""));

            Response<bitmexInstrumentActiveIntervals> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitmexInstrumentCompositeIndex getCompositeIndex(String symbol) throws IOException, URISyntaxException {

            String url = baseUrl + "/instrument/compositeIndex/";

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(0,TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexInstrumentInterface bitmexInstrumentInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexInstrumentInterface.class);

            Map<String,Object> queryParams = new LinkedHashMap<>();
            queryParams.put("symbol",symbol);

            String timestamp = getTimeStamp();

            Call<bitmexInstrumentCompositeIndex> call = bitmexInstrumentInterface.getCompositeIndex(timestamp,apikey,generateSignature("GET",temp("/api/v1/instrument/compositeIndex",generateSingleQueryParam(queryParams)),timestamp,""),symbol);

            Response<bitmexInstrumentCompositeIndex> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public boolean cancelAllOrders(Integer timeout) throws IOException, URISyntaxException {

            String url = baseUrl + "/order/cancelAllAfter/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexFundingInterface bitmexFundingInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexFundingInterface.class);

            Map<String,Object> queryParams = new LinkedHashMap<>();
            queryParams.put("timeout",timeout);

            String timestamp = getTimeStamp();

            Call<Void> call = bitmexFundingInterface.cancelAllOrders(timestamp,apikey,generateSignature("POST",temp("/api/v1/order/cancelAllAfter",generateSingleQueryParam(queryParams)),timestamp,""),timeout);

            Response<Void> response = call.execute();

            return response.isSuccessful();

        }



    }

}
