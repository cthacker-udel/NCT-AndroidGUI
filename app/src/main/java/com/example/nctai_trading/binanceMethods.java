package com.example.nctai_trading;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import jersey.repackaged.com.google.common.collect.ImmutableMap;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class binanceMethods {

    public static String baseUrl = "https://api.binance.us";
    public static String secretKey = "mM57MtfNnRG1UrrZs6uGbKNNx1VIU7UktgwqPxelhXkI0cqjXaSCTOvXZY8vMTxj";
    public static String apiKey = "lISh9SeQdCT1HGPeo3Z6p8jWAsOJ6tmjoG7LeMsMNGCGBT0HRhfyfEvHJdjn49IG";

    public static OkHttpClient defaultHttpClient = new OkHttpClient();

    public static okhttp3.OkHttpClient defaultHttpClient2 = new okhttp3.OkHttpClient();


    public static okhttp3.OkHttpClient getDefaultHttpClient2(){
        defaultHttpClient2.networkInterceptors().add(new okhttp3.Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request().newBuilder().
                        addHeader("secretKey",secretKey)
                        .build();
                return chain.proceed(request);
            }
        });
        return binanceMethods.defaultHttpClient2;
    }

    public static OkHttpClient getDefaultHttpClient() {
        defaultHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("secretKey",secretKey).build();
                return chain.proceed(request);
            }
        });
        return defaultHttpClient;
    }

    static{
        defaultHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("secretKey",secretKey).build();
                return chain.proceed(request);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getSignature(String url,HashMap<String,String> theHashMap) throws NoSuchAlgorithmException, InvalidKeyException {

        String signature = "";
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: theHashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(theHashMap.get(eachKey))));
        }

        signature = String.join("&",signatureList);
        HMAC256 test = new HMAC256();
        return test.hmacDigest(signature,secretKey,"HmacSHA256");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(HashMap<String,String> hashMap){
        ArrayList<String> signatureList = new ArrayList<>();

        for(String eachKey: hashMap.keySet()){
            signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(hashMap.get(eachKey))));
        }
        return "?" + String.join("&",signatureList);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String url = this.baseUrl + "/api/v3/account/";

        HashMap<String,String> data = new HashMap<>();
        data.put("recvWindow","10000");
        data.put("timestamp",String.valueOf(synchronize()));
        String signature = getSignature(url,data);
        data.put("signature",signature);
        String queryString = generateQueryString(data);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        getAccountInfo accountInfoGet = retrofit.create(getAccountInfo.class);

        ///   ONLY PROBLEM IS THE GENERATE SIGNATURE METHOD

        ImmutableMap<String,String> immutableMap = ImmutableMap.of("recvWindow",String.valueOf(data.get("recvWindow")),"timestamp",String.valueOf(data.get("timestamp")),"signature",data.get("signature"));

        Call<com.example.nctai_trading.Account> accountCall = accountInfoGet.getAccount(immutableMap,apiKey);
        try {
            System.out.println("Reached account info");
            Response<com.example.nctai_trading.Account> responseAccount = accountCall.execute();
            com.example.nctai_trading.Account result = responseAccount.body();
            HashMap<String,String> balanceMap = new HashMap<>();
            List<Balance> balanceList = result.getBalances();
            for(Balance eachBalance: balanceList){
                balanceMap.put(eachBalance.getAsset(),eachBalance.getFree());
            }
            String accountType = result.getAccountType();
            Integer makerCommision = result.getMakerCommission();
            System.out.println(balanceMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String displayCurrentPrice(String symbol) throws IOException {
        AveragePrice result;
        HashMap<String,String> data = new HashMap<>();
        data.put("symbol",symbol);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.binance.us/api/v3/avgPrice/").addConverterFactory(GsonConverterFactory.create()).build();

        getAveragePrice avgPriceGet = retrofit.create(getAveragePrice.class);

        Call<AveragePrice> avgPriceObject = avgPriceGet.getAvgPrice(data);

        Response<AveragePrice> responseAvgPrice = avgPriceObject.execute();
        try {
            result = responseAvgPrice.body();
        }
        catch(NullPointerException nullPointerException){
            // fix bug
            return "Not available";
        }
        return String.format("%s : %s","1",result.getPrice());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Order> getOpenOrderList() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String url = "https://api.binance.us/api/v3/openOrderList/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.binance.us/api/v3/openOrderList/").addConverterFactory(GsonConverterFactory.create()).build();

        HashMap<String,String> data = new HashMap<>();
        data.put("recvWindow","10000");
        data.put("timestamp",String.valueOf(synchronize()));

        String signature = getSignature(url,data);

        data.put("signature",signature);

        getOpenOrderList openOrderListCmd = retrofit.create(getOpenOrderList.class);

        ImmutableMap<String,String> immutableMap = ImmutableMap.of("recvWindow", data.get("recvWindow"), "timestamp", data.get("timestamp"), "signature", data.get("signature"));

        Call<OpenOrderList> openOrderListCall = openOrderListCmd.openOrderListQuery(immutableMap,apiKey);

        Response<OpenOrderList> openOrderListResponse = openOrderListCall.execute();

        OpenOrderList openOrderListBody = openOrderListResponse.body();

        List<Order> orderList = openOrderListBody.getOrders();

        for(Order eachOrder: orderList){
            System.out.println(eachOrder.getSymbol());
        }
        return orderList;
    }

    public long getServerTime() throws IOException {
        String url = this.baseUrl + "/api/v3/time/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getTheServerTime theServerTime = retrofit.create(getTheServerTime.class);

        Call<serverTime> serverTimeCall = theServerTime.gettheServerTime();

        Response<serverTime> serverTimeResponse = serverTimeCall.execute();

        serverTime result = serverTimeResponse.body();

        System.out.println(result.getServerTime());

        return result.getServerTime();
    }

    public List<TradeListTrade> getAccountTradeList(String symbol1, String symbol2, int limit) throws IOException {
        String symbol = symbol1 + symbol2;

        String url = this.baseUrl + "/api/v3/myTrades/";

        HashMap<String,String> data = new HashMap<>();
        data.put("symbol",symbol);
        data.put("timestamp",String.valueOf(synchronize()));
        data.put("limit",String.valueOf(limit));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getAccountTradeList theTradeList = retrofit.create(getAccountTradeList.class);

        Call<List<TradeListTrade>> theTradeListCall = theTradeList.getAccountTradeListQuery(data,apiKey);

        Response<List<TradeListTrade>> theTradeListResponse = theTradeListCall.execute();

        List<TradeListTrade> result = theTradeListResponse.body();

        for(TradeListTrade eachTrade: result){
            System.out.println(String.format("Price : %s, Qty %s",eachTrade.getPrice(),eachTrade.getQty()));
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OrderBook getOrderBook(String symbol1, int limit) throws IOException {

        String url = this.baseUrl + "/api/v3/depth";

        String symbol = symbol1 + "USD";

        HashMap<String,String> data = new HashMap<>();

        data.put("symbol",symbol);
        data.put("limit",String.valueOf(limit));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getOrderBook theOrderBook = retrofit.create(getOrderBook.class);

        Call<OrderBook> theOrderBookCall = theOrderBook.getOrderBook(data);

        Response<OrderBook> theOrderBookResponse = theOrderBookCall.execute();

        OrderBook result = theOrderBookResponse.body();

        List<List<String>> bids = result.getBids();

        List<List<String>> asks = result.getAsks();

        ArrayList<String> bidList = new ArrayList<>();
        ArrayList<String> askList = new ArrayList<>();

        bids.stream().parallel().flatMap(Collection::stream).forEach(bidList::add);
        asks.stream().parallel().flatMap(Collection::stream).forEach(askList::add);

        int count = 1;
        for(int i = 0; i < bidList.size(); i++){
            System.out.println(String.format("Order %d : \n Bid : %s \n Ask : %s \n",count++,bidList.get(i),askList.get(i)));
        }

        return result;
    }

    public List<Trades> getRecentTrades(String symbol1, int limit) throws IOException {

        String url = this.baseUrl + "/api/v3/trades";

        String symbol = symbol1 + "USD";

        HashMap<String,String> data = new HashMap<>();

        data.put("symbol",symbol);
        data.put("limit",String.valueOf(limit));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getRecentTrades theRecentTrades = retrofit.create(getRecentTrades.class);

        Call<List<Trades>> theRecentTradesCall = theRecentTrades.getRecentTrades(data);

        Response<List<Trades>> theRecentTradesResponse = theRecentTradesCall.execute();

        List<Trades> result = theRecentTradesResponse.body();

        int count = 1;

        for(Trades eachTrade: result){
            System.out.println(String.format("Trade %d : \n Price : %s \n Quantity %s \n",count++,eachTrade.getPrice(),eachTrade.getQty()));
        }

        return result;

    }

    public long synchronize() throws IOException {
        long serverTime = getServerTime();
        long systemTime = System.currentTimeMillis() * 1000;
        long offset = systemTime - serverTime + 500;
        return systemTime - offset;
    }

    //public long getTimeStamp(){
    //    // deprecated
    //    return System.currentTimeMillis() * 1000;
    //}
    public class sellCurrency {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public Sale sellCurrencyMarketQuantity(String symbol1, double quantity) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            String url = baseUrl + "/api/v3/order";
            String side = "SELL";
            String symbol = symbol1 + "USD";
            String type = "MARKET";
            String timeStamp = String.valueOf(synchronize());

            HashMap<String,String> data = new HashMap<>();
            data.put("symbol",symbol);
            data.put("side",side);
            data.put("type",type);
            data.put("timestamp",timeStamp);

            String signature = getSignature(url,data);

            ImmutableMap<String,String> immutableMap = ImmutableMap.of("symbol",symbol,"side",side,"type",type,"timestamp",timeStamp,"signature",signature);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sellCurrencyMarketQuantity theSale = retrofit.create(sellCurrencyMarketQuantity.class);

            Call<Sale> theSaleCall = theSale.sellCurrencyMarketCall(immutableMap,apiKey);

            Response<Sale> theSaleResult = theSaleCall.execute();

            Sale result = theSaleResult.body();

            ArrayList<String> saleDetails = new ArrayList<>();

            saleDetails.add("---------- Sale Details : ----------\n");


            List<Fill> fills = result.getFills();
            int count = 1;
            for(Fill eachFill: fills){
                saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n",count++,eachFill.getPrice(),eachFill.getQty(),eachFill.getCommission(),eachFill.getCommissionAsset()));
            }
            return result;

        }
    }


    // COINBASE PRO SIGN A MESSAGE



}
