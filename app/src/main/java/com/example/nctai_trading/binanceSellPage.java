package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class binanceSellPage extends AppCompatActivity {

    Button sellBtn;
    Spinner sellSpinner;
    Spinner withSpinner;
    Spinner sellAmountSpinner;
    Button updateSellAmountButton;
    TreeMap<String,String> currencies;
    String[] currenciesNames;
    String selectedCurrencySell;
    String selectedCurrencyWith;
    long selectedAmount;
    double valueOfSelectedSell;
    double valueOfSelectedWith;


    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_sell_page);
        // button
        sellBtn = findViewById(R.id.binanceSellPageSellButton);
        updateSellAmountButton = findViewById(R.id.binanceSellPageUpdateAmountSpinnerButton);
        // spinner
        sellSpinner = findViewById(R.id.binanceSellPageScroller); // left
        withSpinner = findViewById(R.id.binanceSellPageScroller2); // right
        sellAmountSpinner = findViewById(R.id.binanceSellPageAmountSpinner);

        // get currency list
        currencies = currencyInfo.currencyList();

        currenciesNames = currencies.keySet().stream().toArray(String[]::new);

        // alert dialog

        AlertDialog.Builder selectedCurrencyError = new AlertDialog.Builder(binanceSellPage.this);
        selectedCurrencyError.setTitle("Selected Currency Error");
        selectedCurrencyError.setMessage("Left box value error");

        // SHARED PREFERENCES

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        binanceMethods methods = new binanceMethods(apiKey,secretKey);

        try {
            HashMap<String,String> finalOrders = methods.tempGenerateAccountInformation();
            HashMap<String,String> accountInfo = (HashMap<String,String>)finalOrders.keySet().stream().parallel().filter(e -> Double.parseDouble(finalOrders.get(e)) > 0).collect(Collectors.toMap(e -> e, finalOrders::get));

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // update amount spinner

        ArrayAdapter<Long> amountAdapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line);
        amountAdapter.add((long) 0);
        sellAmountSpinner.setAdapter(amountAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line);
        adapter.add("------ select currency ------");

        adapter.addAll(currenciesNames);

        sellSpinner.setAdapter(adapter);
        withSpinner.setAdapter(adapter);

        sellAmountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAmount = (long)sellAmountSpinner.getSelectedItem();
                // how many tether can we get for 1 BTC -> BTCUSDT?
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceSellPage.this,"Please select an amount",Toast.LENGTH_SHORT).show();
            }
        });

        updateSellAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountAdapter.clear();
                amountAdapter.add((long)0);
                PriceTicker priceTicker = null;
                binanceMethods methods = new binanceMethods(apiKey,secretKey);
                if(selectedCurrencySell.equals("------ select currency ------") || selectedCurrencyWith.equals("------ select currency ------")){
                    Toast.makeText(binanceSellPage.this,"Please enter two currencies",Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    priceTicker = methods.getPriceTicker(selectedCurrencySell,selectedCurrencyWith);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(priceTicker == null){
                    Toast.makeText(binanceSellPage.this,"Please swap currencies",Toast.LENGTH_SHORT).show();
                    return;
                }
                long amt = Long.parseLong(priceTicker.getPrice());
                LongStream.range(1,amt).forEach(amountAdapter::add);
                sellAmountSpinner.setAdapter(amountAdapter);
                // use ticker to calucalte -> LTCBTC = 4 LTC TO 1 BTC (result is 4.08888)
            }
        });

        sellSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrencySell = sellSpinner.getSelectedItem().toString();
                if(!selectedCurrencySell.equals("------ select currency ------")){
                    try {
                        valueOfSelectedSell = methods.getPriceOfOne(currencies.get(selectedCurrencySell) + "USD");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceSellPage.this,"Please select a currency", Toast.LENGTH_SHORT).show();
            }
        });

        withSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrencyWith = withSpinner.getSelectedItem().toString();
                if(!selectedCurrencyWith.equals("------ select currency ------")){
                    try {
                        valueOfSelectedWith = methods.getPriceOfOne(currencies.get(selectedCurrencyWith) + "USD");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceSellPage.this,"Please select a currency",Toast.LENGTH_SHORT).show();
            }
        });

        sellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> sellResult = new ArrayList<>();
                if(selectedCurrencySell.equals("------ select currency ------")){
                    selectedCurrencyError.create().show();
                    return;
                }
                if(selectedCurrencyWith.equals("------ select currency ------")){
                    selectedCurrencyError.setMessage("Right box error").create().show();
                    return;
                }
                if(selectedAmount == 0){
                    selectedCurrencyError.setMessage("Amount error").create().show();
                    return;
                }
                binanceMethods.sellCurrency sellCurrencyMethods = methods.new sellCurrency(apiKey,secretKey);
                try {
                     sellResult = sellCurrencyMethods.baseSale(currencies.get(selectedCurrencySell) + currencies.get(selectedCurrencyWith),1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                System.out.println(sellResult);
            }
        });



    }
}