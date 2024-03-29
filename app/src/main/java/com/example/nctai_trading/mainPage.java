package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.nctai_trading.Controller.ARPage;
import com.example.nctai_trading.Controller.addKeys;
import com.example.nctai_trading.Controller.alternateInvestments;
import com.example.nctai_trading.Controller.binancePage;
import com.example.nctai_trading.Controller.donationPage;
import com.example.nctai_trading.coinbasePro.coinBaseProPage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainPage extends AppCompatActivity {

    private static final String CHANNEL_ID = "exampleServiceChannel";
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
    Button addKeysBtn;
    int userContainsKeysError;
    boolean userContainsBinanceKeysError;
    boolean userContainsCoinBaseKeysError;
    static AlarmManager alarmManager;


    //String passedEmail = getIntent().getStringExtra("email");

    // TODO: [MAIN PAGE] Implement sign/stop listening functionality
    // TODO: [MAIN PAGE] Implement edit credentials -

    

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String CHANNEL_ID = "exampleServiceChannel";

        Intent start_alarm = new Intent(mainPage.this,MyBroadcastReceivcer.class);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        setContentView(R.layout.activity_main_page);

        paymentOptionBtn = findViewById(R.id.mainPagePaymentOptionButton);
        donationBtn = findViewById(R.id.donationButton);
        altInvestmentBtn = findViewById(R.id.alternateInvestmentButton);
        mainPageARBtn = findViewById(R.id.mainPageARButton);
        mainPageBinanceSignInBtn = findViewById(R.id.mainPageBinanceSignIn);
        mainPageListeningBtn = findViewById(R.id.mainPageStartStopListening);
        mainPageCoinBaseProBtn = findViewById(R.id.mainPageCoinBaseProSignInButton);
        addKeysBtn = findViewById(R.id.mainPageAddKeys);

        // show image


        imageView = findViewById(R.id.nctLogoMainPage);
        imageView.isShown();

        // set alarm manager

        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

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
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                alarmManager  = (AlarmManager)getSystemService(ALARM_SERVICE);
                createNotificationChannel();
                startService();
            }
        });

        donationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDonationPage = new Intent(getApplicationContext(), donationPage.class);
                startActivity(toDonationPage);
            }
        });

        altInvestmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAlternateInvestmentPage = new Intent(getApplicationContext(), alternateInvestments.class);
                startActivity(toAlternateInvestmentPage);
            }
        });

        mainPageARBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toARPage = new Intent(getApplicationContext(), ARPage.class);
                startActivity(toARPage);
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
        addKeysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddKeysPage = new Intent(getApplicationContext(), addKeys.class);
                startActivity(toAddKeysPage);
            }
        });


    }
    public SharedPreferences getThePreferences(){
        return getSharedPreferences("test",MODE_PRIVATE);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        NotificationChannel serviceChannel = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            serviceChannel = new NotificationChannel(CHANNEL_ID,"Example Service Channel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(serviceChannel);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startService(){
        String exampleText = "Hello there";
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent start_alarm = new Intent(mainPage.this,MyBroadcastReceivcer.class);
        start_alarm.putExtra("prefix","test");
        start_alarm.setAction("ALARM_START");
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,start_alarm,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,pi);
        System.out.println("Broadcast fired");




        //Intent serviceIntent2 = new Intent(this,particleIntentService.class);
        //Intent serviceIntent2 = new Intent(this,exampleIntentService.class);
        //PendingIntent pendingIntent = PendingIntent.getService(this,0,serviceIntent2,0);
        //alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,System.currentTimeMillis(),3000,pendingIntent);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),60000L,pendingIntent);
        //startForegroundService(serviceIntent2);

        //startService(serviceIntent);
    }

    public void setAlarm(Context context){
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    }

    public void stopService(){
        Intent serviceIntent = new Intent(this,particleService.class);
        stopService(serviceIntent);
    }
}