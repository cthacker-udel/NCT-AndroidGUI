package com.example.nctai_trading.bitrue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.example.nctai_trading.bitrue.orderBook.marketDataOrderBook;
import com.example.nctai_trading.bitrue.recentTrades.marketDataRecentTrades;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bitrueMethods {

    String baseUrl = "https://www.bitrue.com";

    String apiKey = "4d52b03ce5feb11781490b77696aeab7bc7a76a0f8c4bf0d2c575d983f4ba4e7";
    String secretKey = "592d0d53611f643790607b4e9f36006fcb71bf273d22fcf78a5ab11ac92c726f";

    // require X-MBX-APIKEY header
    // signed require : signature (query string) HMAC 256 secretkey as key and totalParams as value for HMAC encryption
    // totalParams: query string concat with body, also requires recvWindow

    public String generateSignature(String queryString) throws InvalidKeyException, NoSuchAlgorithmException {

        HMAC256 hmac256 = new HMAC256();

        String body = queryString;

        String signature = hmac256.HMAC256Algorithm(secretKey,body);

        return signature;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(Map<String,Object> map, Long timestamp){

        map.put("timestamp",timestamp);
        ArrayList<String> values = new ArrayList<>();
        for(String eachKey: map.keySet()){
            values.add(eachKey + "=" + map.get(eachKey));
        }
        return String.join("&",values);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Long getTimestamp(){
        return Instant.now().getEpochSecond();
    }


    public class serverRequests{

        public boolean serverPing() throws IOException {

            String url = baseUrl + "/api/v1/ping/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<Object> call = bitrueServerInterface.serverPing();

            Response<Object> response = call.execute();

            return response.isSuccessful();

        }

        public boolean getServerTime() throws IOException {

            String url = baseUrl + "/api/v1/time/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<com.example.nctai_trading.bitrue.serverObject.serverTimeResponse> getServerTime = bitrueServerInterface.getServerTime();

            Response<com.example.nctai_trading.bitrue.serverObject.serverTimeResponse> response = getServerTime.execute();

            return response.isSuccessful();


        }

        public com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse getExchangeInfo() throws IOException {
            String url = baseUrl + "/api/v1/depth/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse> call = bitrueServerInterface.getExchangeInfo();

            Response<com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse> response = call.execute();

            return response.body();
        }


    }

    public class marketDataRequests{

        public marketDataOrderBook getMarketDataEndpoints(String symbol) throws IOException {

            String url = baseUrl + "/api/v1/depth/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            marketDataInterface bitrueMarketDataInterface = retrofit.create(com.example.nctai_trading.bitrue.marketDataInterface.class);

            Call<marketDataOrderBook> call = bitrueMarketDataInterface.getOrderBook(symbol);

            Response<marketDataOrderBook> response = call.execute();

            return response.body();


        }

        public marketDataRecentTrades getRecentTrades(String symbol) throws IOException {

            String url = baseUrl + "/api/v1/trades/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            marketDataInterface marketDataInterface = retrofit.create(com.example.nctai_trading.bitrue.marketDataInterface.class);

            Call<marketDataRecentTrades> call = marketDataInterface.getRecentTrades(symbol);

            Response<marketDataRecentTrades> response = call.execute();

            return response.body();
        }

        public marketDataRecentTrades getPastTrades(String symbol) throws IOException{

            String url = baseUrl + "/api/v1/historicalTrades/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            marketDataInterface marketDataInterface = retrofit.create(com.example.nctai_trading.bitrue.marketDataInterface.class);

            Call<marketDataRecentTrades> call = marketDataInterface.getPastTrades(symbol);

            Response<marketDataRecentTrades> response = call.execute();

            return response.body();


        }

    }

    public class orderRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bitrueOrderResponse placeOrder(String symbol, String side, String type, Double quantity) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            Map<String,Object> queryParams = new LinkedHashMap<>();
            queryParams.put("symbol",symbol);
            queryParams.put("side",side);
            queryParams.put("type",type);
            queryParams.put("quantity",quantity);
            String url = baseUrl + "/api/v1/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            orderInterface orderInterface = retrofit.create(com.example.nctai_trading.bitrue.orderInterface.class);

            Long timestamp = getTimestamp();

            Call<bitrueOrderResponse> call = orderInterface.placeOrder(symbol,side,type,quantity,timestamp,generateSignature(generateQueryString(queryParams,timestamp)));

            Response<bitrueOrderResponse> response = call.execute();

            return response.body();

        }


    }


}
