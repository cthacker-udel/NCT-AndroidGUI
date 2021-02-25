package com.example.nctai_trading.bitforex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bitforexMethods {

    String apiKey = "3f368cf10638f297810615ae156f12a9";
    String secretKey = "e7a3ea02da128f2b74f332fba15c2b31";
    String baseUrl = "https://api.bitforex.com";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateSignaturePOST(String path, Map<String,Object> params){

        /*

        @param String(path) Form -> /path + ?
        @param Map<String,Object> params : values passed with post request

         */

        path = path + "?";

        params.put("accessKey",apiKey);

        String[] sortedKeys = params.keySet().stream().sorted().toArray(String[]::new);

        ArrayList<String> urlList = new ArrayList<>();

        String url = "";

        for(String eachString: sortedKeys){
            urlList.add(String.format("%s=%s",eachString,params.get(eachString)));
        }

        url = path + String.join("&",urlList);

        HMAC256 hmac256 = new HMAC256();

        String result = hmac256.hmacDigest(url,secretKey,"HmacSHA256");

        return result;

    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public Long getTimeStamp(){

        return Instant.now().getEpochSecond();

    }


    public class symbolRequests{

        public bitforexMarketSymbols getSymbolInformation() throws IOException {

            String url = baseUrl + "/api/v1/market/symbols/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitforexSymbolInterface bitforexSymbolInterface = retrofit.create(com.example.nctai_trading.bitforex.bitforexSymbolInterface.class);

            Call<bitforexMarketSymbols> call = bitforexSymbolInterface.getSymbolInformation();

            Response<bitforexMarketSymbols> response = call.execute();

            return response.body();


        }


    }

    public class tickerRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitforexTickerInformation getTickerInformation(String name) throws IOException {

            String url = baseUrl + "/api/v1/market/ticker/";




            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            String path = "/api/v1/market/ticker";

            Map<String,Object> params = new HashMap<>();
            params.put("accessKey",apiKey);
            params.put("symbol",name);

            String signature = generateSignaturePOST(path,params);

            bitforexTickerInterface bitforexTickerInterface = retrofit.create(com.example.nctai_trading.bitforex.bitforexTickerInterface.class);

            Call<bitforexTickerInformation> call = bitforexTickerInterface.getTickerInformation(name);

            Response<bitforexTickerInformation> response = call.execute();

            return response.body();
        }


    }


    public class orderRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitforexOrderResponse placeOrder(String symbol, Double price, Double amount, Integer tradeType) throws IOException {

            String url = baseUrl + "/api/v1/trade/placeOrder/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitforexOrderInterface bitforexOrderInterface = retrofit.create(com.example.nctai_trading.bitforex.bitforexOrderInterface.class);

            Map<String,Object> params = new HashMap<>();

            params.put("symbol",symbol);
            params.put("price",price);
            params.put("amount",amount);
            params.put("tradeType",tradeType);
            params.put("accessKey",apiKey);
            params.put("nonce",getTimeStamp());
            String signature = generateSignaturePOST("/api/v1/trade/placeOrder",params);

            Call<bitforexOrderResponse> call = bitforexOrderInterface.placeOrder(apiKey,amount,(Long)params.get("nonce"),price,symbol,signature);

            Response<bitforexOrderResponse> response = call.execute();

            return response.body();


        }


    }



}
