package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sqip.Card;
import sqip.CardDetails;
import sqip.CardEntry;

public class paymentOptionPage extends AppCompatActivity {

    Button termsOfServiceBtn;
    Button backToHomePageBtn;
    Button payByCardBtn;

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
        payByCardBtn = findViewById(R.id.payByCardBtn);
        termsOfServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTermsOfService = new Intent(getApplicationContext(),termsOfServicePage.class);
                startActivity(toTermsOfService);
            }
        });

        payByCardBtn.setOnClickListener((view) ->
        {
            CardEntry.startCardEntryActivity(paymentOptionPage.this,true,
            CardEntry.DEFAULT_CARD_ENTRY_REQUEST_CODE);
        });

        backToHomePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomePage = new Intent(getApplicationContext(),mainPage.class);
                startActivity(toHomePage);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CardEntry.handleActivityResult(data,result -> {
            if(result.isSuccess()){
                CardDetails cardResult = result.getSuccessValue();
                Card card = cardResult.getCard();
                String nonce = cardResult.getNonce();
            }
            else if(result.isCanceled()){
                Toast.makeText(paymentOptionPage.this,"Canceled",Toast.LENGTH_SHORT).show();
            }
        });

    }
}