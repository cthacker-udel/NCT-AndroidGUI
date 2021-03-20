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
import java.util.stream.IntStream;

public class buyCurrencyPage extends AppCompatActivity {

    Spinner buyCurrencySpinner;
    Spinner buyCurrencyExchangeSpinner;
    Spinner buyCurrencyAmountSpinner;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_currency_page);
        buyCurrencySpinner = findViewById(R.id.buyCurrencySpinner);

        buyCurrencyExchangeSpinner = findViewById(R.id.buyCurrencyExchangeSpinner);

        buyCurrencyAmountSpinner = findViewById(R.id.buyCurrencyExchangeSpinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("---- select currency ----");

        currencyInfo currencyInfo = new currencyInfo();

        adapter.addAll(com.example.nctai_trading.currencyInfo.currencyList().keySet().toArray(new String[0]));

        buyCurrencySpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter2.add("---- select exchange ----");
        adapter2.addAll(new exchangesList().getExchangesList());

        buyCurrencyExchangeSpinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter3.addAll(IntStream.range(1,999).mapToObj(e -> e+"").toArray(String[]::new));

        buyCurrencyAmountSpinner.setAdapter(adapter3);

    }
}