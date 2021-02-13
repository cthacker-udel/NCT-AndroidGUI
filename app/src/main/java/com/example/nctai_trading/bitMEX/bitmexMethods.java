package com.example.nctai_trading.bitMEX;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bitmexMethods {

    String apikey = "Zs8JDFABNcAlPQ8gWlWIZrJb";
    String secretKey = "_lVyrCU8vI_ngFkD7YgCGpBW90pFkJWjTe5x_DLCpCcNsELJ";
    String baseUrl = "https://www.bitmex.com/api/v1";
    HMAC256 hmac256 = new HMAC256();

    public String generateSignature(String verb, String path, String timestamp, String data){
        String prehash = verb + path + timestamp + data;
        String result = hmac256.hmacDigest(prehash,secretKey,"HmacSHA256");
        return result;
    }

    public String encodeQueryString(String queryString) throws UnsupportedEncodingException {

        String result = URLEncoder.encode(queryString,"UTF-8");
        return result;

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

            String url = baseUrl + "/funding/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitmexFundingInterface bitmexFundingInterface = retrofit.create(com.example.nctai_trading.bitMEX.bitmexFundingInterface.class);

            String timestamp = getTimeStamp();
            Call<List<bitmexFunding>> getFundingHistory = bitmexFundingInterface.getFunding(timestamp,apikey,generateSignature("GET","/api/v1/funding",timestamp,""),10);

            Response<List<bitmexFunding>> response = getFundingHistory.execute();

            return response.body();

        }

    }

}
