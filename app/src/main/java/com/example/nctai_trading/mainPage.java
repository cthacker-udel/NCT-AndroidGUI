package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.nctai_trading.binanceUS.binanceKeys;
import com.example.nctai_trading.binanceUS.binancePage;
import com.example.nctai_trading.coinbasePro.coinBaseKeys;
import com.example.nctai_trading.coinbasePro.coinBaseProPage;
import com.example.nctai_trading.particle.particleMethods;

import java.io.IOException;

public class mainPage extends AppCompatActivity {

    Button paymentOptionBtn;
    Button donationBtn;
    Button altInvestmentBtn;
    ImageView imageView;
    Button mainPageARBtn;
    Button mainPageBinanceKeys;
    Button mainPageBinanceSignInBtn;
    Button mainPageListeningBtn;
    Button mainPageCoinbaseKeys;
    Button mainPageCoinBaseProBtn;
    int userContainsKeysError;
    boolean userContainsBinanceKeysError;
    boolean userContainsCoinBaseKeysError;

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
        mainPageARBtn = findViewById(R.id.mainPageARButton);
        mainPageBinanceKeys = findViewById(R.id.mainPageBinanceKeysButton);
        mainPageBinanceSignInBtn = findViewById(R.id.mainPageBinanceSignIn);
        mainPageListeningBtn = findViewById(R.id.mainPageStartStopListening);
        mainPageCoinbaseKeys = findViewById(R.id.coinBaseKeysButton2);
        mainPageCoinBaseProBtn = findViewById(R.id.mainPageCoinBaseProSignInButton);

        // show image


        imageView = findViewById(R.id.nctLogoMainPage);
        imageView.isShown();

        // alert dialog

        AlertDialog.Builder userContainsApiKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsSecretKey = new AlertDialog.Builder(this);

        AlertDialog.Builder userContainsApiKeyAndSecretKey = new AlertDialog.Builder(this);

        userContainsApiKey.setTitle("Api Key Error");

        userContainsSecretKey.setTitle("Secret Key Error");

        userContainsApiKeyAndSecretKey.setTitle("Api key & Secret key error");

        userContainsApiKey.setMessage("Please set Api Key : Enter Binance Keys -> Api Key -> Close and Apply");

        userContainsSecretKey.setMessage("Please set Secret Key: Enter Binance Keys -> Secret Key -> Close and Apply");

        userContainsApiKeyAndSecretKey.setMessage("Please set Binance Secret Key and Api Key : Enter Binance Keys -> Secret Key & Api Key -> Close and Apply");

        // shared preferences

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        String coinBaseApiKey = sharedPreferences.getString("coinBaseApiKey","defaultCoinBaseApiKey");

        String coinBaseSecretKey = sharedPreferences.getString("coinBaseSecretKey","defaultCoinBaseSecretKey");

        String coinBasePassphrase = sharedPreferences.getString("coinBasePassPhrase","defaultCoinBasePassPhrase");

        // sign in double check to make sure they have a binance key, api key and the secret key, if one of them is wrong then throw a prompt

        paymentOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPaymentOptionPage = new Intent(getApplicationContext(),paymentOptionPage.class);
                startActivity(toPaymentOptionPage);
            }
        });

        mainPageListeningBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(apiKey.equals("defaultBinanceApiKey") || secretKey.equals("defaultBinanceSecretKey")){
                    userContainsKeysError++;
                    userContainsBinanceKeysError = true;
                }
                if(coinBaseApiKey.equals("defualtCoinBaseApiKey") || coinBaseSecretKey.equals("defaultCoinBaseSecretKey")){
                    userContainsKeysError++;
                    userContainsCoinBaseKeysError = true;
                }
                if(userContainsKeysError == 2){
                    Toast.makeText(mainPage.this,"Please add coinbase or binance api keys",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(userContainsKeysError == 1){
                    if(userContainsBinanceKeysError){
                        Toast.makeText(mainPage.this,"Please add binance api keys",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else{
                        Toast.makeText(mainPage.this,"Please add coinbase keys",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else{
                    com.example.nctai_trading.particle.particleMethods methods = new com.example.nctai_trading.particle.particleMethods();
                    particleMethods.eventRequests tokenMethods = methods.new eventRequests();
                    try {
                        tokenMethods.publishAnEvent("Event2");
                        tokenMethods.openStreamOfServerEvents("Event2");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    return;
                }

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

        mainPageBinanceKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBinanceKeysPage = new Intent(getApplicationContext(), binanceKeys.class);
                startActivity(toBinanceKeysPage);
            }
        });

        mainPageCoinbaseKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCoinBaseKeysPage = new Intent(getApplicationContext(), coinBaseKeys.class);
                startActivity(toCoinBaseKeysPage);
            }
        });

        mainPageBinanceSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(apiKey.equals("defaultBinanceApiKey") && secretKey.equals("defaultBinanceSecretKey")){
                    userContainsApiKeyAndSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mainPage.this,"Please set secret key and api key for binance",Toast.LENGTH_SHORT).show();
                        }
                    });
                    userContainsApiKeyAndSecretKey.setCancelable(true);
                    userContainsApiKeyAndSecretKey.create().show();
                    return;
                }
                if(apiKey.equals("defaultBinanceApiKey")){
                    userContainsApiKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mainPage.this,"Please set api key for binance",Toast.LENGTH_SHORT).show();
                        }
                    });
                    userContainsApiKey.setCancelable(true);
                    userContainsApiKey.create().show();
                    return;
                }
                if(secretKey.equals("defaultBinanceSecretKey")){
                    userContainsSecretKey.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mainPage.this,"Please set secret key for binance",Toast.LENGTH_SHORT).show();
                        }
                    });
                    userContainsSecretKey.setCancelable(true);
                    userContainsSecretKey.create().show();
                    return;
                }
                Intent toBinancePage = new Intent(getApplicationContext(), binancePage.class);
                startActivity(toBinancePage);
            }
        });
        mainPageCoinBaseProBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coinBaseApiKey.equals("defaultCoinBaseApiKey")){
                    Toast.makeText(mainPage.this,"Please enter coinbase api key",Toast.LENGTH_LONG).show();
                    return;
                }
                if(coinBaseSecretKey.equals("defaultCoinBaseSecretKey")){
                    Toast.makeText(mainPage.this,"Please enter coinbase secret key",Toast.LENGTH_LONG).show();
                    return;
                }
                if(coinBasePassphrase.equals("defaultCoinBasePassPhrase")){
                    Toast.makeText(mainPage.this,"Please enter coinbase passphrase",Toast.LENGTH_LONG).show();
                }
                Intent toCoinBaseProPage = new Intent(getApplicationContext(), coinBaseProPage.class);
                startActivity(toCoinBaseProPage);
            }
        });
    }
}