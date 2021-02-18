package com.example.nctai_trading.bilaxy;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.util.Arrays;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bilaxyMethods {

    String apiKey = "";
    String secretKey = "";
    String baseUrl = "https://api.bilaxy.com";


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateSignatureGET(Object... params){

        String[] sortedParameters = Stream.of(params).sorted().map(String::valueOf).toArray(String[]::new);

        String[] reverseSorted = new String[sortedParameters.length];

        for(int i = sortedParameters.length-1, j = 0; i >= 0; i--, j++){
            reverseSorted[j] = sortedParameters[i];
        }

        String signature = String.join("&",reverseSorted);

        MessageDigest md = null;
        try{

            md = MessageDigest.getInstance("SHA-1");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(md.digest(signature.getBytes()));

    }


    public class priceTickerRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxySinglePriceTicker getPriceTicker(String symbol) throws IOException {

            String url = baseUrl + "/v1/ticker/";

            String signature = generateSignatureGET(apiKey,symbol,secretKey);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyPriceTickerInterface bilaxyPriceTickerInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyPriceTickerInterface.class);

            Call<bilaxySinglePriceTicker> call = bilaxyPriceTickerInterface.getSinglePriceTicker(symbol,apiKey,signature);

            Response<bilaxySinglePriceTicker> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bilaxySinglePriceTicker> getAllPriceTicker(String symbol) throws IOException {

            String url = baseUrl + "/v1/tickers/";

            String signature = generateSignatureGET(apiKey,symbol,secretKey);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyPriceTickerInterface bilaxyPriceTickerInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyPriceTickerInterface.class);

            Call<List<bilaxySinglePriceTicker>> getPriceTickers = bilaxyPriceTickerInterface.getPriceTickers(symbol,apiKey,signature);

            Response<List<bilaxySinglePriceTicker>> response = getPriceTickers.execute();

            return response.body();

        }

    }

    public class marketDepthRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxyMarketDepth getMarketDepth(String symbol, Integer merge) throws IOException {

            String url = baseUrl + "/v1/depth/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyMarketDepthInterface bilaxyMarketDepthInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyMarketDepthInterface.class);

            String signature = generateSignatureGET(apiKey,symbol,merge,secretKey);

            Call<bilaxyMarketDepth> call = bilaxyMarketDepthInterface.getMarketDepth(symbol,merge,apiKey,signature);

            Response<bilaxyMarketDepth> response = call.execute();

            return response.body();


        }


    }

    public class transactionRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bilaxyRecentTransaction> getRecentTransactions(String symbol, Integer size) throws IOException {

            String url = baseUrl + "/v1/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyTransactionInterface bilaxyTransactionInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyTransactionInterface.class);

            String signature = generateSignatureGET(apiKey,symbol,size,secretKey);

            Call<List<bilaxyRecentTransaction>> call = bilaxyTransactionInterface.getRecentTransactions(symbol,size,apiKey,signature);

            Response<List<bilaxyRecentTransaction>> response = call.execute();

            return response.body();

        }


    }

    public class accountRequests{

        public void getAccountInfo(){
            return;
        }


    }

}
