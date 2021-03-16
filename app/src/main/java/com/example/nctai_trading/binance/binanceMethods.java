package com.example.nctai_trading.binance;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import jersey.repackaged.com.google.common.collect.ImmutableMap;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*

@author - Cameron Thacker

binance API methods


 */


public class binanceMethods {

    public static String baseUrl = "https://api.binance.com";
    public static String secretKey = "mM57MtfNnRG1UrrZs6uGbKNNx1VIU7UktgwqPxelhXkI0cqjXaSCTOvXZY8vMTxj";
    public static String apiKey = "lISh9SeQdCT1HGPeo3Z6p8jWAsOJ6tmjoG7LeMsMNGCGBT0HRhfyfEvHJdjn49IG";

    public binanceMethods(){
        super();
    }

    public binanceMethods(String newApiKey, String newSecretKey){
        secretKey = newSecretKey;
        apiKey = newApiKey;
    }

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

        Call<Account> accountCall = accountInfoGet.getAccount(immutableMap,apiKey);
        try {
            System.out.println("Reached account info");
            Response<Account> responseAccount = accountCall.execute();
            Account result = responseAccount.body();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public HashMap<String,String> tempGenerateAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

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

        Call<Account> accountCall = accountInfoGet.getAccount(immutableMap,apiKey);
        try {
            System.out.println("Reached account info");
            Response<Account> responseAccount = accountCall.execute();
            Account result = responseAccount.body();
            HashMap<String,String> balanceMap = new HashMap<>();
            List<Balance> balanceList = result.getBalances();
            for(Balance eachBalance: balanceList){
                balanceMap.put(eachBalance.getAsset(),eachBalance.getFree());
            }
            String accountType = result.getAccountType();
            Integer makerCommision = result.getMakerCommission();
            System.out.println(balanceMap);
            return balanceMap;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public String displayCurrentPrice(String symbol) throws IOException {
        AveragePrice result;
        HashMap<String,String> data = new HashMap<>();
        data.put("symbol",symbol);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.binance.com/api/v3/avgPrice/").addConverterFactory(GsonConverterFactory.create()).build();

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

        String url = "https://api.binance.com/api/v3/openOrderList/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.binance.com/api/v3/openOrderList/").addConverterFactory(GsonConverterFactory.create()).build();

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

        String url = this.baseUrl + "/api/v3/depth/";

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

        String url = this.baseUrl + "/api/v3/trades/";

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

    public double getPriceOfOne(String symbol) throws IOException {
        String result = displayCurrentPrice(symbol);
        return Double.parseDouble(result.split(":")[1].trim());
    }

    public PriceTicker getPriceTicker(String symbol1, String symbol2) throws IOException {

        String url = this.baseUrl + "/api/v3/ticker/price/";
        String symbol = symbol1 + symbol2;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HashMap<String,String> data = new HashMap<>();

        data.put("symbol",symbol);

        getPriceTicker getPriceTicker = retrofit.create(com.example.nctai_trading.binance.getPriceTicker.class);

        Call<PriceTicker> priceTickerCall = getPriceTicker.getPriceTicker(data);

        Response<PriceTicker> priceTickerResponse = priceTickerCall.execute();

        PriceTicker response = priceTickerResponse.body();

        return response;
    }

    //public long getTimeStamp(){
    //    // deprecated
    //    return System.currentTimeMillis() * 1000;
    //}
    public class sellCurrency {

        public sellCurrency(){
            super();
        }

        public sellCurrency(String newApiKey, String newSecretKey){
            apiKey = newApiKey;
            secretKey = newSecretKey;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> sellCurrencyMarketQuantity(String symbol1, double quantity) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order/";
                String side = "SELL";
                String symbol = symbol1 + "USD";
                String type = "MARKET";
                String timeStamp = String.valueOf(synchronize());

                HashMap<String, String> data = new HashMap<>();
                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("timestamp", timeStamp);

                String signature = getSignature(url, data);

                ImmutableMap<String, String> immutableMap = ImmutableMap.of("symbol", symbol, "side", side, "type", type, "timestamp", timeStamp, "signature", signature);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                sellCurrencyMarketQuantity theSale = retrofit.create(sellCurrencyMarketQuantity.class);

                Call<Sale> theSaleCall = theSale.sellCurrencyMarketCall(immutableMap, apiKey);

                Response<Sale> theSaleResult = theSaleCall.execute();

                Sale result = theSaleResult.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                saleDetails.add("---------- Sale Details : ----------\n");


                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }

        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> sellCurrencyMarketQuoteOrderQuantity(String symbol1, double quoteOrderQuantity1) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order/";
                String symbol = symbol1 + "USD";
                String side = "SELL";
                String type = "MARKET";
                double quoteOrderQuantity = quoteOrderQuantity1;
                String timeStamp = String.valueOf(synchronize());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                HashMap<String, String> data = new HashMap<>();

                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("quoteOrderQty", String.valueOf(quoteOrderQuantity));
                data.put("timestamp", timeStamp);
                String signature = getSignature(url, data);
                data.put("signature", signature);

                sellCurrencyMarketQuantity sellCurrencyMarketQuoteOrder = retrofit.create(sellCurrencyMarketQuantity.class);

                Call<Sale> theSale = sellCurrencyMarketQuoteOrder.sellCurrencyMarketCall(data, apiKey);

                Response<Sale> theSaleResult = theSale.execute();

                Sale result = theSaleResult.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> baseSale(String symbol1, long quantity) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                sellCurrencyMarketQuantity sellCurrency = retrofit.create(sellCurrencyMarketQuantity.class);

                String symbol = symbol1;
                String side = "SELL";
                String type = "MARKET";
                String timestamp = String.valueOf(synchronize());

                HashMap<String, String> data = new HashMap<>();

                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("quantity",String.valueOf(quantity));
                data.put("timestamp", timestamp);

                String signature = getSignature(url, data);

                data.put("signature", signature);

                Call<Sale> getSale = sellCurrency.sellCurrencyMarketCall(data, apiKey);

                Response<Sale> theSale = getSale.execute();

                Sale result = theSale.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }


        }
    }

    public class buyCurrency{

        public buyCurrency(){
            super();
        }

        public buyCurrency(String newApiKey, String newSecretKey){
            apiKey = newApiKey;
            secretKey = newSecretKey;
        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> buyCurrencyMarketQuantity(String symbol1, double quantity) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order/";
                String side = "BUY";
                String symbol = symbol1 + "USD";
                String type = "MARKET";
                String timeStamp = String.valueOf(synchronize());

                HashMap<String, String> data = new HashMap<>();
                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("quantity",String.valueOf((long)quantity));
                data.put("timestamp", timeStamp);

                String signature = getSignature(url, data);

                ImmutableMap<String, String> immutableMap = ImmutableMap.of("symbol", symbol, "side", side, "type", type, "timestamp", timeStamp, "signature", signature);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                sellCurrencyMarketQuantity theSale = retrofit.create(sellCurrencyMarketQuantity.class);

                Call<Sale> theSaleCall = theSale.sellCurrencyMarketCall(immutableMap, apiKey);

                Response<Sale> theSaleResult = theSaleCall.execute();

                Sale result = theSaleResult.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                saleDetails.add("---------- Sale Details : ----------\n");


                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }

        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> buyCurrencyMarketQuoteOrderQuantity(String symbol1, double quoteOrderQuantity1) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order/";
                String symbol = symbol1 + "USD";
                String side = "BUY";
                String type = "MARKET";
                double quoteOrderQuantity = quoteOrderQuantity1;
                String timeStamp = String.valueOf(synchronize());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                HashMap<String, String> data = new HashMap<>();

                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("quoteOrderQty", String.valueOf(quoteOrderQuantity));
                data.put("timestamp", timeStamp);
                String signature = getSignature(url, data);
                data.put("signature", signature);

                sellCurrencyMarketQuantity sellCurrencyMarketQuoteOrder = retrofit.create(sellCurrencyMarketQuantity.class);

                Call<Sale> theSale = sellCurrencyMarketQuoteOrder.sellCurrencyMarketCall(data, apiKey);

                Response<Sale> theSaleResult = theSale.execute();

                Sale result = theSaleResult.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public ArrayList<String> baseBuy(String symbol1, long quantity) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
            try {
                String url = baseUrl + "/api/v3/order/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                sellCurrencyMarketQuantity sellCurrency = retrofit.create(sellCurrencyMarketQuantity.class);

                String symbol = symbol1;
                String side = "BUY";
                String type = "MARKET";
                String timestamp = String.valueOf(synchronize());

                HashMap<String, String> data = new HashMap<>();

                data.put("symbol", symbol);
                data.put("side", side);
                data.put("type", type);
                data.put("quantity",String.valueOf(quantity));
                data.put("timestamp", timestamp);

                String signature = getSignature(url, data);

                data.put("signature", signature);

                Call<Sale> getSale = sellCurrency.sellCurrencyMarketCall(data, apiKey);

                Response<Sale> theSale = getSale.execute();

                System.out.println(theSale.errorBody());

                Sale result = theSale.body();

                ArrayList<String> saleDetails = new ArrayList<>();

                List<Fill> fills = result.getFills();
                int count = 1;
                for (Fill eachFill : fills) {
                    saleDetails.add(String.format("-------SALE %d-------\n ---> Price : %s \n---> Quantity : %s\n---> Commission : %s\n---> Commission Asset %s\n\n", count++, eachFill.getPrice(), eachFill.getQty(), eachFill.getCommission(), eachFill.getCommissionAsset()));
                }
                return saleDetails;
            }
            catch(Exception e){
                return new ArrayList<String>();
            }


        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public binanceLimitOrder buyLimitOrder(String symbol1, long quantity1, String price1) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sellCurrencyMarketQuantity sellCurrencyMarketQuantity = retrofit.create(com.example.nctai_trading.binance.sellCurrencyMarketQuantity.class);

            String symbol = symbol1;
            String side = "BUY";
            String type = "LIMIT";
            String timeInForce = "GTC";
            long quantity = quantity1;
            String price = price1;
            String timestamp = synchronize() + "";

            HashMap<String,String> data = new LinkedHashMap<>();
            data.put("symbol",symbol);
            data.put("side",side);
            data.put("type",type);
            data.put("timeInForce",timeInForce);
            data.put("quantity",quantity + "");
            data.put("price",price + "");
            data.put("timestamp",timestamp);

            String signature = getSignature(url,data);

            data.put("signature",signature);

            Call<binanceLimitOrder> call = sellCurrencyMarketQuantity.placeLimitOrder(data,apiKey);

            Response<binanceLimitOrder> response = call.execute();

            return response.body();

        }

    }

    public class tradeRequests{

        public tradeRequests(){
            super();
        }

        public tradeRequests(String newApi, String newSecret){
            apiKey = newApi;
            secretKey = newSecret;
        }

        public List<binanceHistoricalTrade> getHistoricalTrades(String symbol) throws IOException {

            String url = baseUrl + "/api/v3/historicalTrades/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            Call<List<binanceHistoricalTrade>> getHistoricalTradeList = binanceTradesInterface.getHistoricalTrades(data,apiKey);

            Response<List<binanceHistoricalTrade>> historicalTradeList = getHistoricalTradeList.execute();

            List<binanceHistoricalTrade> result = historicalTradeList.body();

            return result;
        }

        public List<binanceAggTrade> getAggTrades(String symbol) throws IOException {

            String url = baseUrl + "/api/v3/aggTrades/";

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            Call<List<binanceAggTrade>> binanceAggTradeCall = binanceTradesInterface.getAggTrades(data,apiKey);

            Response<List<binanceAggTrade>> binanceAggTradeResponse = binanceAggTradeCall.execute();

            List<binanceAggTrade> binanceAggTradeList = binanceAggTradeResponse.body();

            return binanceAggTradeList;


        }

        public binanceAveragePrice getAveragePrice(String symbol) throws IOException {

            String url = baseUrl + "/api/v3/avgPrice/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            Call<binanceAveragePrice> getAvgPrice = binanceTradesInterface.getAvgPrice(data,apiKey);

            Response<binanceAveragePrice> averagePriceResponse = getAvgPrice.execute();

            binanceAveragePrice theAvgPrice = averagePriceResponse.body();

            return theAvgPrice;

        }

        public List<binance24HourChange> get24HourPriceChangeWithoutSymbol() throws IOException {

            String url = baseUrl + "/api/v3/ticker/24hr/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            Call<List<binance24HourChange>> binance24HourChangeCall = binanceTradesInterface.get24HourChangeNoSymbol(apiKey);

            Response<List<binance24HourChange>> binance24HourChangeResponse = binance24HourChangeCall.execute();

            List<binance24HourChange> changes24Hour = binance24HourChangeResponse.body();

            return changes24Hour;


        }

        public binance24HourChange get24HourPriceChangeWithSymbol(String symbol) throws IOException {

            String url = baseUrl + "/api/v3/ticker/24hr/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            Call<binance24HourChange> binance24HourChangeCall = binanceTradesInterface.get24HourChangeSymbol(data,apiKey);

            Response<binance24HourChange> binance24HourChangeResponse = binance24HourChangeCall.execute();

            binance24HourChange result = binance24HourChangeResponse.body();

            return result;

        }

        public List<binanceBookTicker> getBookTickerNoSymbol() throws IOException {

            String url = baseUrl + "/api/v3/ticker/bookTicker/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            Call<List<binanceBookTicker>> tickersCall = binanceTradesInterface.getBookTickerNoSymbol(apiKey);

            Response<List<binanceBookTicker>> binanceBookTickerResponse = tickersCall.execute();

            List<binanceBookTicker> result = binanceBookTickerResponse.body();

            return result;

        }

        public binanceBookTicker getBookTickerSymbol(String symbol) throws IOException {

            String url = baseUrl + "/api/v3/ticker/bookTicker/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceTradesInterface binanceTradesInterface = retrofit.create(com.example.nctai_trading.binance.binanceTradesInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            Call<binanceBookTicker> binanceBookTickerCall = binanceTradesInterface.getBookTickerSymbol(data,apiKey);

            Response<binanceBookTicker> binanceBookTickerRepsonse = binanceBookTickerCall.execute();

            binanceBookTicker result = binanceBookTickerRepsonse.body();

            return result;

        }

    }

    public class cancelRequests{

        public cancelRequests(){
            super();
        }

        public cancelRequests(String newApi, String newSecret){
            apiKey = newApi;
            secretKey = newSecret;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public binanceCancelOrder cancelOrder(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> data = new HashMap<>();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            data.put("symbol",symbol);
            data.put("timestamp",String.valueOf(synchronize()));

            String signature = getSignature(url,data);

            data.put("signature",signature);

            Call<binanceCancelOrder> binanceCancelOrderCall = binanceOrdersInterface.cancelOrder(data,apiKey);

            Response<binanceCancelOrder> cancelOrderResponse = binanceCancelOrderCall.execute();

            binanceCancelOrder result = cancelOrderResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public boolean canelAllOrdersWithSymbol(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/openOrders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);
            data.put("timestamp",String.valueOf(synchronize()));
            data.put("signature",getSignature(url,data));

            Response cancelAllBinanceOrdersWithSymbol = binanceOrdersInterface.cancelAllOrdersSymbol(data,apiKey);

            return cancelAllBinanceOrdersWithSymbol.errorBody() != null;

        }

    }

    public class orderRequests{

        public orderRequests(){
            super();
        }

        public orderRequests(String newApiKey, String newSecretKey){
            apiKey = newApiKey;
            secretKey = newSecretKey;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<binanceOrderListOrder> getAllOpenOrdersNoSymbol() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/openOrders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<List<binanceOrderListOrder>> getAllOpenOrders = binanceOrdersInterface.getAllOpenOrdersNoSymbol(data,apiKey);

            Response<List<binanceOrderListOrder>> binanceOpenOrdersListResponse = getAllOpenOrders.execute();

            List<binanceOrderListOrder> listOfOpenOrders = binanceOpenOrdersListResponse.body();

            return listOfOpenOrders;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<binanceOrderListOrder> getAllOpenOrdersSymbol(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/openOrders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<List<binanceOrderListOrder>> getOpenOrders = binanceOrdersInterface.getAllOpenOrdersSymbol(data,apiKey);

            Response<List<binanceOrderListOrder>> binanceOpenOrdersResponse = getOpenOrders.execute();

            List<binanceOrderListOrder> openOrderList = binanceOpenOrdersResponse.body();

            return openOrderList;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<binanceOrderListOrder> getAllAccountOrders(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/allOrders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);

            data.put("timestamp",synchronize() + "");

            data.put("signature",getSignature(url,data));

            Call<List<binanceOrderListOrder>> allAcctOrdersList = binanceOrdersInterface.getAllOpenOrdersAcct(data,apiKey);

            Response<List<binanceOrderListOrder>> allAcctOrdersResponse = allAcctOrdersList.execute();

            List<binanceOrderListOrder> allAcctOrders = allAcctOrdersResponse.body();

            return allAcctOrders;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public binanceOCOTrade newOCOTrade(String symbol, String side, double quantity, double price, double stopPrice) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/order/oco/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);
            data.put("side",side);
            data.put("quantity",quantity + "");
            data.put("price",price + "");
            data.put("stopPrice",stopPrice + "");
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<binanceOCOTrade> makeOCOTrade = binanceOrdersInterface.createOCOTrade(data,apiKey);

            Response<binanceOCOTrade> ocoTradeResponse = makeOCOTrade.execute();

            binanceOCOTrade trade = ocoTradeResponse.body();

            return trade;


        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public binanceOCOTrade cancelOCOTradeOrderListID(String symbol, String id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/orderList/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();

            data.put("symbol",symbol);
            data.put("orderListId",id);
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<binanceOCOTrade> cancelOCOTrade = binanceOrdersInterface.cancelOCOTradeOrderListId(data,apiKey);

            Response<binanceOCOTrade> cancelledOCOTrade = cancelOCOTrade.execute();

            binanceOCOTrade cancelResult = cancelledOCOTrade.body();

            return cancelResult;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public binanceSpecificOCO cancelSpecificOCOListID(String orderListID) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/orderList/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();
            data.put("orderListId",orderListID);
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<binanceSpecificOCO> cancelSpecificOCO = binanceOrdersInterface.cancelSpecificOCOTradeOrder(data,apiKey);

            Response<binanceSpecificOCO> binanceSpecificOCOResponse = cancelSpecificOCO.execute();

            binanceSpecificOCO result = binanceSpecificOCOResponse.body();

            return result;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<binanceSpecificOCO> cancelAllSpecificOCO() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/allOrderList/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HashMap<String,String> data = new HashMap<>();
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            Call<List<binanceSpecificOCO>> binanceOrdersCall = binanceOrdersInterface.cancelAllSpecificOCO(data,apiKey);

            Response<List<binanceSpecificOCO>> binanceOrdersResponse = binanceOrdersCall.execute();

            List<binanceSpecificOCO> binanceSpecificOCOList = binanceOrdersResponse.body();

            return binanceSpecificOCOList;


        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<binanceSpecificOCO> openAllOpenOCO() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = baseUrl + "/api/v3/openOrderList";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            binanceOrdersInterface binanceOrdersInterface = retrofit.create(com.example.nctai_trading.binance.binanceOrdersInterface.class);

            HashMap<String,String> data = new HashMap<>();
            data.put("timestamp",synchronize() + "");
            data.put("signature",getSignature(url,data));

            Call<List<binanceSpecificOCO>> binanceSpecificOCOList = binanceOrdersInterface.getAllOpenOCO(data,apiKey);

            Response<List<binanceSpecificOCO>> binanceSpecificOcoResponse = binanceSpecificOCOList.execute();

            List<binanceSpecificOCO> result = binanceSpecificOcoResponse.body();

            return result;

        }


    }



    // COINBASE PRO SIGN A MESSAGE



}
