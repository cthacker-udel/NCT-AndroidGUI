package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class mainPage extends AppCompatActivity {

    Button paymentOptionBtn;
    Button donationBtn;
    Button altInvestmentBtn;
    ImageView imageView;
    Button mainPageSignInBtn;
    Button mainPageARBtn;
    //String passedEmail = getIntent().getStringExtra("email");

    // TODO: [MAIN PAGE] Implement sign/stop listening functionality
    // TODO: [MAIN PAGE] Implement edit credentials -

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        paymentOptionBtn = findViewById(R.id.mainPagePaymentOptionButton);
        donationBtn = findViewById(R.id.donationButton);
        altInvestmentBtn = findViewById(R.id.alternateInvestmentButton);
        mainPageSignInBtn = findViewById(R.id.mainPageSignInButton);
        mainPageARBtn = findViewById(R.id.mainPageARButton);

        paymentOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPaymentOptionPage = new Intent(getApplicationContext(),paymentOptionPage.class);
                startActivity(toPaymentOptionPage);
            }
        });

        mainPageSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        donationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDonationPage = new Intent(getApplicationContext(),donationPage.class);
                startActivity(toDonationPage);
            }
        });

        altInvestmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAlternateInvestmentPage = new Intent(getApplicationContext(),alternateInvestments.class);
                startActivity(toAlternateInvestmentPage);
            }
        });

        mainPageARBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toARPage = new Intent(getApplicationContext(),ARPage.class);
                startActivity(toARPage);
            }
        });

        imageView = findViewById(R.id.nctLogoMainPage);
        imageView.isShown();
    }
}