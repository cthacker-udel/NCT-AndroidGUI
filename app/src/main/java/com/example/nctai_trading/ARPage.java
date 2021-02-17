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
import com.example.nctai_trading.mailgun.mailGunMethods;
import com.example.nctai_trading.particle.particleMethods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
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

                com.example.nctai_trading.mailgun.mailGunMethods methods = new com.example.nctai_trading.mailgun.mailGunMethods();

                com.example.nctai_trading.binanceUS.binanceMethods binanceMethods = new com.example.nctai_trading.binanceUS.binanceMethods();

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