package com.example.nctai_trading.binance;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nctai_trading.R;
import com.example.nctai_trading.currencyInfo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.LongStream;

public class binanceBuyPage extends AppCompatActivity {
    Spinner currency1Spinner;
    Spinner currency2Spinner;
    String selectedCurrency1;
    String selectedCurrency2;
    TreeMap<String,String> currencies;
    String[] currenciesNames;
    Button buyButton;
    Map<String,String> accountResults;
    Spinner binanceBuyPageSpinner;
    long selectedAmount;
    Button updateAmountScrollerBtn;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_binance_buy_page);
        currency1Spinner = findViewById(R.id.binanceBuyPageScroller1);
        currency2Spinner = findViewById(R.id.binanceBuyPageScroller2);
        buyButton = findViewById(R.id.binanceBuyPageButton);
        binanceBuyPageSpinner = findViewById(R.id.binanceBuyPageAmountScroller);
        updateAmountScrollerBtn = findViewById(R.id.binanceBuyPageUpdateAmountSpinnerButton);

        currencies = currencyInfo.currencyList();

        currenciesNames = currencies.keySet().stream().toArray(String[]::new);

        // alert dialog

        AlertDialog.Builder selectedCurrencyError = new AlertDialog.Builder(binanceBuyPage.this);
        selectedCurrencyError.setTitle("Selected Currency Error");
        selectedCurrencyError.setMessage("Left box value error");

        // SHARED PREFERENCES

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        binanceMethods fillAccountInfo = new binanceMethods(apiKey,secretKey);



        try {
            accountResults = fillAccountInfo.tempGenerateAccountInformation();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("Binance buy page account details : " + accountResults);

        ArrayAdapter<Long> amountAdapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line);
        amountAdapter.add((long) 0);
        binanceBuyPageSpinner.setAdapter(amountAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line);
        adapter.add("------ select currency ------");

        adapter.addAll(currenciesNames);

        currency1Spinner.setAdapter(adapter);
        currency2Spinner.setAdapter(adapter);

        binanceBuyPageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAmount = (long)binanceBuyPageSpinner.getSelectedItem();
                // it will display how much that quantity with the price is worth, if you select 20 doge coin it will display -> .75
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceBuyPage.this,"Please select an amount",Toast.LENGTH_SHORT).show();
            }
        });

        updateAmountScrollerBtn.setOnClickListener(new View.OnClickListener() {
            // add functionality to calculate the present amount in your account and calculate the max amount you can buy, such as since 1 dogecoin = 1 tether, so reverse the amounts, and
            // also calculate the total amount of the coin you select and calculate how many of the other coin buy
            @Override
            public void onClick(View v) {
                PriceTicker priceTicker = null;
                if(selectedCurrency1 != null && selectedCurrency2 != null && !selectedCurrency1.equals("------ select currency ------") && !selectedCurrency2.equals("------ select currency ------") && !selectedCurrency1.equals(selectedCurrency2)){
                    binanceMethods methods = new binanceMethods(apiKey,secretKey);
                    amountAdapter.clear();
                    amountAdapter.add((long)1);
                    // TO GET CONVERSION FIRST MAKE A COINBASE PRO API AND THEN UTILIZE THE CONVERT TO - FROM AND GET THE ID THEN ACCESS THE LEDGER ASSOCIATED WITH THE ID
                    // figure out calculation
                    // [0.35    , 1.5 (2 of 1.5) 3 -> .35 * 30] first case
                    // [1.5   , 0.35 (20 of .35) -> 1.5] second case
                    //double max = Math.max(priceOne,priceTwo);
                    //double min = Math.min(priceOne,priceTwo);
                    //long times = Math.round(max / min);
                    //LongStream.range(1,times).forEach(amountAdapter::add);
                    try {
                        priceTicker = methods.getPriceTicker(currencies.get(selectedCurrency2),currencies.get(selectedCurrency1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(priceTicker == null){
                        Toast.makeText(binanceBuyPage.this,"Please swap currency",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    long amt = Long.parseLong(priceTicker.getPrice());
                    LongStream.range(1,amt).forEach(amountAdapter::add);
                }
                else{
                    Toast.makeText(binanceBuyPage.this,"Please enter currency",Toast.LENGTH_SHORT).show();
                    return;
                }
                binanceBuyPageSpinner.setAdapter(amountAdapter);
            }
        });

        currency1Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrency1 = currency1Spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceBuyPage.this,"Select a currency on the left box",Toast.LENGTH_SHORT).show();
            }
        });

        currency2Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrency2 = currency2Spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binanceBuyPage.this,"Select a currency on the right box",Toast.LENGTH_SHORT).show();
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> orderResult = new ArrayList<>();
                selectedCurrency1 = currency1Spinner.getSelectedItem().toString();
                selectedCurrency2 = currency2Spinner.getSelectedItem().toString();
                selectedAmount = (long)binanceBuyPageSpinner.getSelectedItem();
                if(selectedCurrency1.equals("------ select currency ------")){
                    selectedCurrencyError.create().show();
                    return;
                }
                else if(selectedCurrency2.equals("------ select currency ------")){
                    selectedCurrencyError.setMessage("Right box value error");
                    selectedCurrencyError.create().show();
                    return;
                }
                else if(selectedCurrency1.equals(selectedCurrency2)){
                    selectedCurrencyError.setMessage("Same currencies in both boxes");
                    selectedCurrencyError.create().show();
                    return;
                }
                else if(selectedAmount == 0){
                    selectedCurrencyError.setMessage("Cannot buy 0 amount");
                    selectedCurrencyError.create().show();
                }
                else{
                    binanceMethods methods = new binanceMethods(apiKey,secretKey);

                    binanceMethods.buyCurrency buyMethods = methods.new buyCurrency(apiKey,secretKey);
                    // find a way to calculate the amount you can buy and also the amount you make as to avoid the MIN_NOTIONAL error which suggest too low of an amount < 0.1
                    try {
                        orderResult = buyMethods.baseBuy(currencies.get(selectedCurrency1) + currencies.get(selectedCurrency2),1000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InvalidKeyException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    System.out.println(orderResult);
                }

                //[size=98 text={"code":-1102,"msg":"Param 'quantity' or 'quoteOrderQty' must be…]
            }
        });




    }
}