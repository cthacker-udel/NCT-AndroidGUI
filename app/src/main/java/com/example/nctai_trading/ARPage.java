package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.binanceUS.binanceMethods;
import com.example.nctai_trading.bitMEX.bitmexMethods;
import com.example.nctai_trading.bitcoincom.bitcoincomMethods;
import com.example.nctai_trading.bitforex.bitforexMethods;
import com.example.nctai_trading.bitrue.bitrueMethods;
import com.example.nctai_trading.bkex.bkexMethods;
import com.example.nctai_trading.bybit.bybitMethods;
import com.example.nctai_trading.digifinex.digifinexMethods;
import com.example.nctai_trading.huobiApi.huobiMethods;
import com.example.nctai_trading.idcm.idcmMethods;
import com.example.nctai_trading.mailgun.mailGunMethods;
import com.example.nctai_trading.particle.particleMethods;
import com.example.nctai_trading.wbf.wbfMethods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ARPage extends AppCompatActivity {

    Button ARButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r_page);
        ARButton = findViewById(R.id.ARPageButton);

        ARButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                com.example.nctai_trading.bkex.bkexMethods bkexMethods = new com.example.nctai_trading.bkex.bkexMethods();

                com.example.nctai_trading.bitcoincom.bitcoincomMethods bitcoincomMethods = new com.example.nctai_trading.bitcoincom.bitcoincomMethods();

                com.example.nctai_trading.wbf.wbfMethods wbfMethods = new com.example.nctai_trading.wbf.wbfMethods();

                com.example.nctai_trading.idcm.idcmMethods idcmMethods = new com.example.nctai_trading.idcm.idcmMethods();

                com.example.nctai_trading.bitforex.bitforexMethods bitforexMethods = new com.example.nctai_trading.bitforex.bitforexMethods();

                com.example.nctai_trading.bitrue.bitrueMethods bitrueMethods = new com.example.nctai_trading.bitrue.bitrueMethods();

                com.example.nctai_trading.bitrue.bitrueMethods.serverRequests serverRequests = bitrueMethods.new serverRequests();

                bitrueMethods.marketDataRequests bitrueMarketDataRequests = bitrueMethods.new marketDataRequests();

                com.example.nctai_trading.bitrue.bitrueMethods.orderRequests bitrueOrderRequests = bitrueMethods.new orderRequests();

                com.example.nctai_trading.bybit.bybitMethods bitbymethods = new com.example.nctai_trading.bybit.bybitMethods();

                bybitMethods.orderRequests bitbyorderRequests = bitbymethods.new orderRequests();

                com.example.nctai_trading.digifinex.digifinexMethods digifinexMethods = new digifinexMethods();

                com.example.nctai_trading.digifinex.digifinexMethods.orderRequests digiOrderRequests = digifinexMethods.new orderRequests();

                com.example.nctai_trading.idcm.idcmMethods.orderRequests idcmOrderRequests = idcmMethods.new orderRequests();

                com.example.nctai_trading.wbf.wbfMethods.transactionRequests transactionRequests = wbfMethods.new transactionRequests();

                com.example.nctai_trading.bitcoincom.bitcoincomMethods.orderRequests bitcoincomOrderRequests = bitcoincomMethods.new orderRequests();

                com.example.nctai_trading.bkex.bkexMethods.exchangeRequests bkexExchangeRequests = bkexMethods.new exchangeRequests();

                com.example.nctai_trading.bkex.bkexMethods.orderRequests bkexOrderRequests = bkexMethods.new orderRequests();

                try {
                    bkexOrderRequests.getAllFinishedOrders();
                    bkexOrderRequests.createOrder("ETH_USDT",1.0,2.0);
                    bkexExchangeRequests.getExchangeInfo();
                    bitcoincomOrderRequests.placeOrder("eth","buy","market",10);
                    transactionRequests.getTransactionRecords("BTC");
                    idcmOrderRequests.placeOrder("BTC-USDT",1,1,1,1,10);
                    digiOrderRequests.placeOrder("usdt_btc","buy",6000.12,0.1);
                    bitbyorderRequests.placeOrder("Buy","BTCUSD","Market","10","GoodTillCancel","false","false");
                    bitrueOrderRequests.placeOrder("LTCBTC","BUY","MARKET",1);
                    bitrueMarketDataRequests.getMarketDataEndpoints("LTCBTC");
                    serverRequests.getServerTime();
                    serverRequests.getExchangeInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }

                Map<String,Object> testParams = new HashMap<>();

                testParams.put("price",1000);
                testParams.put("amount",1);
                testParams.put("tradeType",1);
                testParams.put("symbol","coin-usd-eth");
                testParams.put("nonce",1501234567890L);

                bitforexMethods.generateSignaturePOST("/api/v1/trade/placeOrder",testParams);

                com.example.nctai_trading.bitforex.bitforexMethods.symbolRequests symbolRequests = bitforexMethods.new symbolRequests();

                com.example.nctai_trading.bitforex.bitforexMethods.tickerRequests tickerRequests = bitforexMethods.new tickerRequests();

                com.example.nctai_trading.bitforex.bitforexMethods.orderRequests forexOrderRequests = bitforexMethods.new orderRequests();


                try {
                    //forexOrderRequests.placeOrder("coin-usd-eth",1000.0,1.0,1);
                    tickerRequests.getTickerInformation("coin-usd-eth");
                    symbolRequests.getSymbolInformation();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                com.example.nctai_trading.mailgun.mailGunMethods methods = new com.example.nctai_trading.mailgun.mailGunMethods();

                com.example.nctai_trading.binanceUS.binanceMethods binanceMethods = new com.example.nctai_trading.binanceUS.binanceMethods();

                com.example.nctai_trading.huobiApi.huobiMethods huobiMethods = new com.example.nctai_trading.huobiApi.huobiMethods();

                mailGunMethods.messageRequests messageRequests = methods.new messageRequests();
                mailGunMethods.domainRequests domainRequests = methods.new domainRequests();
                mailGunMethods.validationRequests validationRequests = methods.new validationRequests();

                com.example.nctai_trading.alpaca.alpacaMethods alpacaMethods = new com.example.nctai_trading.alpaca.alpacaMethods();
                com.example.nctai_trading.basefex.basefexMethods basefexMethods = new com.example.nctai_trading.basefex.basefexMethods();
                com.example.nctai_trading.particle.particleMethods particleMethods = new com.example.nctai_trading.particle.particleMethods();
                com.example.nctai_trading.bitMEX.bitmexMethods bitmexMethods = new com.example.nctai_trading.bitMEX.bitmexMethods();

                com.example.nctai_trading.bitMEX.bitmexMethods.announcementRequests announcementMethods = bitmexMethods.new announcementRequests();
                com.example.nctai_trading.alpaca.alpacaMethods.accountReqeusts accountMethods = alpacaMethods.new accountReqeusts();
                com.example.nctai_trading.alpaca.alpacaMethods.orderRequests orderRequests = alpacaMethods.new orderRequests();
                com.example.nctai_trading.alpaca.alpacaMethods.positionRequests positionRequests = alpacaMethods.new positionRequests();
                com.example.nctai_trading.alpaca.alpacaMethods.assetRequests assetRequests = alpacaMethods.new assetRequests();
                com.example.nctai_trading.basefex.basefexMethods.accountRequests accountRequests = basefexMethods.new accountRequests();
                com.example.nctai_trading.basefex.basefexMethods.ordersRequests ordersRequests = basefexMethods.new ordersRequests();

                com.example.nctai_trading.particle.particleMethods.eventRequests eventRequests = particleMethods.new eventRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.apiKeyRequests apiMethods = bitmexMethods.new apiKeyRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.executionRequests executionRequests = bitmexMethods.new executionRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.fundingRequests fundingRequests = bitmexMethods.new fundingRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.globalNotificationsRequests globalNotificationsRequests = bitmexMethods.new globalNotificationsRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.announcementRequests announcementRequests = bitmexMethods.new announcementRequests();
                com.example.nctai_trading.bitMEX.bitmexMethods.instrumentRequests instrumentRequests = bitmexMethods.new instrumentRequests();

                com.example.nctai_trading.huobiApi.huobiMethods.marketDataRequests marketDataRequests = huobiMethods.new marketDataRequests();


                binanceMethods.buyCurrency binanceBuyRequests = binanceMethods.new buyCurrency();

                try {
                    //accountRequests.countTransactions();
                    //ordersRequests.placeOrder(1000,"BTCUSD","MARKET","BUY");
                    //List<Map<String,Object>> orderList = new LinkedList<Map<String,Object>>();
                    //Map<String,Object> orders = new HashMap<>();
                    //orders.put("price",11234);
                    //orders.put("size",200);
                    //orders.put("side","BUY");
                    //orderList.add(orders);
                    //ordersRequests.placeOrderInBatches("BTCUSD",orderList);
                    //ordersRequests.getActiveOrderList("BTCUSD","10");
                    marketDataRequests.getKLineData("BTC-USD","1min");
                    marketDataRequests.getMarketDepth("BTC-USD","step5");
                    marketDataRequests.getSwapOpenInterest();
                    marketDataRequests.getMarketData();
                    marketDataRequests.getSwapIndexPriceInfo();
                    marketDataRequests.getSwapPriceLimitation("BTC-USD");
                    binanceBuyRequests.buyLimitOrder("BNBBTC",100,"0.00001");
                    binanceBuyRequests.baseBuy("BTCUSDT",10);
                    announcementMethods.getAnnouncement();
                    fundingRequests.getFunding();
                    globalNotificationsRequests.getGlobalNotifications();
                    instrumentRequests.getCompositeIndex("XBL");
                    eventRequests.openStreamOfServerEvents("event1");
                    eventRequests.publishAnEvent("event1");
                    //eventRequests.openStreamOfServerEvents("String_msg_from_RL");
                    fundingRequests.getFunding();
                    executionRequests.getExecutionTradeHistory();
                    apiMethods.getApiKeys();
                    announcementMethods.getUrgentAnnouncement();

                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                //accountMethods.getAccount();
                    //orderRequests.getListOfOrders();
                    //orderRequests.placeOrder("AAPL",20,"buy","market","gtc");
                    //orderRequests.getOrderOrderId("db2c0948-7815-4085-8958-5e00f56e2faa");
                    //positionRequests.getOpenPositions();
                    //positionRequests.getOpenPosition("YUM");
                    //assetRequests.getAssets();
                    //assetRequests.getAsset("AAT");



                //validationRequests.singleEmailValidationPOST("cthacker@udel.edu");
                    //messageRequests.sendMessage("cthacker@udel.edu","NCT <Noreply@sales.nextcapitaltech.com>","Message",methods.generateCode());
                    //domainRequests.getDomainsUnderAccount();


                Intent backToMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(backToMainPage);
            }
        });
    }
}