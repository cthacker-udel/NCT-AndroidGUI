package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class coinBaseProPage extends AppCompatActivity {

    Button coinBaseProAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_base_pro_page);

        coinBaseProAccountBtn = findViewById(R.id.coinBaseProAccountDetails);

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String coinBaseApiKey = sharedPreferences.getString("coinBaseApiKey","defaultCoinBaseApiKey");

        String coinBaseSecretKey = sharedPreferences.getString("coinBaseSecretKey","defaultCoinBaseSecretKey");

        String passPhrase = sharedPreferences.getString("coinBasePassPhrase","defaultCoinBasePassPhrase");

        coinBaseProAccountBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                coinbaseProMethods methods = new coinbaseProMethods(coinBaseApiKey,coinBaseSecretKey,passPhrase);
                try {
                    methods.getAccount();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}