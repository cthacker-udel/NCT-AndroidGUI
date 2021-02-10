package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            @Override
            public void onClick(View v) {

                com.example.nctai_trading.mailgun.mailGunMethods methods = new com.example.nctai_trading.mailgun.mailGunMethods();

                mailGunMethods.messageRequests messageRequests = methods.new messageRequests();

                try {
                    messageRequests.sendMessage("cthacker@udel.edu","sales.nextcapitaltech.com","Message","This should contain a message");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent backToMainPage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(backToMainPage);
            }
        });
    }
}