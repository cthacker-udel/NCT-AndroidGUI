package com.example.nctai_trading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class binancePage extends AppCompatActivity {

    Button binancePageSignInBtn;

    private TreeMap<String,String> currencies;

    String[] currenciesNames;

    Spinner displayCurrencyAmountAndQuantity;

    Button displayPriceAndQuantity;

    BinanceApiRestClient client;

    boolean userSignedIn;

    Button displayAccountBalance;

    TextView accountBalanceView;

    Button displayAccountTransactions;

    TextView accountTradesTextView;

    String currentSelectedItem;

    Button showAccountInfo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binance_page);

        currencies = currencyInfo.currencyList();

        currenciesNames = currencies.keySet().stream().toArray(String[]::new);

        displayCurrencyAmountAndQuantity = findViewById(R.id.binancePageScroller);
        binancePageSignInBtn = findViewById(R.id.binancePageSignInBtn);
        displayPriceAndQuantity = findViewById(R.id.binancePagePriceAndQuantity);
        displayAccountBalance = findViewById(R.id.binancePageAccountBalanceButton);
        accountBalanceView = findViewById(R.id.binancePageAccountView);
        displayAccountTransactions = findViewById(R.id.binancePageDisplayAccountTransactions);
        accountTradesTextView = findViewById(R.id.binanceAccountDetailsScrollViewText);
        showAccountInfo = findViewById(R.id.binanceAccountDetailsAccountShowButton);

        AlertDialog.Builder currencyError = new AlertDialog.Builder(this);

        currencyError.setTitle("Currency Error");

        currencyError.setMessage("Currency error");

        userSignedIn = false;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
        adapter.add("--- select currency ---");
        adapter.addAll(currenciesNames);

        displayCurrencyAmountAndQuantity.setAdapter(adapter);

        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);

        String apiKey = sharedPreferences.getString("binanceApiKey","defaultBinanceApiKey");

        String secretKey = sharedPreferences.getString("binanceSecretKey","defaultBinanceSecretKey");

        showAccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BinanceAccountDetails.class);
                startActivity(intent);
            }
        });

        displayCurrencyAmountAndQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = displayCurrencyAmountAndQuantity.getSelectedItem().toString();
                if(selectedItem.equals("--- select currency ---")){
                    Toast.makeText(binancePage.this,"Please select an currency",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    currentSelectedItem = displayCurrencyAmountAndQuantity.getSelectedItem().toString();
                    // error message below, probably because client has not been instantiated properly, requires proper keys
                    // spinner functions correctly
                    OrderBook orderBook = client.getOrderBook(currencies.get(currentSelectedItem),10);
                    List<OrderBookEntry> asks = orderBook.getAsks();
                    OrderBookEntry firstAskEntry = asks.get(0);
                    displayPriceAndQuantity.setText(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    //System.out.println(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    List<Trade> trades = client.getMyTrades(currencies.get(currentSelectedItem));
                    ArrayList<String> tradeList = new ArrayList<>();
                    for(Trade eachTrade: trades){
                        tradeList.add(String.format("Price : %s \n Quantity : %s \n--------------------",eachTrade.getPrice(),eachTrade.getQty()));
                    }
                    accountBalanceView.setText(String.join("\n",tradeList));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(binancePage.this,"Please select an currency",Toast.LENGTH_SHORT).show();
                return;
            }
        });


        binancePageSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secretKey);
                    client = factory.newRestClient();

                    // test client

                    client.ping();
                    System.out.println(client.getServerTime());
                    binancePageSignInBtn.setText("Login Success!");
            }
        });

        // display account balance

        displayAccountBalance.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey,secretKey);
                client = factory.newRestClient();
                BinanceApiAsyncRestClient client2 = factory.newAsyncRestClient();

                List<Order> LTCBTCorderList = client.getAllOrders(new AllOrdersRequest("LTCBTC"));

                ArrayList<String> ordersList = new ArrayList<String>();

                for (Order each : LTCBTCorderList){
                    each.getOrderId();
                    each.getPrice();
                    each.getOrigQty();
                    each.getExecutedQty();
                    // orderid, symbol, price, origqty, executedqty -- 2, LTCBTC, 10.0, 100, 200.
                    ordersList.add(String.format("%s, %s, %s, %s, %s", each.getOrderId(), each.getPrice(), each.getOrigQty(), each.getExecutedQty()) );
                }
                String formattedOrders = String.join("\n -------- \n", ordersList);

                Account account = client.getAccount();

                // ACCOUNT DETAILS

                List<Order> openOrders = client.getOpenOrders(new OrderRequest("BTC"));

                ArrayList<String> openOrdersList = new ArrayList<>();
                openOrdersList.add("--------OPEN ORDERS--------");
                for(Order eachOrder: openOrders){
                    openOrdersList.add(String.format("%s, %s, %s, %s",eachOrder.getOrderId(),eachOrder.getPrice(),eachOrder.getOrigQty(),eachOrder.getExecutedQty()));
                }
                String formattedOpenOrders = String.join("\n-----------\n",openOrdersList);

                List<AssetBalance> acctAssetBalances =  account.getBalances();
                ArrayList<String> acctAssetList = new ArrayList<String>();

                for (AssetBalance each : acctAssetBalances) {
                  String acctAsset = each.getAsset();
                  System.out.println(each.getAsset());
                  acctAssetList.add(each.getAsset());

                }

                String formattedAssets = String.join("\n -------- \n", acctAssetList);

                ArrayList<String> accountDetails = new ArrayList<>();

                accountDetails.add("---------ACCOUNT DETAILS---------");
                accountDetails.add(account.isCanTrade()? "Can Trade: True": "Can Trade: False");
                accountDetails.add(account.isCanWithdraw()? "Can Withdraw: True": "Can Withdraw: False");
                accountDetails.add(account.isCanDeposit()? "Can Deposit: True": "Can Deposit: False");
                accountDetails.add(String.format("Update Time : %d",account.getUpdateTime()));

                String formattedAccountDetails = String.format("\n---------\n",accountDetails);

                double totalBalance = 0;
                DecimalFormat format = new DecimalFormat("##.##");
                format.setRoundingMode(RoundingMode.HALF_UP);
                List<AssetBalance> balances = account.getBalances();
                for(AssetBalance eachBalance: balances){
                    totalBalance += Double.parseDouble(eachBalance.getAsset());
                }
                accountBalanceView.setText(String.format("$%s",format.format(totalBalance)));
            }
        });

        displayPriceAndQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autoCompletePriceAndQuantityText = currentSelectedItem;
                try{
                    String formattedAutoCompletePriceAndQuantityText = autoCompletePriceAndQuantityText.substring(0,1).toUpperCase() + autoCompletePriceAndQuantityText.substring(1);
                    if(!currencies.keySet().contains(formattedAutoCompletePriceAndQuantityText)){
                        currencyError.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(binancePage.this,"Currency error",Toast.LENGTH_SHORT).show();
                            }
                        });
                        currencyError.setCancelable(true);
                        currencyError.create().show();
                        return;
                    }
                    else{
                        OrderBook orderBook = client.getOrderBook(currencies.get(formattedAutoCompletePriceAndQuantityText),10);
                        List<OrderBookEntry> asks = orderBook.getAsks();
                        OrderBookEntry firstAskEntry = asks.get(0);
                        System.out.println(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    }
                }
                catch(Exception e){
                    return;
                }
            }
        });

        displayAccountTransactions.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey,secretKey);
                client = factory.newRestClient();
                currencies = currencyInfo.currencyList();
                List<Trade> trades = client.getMyTrades(currencies.get(currentSelectedItem));
                ArrayList<String> tradeList = new ArrayList<>();
                for(Trade eachTrade: trades){
                    tradeList.add(String.format("Price : %s \n Quantity : %s \n--------------------",eachTrade.getPrice(),eachTrade.getQty()));
                }
                accountBalanceView.setText(String.join("\n",tradeList));


            }
        });


    }
}