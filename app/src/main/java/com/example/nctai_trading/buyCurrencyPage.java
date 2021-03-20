package com.example.nctai_trading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.nctai_trading.R;

public class buyCurrencyPage extends AppCompatActivity {

    Spinner buyCurrencySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_currency_page);
        buyCurrencySpinner = findViewById(R.id.buyCurrencySpinner);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("---- select currency ----");

        exchangesList exchangeListMethods = new exchangesList();

        adapter.addAll(exchangeListMethods.getExchangesList());

        buyCurrencySpinner.setAdapter(adapter);

    }
}