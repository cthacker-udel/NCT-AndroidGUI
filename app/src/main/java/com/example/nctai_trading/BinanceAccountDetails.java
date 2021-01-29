package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.binance.api.client.BinanceApiRestClient;

public class BinanceAccountDetails extends AppCompatActivity {

    TextView accountId;
    TextView accountWithdraw;
    TextView accountDeposit;
    TextView accountBalance;
    Spinner currencySelectorBinanceAccountDetailsPage;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_account_details);
        accountId = findViewById(R.id.binanceAccountDetailsAccountID);
        accountWithdraw = findViewById(R.id.binanceAccountDetailsCanWithdraw);
        accountDeposit = findViewById(R.id.binanceAccountDetailsCanDeposit);
        accountBalance = findViewById(R.id.binanceAccountDetailsAccountBalance);
        currencySelectorBinanceAccountDetailsPage = findViewById(R.id.binanceAccountDetailsCurencySelector);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
        adapter2.add("-- Please select currency --");
        adapter2.addAll(currencyInfo.currencyList().values().stream().toArray(String[]::new));
        currencySelectorBinanceAccountDetailsPage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currencySelectorBinanceAccountDetailsPage.getSelectedItem().toString().equals("-- Please select currency --")){
                    Toast.makeText(BinanceAccountDetails.this,"Please select a currency",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(BinanceAccountDetails.this,"Please select a currency",Toast.LENGTH_SHORT).show();
                return;
            }
        });

    }

}