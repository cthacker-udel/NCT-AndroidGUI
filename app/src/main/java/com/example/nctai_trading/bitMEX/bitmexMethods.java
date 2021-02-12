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

    String apikey = "QL96zz4M6oj2aPGIZBeUGuyq";
    String secretKey = "aTkRoaagMp7S5edIjoy-bEb7jyubNZphikluLNRrS3Ktlwu4";
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

    }

}
