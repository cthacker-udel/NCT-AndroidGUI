package com.example.nctai_trading.binance.Client;

import com.example.nctai_trading.binance.ClientModel.Account;
import com.example.nctai_trading.binance.Controller.GeneralEndpointAPI.ExchangeInfo.ExchangeInfoRoot;
import com.example.nctai_trading.binance.Controller.GeneralEndpointAPI.ServerTime;
import com.example.nctai_trading.binance.InterfaceModel.*;
import com.example.nctai_trading.binance.Controller.MarketAPI.*;
import com.example.nctai_trading.binance.Controller.AccountAPI.*;
import com.example.nctai_trading.binance.Controller.AccountAPI.OpenOCO.*;
import com.example.nctai_trading.binance.Controller.AccountAPI.OCO.*;
import com.example.nctai_trading.binance.Controller.AccountAPI.AccountInfo.*;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.nctai_trading.binance.InterfaceModel.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

public class BinanceRestAPI {

    public static String baseUrl = "https://api.binance.com/";


    /*
     *
     * General Endpoint API Methods
     *
     */


    /**
     *
     * Tests the connectivity to the server from the Client side
     *
     * @param client - BinanceClient instance
     * @return boolean - If BinanceClient instance is able to connect to server
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public boolean testConnectivity(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ping/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.generalInterface.class);

        Call<Void> testConnectivityCall = generalInterface.testConnectivity();

        Response<Void> testConnectivityResponse = testConnectivityCall.execute();

        return testConnectivityResponse.isSuccessful();

    }

    /**
     *
     * Gets Server Time using BinanceClient instance given
     * @param client - BinanceClient instance
     * @return Long - Server Time
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public Long getServerTime(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/time/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.generalInterface.class);

        Call<ServerTime> call = generalInterface.getServerTime();

        Response<ServerTime> response = call.execute();

        assert response.body() != null;
        return response.body().getServerTime();

    }


    /**
     *
     * Gets the current exchange trading rules and symbol information
     * @param client - BinanceClient instance
     * @return ExchangeInfoRoot instance
     * @throws IOException - IOException if Retrofit is unable to execute GET Request
     */

    public ExchangeInfoRoot getExchangeInformation(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/exchangeInfo/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        generalInterface generalInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.generalInterface.class);

        Call<ExchangeInfoRoot> call = generalInterface.getExchangeInformation();

        Response<ExchangeInfoRoot> response = call.execute();

        return response.body();

    }

    //#########################
    //# MARKET DATA API
    //########################

    public OrderBook getOrderBook(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/depth/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<OrderBook> call = marketInterface.getOrderBook(client.getMarket().generateQueries());

        Response<OrderBook> response = call.execute();

        return response.body();

    }

    public List<RecentTrade> getRecentTrades(BinanceClient client) throws IOException{

        String url = baseUrl + "/api/v3/trades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<RecentTrade>> call = marketInterface.getRecentTrade(client.getMarket().generateQueries());

        Response<List<RecentTrade>> response = call.execute();

        return response.body();

    }

    public List<RecentTrade> oldTradeLookup(BinanceClient client) throws IOException{

        String url = baseUrl + "/api/v3/historicalTrades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<RecentTrade>> call = marketInterface.getOldTrade(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<RecentTrade>> response = call.execute();

        return response.body();

    }

    public List<AggOrCompressedTrade> getAggregateOrCompressedTrades(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/aggTrades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<AggOrCompressedTrade>> call = marketInterface.getAggOrCompressedTrades(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<AggOrCompressedTrade>> response = call.execute();

        return response.body();

    }

    public List<List<Integer>> getKlineData(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/klines/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<List<Integer>>> call = marketInterface.getKlineData(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<List<Integer>>> response = call.execute();

        return response.body();

    }

    public AvgPrice getCurrentAveragePrice(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/avgPrice/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<AvgPrice> call = marketInterface.getAveragePrice(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<AvgPrice> response = call.execute();

        return response.body();

    }

    public TwentyFourPriceChange getTwentyFourPriceChange(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ticker/24hr/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<TwentyFourPriceChange> call = marketInterface.getTwentyFourHourChange(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<TwentyFourPriceChange> response = call.execute();

        return response.body();

    }

    public List<PriceTicker> getPriceTicker(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ticker/price/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<PriceTicker>> call = marketInterface.getPriceTicker(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<PriceTicker>> response = call.execute();

        return response.body();

    }

    public List<OrderBookTicker> getOrderBookPrice(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/ticker/bookTicker/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.marketInterface.class);

        Call<List<OrderBookTicker>> call = marketInterface.getOrderBookPrice(client.getClientKeys().getApiKey(),client.getMarket().generateQueries());

        Response<List<OrderBookTicker>> response = call.execute();

        return response.body();

    }

    /*

    ACCOUNT API

     */

    public NewOrder placeNewOrder(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/order/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();
        HashMap<String,Object> queries = binanceAccount.generateQueries();
        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<NewOrder> call = accountInterface.placeNewOrder(client.getClientKeys().getApiKey(),queries);

        Response<NewOrder> response = call.execute();

        return response.body();

    }


    public boolean testNewOrder(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/order/test/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();
        HashMap<String,Object> queries = binanceAccount.generateQueries();
        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<Void> call = accountInterface.testNewOrder(client.getClientKeys().getApiKey(),queries);

        Response<Void> response = call.execute();

        return response.isSuccessful();

    }

    public QueryOrder queryOrder(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/order/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<QueryOrder> call = accountInterface.queryOrder(client.getClientKeys().getApiKey(),queries);

        Response<QueryOrder> response = call.execute();

        return response.body();

    }

    public void cancelOrder(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/order/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<CancelOrder> call = accountInterface.cancelOrder(client.getClientKeys().getApiKey(),queries);

    }

    public List<CancelOrder> cancelAllOpenOrdersOnSymbol(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/openOrders/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<List<CancelOrder>> call = accountInterface.cancelAllActiveOrdersOnSymbol(client.getClientKeys().getApiKey(),queries);

        Response<List<CancelOrder>> response = call.execute();

        return response.body();

    }

    public List<OpenOrder> getCurrentOpenOrders(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/openOrders/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<List<OpenOrder>> call = accountInterface.getCurrentOpenOrders(client.getClientKeys().getApiKey(),queries);

        Response<List<OpenOrder>> response = call.execute();

        return response.body();

    }

    public List<Order> getListOfAllOrders(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/allOrders/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<List<Order>> call = accountInterface.getAllOrders(client.getClientKeys().getApiKey(),queries);

        Response<List<Order>> response = call.execute();

        return response.body();

    }

    public OCOTrade newOCOTrade(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/order/oco/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<OCOTrade> call = accountInterface.placeNewOCO(client.getClientKeys().getApiKey(),queries);

        Response<OCOTrade> response = call.execute();

        return response.body();

    }

    public OCOTrade cancelOCO(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/orderList/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<OCOTrade> call = accountInterface.cancelOCO(client.getClientKeys().getApiKey(),queries);

        Response<OCOTrade> response = call.execute();

        return response.body();
    }

    public OCOTrade queryOCO(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/orderList/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<OCOTrade> call = accountInterface.queryOCO(client.getClientKeys().getApiKey(),queries);

        Response<OCOTrade> response = call.execute();

        return response.body();

    }

    public List<OCOTrade> queryAllOCO(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/allOrderList/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);
        queries.put("signature",client.generateSignature(queries));

        Call<List<OCOTrade>> call = accountInterface.queryAllOCO(client.getClientKeys().getApiKey(),queries);

        Response<List<OCOTrade>> response = call.execute();

        return response.body();

    }

    public List<OpenOCO> queryOpenOCO(BinanceClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/api/v3/openOrderList/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);

        queries.put("signature",client.generateSignature(queries));

        Call<List<OpenOCO>> call = accountInterface.queryOpenOCO(client.getClientKeys().getApiKey(),queries);

        Response<List<OpenOCO>> response = call.execute();

        return response.body();

    }

    public AccountInfo getAccountInformation(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/account/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);

        Call<AccountInfo> call = accountInterface.getAccountInformation(client.getClientKeys().getApiKey(),queries);

        Response<AccountInfo> response = call.execute();

        return response.body();

    }

    public AccountInfo getAccountTradeList(BinanceClient client) throws IOException {

        String url = baseUrl + "/api/v3/myTrades/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.binance.InterfaceModel.accountInterface.class);

        Account binanceAccount = client.getAccount();

        HashMap<String,Object> queries = binanceAccount.generateQueries();

        queries.put("timestamp",(System.currentTimeMillis() * 1000) - client.getServerTime(client) + 500);

        Call<AccountInfo> call = accountInterface.getAccountInformation(client.getClientKeys().getApiKey(),queries);

        Response<AccountInfo> response = call.execute();

        return response.body();

    }











}
