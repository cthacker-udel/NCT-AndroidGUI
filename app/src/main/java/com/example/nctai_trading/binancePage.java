package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;

import java.util.HashMap;
import java.util.List;

public class binancePage extends AppCompatActivity {

    Button binancePageSignInBtn;

    private HashMap<String,String> currencies;

    String[] currenciesNames;

    AutoCompleteTextView displayCurrencyAmountAndQuantity;

    Button displayPriceAndQuantity;

    BinanceApiRestClient client;

    boolean userSignedIn;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_page);

        currencies = currencyInfo.currencyList();

        currenciesNames = currencies.values().stream().toArray(String[]::new);

        displayCurrencyAmountAndQuantity = findViewById(R.id.binancePageAutoCompletePriceQuantity);
        binancePageSignInBtn = findViewById(R.id.binancePageSignInBtn);
        displayPriceAndQuantity = findViewById(R.id.binancePagePriceAndQuantity);

        AlertDialog.Builder currencyError = new AlertDialog.Builder(this);

        currencyError.setTitle("Currency Error");

        currencyError.setMessage("Currency error");

        userSignedIn = false;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,currenciesNames);

        displayCurrencyAmountAndQuantity.setAdapter(adapter);

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");


        binancePageSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secretKey);
                    client = factory.newRestClient();

                    // test client

                    client.ping();
                    System.out.println(client.getServerTime());
                    binancePageSignInBtn.setText("Login Success!");
            }
        });

        displayPriceAndQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autoCompletePriceAndQuantityText = displayCurrencyAmountAndQuantity.getText().toString().toLowerCase();
                try{
                    String formattedAutoCompletePriceAndQuantityText = autoCompletePriceAndQuantityText.substring(0,1).toUpperCase() + autoCompletePriceAndQuantityText.substring(1);
                    if(!currencies.values().contains(formattedAutoCompletePriceAndQuantityText)){
                        currencyError.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(binancePage.this,"Currency error",Toast.LENGTH_SHORT).show();
                            }
                        });
                        currencyError.setCancelable(true);
                        currencyError.create().show();
                        return;
                    }
                    else{
                        OrderBook orderBook = client.getOrderBook(currencies.get(formattedAutoCompletePriceAndQuantityText),10);
                        List<OrderBookEntry> asks = orderBook.getAsks();
                        OrderBookEntry firstAskEntry = asks.get(0);
                        System.out.println(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    }
                }
                catch(Exception e){
                    return;
                }
            }
        });


    }
}