package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

                try {
                    validationRequests.singleEmailValidationPOST("cthacker@udel.edu");
                    messageRequests.sendMessage("cthacker@udel.edu","NCT <Noreply@sales.nextcapitaltech.com>","Message",methods.generateCode());
                    //domainRequests.getDomainsUnderAccount();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent backToMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(backToMainPage);
            }
        });
    }
}