package com.example.nctai_trading.coinbasePro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nctai_trading.R;

public class coinBaseProPage extends AppCompatActivity {

    Button coinbaseProBuyButton;
    Button coinbaseProSellButton;
    Button coinbaseProAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_base_pro_page);

        coinbaseProBuyButton = findViewById(R.id.coinbaseProBuyButton);
        coinbaseProSellButton = findViewById(R.id.coinbaseProSellBtn);
        coinbaseProAccountButton = findViewById(R.id.coinbaseProAccountBtn);

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String coinBaseApiKey = sharedPreferences.getString("coinBaseApiKey","defaultCoinBaseApiKey");

        String coinBaseSecretKey = sharedPreferences.getString("coinBaseSecretKey","defaultCoinBaseSecretKey");

        String passPhrase = sharedPreferences.getString("coinBasePassPhrase","defaultCoinBasePassPhrase");

        coinbaseProBuyButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                /*
                coinbaseProMethods methods = new coinbaseProMethods(coinBaseApiKey,coinBaseSecretKey,passPhrase);
                try {
                    methods.getAccount("86995fbe-8a22-4647-b1a4-0b0a34e7a16c");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                coinbaseProMethods.buyCurrency buyCurrencyMethods = methods.new buyCurrency(coinBaseApiKey,coinBaseSecretKey,passPhrase);
                try {
                    buyCurrencyMethods.placeOrderMarket(BigDecimal.valueOf(5),"BTC",null);
                    //buyCurrencyMethods.placeOrdermarket(new BigDecimal("1.0"), new BigDecimal("1.0"), "BTC", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 */
            }
        });
    }
}