package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paymentOptionPage extends AppCompatActivity {

    Button termsOfServiceBtn;
    Button backToHomePageBtn;

    // TODO: [PAYMENT OPTION PAGE] Implement check discount code button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by crypto button feature
    // TODO: [PAYMENT OPTION PAGE] Implement pay by card feature
    // TODO: [PAYMENT OPTION PAGE] Implement refresh payment status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option_page);
        termsOfServiceBtn = findViewById(R.id.paymentOptionTermsOfServiceBtn);
        backToHomePageBtn = findViewById(R.id.backToHomePageButton);
        termsOfServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTermsOfService = new Intent(getApplicationContext(),termsOfServicePage.class);
                startActivity(toTermsOfService);
            }
        });

        backToHomePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomePage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(toHomePage);
            }
        });
    }
}