package com.example.nctai_trading.bithumb;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bithumbMethods {

    public String apiKey = "";
    public String secretKey = "";
    public String baseUrl = "https://global-openapi.bithumb.pro/openapi/v1";

    public bithumbMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getSignature(Map<String,String> headers) throws InvalidKeyException, NoSuchAlgorithmException {
        String[] sortedHeaders = headers.keySet().stream().sorted().toArray(String[]::new);
        String emptystring = "";
        for(String eachKey: sortedHeaders){
            emptystring += String.format("%s=%s",eachKey,headers.get(eachKey));
        }
        com.example.nctai_trading.HMAC256 encoder = new com.example.nctai_trading.HMAC256();
        String result = encoder.HMAC256Algorithm(secretKey,emptystring);
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTimeStamp(){
        return Instant.EPOCH.getEpochSecond() + "";
    }


    public Integer getServerTime() throws IOException {

        String url = baseUrl + "/serverTime/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bithumbServerInterface bithumbServerInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbServerInterface.class);

        Call<bithumbServerTimeResponse> call = bithumbServerInterface.getServerTime();

        Response<bithumbServerTimeResponse> response = call.execute();

        return response.body().getData();
    }

    public void getConfigDetail(){

        String url = baseUrl + "/spot/config/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();




    }

    public class withdrawRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bithumbWithdrawResponse withdraw(String coinType, String address, String quantity, String mark) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/withdraw";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> authHeader = new HashMap<>();

            bithumbWithdrawInterface bithumbWithdrawInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbWithdrawInterface.class);

            authHeader.put("coinType",coinType);
            authHeader.put("address",address);
            authHeader.put("quantity",quantity);
            authHeader.put("mark",mark);
            authHeader.put("timestamp",getTimeStamp());
            authHeader.put("signature",getSignature(authHeader));

            Call<bithumbWithdrawResponse> call = bithumbWithdrawInterface.withdraw(authHeader);

            Response<bithumbWithdrawResponse> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bithumbWithdrawResponse withdrawAssetBetweenAccounts(String coinType, String quantity, String from, String to) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/transfer/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,String> authHeader = new HashMap<>();

            authHeader.put("coinType",coinType);
            authHeader.put("quantity",quantity);
            authHeader.put("from",from);
            authHeader.put("to",to);
            authHeader.put("timestamp",getTimeStamp());
            authHeader.put("signature",getSignature(authHeader));

            bithumbWithdrawInterface bithumbWithdrawInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbWithdrawInterface.class);

            Call<bithumbWithdrawResponse> call = bithumbWithdrawInterface.transferAccount(authHeader);

            Response<bithumbWithdrawResponse> response = call.execute();

            bithumbWithdrawResponse result = response.body();

            return result;
        }
    }

    public class historyRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bithumbWithdrawResponse queryDepositHistory(String coin, String start) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/wallet/depositHistory/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bithumbDepositInterface bithumbDepositInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbDepositInterface.class);

            Map<String,String> authHeader = new HashMap<>();

            authHeader.put("coin",coin);
            authHeader.put("start",start);
            authHeader.put("timestamp",getTimeStamp());
            authHeader.put("signature",getSignature(authHeader));

            Call<bithumbWithdrawResponse> call = bithumbDepositInterface.getDepositHistory(authHeader);

            Response<bithumbWithdrawResponse> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bithumbWithdrawResponse getWithdrawHistory(String start) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/wallet/withdrawHistory/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bithumbWithdrawInterface bithumbWithdrawInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbWithdrawInterface.class);

            Map<String,String> authHeader = new HashMap<>();

            authHeader.put("start",start);
            authHeader.put("timestamp",getTimeStamp());
            authHeader.put("signature",getSignature(authHeader));

            Call<bithumbWithdrawResponse> call = bithumbWithdrawInterface.getWithdrawHistory(authHeader);

            Response<bithumbWithdrawResponse> response = call.execute();

            return response.body();
        }



    }

    public class tickerRequests{

        public bithumbTickerResponse getTickerPrice(String symbol) throws IOException {

            String url = baseUrl + "/spot/ticker/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bithumbTickerInterface bithumbTickerInterface = retrofit.create(com.example.nctai_trading.bithumb.bithumbTickerInterface.class);

            Map<String,String> authHeader = new HashMap<>();

            authHeader.put("symbol",symbol);

            Call<bithumbTickerResponse> call = bithumbTickerInterface.getTickerPrice(authHeader);

            Response<bithumbTickerResponse> response = call.execute();

            bithumbTickerResponse result = response.body();

            return result;
        }

        public void getOrderBook(String symbol){

            String url = baseUrl + "/spot/orderBook/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();






        }


    }


}
