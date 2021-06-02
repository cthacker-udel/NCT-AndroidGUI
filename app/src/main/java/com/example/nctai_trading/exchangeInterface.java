package com.example.nctai_trading;

import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.alpaca.NonTradeActivity;
import com.example.nctai_trading.alpaca.alpacaAsset;
import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexAccountDepositWithdrawHistory;
import com.example.nctai_trading.basefex.basefexGetAccountCashAndPositionDetail;
import com.example.nctai_trading.basefex.basefexGetAccountCashAndPositionDetailCash;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.basefex.basefexOrderListOrder;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;
import com.example.nctai_trading.bibox.CQueryOrderListParams;
import com.example.nctai_trading.bibox.CTypeEnum;
import com.example.nctai_trading.bidesk.BrokerApiClientFactory;
import com.example.nctai_trading.bidesk.BrokerApiRestClient;
import com.example.nctai_trading.bidesk.domain.account.AssetBalance;
import com.example.nctai_trading.bidesk.domain.account.DepositOrder;
import com.example.nctai_trading.bidesk.domain.account.request.DepositOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.HistoryOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.OpenOrderRequest;
import com.example.nctai_trading.bilaxy.bilaxyAccount;
import com.example.nctai_trading.bilaxy.bilaxyAccountData;
import com.example.nctai_trading.bilaxy.bilaxyMethods;
import com.example.nctai_trading.binance.Client.BinanceClient;
import com.example.nctai_trading.binance.Controller.AccountAPI.AccountInfo.AccountBalance;
import com.example.nctai_trading.binance.Controller.AccountAPI.AccountInfo.AccountInfo;
import com.example.nctai_trading.bitMEX.bitmexMethods;
import com.example.nctai_trading.bitMEX.userWalletHistory;
import com.example.nctai_trading.bitcoincom.bitcoincomMethods;
import com.example.nctai_trading.bitforex.AccountAsset.AccountAssets;
import com.example.nctai_trading.bitforex.AccountAsset.Datum;
import com.example.nctai_trading.bitforex.bitforexMethods;
import com.example.nctai_trading.bithumb.bithumbMethods;
import com.example.nctai_trading.bithumb.bithumbVirtualCoinAsset;
import com.example.nctai_trading.bithumb.bithumbVirtualCoinAssetData;
import com.example.nctai_trading.bithumb.bithumbWithdrawResponse;
import com.example.nctai_trading.bithumb.bithumbWithdrawResponseData;
import com.example.nctai_trading.bithumb.bithumbmyTrades;
import com.example.nctai_trading.bitrue.accountTradeList.accountTrade;
import com.example.nctai_trading.bitrue.bitrueMethods;
import com.example.nctai_trading.bittrex.ApiKeySecret;
import com.example.nctai_trading.bittrex.BittrexExchange;
import com.example.nctai_trading.bittrexV2.BittrexClient;
import com.example.nctai_trading.bittrexV2.Controller.accountBalances.accountBalance;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.Result;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.accountOrder;
import com.example.nctai_trading.bkex.account.DepositRecord.depositRecord;
import com.example.nctai_trading.bkex.account.WalletBalance.walletBalance;
import com.example.nctai_trading.bkex.account.WithdrawRecord.withdrawRecord;
import com.example.nctai_trading.bkex.bkexMethods;
import com.example.nctai_trading.btse.btseMethods;
import com.example.nctai_trading.btse.walletHistory;
import com.example.nctai_trading.bybit.bybitMethods;
import com.example.nctai_trading.bybit.walletFunds.walletFund;
import com.example.nctai_trading.coinbasePro.coinbaseProDeposit;
import com.example.nctai_trading.coinbasePro.coinbaseProMethods;
import com.example.nctai_trading.coinbasePro.coinbaseProWithdrawl;
import com.example.nctai_trading.digifinex.digifinexMethods;
import com.example.nctai_trading.exante.exanteMethods;
import com.example.nctai_trading.huobi.Client.HuobiClient;
import com.example.nctai_trading.idcm.idcmMethods;
import com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods;
import com.example.nctai_trading.kiteConnect.KiteConnect;
import com.example.nctai_trading.kiteConnect.KiteException;
import com.example.nctai_trading.kraken.KrakenApi;
import com.example.nctai_trading.wbf.wbfMethods;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.apache.http.HttpException;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.spongycastle.asn1.cms.KeyAgreeRecipientIdentifier;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.O)
public class exchangeInterface {

    /*

    Getting shared preferences

     */

    com.example.nctai_trading.mainPage mainPage = new mainPage();

    SharedPreferences sharedPreferences = mainPage.getThePreferences();

    /*

    Initializing currency info list

     */

    currencyInfo currencyInfo = new currencyInfo();
    Collection<String> currencySymbols = currencyInfo.currList.values();

    /*

    Set global gson variable

     */

    Gson gson = new Gson();

    /*

    Creating global MongoClient connection to database

     */

    MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);

    /*

    Create global BasicDbObject

     */

    BasicDBObject basicDBObject = new BasicDBObject();

    BasicDBObject eachOrderObj = new BasicDBObject();

    BasicDBObject accountHoldingsObj = new BasicDBObject();

    BasicDBObject depositsObj = new BasicDBObject();

    BasicDBObject withdrawlsObj = new BasicDBObject();

    /*

    Initializing userId, _id variables, and orderNumber variables

     */

    String _idStr = sharedPreferences.getString("Mongo_ID","");

    ObjectId _id = gson.fromJson(_idStr,ObjectId.class);

    String userIdStr = sharedPreferences.getString("MongoUserId","");

    ObjectId userId = gson.fromJson(userIdStr,ObjectId.class);

    int orderNumber = 0;

    /*

    List of all clients

     */

    com.example.nctai_trading.alpaca.alpacaMethods alpacaMethods = new alpacaMethods(sharedPreferences.getString("alpacaApiKey",""),sharedPreferences.getString("alpacaSecretKey",""));

    com.example.nctai_trading.basefex.basefexMethods basefexMethods = new basefexMethods(sharedPreferences.getString("basefexApiKey",""),sharedPreferences.getString("basefexSecretKey",""));

    BiBoxHttpClient biBoxHttpClient = new BiBoxHttpClient(new BiBoxHttpClientConfig.Builder().apiKey(sharedPreferences.getString("biboxApikey","")).secret(sharedPreferences.getString("biboxSecretKey","")).build());

    BrokerApiRestClient bideskClient = new BrokerApiClientFactory("https://api.bidesk.com/",sharedPreferences.getString("bideskApiKey",""),sharedPreferences.getString("bideskApiKey","")).newRestClient();

    com.example.nctai_trading.bilaxy.bilaxyMethods bilaxyMethods = new bilaxyMethods(sharedPreferences.getString("bilaxyApiKey",""),sharedPreferences.getString("bilaxyApiKey",""));

    com.example.nctai_trading.binance.Client.BinanceClient binanceMethods = new BinanceClient(sharedPreferences.getString("binanceApiKey",""),sharedPreferences.getString("binanceSecretKey",""));

    com.example.nctai_trading.binanceUS.Client.BinanceClient binanceUSMethods = new com.example.nctai_trading.binanceUS.Client.BinanceClient(sharedPreferences.getString("binanceUSApiKey",""),sharedPreferences.getString("binanceUSSecretKey",""));

    com.example.nctai_trading.bitcoincom.bitcoincomMethods bitcoincomMethods = new bitcoincomMethods(sharedPreferences.getString("bitcoincomApiKey",""),sharedPreferences.getString("bitcoincomApiKey",""));

    com.example.nctai_trading.bitforex.bitforexMethods bitforexMethods = new bitforexMethods(sharedPreferences.getString("bitforexApiKey",""),sharedPreferences.getString("bitforexApiKey",""));

    com.example.nctai_trading.bithumb.bithumbMethods bithumbMethods = new bithumbMethods(sharedPreferences.getString("bithumbApiKey",""),sharedPreferences.getString("bithumbApiKey",""));

    com.example.nctai_trading.bitMEX.bitmexMethods bitmexMethods = new bitmexMethods(sharedPreferences.getString("bitMEXApiKey",""),sharedPreferences.getString("bitMEXApiKey",""));

    com.example.nctai_trading.bitrue.bitrueMethods bitrueMethods = new bitrueMethods(sharedPreferences.getString("bitrueApiKey",""),sharedPreferences.getString("bitrueSecretKey",""));

    com.example.nctai_trading.bittrexV2.BittrexClient bittrexMethods = new BittrexClient(sharedPreferences.getString("bittrexApiKey",""),sharedPreferences.getString("bittrexSecretKey",""));

    com.example.nctai_trading.bkex.bkexMethods bkexMethods = new bkexMethods(sharedPreferences.getString("bkexApiKey",""),sharedPreferences.getString("bkexSecretKey",""));

    com.example.nctai_trading.btse.btseMethods btseMethods = new btseMethods(sharedPreferences.getString("btseApiKey",""),sharedPreferences.getString("btseSecretKey",""));

    com.example.nctai_trading.bybit.bybitMethods bybitMethods = new bybitMethods(sharedPreferences.getString("bybitApiKey",""),sharedPreferences.getString("bybitApiKey",""));

    com.example.nctai_trading.coinbasePro.coinbaseProMethods coinbaseProMethods = new coinbaseProMethods(sharedPreferences.getString("coinbaseApiKey",""),sharedPreferences.getString("coinbaseSecretKey",""),sharedPreferences.getString("coinbasePassphrase",""));

    com.example.nctai_trading.digifinex.digifinexMethods digifinexMethods = new digifinexMethods(sharedPreferences.getString("digifinexApiKey",""),sharedPreferences.getString("digifinexSecretKey",""));

    //com.example.nctai_trading.exante.exanteMethods exanteMethods = new exanteMethods(sharedPreferences.getString("exanteApiKey",""),sharedPreferences.getString("exanteSecretKey",""));

    com.example.nctai_trading.huobi.Client.HuobiClient huobiClient = new HuobiClient(sharedPreferences.getString("huobiApiKey",""),sharedPreferences.getString("huobiSecretKey",""));

    com.example.nctai_trading.idcm.idcmMethods idcmMethods = new idcmMethods(sharedPreferences.getString("idcmApiKey",""),sharedPreferences.getString("idcmSecretKey",""));

    //com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods()

    /*

    user needs to login to gain access to tokens to make trades

     */

    com.example.nctai_trading.kiteConnect.KiteConnect kiteConnect = new KiteConnect(sharedPreferences.getString("kiteApiKey",""));

    com.example.nctai_trading.kraken.KrakenApi krakenApi = new KrakenApi();

    public void setKrakenApi(){
        krakenApi.setKey(sharedPreferences.getString("krakenApiKey",""));
        krakenApi.setSecret(sharedPreferences.getString("krakenSecretKey",""));
    }

    com.example.nctai_trading.wbf.wbfMethods wbfMethods = new wbfMethods(sharedPreferences.getString("wbfApiKey",""),sharedPreferences.getString("wbfSecretKey",""));

    String dataReceived = "";

    public String getDataReceived() {
        return dataReceived;
    }

    public void setDataReceived(String dataReceived) {
        this.dataReceived = dataReceived;
    }

    public void resetDBObjects(){
        basicDBObject = new BasicDBObject();
        basicDBObject.append("_id",_id);
        basicDBObject.append("userID",userId);
        eachOrderObj = new BasicDBObject();
        accountHoldingsObj = new BasicDBObject();
        depositsObj = new BasicDBObject();
        withdrawlsObj = new BasicDBObject();
        orderNumber = 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void collectPastOrders() throws IOException, InvalidKeyException, NoSuchAlgorithmException, HttpException, KiteException, JSONException {

        MongoDatabase pastOrders = mongoClient.getDatabase("test");

        MongoCollection<Document> pastOrderCollection = pastOrders.getCollection("pastOrders");

        ArrayList<List<Object>> orders = new ArrayList<>();

        /*

        alpaca

         */

        com.example.nctai_trading.alpaca.alpacaMethods.orderRequests aorderRequests = alpacaMethods.new orderRequests();
        List<com.example.nctai_trading.alpaca.alpacaOrderListOrder> alpacaOrders = aorderRequests.getListOfOrders("closed");
        resetDBObjects();
        basicDBObject.append("exchange","alpaca");
        if(alpacaOrders.size() > 0){
            for(com.example.nctai_trading.alpaca.alpacaOrderListOrder eachOrder : alpacaOrders){
                if(eachOrder.getStatus().equalsIgnoreCase("closed")) {
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("clientOrderId", eachOrder.getClientOrderId()),
                            new Document("symbol", eachOrder.getSymbol()),
                            new Document("updateTime", eachOrder.getTimeInForce()),
                            new Document("origQty", eachOrder.getQty()),
                            new Document("origQuoteOrderQty", eachOrder.getFilledQty()),
                            new Document("executedQty", eachOrder.getFilledQty()),
                            new Document("side", eachOrder.getSide()),
                            new Document("price", eachOrder.getStopPrice()),
                            new Document("time", eachOrder.getCreatedAt()),
                            new Document("orderId", eachOrder.getId()),
                            new Document("status", eachOrder.getStatus()),
                            new Document("stopPrice",eachOrder.getStopPrice())
                    });
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        basefex

         */

        com.example.nctai_trading.basefex.basefexMethods.ordersRequests bordersRequests = basefexMethods.new ordersRequests();
        List<basefexOrderListOrder> basefexOrderList = bordersRequests.getOrderList("FILLED");
        basicDBObject.append("exchange","basefex");
        for(basefexOrderListOrder eachOrder : basefexOrderList){
            if(eachOrder.getStatus().equals("FILLED")){
                eachOrderObj.append("" + orderNumber++,new Object[]{
                        new Document("clientOrderId",eachOrder.getId()),
                        new Document("symbol",eachOrder.getSymbol()),
                        new Document("origQty",eachOrder.getSize()),
                        new Document("origQuoteOrderQty",eachOrder.getSize()),
                        new Document("executedQty",eachOrder.getSize()),
                        new Document("side",eachOrder.getSide()),
                        new Document("type",eachOrder.getType()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("time",eachOrder.getTs()),
                        new Document("orderId",eachOrder.getId()),
                        new Document("status",eachOrder.getStatus()),
                        new Document("stopPrice",eachOrder.getPrice())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bibox

         */

        CQueryOrderListParams cQueryOrderListParams = new com.example.nctai_trading.bibox.CQueryOrderListParams();

        cQueryOrderListParams.setType(CTypeEnum.CLOSE);

        String allOrders = biBoxHttpClient.cQueryOrderList(cQueryOrderListParams);

        /*

        bidesk

         */

        List<com.example.nctai_trading.bidesk.domain.account.Order> bideskOrders = bideskClient.getHistoryOrders(new HistoryOrderRequest());

        basicDBObject.append("exchange","bidesk");
        for(com.example.nctai_trading.bidesk.domain.account.Order eachOrder: bideskOrders){
            if(eachOrder.getStatus().toString().equalsIgnoreCase("filled")){
                eachOrderObj.append("" + orderNumber++, new Object[]{
                        new Document("clientOrderId",eachOrder.getClientOrderId()),
                        new Document("symbol",eachOrder.getSymbol()),
                        new Document("updateTime",eachOrder.getTime()),
                        new Document("origQty",eachOrder.getOrigQty()),
                        new Document("origQuoteOrderQty",eachOrder.getCummulativeQuoteQty()),
                        new Document("executedQty",eachOrder.getExecutedQty()),
                        new Document("side",eachOrder.getSide()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("time",eachOrder.getTime()),
                        new Document("orderId",eachOrder.getOrderId()),
                        new Document("status",eachOrder.getStatus()),
                        new Document("stopPrice",eachOrder.getStopPrice())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();


        /*

        bilaxy

         */

        com.example.nctai_trading.bilaxy.bilaxyMethods.transactionRequests bilaxyTransactionRequests = bilaxyMethods.new transactionRequests();

        List<com.example.nctai_trading.bilaxy.bilaxyRecentTransaction> bilaxyTrades = bilaxyTransactionRequests.getRecentTransactions("symbol",100);

        /*

        binance

         */

        List<com.example.nctai_trading.binance.Controller.AccountAPI.Order> binanceOrders = binanceMethods.getListOfAllOrders(binanceMethods);

        basicDBObject.append("exchange","binance");
        if(binanceOrders.size() > 0){
            for(com.example.nctai_trading.binance.Controller.AccountAPI.Order eachOrder : binanceOrders){
                if(eachOrder.getStatus().equalsIgnoreCase("filled")){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("clientOrderId",eachOrder.getClientOrderId()),
                            new Document("symbol",eachOrder.getSymbol()),
                            new Document("updateTime",eachOrder.getUpdateTime()),
                            new Document("origQty",eachOrder.getOrigQty()),
                            new Document("origQuoteOrderQty",eachOrder.getOrigQuoteOrderQty()),
                            new Document("executedQty",eachOrder.getExecutedQty()),
                            new Document("side",eachOrder.getSide()),
                            new Document("type",eachOrder.getType()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("time",eachOrder.getTime()),
                            new Document("orderId",eachOrder.getOrderId()),
                            new Document("status",eachOrder.getStatus()),
                            new Document("stopPrice",eachOrder.getStopPrice())
                    });
                }
            }
            }

        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        binanceUS

         */

        List<com.example.nctai_trading.binanceUS.Controller.AccountAPI.Order> binanceUSOrders = binanceUSMethods.getListOfAllOrders(binanceUSMethods);

        basicDBObject.append("exchange","binanceUS");
        if(binanceOrders.size() > 0){
            for(com.example.nctai_trading.binanceUS.Controller.AccountAPI.Order eachOrder : binanceUSOrders){
                if(eachOrder.getStatus().equalsIgnoreCase("filled")){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("clientOrderId",eachOrder.getClientOrderId()),
                            new Document("symbol",eachOrder.getSymbol()),
                            new Document("updateTime",eachOrder.getUpdateTime()),
                            new Document("origQty",eachOrder.getOrigQty()),
                            new Document("origQuoteOrderQty",eachOrder.getOrigQuoteOrderQty()),
                            new Document("executedQty",eachOrder.getExecutedQty()),
                            new Document("side",eachOrder.getSide()),
                            new Document("type",eachOrder.getType()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("time",eachOrder.getTime()),
                            new Document("orderId",eachOrder.getOrderId()),
                            new Document("status",eachOrder.getStatus()),
                            new Document("stopPrice",eachOrder.getStopPrice())
                    });
                }
            }
        }

        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bitcoincom

         */

        com.example.nctai_trading.bitcoincom.bitcoincomMethods.orderRequests bitcoincomOrderRequests = bitcoincomMethods.new orderRequests();

        // implement getting order information

        /*

        bitforex

         */

        com.example.nctai_trading.bitforex.bitforexMethods.orderRequests bitforexOrderRequests = bitforexMethods.new orderRequests();

        // implement getting order information

        /*

        bithumb

         */

        com.example.nctai_trading.bithumb.bithumbMethods.tradeRecordRequests bithumbTradeRecordRequests = bithumbMethods.new tradeRecordRequests();

        //List<com.example.nctai_trading.bithumb.bithumbmyTrades> bithumbmyTrades = bithumbTradeRecordRequests.getMyTradeRecords("BTC"); // provide symbol or implement trade records with no symbol

        basicDBObject.append("exchange","bithumb");

        for(String eachCurrency : currencyInfo.currList.values()){
            List<com.example.nctai_trading.bithumb.bithumbmyTrades> bithumbmyTrades = bithumbTradeRecordRequests.getMyTradeRecords(eachCurrency);
            if(bithumbmyTrades.size() > 0){
                for(com.example.nctai_trading.bithumb.bithumbmyTrades eachTrade: bithumbmyTrades){
                    for(com.example.nctai_trading.bithumb.bithumbmyTradesDatum tradeData : eachTrade.getData()){
                        if(tradeData.getSide().equalsIgnoreCase("buy")){
                            eachOrderObj.append("" + orderNumber++, new Object[]{
                                    new Document("origQty",tradeData.getAmount()),
                                    new Document("orderId",tradeData.getId()),
                                    new Document("time",tradeData.getTime()),
                                    new Document("side",tradeData.getDirection()),
                                    new Document("price",tradeData.getPrice()),
                                    new Document("direction",tradeData.getDirection())
                            });
                        }
                    }
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bitMex

         */

        com.example.nctai_trading.bitMEX.bitmexMethods.fundingRequests bitmexfunding = bitmexMethods.new fundingRequests();

        // implement getting order information

        /*

        bitrue

         */

        com.example.nctai_trading.bitrue.bitrueMethods.orderRequests bitrueOrderRequests = bitrueMethods.new orderRequests();

        // implement getting order information


        /*

        bittrex

         */

        basicDBObject.append("exchange","bittrex");

        accountOrder bittrexOrders = bittrexMethods.getAccountOrderHistory(bittrexMethods);

        List<Result> bittrexOrderResults = bittrexOrders.getResult();

        for(Result eachOrder : bittrexOrderResults){
            if(eachOrder.getClosed().length() > 6){
                if(eachOrder.getOrderType().equalsIgnoreCase("buy")){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("orderId",eachOrder.getOrderUuid()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("origQty",eachOrder.getQuantity()),
                            new Document("symbol",eachOrder.getExchange())

                    });
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bkex

         */

        com.example.nctai_trading.bkex.bkexMethods.orderRequests bkexOrderRequests = bkexMethods.new orderRequests();

        com.example.nctai_trading.bkex.orderHistory.orderHistoryResponse bkexFinishedOrders = bkexOrderRequests.getAllFinishedOrders();

        basicDBObject.append("exchange","bkex");

        for(com.example.nctai_trading.bkex.orderHistory.orderHistoryDatum eachOrder : bkexFinishedOrders.getData().getData()){
            if(eachOrder.getDirection().equalsIgnoreCase("buy")){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("orderId",eachOrder.getId()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("origQty",eachOrder.getDealAmount()),
                            new Document("symbol",eachOrder.getPair()),
                            new Document("type",eachOrder.getOrderType())

                    });

            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        btse

         */

        com.example.nctai_trading.btse.btseMethods.orderRequests btseOrderRequests = btseMethods.new orderRequests();

        // implement getting order information

        /*

        bybit

         */

        com.example.nctai_trading.bybit.bybitMethods.orderRequests bybitOrderRequests = bybitMethods.new orderRequests();

        // implement getting order information

        /*

        coinbasePro

         */

        com.example.nctai_trading.coinbasePro.coinbaseProMethods.orderRequests coinbaseProOrderRequests = coinbaseProMethods.new orderRequests();

        List<com.example.nctai_trading.coinbasePro.coinbaseOpenOrderListOrder> coinbaseProOrders = coinbaseProOrderRequests.getOpenOrderList();

        basicDBObject.append("exchange","coinbasePro");

        for(com.example.nctai_trading.coinbasePro.coinbaseOpenOrderListOrder eachOrder : coinbaseProOrders){
           if(eachOrder.getSettled()){
               eachOrderObj.append("" + orderNumber++, new Object[]{
                       new Document("orderId",eachOrder.getId()),
                       new Document("price",eachOrder.getPrice()),
                       new Document("size",eachOrder.getSize()),
                       new Document("side",eachOrder.getSide()),
                       new Document("time",eachOrder.getCreatedAt()),
                       new Document("executed_value",eachOrder.getExecutedValue())
               });
           }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();



        /*

        digifinex

         */

        com.example.nctai_trading.digifinex.digifinexMethods.orderRequests digiFinexOrderRequests = digifinexMethods.new orderRequests();

        // implement getting order information

        /*

        huobi

         */

        com.example.nctai_trading.huobi.Controller.AccountAPI.PositionInformation.AccountPositionInformation getOrders = huobiClient.queryUserPositionInformation(huobiClient);

        /*

        idcm

         */

        com.example.nctai_trading.idcm.idcmMethods.orderRequests idcmOrderRequests = idcmMethods.new orderRequests();

        // implement getting order information

        /*

        interactive brokers

         */

        interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods("","");

        // implement getting order information

        /*

        kite

         */

        List<com.example.nctai_trading.kiteConnect.Order> kiteOrders = kiteConnect.getOrders();

        basicDBObject.append("exchange","kiteconnect");

        for(com.example.nctai_trading.kiteConnect.Order eachOrder : kiteOrders){
            if(eachOrder.status.toLowerCase().charAt(0) == 'f'){
                eachOrderObj.append("" + orderNumber++,new Object[]{

                        new Document("accountId", eachOrder.accountId),
                        new Document("orderId",eachOrder.orderId),
                        new Document("time",eachOrder.orderTimestamp),
                        new Document("symbol",eachOrder.symbol),
                        new Document("price",eachOrder.price),
                        new Document("origQty",eachOrder.filledQuantity),
                        new Document("type",eachOrder.orderType),

                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        kraken

         */

        krakenApi.queryPrivate(KrakenApi.Method.TRADES_HISTORY);

        /*

        wbf

         */

        com.example.nctai_trading.wbf.wbfMethods.transactionRequests wbfTransactionRequests = wbfMethods.new transactionRequests();

        wbfTransactionRequests.getTransactionRecords("symbol");

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void collectOpenOrders() throws IOException, InvalidKeyException, NoSuchAlgorithmException, HttpException, KiteException, JSONException {

        MongoDatabase pastOrders = mongoClient.getDatabase("test");

        MongoCollection<Document> pastOrderCollection = pastOrders.getCollection("pastOrders");

        ArrayList<List<Object>> orders = new ArrayList<>();

        /*

        alpaca

         */

        com.example.nctai_trading.alpaca.alpacaMethods.orderRequests aorderRequests = alpacaMethods.new orderRequests();
        List<com.example.nctai_trading.alpaca.alpacaOrderListOrder> alpacaOrders = aorderRequests.getListOfOrders("open");
        resetDBObjects();
        basicDBObject.append("exchange","alpaca");
        if(alpacaOrders.size() > 0){
            for(com.example.nctai_trading.alpaca.alpacaOrderListOrder eachOrder : alpacaOrders){
                if(eachOrder.getStatus().equalsIgnoreCase("open")) {
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("clientOrderId", eachOrder.getClientOrderId()),
                            new Document("symbol", eachOrder.getSymbol()),
                            new Document("updateTime", eachOrder.getTimeInForce()),
                            new Document("origQty", eachOrder.getQty()),
                            new Document("origQuoteOrderQty", eachOrder.getFilledQty()),
                            new Document("executedQty", eachOrder.getFilledQty()),
                            new Document("side", eachOrder.getSide()),
                            new Document("price", eachOrder.getStopPrice()),
                            new Document("time", eachOrder.getCreatedAt()),
                            new Document("orderId", eachOrder.getId()),
                            new Document("status", eachOrder.getStatus()),
                            new Document("stopPrice",eachOrder.getStopPrice())
                    });
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        basefex

         */

        com.example.nctai_trading.basefex.basefexMethods.ordersRequests bordersRequests = basefexMethods.new ordersRequests();
        List<basefexOrderListOrder> basefexOrderList = bordersRequests.getOrderList("NEW");
        basicDBObject.append("exchange","basefex");
        for(basefexOrderListOrder eachOrder : basefexOrderList){
            if(eachOrder.getStatus().equals("OPEN")){
                eachOrderObj.append("" + orderNumber++,new Object[]{
                        new Document("clientOrderId",eachOrder.getId()),
                        new Document("symbol",eachOrder.getSymbol()),
                        new Document("origQty",eachOrder.getSize()),
                        new Document("origQuoteOrderQty",eachOrder.getSize()),
                        new Document("executedQty",eachOrder.getSize()),
                        new Document("side",eachOrder.getSide()),
                        new Document("type",eachOrder.getType()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("time",eachOrder.getTs()),
                        new Document("orderId",eachOrder.getId()),
                        new Document("status",eachOrder.getStatus()),
                        new Document("stopPrice",eachOrder.getPrice())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bibox

         */

        CQueryOrderListParams cQueryOrderListParams = new com.example.nctai_trading.bibox.CQueryOrderListParams();

        cQueryOrderListParams.setType(CTypeEnum.CLOSE);

        String allOrders = biBoxHttpClient.cQueryOrderList(cQueryOrderListParams);

        /*

        bidesk

         */


        List<com.example.nctai_trading.bidesk.domain.account.Order> bideskOrders = bideskClient.getOpenOrders(new OpenOrderRequest());

        basicDBObject.append("exchange","bidesk");
        for(com.example.nctai_trading.bidesk.domain.account.Order eachOrder: bideskOrders){
            if(eachOrder.getStatus().toString().equalsIgnoreCase("open")){
                eachOrderObj.append("" + orderNumber++, new Object[]{
                        new Document("clientOrderId",eachOrder.getClientOrderId()),
                        new Document("symbol",eachOrder.getSymbol()),
                        new Document("updateTime",eachOrder.getTime()),
                        new Document("origQty",eachOrder.getOrigQty()),
                        new Document("origQuoteOrderQty",eachOrder.getCummulativeQuoteQty()),
                        new Document("executedQty",eachOrder.getExecutedQty()),
                        new Document("side",eachOrder.getSide()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("time",eachOrder.getTime()),
                        new Document("orderId",eachOrder.getOrderId()),
                        new Document("status",eachOrder.getStatus()),
                        new Document("stopPrice",eachOrder.getStopPrice())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();


        /*

        bilaxy

         */

        com.example.nctai_trading.bilaxy.bilaxyMethods.transactionRequests bilaxyTransactionRequests = bilaxyMethods.new transactionRequests();

        List<com.example.nctai_trading.bilaxy.bilaxyRecentTransaction> bilaxyTrades = bilaxyTransactionRequests.getRecentTransactions("symbol",100);

        /*

        binance

         */

        List<com.example.nctai_trading.binance.Controller.AccountAPI.OpenOrder> openOrders =  binanceMethods.getCurrentOpenOrders(binanceMethods);

        basicDBObject.append("exchange","binance");

        if(openOrders.size() > 0){
            for(com.example.nctai_trading.binance.Controller.AccountAPI.OpenOrder eachOrder : openOrders){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("clientOrderId",eachOrder.getClientOrderId()),
                            new Document("symbol",eachOrder.getSymbol()),
                            new Document("updateTime",eachOrder.getUpdateTime()),
                            new Document("origQty",eachOrder.getOrigQty()),
                            new Document("origQuoteOrderQty",eachOrder.getOrigQuoteOrderQty()),
                            new Document("executedQty",eachOrder.getExecutedQty()),
                            new Document("side",eachOrder.getSide()),
                            new Document("type",eachOrder.getType()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("time",eachOrder.getTime()),
                            new Document("orderId",eachOrder.getOrderId()),
                            new Document("status",eachOrder.getStatus()),
                            new Document("stopPrice",eachOrder.getStopPrice())
                    });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        binanceUS

         */

        basicDBObject.append("exchange","binanceUS");

        List<com.example.nctai_trading.binanceUS.Controller.AccountAPI.OpenOrder> openUSOrders =  binanceUSMethods.getCurrentOpenOrders(binanceUSMethods);

        if(openOrders.size() > 0){
            for(com.example.nctai_trading.binance.Controller.AccountAPI.OpenOrder eachOrder : openOrders){
                eachOrderObj.append("" + orderNumber++, new Object[]{
                        new Document("clientOrderId",eachOrder.getClientOrderId()),
                        new Document("symbol",eachOrder.getSymbol()),
                        new Document("updateTime",eachOrder.getUpdateTime()),
                        new Document("origQty",eachOrder.getOrigQty()),
                        new Document("origQuoteOrderQty",eachOrder.getOrigQuoteOrderQty()),
                        new Document("executedQty",eachOrder.getExecutedQty()),
                        new Document("side",eachOrder.getSide()),
                        new Document("type",eachOrder.getType()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("time",eachOrder.getTime()),
                        new Document("orderId",eachOrder.getOrderId()),
                        new Document("status",eachOrder.getStatus()),
                        new Document("stopPrice",eachOrder.getStopPrice())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bitcoincom

         */

        com.example.nctai_trading.bitcoincom.bitcoincomMethods.orderRequests bitcoincomOrderRequests = bitcoincomMethods.new orderRequests();

        // implement getting order information

        /*

        bitforex

         */

        com.example.nctai_trading.bitforex.bitforexMethods.orderRequests bitforexOrderRequests = bitforexMethods.new orderRequests();

        // implement getting order information

        /*

        bithumb

         */

        com.example.nctai_trading.bithumb.bithumbMethods.tradeRecordRequests bithumbTradeRecordRequests = bithumbMethods.new tradeRecordRequests();

        //List<com.example.nctai_trading.bithumb.bithumbmyTrades> bithumbmyTrades = bithumbTradeRecordRequests.getMyTradeRecords("BTC"); // provide symbol or implement trade records with no symbol

        basicDBObject.append("exchange","bithumb");

        for(String eachCurrency : currencyInfo.currList.values()){
            List<com.example.nctai_trading.bithumb.bithumbOpenOrder> bithumbmyTrades = bithumbTradeRecordRequests.getOpenOrders(eachCurrency);
            if(bithumbmyTrades.size() > 0){
                for(com.example.nctai_trading.bithumb.bithumbOpenOrder eachTrade: bithumbmyTrades){
                    for(com.example.nctai_trading.bithumb.bithumbOpenOrderList tradeData : eachTrade.getData().getList()){
                            eachOrderObj.append("" + orderNumber++, new Object[]{
                                    new Document("origQty",tradeData.getQuantity()),
                                    new Document("orderId",tradeData.getOrderId()),
                                    new Document("time",tradeData.getCreateTime()),
                                    new Document("side",tradeData.getType()),
                                    new Document("price",tradeData.getPrice()),
                                    new Document("direction",tradeData.getSide())
                            });
                    }
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bitMex

         */

        com.example.nctai_trading.bitMEX.bitmexMethods.fundingRequests bitmexfunding = bitmexMethods.new fundingRequests();

        // implement getting order information

        /*

        bitrue

         */

        com.example.nctai_trading.bitrue.bitrueMethods.orderRequests bitrueOrderRequests = bitrueMethods.new orderRequests();

        // implement getting order information


        /*

        bittrex

         */

        basicDBObject.append("exchange","bittrex");

        accountOrder bittrexOrders = bittrexMethods.getAccountOrderHistory(bittrexMethods);

        List<Result> bittrexOrderResults = bittrexOrders.getResult();

        for(Result eachOrder : bittrexOrderResults){
            if(eachOrder.getClosed().length() < 6){
                if(eachOrder.getOrderType().equalsIgnoreCase("buy")){
                    eachOrderObj.append("" + orderNumber++, new Object[]{
                            new Document("orderId",eachOrder.getOrderUuid()),
                            new Document("price",eachOrder.getPrice()),
                            new Document("origQty",eachOrder.getQuantity()),
                            new Document("symbol",eachOrder.getExchange())

                    });
                }
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        bkex

         */

        com.example.nctai_trading.bkex.bkexMethods.orderRequests bkexOrderRequests = bkexMethods.new orderRequests();

        com.example.nctai_trading.bkex.orderHistory.orderHistoryResponse bkexFinishedOrders = bkexOrderRequests.getAllOpenOrders();

        basicDBObject.append("exchange","bkex");

        for(com.example.nctai_trading.bkex.orderHistory.orderHistoryDatum eachOrder : bkexFinishedOrders.getData().getData()){
            if(eachOrder.getDirection().equalsIgnoreCase("buy")){
                eachOrderObj.append("" + orderNumber++, new Object[]{
                        new Document("orderId",eachOrder.getId()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("origQty",eachOrder.getDealAmount()),
                        new Document("symbol",eachOrder.getPair()),
                        new Document("type",eachOrder.getOrderType())

                });

            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        btse

         */

        com.example.nctai_trading.btse.btseMethods.orderRequests btseOrderRequests = btseMethods.new orderRequests();

        // implement getting order information

        /*

        bybit

         */

        com.example.nctai_trading.bybit.bybitMethods.orderRequests bybitOrderRequests = bybitMethods.new orderRequests();

        // implement getting order information

        /*

        coinbasePro

         */

        com.example.nctai_trading.coinbasePro.coinbaseProMethods.orderRequests coinbaseProOrderRequests = coinbaseProMethods.new orderRequests();

        List<com.example.nctai_trading.coinbasePro.coinbaseOpenOrderListOrder> coinbaseProOrders = coinbaseProOrderRequests.getOpenOrderList();

        basicDBObject.append("exchange","coinbasePro");

        for(com.example.nctai_trading.coinbasePro.coinbaseOpenOrderListOrder eachOrder : coinbaseProOrders){
            if(!eachOrder.getSettled()){
                eachOrderObj.append("" + orderNumber++, new Object[]{
                        new Document("orderId",eachOrder.getId()),
                        new Document("price",eachOrder.getPrice()),
                        new Document("size",eachOrder.getSize()),
                        new Document("side",eachOrder.getSide()),
                        new Document("time",eachOrder.getCreatedAt()),
                        new Document("executed_value",eachOrder.getExecutedValue())
                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();



        /*

        digifinex

         */

        com.example.nctai_trading.digifinex.digifinexMethods.orderRequests digiFinexOrderRequests = digifinexMethods.new orderRequests();

        // implement getting order information

        /*

        huobi

         */

        com.example.nctai_trading.huobi.Controller.AccountAPI.PositionInformation.AccountPositionInformation getOrders = huobiClient.queryUserPositionInformation(huobiClient);

        /*

        idcm

         */

        com.example.nctai_trading.idcm.idcmMethods.orderRequests idcmOrderRequests = idcmMethods.new orderRequests();

        // implement getting order information

        /*

        interactive brokers

         */

        interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods("","");

        // implement getting order information

        /*

        kite

         */

        List<com.example.nctai_trading.kiteConnect.Order> kiteOrders = kiteConnect.getOrders();

        basicDBObject.append("exchange","kiteconnect");

        for(com.example.nctai_trading.kiteConnect.Order eachOrder : kiteOrders){
            if(eachOrder.status.toLowerCase().charAt(0) == 'o'){
                eachOrderObj.append("" + orderNumber++,new Object[]{

                        new Document("accountId", eachOrder.accountId),
                        new Document("orderId",eachOrder.orderId),
                        new Document("time",eachOrder.orderTimestamp),
                        new Document("symbol",eachOrder.symbol),
                        new Document("price",eachOrder.price),
                        new Document("origQty",eachOrder.filledQuantity),
                        new Document("type",eachOrder.orderType),

                });
            }
        }
        basicDBObject.append("orders",eachOrderObj);
        pastOrderCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        /*

        kraken

         */

        krakenApi.queryPrivate(KrakenApi.Method.TRADES_HISTORY);

        /*

        wbf

         */

        com.example.nctai_trading.wbf.wbfMethods.transactionRequests wbfTransactionRequests = wbfMethods.new transactionRequests();

        wbfTransactionRequests.getTransactionRecords("symbol");

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void collectAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {


        MongoDatabase accountInfo = mongoClient.getDatabase("test");

        MongoCollection<Document> accountInfoCollection = accountInfo.getCollection("accountInfo");

        ArrayList<List<Object>> accHoldings = new ArrayList<>();

        ArrayList<List<Object>> deposits = new ArrayList<>();

        ArrayList<List<Object>> withdrawls = new ArrayList<>();

        resetDBObjects();

        // alpaca

        basicDBObject.append("exchange","alpaca");

        com.example.nctai_trading.alpaca.alpacaMethods.accountReqeusts alpacaAccountRequests = alpacaMethods.new accountReqeusts();

        List<alpacaAsset> alpacaAssets = alpacaAccountRequests.getAssets();

        List<NonTradeActivity> alpacaNonTradeActivities = alpacaAccountRequests.getAccountNonTradeActivitiesWithdrawlsDeposits();

        for(alpacaAsset eachAsset : alpacaAssets){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachAsset.getExchange()),

            });
        }
        orderNumber = 0;
        for(NonTradeActivity eachNonTradeActivity : alpacaNonTradeActivities){
            if(eachNonTradeActivity.getActivityType().equalsIgnoreCase("CSD")){
                depositsObj.append("" + orderNumber++, new Object[]{

                        new Document("currency",eachNonTradeActivity.getSymbol()),
                        new Document("amount",eachNonTradeActivity.getQty()),
                        new Document("date",eachNonTradeActivity.getDate())

                });
            }
        }
        orderNumber = 0;
        for(NonTradeActivity eachNonTradeActivity : alpacaNonTradeActivities){
            if(eachNonTradeActivity.getActivityType().equalsIgnoreCase("CSW")){
                withdrawlsObj.append("" + orderNumber++, new Object[]{

                        new Document("currency",eachNonTradeActivity.getSymbol()),
                        new Document("amount",eachNonTradeActivity.getQty()),
                        new Document("date",eachNonTradeActivity.getDate())

                });
            }
        }

        /*
        for(com.example.nctai_trading.kiteConnect.Order eachOrder : kiteOrders){
            if(eachOrder.status.toLowerCase().charAt(0) == 'o'){
                eachOrderObj.append("" + orderNumber++,new Object[]{

                        new Document("accountId", eachOrder.accountId),
                        new Document("orderId",eachOrder.orderId),
                        new Document("time",eachOrder.orderTimestamp),
                        new Document("symbol",eachOrder.symbol),
                        new Document("price",eachOrder.price),
                        new Document("origQty",eachOrder.filledQuantity),
                        new Document("type",eachOrder.orderType),

                });
            }
        }
         */
        basicDBObject.append("deposits",depositsObj);
        basicDBObject.append("accHoldings",accountHoldingsObj);
        basicDBObject.append("withdrawls",withdrawlsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // basefex

        basicDBObject.append("exchange","basefex");


        com.example.nctai_trading.basefex.basefexMethods.accountRequests basefexAccountRequests = basefexMethods.new accountRequests();

        List<basefexAccountDepositWithdrawHistory> basefexAccountWithdrawHistories = basefexAccountRequests.getDepositAndWithdrawHistory("WITHDRAW");

        for(basefexAccountDepositWithdrawHistory eachWithdrawl : basefexAccountWithdrawHistories){
            withdrawlsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachWithdrawl.getCurrency()),
                    new Document("amount",eachWithdrawl.getAmount())

            });
        }
        orderNumber = 0;
        List<basefexAccountDepositWithdrawHistory> basefexAccountDepositHistories = basefexAccountRequests.getDepositAndWithdrawHistory("DEPOSIT");

        for(basefexAccountDepositWithdrawHistory eachDeposit: basefexAccountDepositHistories){
            depositsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachDeposit.getCurrency()),
                    new Document("amount",eachDeposit.getAmount())

            });
        }
        orderNumber = 0;

        List<basefexGetAccountCashAndPositionDetail> basefexGetAccountCashAndPositionDetails = basefexAccountRequests.getCashAndPositionDetail();

        for(basefexGetAccountCashAndPositionDetail eachAccountCashPosition: basefexGetAccountCashAndPositionDetails){
            basefexGetAccountCashAndPositionDetailCash cashDetails = eachAccountCashPosition.getCash();
            accountHoldingsObj.append("" + orderNumber++, new Object[]{
                new Document("currency",cashDetails.getCurrency()),
                    new Document("amount",cashDetails.getAvailable())
            });
        }

        orderNumber = 0;
        basicDBObject.append("accHoldings",accountHoldingsObj);
        basicDBObject.append("withdrawls",withdrawlsObj);
        basicDBObject.append("deposits",depositsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bidesk

        com.example.nctai_trading.bidesk.domain.account.Account biDeskAccount = bideskClient.getAccount(10000L,System.currentTimeMillis() * 1000);

        List<DepositOrder> bideskDeposits = bideskClient.getDepositOrders(new DepositOrderRequest());

        List<AssetBalance> bideskBalances = biDeskAccount.getBalances();

        basicDBObject.append("exchange","bidesk");

        for(AssetBalance eachAsset : bideskBalances){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachAsset.getAsset()),
                    new Document("free",eachAsset.getFree()),
                    new Document("locked",eachAsset.getLocked())

            });
        }
        orderNumber = 0;

        for(DepositOrder eachDeposit : bideskDeposits){
            depositsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency", eachDeposit.getToken()),
                    new Document("amount",eachDeposit.getQuantity()),
                    new Document("date",eachDeposit.getTime())

            });
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        basicDBObject.append("deposits",depositsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bilaxy

        basicDBObject.append("exchange","bilaxy");

        com.example.nctai_trading.bilaxy.bilaxyMethods.interfaceRequests bilaxyAccountRequests = bilaxyMethods.new interfaceRequests();

        List<bilaxyAccount> bilaxyAccounts = bilaxyAccountRequests.getAccountInfo();

        for(bilaxyAccount eachAccount : bilaxyAccounts){
            List<bilaxyAccountData> bilaxyAccountData = eachAccount.getData();
            for(bilaxyAccountData eachBilaxyAccountData : bilaxyAccountData){
                accountHoldingsObj.append("" + orderNumber++, new Object[]{

                        new Document("currency",eachBilaxyAccountData.getSymbol()),
                        new Document("amount",eachBilaxyAccountData.getBalance()),
                        new Document("frozen",eachBilaxyAccountData.getFrozen())

                });

            }
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // binance & binanceUS


        basicDBObject.append("exchange","binance");

        AccountInfo binanceAccountInfo = binanceMethods.getAccountInformation(binanceMethods);

        List<AccountBalance> binanceAccBalances = binanceAccountInfo.getBalances();

        for(AccountBalance eachBinanceAccountBalance: binanceAccBalances){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachBinanceAccountBalance.getAsset()),
                    new Document("free",eachBinanceAccountBalance.getFree()),
                    new Document("locked",eachBinanceAccountBalance.getLocked())

            });
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        com.example.nctai_trading.binanceUS.Controller.AccountAPI.AccountInfo.AccountInfo binanceUSAccountInfo = binanceUSMethods.getAccountInformation(binanceUSMethods);

        basicDBObject.append("exchange","binanceUS");

        List<com.example.nctai_trading.binanceUS.Controller.AccountAPI.AccountInfo.AccountBalance> binanceUSAccBalances = binanceUSAccountInfo.getBalances();

        for(com.example.nctai_trading.binanceUS.Controller.AccountAPI.AccountInfo.AccountBalance eachBinanceAccountBalance: binanceUSAccBalances){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachBinanceAccountBalance.getAsset()),
                    new Document("free",eachBinanceAccountBalance.getFree()),
                    new Document("locked",eachBinanceAccountBalance.getLocked())

            });
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bitforex

        List<com.example.nctai_trading.bitforex.AccountAsset.AccountAssets> bitForexAccountAssets = bitforexMethods.getAccountAssets();

        basicDBObject.append("exchange","bitforex");


        for(AccountAssets eachBitForexAccAsset : bitForexAccountAssets){

            List<Datum> bitforexAccDatum = eachBitForexAccAsset.getData();
            for(Datum eachBitforexDatum : bitforexAccDatum){
                accountHoldingsObj.append("" + orderNumber++, new Object[]{

                        new Document("currency",eachBitforexDatum.getCurrency()),
                        new Document("frozen",eachBitforexDatum.getFrozen()),
                        new Document("fix",eachBitforexDatum.getFix()),
                        new Document("active",eachBitforexDatum.getActive())

                });
            }
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bithumb

        com.example.nctai_trading.bithumb.bithumbMethods.historyRequests bithumbAccHistoryMethods = bithumbMethods.new historyRequests();
        com.example.nctai_trading.bithumb.bithumbMethods.virtualCoinOrderRequests bithumbAssetMethods = bithumbMethods.new virtualCoinOrderRequests();

        List<bithumbWithdrawResponseData> bithumbWithdrawResponse = bithumbAccHistoryMethods.getWithdrawHistory("90").getData();
        List<bithumbWithdrawResponseData> bithumbDepositResponse = bithumbAccHistoryMethods.queryDepositHistory("90").getData();
        List<bithumbVirtualCoinAssetData> bithumbVirtualCoinAsset = bithumbAssetMethods.queryVirtualCoinAccount("wallet").getData();

        for(bithumbWithdrawResponseData bithumbWithdrawResponseData : bithumbWithdrawResponse){
            withdrawlsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",bithumbWithdrawResponseData.getCoinType()),
                    new Document("quantity",bithumbWithdrawResponseData.getQuantity()),
                    new Document("date",bithumbWithdrawResponseData.getCreateTime())

            });
        }

        orderNumber = 0;

        for(bithumbWithdrawResponseData bithumbDepositData : bithumbDepositResponse){
            depositsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",bithumbDepositData.getCoinType()),
                    new Document("quantity",bithumbDepositData.getQuantity()),
                    new Document("date",bithumbDepositData.getCreateTime())

            });
        }

        orderNumber = 0;

        for(bithumbVirtualCoinAssetData bithumbVirtualCoinAssetData : bithumbVirtualCoinAsset){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{
                    new Document("currency",bithumbVirtualCoinAssetData.getCoinType()),
                    new Document("quantity",bithumbVirtualCoinAssetData.getBtcQuantity()),
            });
        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        basicDBObject.append("withdrawls",withdrawlsObj);
        basicDBObject.append("deposits",depositsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bitmex

        List<userWalletHistory> bitmwxAccountWalletHistory = bitmexMethods.getAccountWalletHistory();

        basicDBObject.append("exchange","bitmex");

        for(userWalletHistory userWalletHistory: bitmwxAccountWalletHistory){

            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",userWalletHistory.getCurrency()),
                    new Document("amount",userWalletHistory.getAmount())

            });

        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bitrue

        com.example.nctai_trading.bitrue.bitrueMethods.orderRequests bitrueorder = bitrueMethods.new orderRequests();
        List<accountTrade> bitrueAccountTradeList = bitrueorder.getAccountTradeList();

        basicDBObject.append("exchange","bitrue");

        for(accountTrade eachAccountTrade : bitrueAccountTradeList){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachAccountTrade.getSymbol()),
                    new Document("amount",eachAccountTrade.getQty()),
                    new Document("price",eachAccountTrade.getPrice())


            });
        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bittrex

        basicDBObject.append("exchange","bittrex");

        List<accountBalance> bittrexAccountBalances = bittrexMethods.getAccountBalances(bittrexMethods);

        for(accountBalance eachBittrexAccountBalance : bittrexAccountBalances){

            List<com.example.nctai_trading.bittrexV2.Controller.accountBalances.Result> bittrexResult = eachBittrexAccountBalance.getResult();

            for(com.example.nctai_trading.bittrexV2.Controller.accountBalances.Result eachResult : bittrexResult){
                accountHoldingsObj.append("" + orderNumber++, new Object[]{

                        new Document("currency",eachResult.getCurrency()),
                        new Document("amount",eachResult.getBalance())

                });
            }
        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bkex

        basicDBObject.append("exchange","bkex");

        com.example.nctai_trading.bkex.bkexMethods.orderRequests bkexOrder = bkexMethods.new orderRequests();
        walletBalance bkexAccountBalance = bkexOrder.getAccountBalance();
        depositRecord bkexDepositRecord = bkexOrder.getDepositRecord();
        withdrawRecord bkexWithdrawRecord = bkexOrder.getWithdrawRecord();

        List<com.example.nctai_trading.bkex.account.WalletBalance.Datum> bkexWalletBalanceDatum = bkexAccountBalance.getData();
        List<com.example.nctai_trading.bkex.account.WithdrawRecord.Datum> bkexWithdrawDatum = bkexWithdrawRecord.getData().getData();
        List<com.example.nctai_trading.bkex.account.DepositRecord.Datum> bkexDepositDatum = bkexDepositRecord.getData().getData();

        for(com.example.nctai_trading.bkex.account.WalletBalance.Datum eachBalance : bkexWalletBalanceDatum){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachBalance.getCoinType()),
                    new Document("amount",eachBalance.getTotal()),
                    new Document("frozen",eachBalance.getFrozen()),
                    new Document("available",eachBalance.getAvailable())

            });
        }

        orderNumber = 0;
        for(com.example.nctai_trading.bkex.account.DepositRecord.Datum eachDeposit: bkexDepositDatum){
            depositsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachDeposit.getCoinType()),
                    new Document("amount",eachDeposit.getAmount()),
                    new Document("confirmed",eachDeposit.getConfirmed()),
                    new Document("date",eachDeposit.getCreateTime()),
                    new Document("from address",eachDeposit.getFromAddress()),
                    new Document("to address",eachDeposit.getToAddress())

            });
        }
        orderNumber = 0;
        for(com.example.nctai_trading.bkex.account.WithdrawRecord.Datum eachWithdraw :  bkexWithdrawDatum) {
            withdrawlsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency", eachWithdraw.getCoinType()),
                    new Document("amount", eachWithdraw.getAmount()),
                    new Document("date", eachWithdraw.getCreateTime()),
                    new Document("from address", eachWithdraw.getFromAddress()),
                    new Document("to address", eachWithdraw.getToAddress())

            });
        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        basicDBObject.append("withdrawls",withdrawlsObj);
        basicDBObject.append("deposits",depositsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();


        // btse

        basicDBObject.append("exchange","btse");

        com.example.nctai_trading.btse.btseMethods.orderRequests btseOrder = btseMethods.new orderRequests();
        List<walletHistory> btseAccountWalletHistory = btseOrder.getWalletHistory();

        for(walletHistory eachWalletHistory : btseAccountWalletHistory){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachWalletHistory.getCurrency()),
                    new Document("amount",eachWalletHistory.getAmount()),
                    new Document("date",eachWalletHistory.getTimestamp())

            });
        }

        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // bybit

        com.example.nctai_trading.bybit.bybitMethods.orderRequests bybitorder = bybitMethods.new orderRequests();
        walletFund bybitAccountWalletFund = bybitorder.getWalletFundRecords();

        List<com.example.nctai_trading.bybit.walletFunds.Datum> bybitWalletData = bybitAccountWalletFund.getResult().getData();

        for(com.example.nctai_trading.bybit.walletFunds.Datum eachWalletFund : bybitWalletData){
            accountHoldingsObj.append("" + orderNumber++, new Object[]{

                    new Document("currency",eachWalletFund.getCoin()),
                    new Document("amount",eachWalletFund.getAmount()),
                    new Document("date",eachWalletFund.getExecTime())

            });
        }
        basicDBObject.append("accHoldings",accountHoldingsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // coinbase

        coinbaseProMethods.withdrawRequests coinbaseWithdraw = coinbaseProMethods.new withdrawRequests();
        List<coinbaseProWithdrawl> coinbaseProWithdrawl = coinbaseWithdraw.getListOfWithdrawls();
        com.example.nctai_trading.coinbasePro.coinbaseProMethods.depositRequests coinbaseDeposit = coinbaseProMethods.new depositRequests();
        List<coinbaseProDeposit> coinbaseProDeposits = coinbaseDeposit.getListOfDeposits();

        for(coinbaseProDeposit eachDeposit : coinbaseProDeposits){
            depositsObj.append("" + orderNumber++, new Object[]{

                    new Document("amount",eachDeposit.getAccountId()),
                    new Document("date",eachDeposit.getProcessedAt()),
                    new Document("id",eachDeposit.getId())

            });
        }

        for(coinbaseProWithdrawl eachWithdrawl : coinbaseProWithdrawl){
            withdrawlsObj.append("" + orderNumber++, new Object[]{

                    new Document("amount",eachWithdrawl.getAmount()),
                    new Document("date",eachWithdrawl.getProcessedAt()),
                    new Document("id",eachWithdrawl.getId())

            });
        }

        basicDBObject.append("withdrawls",withdrawlsObj);
        basicDBObject.append("deposits",depositsObj);
        accountInfoCollection.insertOne(new Document(basicDBObject));
        resetDBObjects();

        // digifinex

        com.example.nctai_trading.digifinex.digifinexMethods.orderRequests digifinexOrder = digifinexMethods.new orderRequests();

        // kraken

        krakenApi.queryPrivate(KrakenApi.Method.QUERY_LEDGERS);


    }

    public void cancelOrderSpecificExchange(String exchange){

    }

    public void marginOrderSpecificExchange(String exchange, String fromCurrency, String toCurrency, String direction, String amount, String limitPrice, String stopLossPrice){

    }

    public void cancelAllOrders(){

    }

    public void liquidateAllCurrencyAssetsBuy(String exchange, String currency){
        // buy all currency from exchange as possible
    }

    public void liquidateAllCurrencyAssetsSell(String exchange){
        // sell all currency from exchange
    }

    public void placeOrderPrice(String exchange, String fromCurrency, String toCurrency, String direction, String amount, String price){

    }

    public void placeOrderPriceStopLossPrice(String exchange, String fromCurrency, String toCurrency, String direction, String amount, String price, String stopLossPrice){

    }

    public void placeOrder(String exchange, String fromCurrency, String toCurrency, String direction, String amount){

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void followParticleCommand() throws KiteException, NoSuchAlgorithmException, IOException, JSONException, HttpException, InvalidKeyException {

        String[] fields = getDataReceived().split(" ");

        /*

        List:

        // (all)collect account holdings <--- check
        // (all)collect all history orders <--- check
        // (all)collect all open orders <---- check

        // (currency)cancel orders <--- set up
        // (exchange) margin orders <--- set up
        // (exchange) regular order <--- set up
        // (exchange) liquidate order <--- set up

         */


        if(fields[0].equalsIgnoreCase("all") && fields[1].equalsIgnoreCase("ex")){
            if(fields[2].equalsIgnoreCase("HISTORY")){
                collectPastOrders();
            }
            else if(fields[2].equalsIgnoreCase("open_orders")){
                collectOpenOrders();
            }
            else if(fields[2].equalsIgnoreCase("collect")){
                collectAccountInformation();
            }
        }
        else if(fields[2].equalsIgnoreCase("cancel")){
            if(fields[3].equalsIgnoreCase("unspecified")){
                cancelAllOrders();
            }
            else{
                cancelOrderSpecificExchange("");
            }
        }
        else if(fields[2].equalsIgnoreCase("margin")){
            marginOrderSpecificExchange(fields[0],fields[1],fields[3],fields[4],fields[5],fields[6],fields[7]);
        }
        else if(fields[2].equalsIgnoreCase("all")){
            if(fields[1].equalsIgnoreCase("buy")){
                liquidateAllCurrencyAssetsBuy(fields[0],fields[3]);
            }
            else{
                liquidateAllCurrencyAssetsSell(fields[0]);
            }
        }
        else{
            if(fields.length == 6){
                placeOrderPrice(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);
            }
            else if(fields.length == 7){
                placeOrderPriceStopLossPrice(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
            }
            else{
                placeOrder(fields[0],fields[1],fields[2],fields[3],fields[4]);
            }
        }


        //{"data":"TTTTTTEEEESSSTTTTT","ttl":60,"published_at":"2021-05-05T08:26:19.211Z","coreid":"api"}

    }
}
