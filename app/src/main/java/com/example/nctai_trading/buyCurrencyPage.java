package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.nctai_trading.R;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class buyCurrencyPage extends AppCompatActivity {

    Spinner buyCurrencySpinner;
    Spinner buyCurrencyExchangeSpinner;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_currency_page);
        buyCurrencySpinner = findViewById(R.id.buyCurrencySpinner);

        buyCurrencyExchangeSpinner = findViewById(R.id.buyCurrencyExchangeSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("---- select currency ----");

        currencyInfo currencyInfo = new currencyInfo();

        adapter.addAll(com.example.nctai_trading.currencyInfo.currencyList().keySet().toArray(new String[0]));

        buyCurrencySpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter2.add("---- select exchange ----");
        adapter2.addAll(new exchangesList().getExchangesList());

        buyCurrencyExchangeSpinner.setAdapter(adapter2);

    }
}