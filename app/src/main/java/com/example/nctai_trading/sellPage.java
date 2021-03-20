package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.stream.IntStream;

public class sellPage extends AppCompatActivity {

    Spinner sellCurrencyCurrencySpinner;
    Spinner sellCurrencyPageExchanges;
    Spinner sellCurrencyAmount;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        sellCurrencyCurrencySpinner = findViewById(R.id.sellCurrencySpinner2);

        sellCurrencyPageExchanges = findViewById(R.id.sellPageExchangeSpinner);

        sellCurrencyAmount = findViewById(R.id.sellCurrencySpinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("---- select currency ----");
        exchangesList exchangesList = new exchangesList();
        currencyInfo currencyInfo = new currencyInfo();
        adapter.addAll(currencyInfo.currencyList().keySet().stream().toArray(String[]::new));

        sellCurrencyCurrencySpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter2.add("---- select exchange ----");
        adapter2.addAll(exchangesList.getExchangesList());

        sellCurrencyPageExchanges.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter3.addAll(IntStream.range(1,999).mapToObj(String::valueOf).toArray(String[]::new));

        sellCurrencyAmount.setAdapter(adapter3);



    }
}