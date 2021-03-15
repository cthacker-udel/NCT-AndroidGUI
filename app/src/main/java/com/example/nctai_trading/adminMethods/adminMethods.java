package com.example.nctai_trading.adminMethods;

import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;
import com.example.nctai_trading.bidesk.BrokerApiClientFactory;
import com.example.nctai_trading.bidesk.BrokerApiRestClient;
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(String eachString: listOfAllExchanges){
            try{
                // alpaca
                    com.example.nctai_trading.alpaca.alpacaMethods methods = new alpacaMethods();
                // basefex
                    com.example.nctai_trading.basefex.basefexMethods basefexMethods = new basefexMethods();
                // bibox
                com.example.nctai_trading.bibox.BiBoxHttpClientConfig client = new BiBoxHttpClientConfig.Builder().apiKey("").secret("").build();
                BiBoxHttpClient biBoxHttpClient = new BiBoxHttpClient(client);
                // bidesk
                com.example.nctai_trading.bidesk.BrokerApiClientFactory brokerApiClientFactory = new BrokerApiClientFactory("https://api.bidesk.com/","","");
                BrokerApiRestClient restClient = brokerApiClientFactory.newRestClient();
                // bilaxy
                com.example.nctai_trading.bilaxy.bilaxyMethods bilaxyMethods = new bilaxyMethods();
                // binance
                com.example.nctai_trading.binance.binanceMethods binanceMethods = new binanceMethods();
                // binanceUS
                com.example.nctai_trading.binanceUS.binanceMethods binanceMethods1 = new com.example.nctai_trading.binanceUS.binanceMethods();
                // bitcoincom
                com.example.nctai_trading.bitcoincom.bitcoincomMethods bitcoincomMethods = new bitcoincomMethods();
                // bitforex
                com.example.nctai_trading.bitforex.bitforexMethods bitforexMethods = new bitforexMethods();
                // bithumb
                com.example.nctai_trading.bithumb.bithumbMethods bithumbMethods = new bithumbMethods("","");
                // bitMEX
                com.example.nctai_trading.bitMEX.bitmexMethods bitmexMethods = new bitmexMethods();
                // bitrue
                com.example.nctai_trading.bitrue.bitrueMethods bitrueMethods = new bitrueMethods();
                //bittrex
                com.example.nctai_trading.bittrex.BittrexExchange bittrexExchange = new BittrexExchange();
                //  bkex
                com.example.nctai_trading.bkex.bkexMethods bkexMethods = new bkexMethods();
                // btse
                com.example.nctai_trading.btse.btseMethods btseMethods = new btseMethods();
                // bybit
                com.example.nctai_trading.bybit.bybitMethods bybitMethods = new bybitMethods();
                // coinbasePro
                com.example.nctai_trading.coinbasePro.coinbaseProMethods coinbaseProMethods = new coinbaseProMethods("","","");
                // digifinex
                com.example.nctai_trading.digifinex.digifinexMethods digifinexMethods = new digifinexMethods();
                // exante
                com.example.nctai_trading.exante.exanteMethods exanteMethods = new exanteMethods();
                // huobiApi
                com.example.nctai_trading.huobiApi2.api.HbdmswapRestApiV1 hbdmswapRestApiV1 = new HbdmswapRestApiV1("baseurl","","");
                // idcm
                com.example.nctai_trading.idcm.idcmMethods idcmMethods = new idcmMethods();
                // interactiveBrokers
                com.example.nctai_trading.interactiveBrokers.interactiveBrokersMethods interactiveBrokersMethods = new interactiveBrokersMethods();
                // kiteConnect
                com.example.nctai_trading.kiteConnect.KiteConnect kiteConnect = new KiteConnect("");
                // kraken
                com.example.nctai_trading.kraken.KrakenApi krakenApi = new KrakenApi();
                // wbf
                com.example.nctai_trading.wbf.wbfMethods wbfMethods = new wbfMethods();
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
