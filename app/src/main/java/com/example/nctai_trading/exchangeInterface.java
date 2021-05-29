package com.example.nctai_trading;

import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.basefex.basefexOrderListOrder;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;
import com.example.nctai_trading.bibox.CQueryOrderListParams;
import com.example.nctai_trading.bibox.CTypeEnum;
import com.example.nctai_trading.bidesk.BrokerApiClientFactory;
import com.example.nctai_trading.bidesk.BrokerApiRestClient;
import com.example.nctai_trading.bidesk.domain.account.request.HistoryOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.OpenOrderRequest;
import com.example.nctai_trading.bilaxy.bilaxyMethods;
import com.example.nctai_trading.binance.Client.BinanceClient;
import com.example.nctai_trading.bitMEX.bitmexMethods;
import com.example.nctai_trading.bitcoincom.bitcoincomMethods;
import com.example.nctai_trading.bitforex.bitforexMethods;
import com.example.nctai_trading.bithumb.bithumbMethods;
import com.example.nctai_trading.bitrue.bitrueMethods;
import com.example.nctai_trading.bittrex.ApiKeySecret;
import com.example.nctai_trading.bittrex.BittrexExchange;
import com.example.nctai_trading.bittrexV2.BittrexClient;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.Result;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.accountOrder;
import com.example.nctai_trading.bkex.bkexMethods;
import com.example.nctai_trading.btse.btseMethods;
import com.example.nctai_trading.bybit.bybitMethods;
import com.example.nctai_trading.coinbasePro.coinbaseProMethods;
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

    public void collectAccountInformation() throws IOException, InvalidKeyException, NoSuchAlgorithmException {


        com.example.nctai_trading.alpaca.alpacaMethods.accountReqeusts alpacaAccountRequests = alpacaMethods.new accountReqeusts();
        com.example.nctai_trading.basefex.basefexMethods.accountRequests basefexAccountRequests = basefexMethods.new accountRequests();
        com.example.nctai_trading.bidesk.domain.account.Account biDeskAccount = bideskClient.getAccount(10000L,System.currentTimeMillis() * 1000);
        com.example.nctai_trading.bilaxy.bilaxyMethods.interfaceRequests bilaxyAccountRequests = bilaxyMethods.new interfaceRequests();
        binanceMethods.getAccountInformation(binanceMethods);
        binanceUSMethods.getAccountInformation(binanceUSMethods);
        List<com.example.nctai_trading.bitforex.AccountAsset.AccountAssets> bitForexAccountAssets = bitforexMethods.getAccountAssets();
        com.example.nctai_trading.bithumb.bithumbMethods.tradeRecordRequests bithumbTradeRecordReq = bithumbMethods.new tradeRecordRequests();
        bitmexMethods.getAccountWalletHistory();
        com.example.nctai_trading.bitrue.bitrueMethods.orderRequests bitrueorder = bitrueMethods.new orderRequests();
        bitrueorder.getAccountTradeList();
        bittrexMethods.getAccountBalances(bittrexMethods);
        com.example.nctai_trading.bkex.bkexMethods.orderRequests bkexOrder = bkexMethods.new orderRequests();
        bkexOrder.getAccountBalance();
        bkexOrder.getDepositRecord();
        bkexOrder.getWithdrawRecord();
        com.example.nctai_trading.btse.btseMethods.orderRequests btseOrder = btseMethods.new orderRequests();
        btseOrder.getWalletHistory();
        com.example.nctai_trading.bybit.bybitMethods.orderRequests bybitorder = bybitMethods.new orderRequests();


    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void followParticleCommand() throws KiteException, NoSuchAlgorithmException, IOException, JSONException, HttpException, InvalidKeyException {

        String[] fields = getDataReceived().split(" ");

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

        //{"data":"TTTTTTEEEESSSTTTTT","ttl":60,"published_at":"2021-05-05T08:26:19.211Z","coreid":"api"}

    }
}
