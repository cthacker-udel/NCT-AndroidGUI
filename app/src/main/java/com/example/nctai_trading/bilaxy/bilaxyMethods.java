package com.example.nctai_trading.bilaxy;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.util.Arrays;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
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

    public bilaxyMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }


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

    public class interfaceRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bilaxyAccount> getAccountInfo() throws IOException {

            String url = baseUrl + "/v1/balances/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyAccountInterface bilaxyAccountInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyAccountInterface.class);

            String signature = generateSignatureGET(apiKey,secretKey);
            Call<List<bilaxyAccount>> call = bilaxyAccountInterface.getAccountInformation(apiKey,signature);

            Response<List<bilaxyAccount>> repsonse = call.execute();

            return repsonse.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxyDepositAddress getDepositAddress(String symbol) throws IOException {

            String url = baseUrl + "/v1/coin_address/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyInterfacesInterface bilaxyInterfacesInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyInterfacesInterface.class);

            String signature = generateSignatureGET(symbol,apiKey,secretKey);
            Call<bilaxyDepositAddress> call = bilaxyInterfacesInterface.getDepositAddress(symbol,apiKey,signature);

            Response<bilaxyDepositAddress> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<bilaxyOrderQuery> ordersQuery(String symbol, String type) throws IOException {

            String url = baseUrl + "/v1/trade_list/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyInterfacesInterface bilaxyInterfacesInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyInterfacesInterface.class);

            String timestamp = Instant.now().getEpochSecond() + "";
            String signature = generateSignatureGET(symbol, timestamp,type,secretKey,apiKey);

            Call<List<bilaxyOrderQuery>> getOrderQueries = bilaxyInterfacesInterface.getOrderQueries(symbol,timestamp,type,apiKey,signature);

            Response<List<bilaxyOrderQuery>> response = getOrderQueries.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxyOrderQuery queryOrdersInformation(String id) throws IOException {

            String url = baseUrl + "/v1/trade_view/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyInterfacesInterface bilaxyInterfacesInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyInterfacesInterface.class);

            String signature = generateSignatureGET(id,apiKey,secretKey);
            Call<bilaxyOrderQuery> getOrderQuery = bilaxyInterfacesInterface.getOrderQuery(id,apiKey,signature);

            Response<bilaxyOrderQuery> response = getOrderQuery.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxyDepositAddress cancelOrders(String id) throws IOException {

            String url = baseUrl + "/v1/cancel_trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyInterfacesInterface bilaxyInterfacesInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyInterfacesInterface.class);

            String signature = generateSignatureGET(id,apiKey,secretKey);

            Call<bilaxyDepositAddress> call = bilaxyInterfacesInterface.cancelOrder(id,apiKey,signature);

            Response<bilaxyDepositAddress> response = call.execute();

            return response.body();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public bilaxyDepositAddress placeOrder(String symbol, String amount, Double price, String type) throws IOException {

            String url = baseUrl + "/v1/trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bilaxyInterfacesInterface bilaxyInterfacesInterface = retrofit.create(com.example.nctai_trading.bilaxy.bilaxyInterfacesInterface.class);

            String signature = generateSignatureGET(symbol,amount,price,type,apiKey,secretKey);

            Call<bilaxyDepositAddress> placeOrder = bilaxyInterfacesInterface.placeOrder(symbol,amount,price,type,apiKey,signature);

            Response<bilaxyDepositAddress> response = placeOrder.execute();

            return response.body();

        }


    }

}
