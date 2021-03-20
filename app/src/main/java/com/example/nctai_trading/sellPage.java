package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class sellPage extends AppCompatActivity {

    Spinner sellCurrencyCurrencySpinner;
    Spinner sellCurrencyPageExchanges;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        sellCurrencyCurrencySpinner = findViewById(R.id.sellCurrencySpinner);

        sellCurrencyPageExchanges = findViewById(R.id.sellPageExchangeSpinner);

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



    }
}