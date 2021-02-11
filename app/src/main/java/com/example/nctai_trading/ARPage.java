package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.mailgun.mailGunMethods;

import java.io.IOException;

public class ARPage extends AppCompatActivity {

    Button ARButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r_page);
        ARButton = findViewById(R.id.ARPageButton);

        ARButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                com.example.nctai_trading.mailgun.mailGunMethods methods = new com.example.nctai_trading.mailgun.mailGunMethods();

                mailGunMethods.messageRequests messageRequests = methods.new messageRequests();
                mailGunMethods.domainRequests domainRequests = methods.new domainRequests();
                mailGunMethods.validationRequests validationRequests = methods.new validationRequests();

                com.example.nctai_trading.alpaca.alpacaMethods alpacaMethods = new com.example.nctai_trading.alpaca.alpacaMethods();

                com.example.nctai_trading.alpaca.alpacaMethods.accountReqeusts accountMethods = alpacaMethods.new accountReqeusts();
                com.example.nctai_trading.alpaca.alpacaMethods.orderRequests orderRequests = alpacaMethods.new orderRequests();
                com.example.nctai_trading.alpaca.alpacaMethods.positionRequests positionRequests = alpacaMethods.new positionRequests();
                try {
                    //accountMethods.getAccount();
                    //orderRequests.getListOfOrders();
                    //orderRequests.placeOrder("AAPL",20,"buy","market","gtc");
                    orderRequests.getOrderOrderId("db2c0948-7815-4085-8958-5e00f56e2faa");
                    positionRequests.getOpenPositions();
                    positionRequests.getOpenPosition("YUM");
                } catch (IOException e) {
                    e.printStackTrace();
                }


                //validationRequests.singleEmailValidationPOST("cthacker@udel.edu");
                    //messageRequests.sendMessage("cthacker@udel.edu","NCT <Noreply@sales.nextcapitaltech.com>","Message",methods.generateCode());
                    //domainRequests.getDomainsUnderAccount();


                Intent backToMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(backToMainPage);
            }
        });
    }
}