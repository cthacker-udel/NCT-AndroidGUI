package com.example.nctai_trading.binance;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.nctai_trading.R;
import com.example.nctai_trading.currencyInfo;

import java.util.ArrayList;

//import com.binance.api.client.BinanceApiClientFactory;
//import com.binance.api.client.BinanceApiRestClient;
//import com.binance.api.client.domain.account.Order;
//import com.binance.api.client.domain.account.Trade;
//import com.binance.api.client.domain.account.request.AllOrdersRequest;
//import com.binance.api.client.domain.general.ExchangeInfo;
//import com.binance.api.client.domain.general.SymbolInfo;

public class BinanceAccountDetails extends AppCompatActivity {

    TextView accountId;
    TextView accountBalance;
    Spinner currencySelectorBinanceAccountDetailsPage;
    TextView accountDetailsScrollText;
    NestedScrollView accountDetailsScroller;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_account_details);
        accountId = findViewById(R.id.binanceAccountDetailsAccountID);
        accountBalance = findViewById(R.id.binanceAccountDetailsAccountBalanceOfCurrency);
        currencySelectorBinanceAccountDetailsPage = findViewById(R.id.binanceAccountDetailsCurencySelector);
        accountDetailsScrollText = findViewById(R.id.binanceAccountDetailsScrollViewText);
        accountDetailsScroller = findViewById(R.id.binanceAccountDetailsScrollView);
        accountDetailsScroller.setNestedScrollingEnabled(true);

        // beneath the scrollview should have a message saying Thank you for using Next Capital Tech LLC!

        accountDetailsScrollText.setText(R.string.binancePageScrollViewContent);

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        //BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey,secretKey);
        //BinanceApiRestClient client = factory.newRestClient();

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        adapter2.add("-- Please select currency --");
        adapter2.addAll(currencyInfo.currencyList().keySet().stream().toArray(String[]::new));
        currencySelectorBinanceAccountDetailsPage.setAdapter(adapter2);
        currencySelectorBinanceAccountDetailsPage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currencySelectorBinanceAccountDetailsPage.getSelectedItem().toString().equals("-- Please select currency --")){
                    Toast.makeText(BinanceAccountDetails.this,"Please select a currency",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    String selectedCurrency = currencySelectorBinanceAccountDetailsPage.getSelectedItem().toString();
                    //List<Trade> listTrades = client.getMyTrades(currencyInfo.currencyList().get(selectedCurrency));
                    ArrayList<String> tradeList = new ArrayList<>();
                    //for(Trade eachTrade: listTrades){
                    //    eachTrade.getTime();
                    //    eachTrade.getPrice();
                    //    eachTrade.getQty();
                    //    tradeList.add(String.format("Price : %s , Quantity : %s , Time %d",eachTrade.getPrice(),eachTrade.getQty(),eachTrade.getTime()));
                    //}
                    //accountDetailsScrollText.setText(String.join("\n----------\n",tradeList));
                    //List<Order> orderList = client.getAllOrders(new AllOrdersRequest(selectedCurrency));
                    double sumOfOrders = 0;
                    //for(Order eachOrder: orderList){
                    //    sumOfOrders += (Double.parseDouble(eachOrder.getPrice()) * Double.parseDouble(eachOrder.getExecutedQty()));
                    //}
                    //accountBalance.setText(String.valueOf(sumOfOrders));
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