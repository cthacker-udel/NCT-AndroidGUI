package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class sellPage extends AppCompatActivity {

    Spinner sellCurrencyPage;
    Spinner buyCurrencyExchanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        sellCurrencyPage = findViewById(R.id.sellCurrencySpinner);

        buyCurrencyExchanges = findViewById(R.id.sellPageExchangeSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("---- select currency ----");
        exchangesList exchangesList = new exchangesList();
        adapter.addAll(exchangesList.getExchangesList());

    }
}