package com.example.nctai_trading.adminMethods;

import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.alpaca.alpacaOrderListOrder;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;
import com.example.nctai_trading.bibox.CTypeEnum;
import com.example.nctai_trading.bidesk.BrokerApiClientFactory;
import com.example.nctai_trading.bidesk.BrokerApiRestClient;
import com.example.nctai_trading.bidesk.domain.account.Trade;
import com.example.nctai_trading.bidesk.domain.account.request.MyTradeRequest;
import com.example.nctai_trading.bilaxy.bilaxyMethods;
import com.example.nctai_trading.binance.binanceMethods;
import com.example.nctai_trading.bitMEX.bitmexMethods;
import com.example.nctai_trading.bitcoincom.bitcoincomMethods;
import com.example.nctai_trading.bitforex.bitforexMethods;
import com.example.nctai_trading.bithumb.bithumbMethods;
import com.example.nctai_trading.bitrue.bitrueMethods;
import com.example.nctai_trading.bittrex.BittrexExchange;
import com.example.nctai_trading.bkex.bkexMethods;
import com.example.nctai_trading.btse.btseMethods;
import com.example.nctai_trading.bybit.bybitMethods;
import com.example.nctai_trading.coinbasePro.coinbaseProMethods;
import com.example.nctai_trading.digifinex.digifinexMethods;
import com.example.nctai_trading.exante.exanteMethods;
import com.example.nctai_trading.huobiApi2.api.HbdmswapRestApiV1;
import com.example.nctai_trading.idcm.idcmMethods;
import com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods;
import com.example.nctai_trading.kiteConnect.KiteConnect;
import com.example.nctai_trading.kraken.KrakenApi;
import com.example.nctai_trading.mainPage;
import com.example.nctai_trading.wbf.wbfMethods;
import com.mongodb.BasicDBObject;
import com.mongodb.CursorType;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class adminMethods {
    String orderId = "";
    ArrayList<String> listOfAllExchanges = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addUserExchanges(){
        MongoClientURI uri = new MongoClientURI("mongodb://admin:CompeteToWin*13@cluster0-shard-00-00.jhtaz.mongodb.net:27017,cluster0-shard-00-01.jhtaz.mongodb.net:27017,cluster0-shard-00-02.jhtaz.mongodb.net:27017/test?ssl=true&replicaSet=atlas-79gy36-shard-0&authSource=admin&retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> coll = null;
        MongoCollection<Document> orders = null;
        orders = database.getCollection("pastOrders");
        //for(String name: database.listCollectionNames()){
        //    if(name.equals("user")){
        //        coll = database.getCollection(name);
        //        break;
        //    }
        //}
        exchangesList exchangesList = new exchangesList();
        listOfAllExchanges = exchangesList.getExchangesList();
        com.example.nctai_trading.mainPage mainPage = new com.example.nctai_trading.mainPage();
        SharedPreferences sharedPreferences = mainPage.getThePreferences();
        for(String eachString: listOfAllExchanges){
            try{
                switch(eachString) {
                    case "alpaca":
                        // alpaca
                        String alpacaAPIKey = sharedPreferences.getString("alpacaApiKey","");
                        String alpacaSecretKey = sharedPreferences.getString("alpacaSecretKey","");
                        if(alpacaAPIKey.equals("") || alpacaSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.alpaca.alpacaMethods alpacaMethods = new alpacaMethods(alpacaAPIKey,alpacaSecretKey);
                        com.example.nctai_trading.alpaca.alpacaMethods.orderRequests alpacaOrderRequests = alpacaMethods.new orderRequests();
                        List<alpacaOrderListOrder> alpacaOrderList = alpacaOrderRequests.getListOfOrders();
                        break;
                    case "basefex":
                        // basefex
                        String baseFexApiKey = sharedPreferences.getString("basefexApiKey","");
                        String baseFexSecretKey = sharedPreferences.getString("basefexSecretKey","");
                        if(baseFexApiKey.equals("") || baseFexSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.basefex.basefexMethods basefexMethods = new basefexMethods(baseFexApiKey,baseFexSecretKey);
                        com.example.nctai_trading.basefex.basefexMethods.ordersRequests baseFexOrderRequests = basefexMethods.new ordersRequests();
                        List<com.example.nctai_trading.basefex.basefexOrderListOrder> basefexOrderList = baseFexOrderRequests.getOrderList();
                        break;
                    case "bibox":
                        // bibox
                        String biBoxApiKey = sharedPreferences.getString("biboxApiKey","");
                        String biBoxSecretKey = sharedPreferences.getString("biboxSecretKey","");
                        if(biBoxApiKey.equals("") || biBoxSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.bibox.BiBoxHttpClientConfig client = new BiBoxHttpClientConfig.Builder().apiKey(biBoxApiKey).secret(biBoxSecretKey).build();
                        BiBoxHttpClient biBoxHttpClient = new BiBoxHttpClient(client);
                        com.example.nctai_trading.bibox.CQueryOrderListParams orderListParams = new com.example.nctai_trading.bibox.CQueryOrderListParams();
                        orderListParams.setType(CTypeEnum.CLOSE);
                        String biboxOrders = biBoxHttpClient.cQueryOrderList(orderListParams);
                        break;
                    case "bidesk":
                        // bidesk
                        String bideskApiKey = sharedPreferences.getString("bideskApiKey","");
                        String bideskSecretKey = sharedPreferences.getString("bideskSecretKey","");
                        if(bideskApiKey.equals("") || bideskSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.bidesk.BrokerApiClientFactory brokerApiClientFactory = new BrokerApiClientFactory("https://api.bidesk.com/", bideskApiKey, bideskSecretKey);
                        BrokerApiRestClient restClient = brokerApiClientFactory.newRestClient();
                        List<Trade> tradeList = restClient.getMyTrades(new MyTradeRequest(100));
                        break;
                    case "bilaxy":
                        // bilaxy
                        String bilaxyApiKey = sharedPreferences.getString("bilaxyApiKey","");
                        String bilaxySecretKey = sharedPreferences.getString("bilaxySecretKey","");
                        if(bilaxyApiKey.equals("") || bilaxySecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.bilaxy.bilaxyMethods bilaxyMethods = new bilaxyMethods(bilaxyApiKey,bilaxySecretKey);
                        com.example.nctai_trading.bilaxy.bilaxyMethods.interfaceRequests bilaxyOrdersRequests = bilaxyMethods.new interfaceRequests();
                        List<com.example.nctai_trading.bilaxy.bilaxyOrderQuery> orderList = bilaxyOrdersRequests.ordersQuery("","");
                        break;
                    case "binance":
                        // binance
                        String binanceApiKey = sharedPreferences.getString("binanceApiKey","");
                        String binanceSecretKey = sharedPreferences.getString("binanceSecretKey","");
                        if(binanceApiKey.equals("") || binanceSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.binance.binanceMethods binanceMethods = new binanceMethods(binanceApiKey,binanceSecretKey);
                        com.example.nctai_trading.binance.binanceMethods.orderRequests binanceOrderRequests = binanceMethods.new orderRequests();
                        List<com.example.nctai_trading.binance.binanceOrderListOrder> binanceOrderList = binanceOrderRequests.getAllOpenOrdersNoSymbol();
                        break;
                    case "binanceUS":
                        // binanceUS
                        String binanceUSApiKey = sharedPreferences.getString("binanceUSApiKey","");
                        String binanceUSSecretKey = sharedPreferences.getString("binanceUSSecretKey","");
                        if(binanceUSApiKey.equals("") || binanceUSSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.binanceUS.binanceMethods binanceMethods1 = new com.example.nctai_trading.binanceUS.binanceMethods(binanceUSApiKey,binanceUSSecretKey);
                        com.example.nctai_trading.binanceUS.binanceMethods.orderRequests binanceUSOrderRequests = binanceMethods1.new orderRequests();
                        List<com.example.nctai_trading.binanceUS.binanceOrderListOrder> binanceUSOrderList = binanceUSOrderRequests.getAllOpenOrdersNoSymbol();
                        break;
                    case "bitcoincom":
                        // bitcoincom
                        String bitcoincomApiKey = sharedPreferences.getString("bitcoincomApiKey","");
                        String bitcoincomSecretKey = sharedPreferences.getString("bitcoincomSecretKey","");
                        if(bitcoincomApiKey.equals("") || bitcoincomSecretKey.equals("")){
                            break;
                        }
                        com.example.nctai_trading.bitcoincom.bitcoincomMethods bitcoincomMethods = new bitcoincomMethods(bitcoincomApiKey,bitcoincomSecretKey);
                        break;
                    case "bitforex":
                        // bitforex
                        com.example.nctai_trading.bitforex.bitforexMethods bitforexMethods = new bitforexMethods();
                        break;
                    case "bithumb":
                        // bithumb
                        com.example.nctai_trading.bithumb.bithumbMethods bithumbMethods = new bithumbMethods("", "");
                        break;
                    case "bitMEX":
                        // bitMEX
                        com.example.nctai_trading.bitMEX.bitmexMethods bitmexMethods = new bitmexMethods();
                        break;
                    case "bitrue":
                        // bitrue
                        com.example.nctai_trading.bitrue.bitrueMethods bitrueMethods = new bitrueMethods();
                        break;
                    case "bittrex":
                        //bittrex
                        com.example.nctai_trading.bittrex.BittrexExchange bittrexExchange = new BittrexExchange();
                        break;
                    case "bkex":
                        //  bkex
                        com.example.nctai_trading.bkex.bkexMethods bkexMethods = new bkexMethods();
                        break;
                    case "btse":
                        // btse
                        com.example.nctai_trading.btse.btseMethods btseMethods = new btseMethods();
                        break;
                    case "bybit":
                        // bybit
                        com.example.nctai_trading.bybit.bybitMethods bybitMethods = new bybitMethods();
                        break;
                    case "coinbasePro":
                        // coinbasePro
                        com.example.nctai_trading.coinbasePro.coinbaseProMethods coinbaseProMethods = new coinbaseProMethods("", "", "");
                        break;
                    case "digifinex":
                        // digifinex
                        com.example.nctai_trading.digifinex.digifinexMethods digifinexMethods = new digifinexMethods();
                        break;
                    case "exante":
                        // exante
                        com.example.nctai_trading.exante.exanteMethods exanteMethods = new exanteMethods();
                        break;
                    case "huobi":
                        // huobiApi
                        com.example.nctai_trading.huobiApi2.api.HbdmswapRestApiV1 hbdmswapRestApiV1 = new HbdmswapRestApiV1("baseurl", "", "");
                        break;
                    case "idcm":
                        // idcm
                        com.example.nctai_trading.idcm.idcmMethods idcmMethods = new idcmMethods();
                        break;
                    case "interactiveBrokers":
                        // interactiveBrokers
                        com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods();
                        break;
                    case "kite":
                        // kiteConnect
                        com.example.nctai_trading.kiteConnect.KiteConnect kiteConnect = new KiteConnect("");
                        break;
                    case "kraken":
                        // kraken
                        com.example.nctai_trading.kraken.KrakenApi krakenApi = new KrakenApi();
                        break;
                    case "wbf":
                        // wbf
                        com.example.nctai_trading.wbf.wbfMethods wbfMethods = new wbfMethods();
                        break;
                }
            }
            catch(Exception e){
            }
        }
        orders = database.getCollection("pastOrders");
        //BasicDBObject objectIdQuery = new BasicDBObject();
        //long amount = coll.count();

        //for(long i = 0; i < amount; i++){
        //    FindIterable<Document> documents = coll.find();
        //    for(Document doc: documents){
        //        ObjectId objectId = doc.getObjectId("_id");
        //        objectIdQuery.put("_id",objectId);
        //        FindIterable<Document> exchangeDocuments = orders.find(objectIdQuery);
        //        for(Document docs: exchangeDocuments){
        //            if(docs.getObjectId("_id").equals(objectId)){
        //
        //            }
        //        }
        //    }
        //}
        //FindIterable<Document> emailID = coll.find(emailQuery);
        //Document emailResult = emailID.first();
    }


}
