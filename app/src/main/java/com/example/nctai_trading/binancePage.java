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
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

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

    TextView accountTradesTextView;

    String currentSelectedItem;

    Button showAccountInfo;

    //URL url;

    Button buyButton;

    Button sellButton;

    @RequiresApi(api = Build.VERSION_CODES.O)
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
        accountTradesTextView = findViewById(R.id.binanceAccountDetailsScrollViewText);
        showAccountInfo = findViewById(R.id.binanceAccountDetailsAccountShowButton);
        buyButton = findViewById(R.id.binancePageBuyButton);
        sellButton = findViewById(R.id.binancePageSellButton);


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

        // not IP, either API Key <--



        //BinanceApiAsyncRestClient client2 = factory.newAsyncRestClient();

        // I noticed that the android binanceUS is only formatted to allow trades to the v3 account, none others, only allow account details of v3, none others such as in the account link its api/V3/

        //client2.getPrice("BTC", BinanceApiCallback -> {});

        String baseUrl = "https://api.binance.us/api/v3/account/";

        // need proper account url that generates the signature

        //try {
        //    URL url = new URL("https://api.binance.us/api/v3/account");
        //} catch (MalformedURLException e) {
        //    e.printStackTrace();
        //}

        binanceMethods methods = new binanceMethods();

        try {
            methods.generateAccountInformation();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey,secretKey);

        BinanceApiRestClient client = factory.newRestClient();

        //Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build();

        //getAccountInfo accountInfoGet = retrofit.create(getAccountInfo.class);

        //Call<com.example.nctai_trading.Account> accountCall = accountInfoGet.getAccount();
        //try {
        //    Response<com.example.nctai_trading.Account> responseAccount = accountCall.execute();
        //    com.example.nctai_trading.Account result = responseAccount.body();
        //    System.out.println(result.getBalances());
        //    System.out.println(result.getAccountType());
        //    System.out.println(result.getMakerCommission());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        // we can use unirest for serverspeed and get requests, and use retrofit for post requests like buy and sell


        //try {
            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Now it's "open", we can set the request method, headers etc.
            //connection.setRequestProperty("accept", "application/json");

            // This line makes the request
            //InputStream responseStream = connection.getInputStream();

            //System.out.println(responseStream);
        /*
            'https://api.binance.us/api/v3/order'

                    dictionary of values ['data': 'afafsaf', 'side': 'direction'
        'type': 'market', 'quantity': currquant,'timestamp': dateimte.now, 'recvwindow': 10000];

            with that dictionary of values they are passing it into a generate signature method
                    and wihtin that method they are first doing '{}={}'=LTCBTC
                    [LTC=USDT,SIDE=DIRECTION,TYPE=MARKET,QUANTITY=CURR_QUANT,TIMESTAMP=CURRTIME,RECVWINDOW=10000]
            JOIN METHOD '&' ----> LTC=USDT&SIDE=DIRECTION&TYPE=MARKET&QUANTITY=CURR_QUANT&TIMESTAMP=CURRTIME&RECVWINDOW=10000
                    after the join method they are creating an instance of hmac and then hexdigesting it
                    the instance of hmac takes the secretkey encoded, the joinedstring encoded, and encodes using sha256\

            afterwards they are simply just making a new key named signature and replacing it with the generatesignature result

         */
        //    HashMap<String,Object> hashMap = new HashMap<>();
        //    hashMap.put("data","dataexample");
        //    hashMap.put("side","sideexample");
        //    hashMap.put("type","typeexample");
        //    hashMap.put("quantity",1111111);
        //    hashMap.put("timestamp","figureouthowtomaketimestamp");
        //    hashMap.put("recvwindow",10000);

        //    String signature = "";
        //    ArrayList<String> signatureList = new ArrayList<>();

        //    for(String eachKey: hashMap.keySet()){
        //        signatureList.add(String.format("%s=%s",String.valueOf(eachKey),String.valueOf(hashMap.get(eachKey))));
        //    }

        //    signature = String.join("&",signatureList);
        //    String utf8EncodedSecretKey = new String(secretKey.getBytes(), StandardCharsets.UTF_8);
        //    SecretKeySpec keySpec = new SecretKeySpec(utf8EncodedSecretKey.getBytes(), "HmacSHA256");
        //    Mac mac = Mac.getInstance("HmacSHA256");
        //    mac.init(keySpec);
        //    String utf8EncodedSignature = new String(signature.getBytes(),StandardCharsets.UTF_8);
        //    byte[] digest = mac.doFinal(utf8EncodedSignature.getBytes());
            // returns the hashed url
        //    System.out.println(DigestUtils.shaHex(digest));

            // how to use hmac new in java, and what to do with the third parameter in hmac but in java

        //} catch (NoSuchAlgorithmException | InvalidKeyException e) {
        //    e.printStackTrace();
        //}


        //System.out.println(client2);

        //System.out.println(client.getServerTime());

        // Permissions

        //System.out.println(client);

        //System.out.println(client.getAccount().getAssetBalance("BTC").getFree());
        //System.out.println(client.getAccount().getBalances());

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
                    try {
                        displayPriceAndQuantity.setText(new binanceMethods(apiKey,secretKey).displayCurrentPrice(currencyInfo.currencyList().get(selectedItem) + "USD"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //currentSelectedItem = displayCurrencyAmountAndQuantity.getSelectedItem().toString();
                    // error message below, probably because client has not been instantiated properly, requires proper keys
                    // spinner functions correctly
                    //OrderBook orderBook = client.getOrderBook(currencies.get(currentSelectedItem),10);
                    //List<OrderBookEntry> asks = orderBook.getAsks();
                    //OrderBookEntry firstAskEntry = asks.get(0);
                    //displayPriceAndQuantity.setText(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    //System.out.println(String.format("Price : %s \n Quantity : %s",firstAskEntry.getPrice(),firstAskEntry.getQty()));
                    //List<Trade> trades = client.getMyTrades(currencies.get(currentSelectedItem));
                    //ArrayList<String> tradeList = new ArrayList<>();
                    //for(Trade eachTrade: trades){
                    //    tradeList.add(String.format("Price : %s \n Quantity : %s \n--------------------",eachTrade.getPrice(),eachTrade.getQty()));
                    //}
                    //accountBalanceView.setText(String.join("\n",tradeList));
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

                    // test client

                    client.ping();
                    System.out.println(client.getServerTime());
                    binancePageSignInBtn.setText("Login Success!");
            }
        });

        // display account balance

        displayAccountBalance.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                //BinanceApiAsyncRestClient client2 = factory.newAsyncRestClient();

                //List<Order> LTCBTCorderList = client.getAllOrders(new AllOrdersRequest("LTCBTC"));

                ArrayList<String> ordersList = new ArrayList<String>();

                binanceMethods methods = new binanceMethods(apiKey,secretKey);

                HashMap<String,String> orders = new HashMap<>();

                try {
                    orders = methods.tempGenerateAccountInformation();
                } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
                    e.printStackTrace();
                }

                double total = 0;
                HashMap<String, String> finalOrders = orders;
                HashMap<String,String> updatedOrders = (HashMap<String,String>)finalOrders.keySet().stream().parallel().filter(e -> Double.parseDouble(finalOrders.get(e)) > 0).collect(Collectors.toMap(e -> e, finalOrders::get));
                for(String eachSymbol: updatedOrders.keySet()){
                    if(eachSymbol.equals("USD")){
                        total += Double.parseDouble(updatedOrders.get(eachSymbol));
                    }
                    else {
                        try {
                            System.out.println(eachSymbol);
                            total += Double.parseDouble(methods.displayCurrentPrice(eachSymbol + "USD").split(":")[1]) * Double.parseDouble(updatedOrders.get(eachSymbol));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

                DecimalFormat decimalFormat = new DecimalFormat("#########.##");

                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

                displayAccountBalance.setText(decimalFormat.format(total));



                //for (Order each : LTCBTCorderList){
                //    each.getOrderId();
                //    each.getPrice();
                //    each.getOrigQty();
                //    each.getExecutedQty();
                    // orderid, symbol, price, origqty, executedqty -- 2, LTCBTC, 10.0, 100, 200.
                //    ordersList.add(String.format("%s, %s, %s, %s, %s", each.getOrderId(), each.getPrice(), each.getOrigQty(), each.getExecutedQty()) );
                //}
                //String formattedOrders = String.join("\n -------- \n", ordersList);

                //Account account = client.getAccount();

                // ACCOUNT DETAILS

                //List<Order> openOrders = client.getOpenOrders(new OrderRequest("BTC"));

                //ArrayList<String> openOrdersList = new ArrayList<>();
                //openOrdersList.add("--------OPEN ORDERS--------");
                //for(Order eachOrder: openOrders){
                //    openOrdersList.add(String.format("%s, %s, %s, %s",eachOrder.getOrderId(),eachOrder.getPrice(),eachOrder.getOrigQty(),eachOrder.getExecutedQty()));
                //}
                //String formattedOpenOrders = String.join("\n-----------\n",openOrdersList);

                //List<AssetBalance> acctAssetBalances =  account.getBalances();
                //ArrayList<String> acctAssetList = new ArrayList<String>();

                //for (AssetBalance each : acctAssetBalances) {
                  //String acctAsset = each.getAsset();
                  //System.out.println(each.getAsset());
                  //acctAssetList.add(each.getAsset());

                //}

                //String formattedAssets = String.join("\n -------- \n", acctAssetList);

                //ArrayList<String> accountDetails = new ArrayList<>();

                //accountDetails.add("---------ACCOUNT DETAILS---------");
                //accountDetails.add(account.isCanTrade()? "Can Trade: True": "Can Trade: False");
                //accountDetails.add(account.isCanWithdraw()? "Can Withdraw: True": "Can Withdraw: False");
                //accountDetails.add(account.isCanDeposit()? "Can Deposit: True": "Can Deposit: False");
                //accountDetails.add(String.format("Update Time : %d",account.getUpdateTime()));

                //String formattedAccountDetails = String.format("\n---------\n",accountDetails);

                //double totalBalance = 0;
                //DecimalFormat format = new DecimalFormat("##.##");
                //format.setRoundingMode(RoundingMode.HALF_UP);
                //List<AssetBalance> balances = account.getBalances();
                //for(AssetBalance eachBalance: balances){
                //    totalBalance += Double.parseDouble(eachBalance.getAsset());
                //}
                //accountBalanceView.setText(String.format("$%s",format.format(totalBalance)));
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
        /*
        displayAccountTransactions.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                currencies = currencyInfo.currencyList();
                List<Trade> trades = client.getMyTrades(currencies.get(currentSelectedItem));
                ArrayList<String> tradeList = new ArrayList<>();
                for(Trade eachTrade: trades){
                    tradeList.add(String.format("Price : %s \n Quantity : %s \n--------------------",eachTrade.getPrice(),eachTrade.getQty()));
                }
                accountBalanceView.setText(String.join("\n",tradeList));


            }
        });
        */

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBuyPage = new Intent(getApplicationContext(),binanceBuyPage.class);
                startActivity(toBuyPage);
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSellPage = new Intent(getApplicationContext(),binanceSellPage.class);
                startActivity(toSellPage);
            }
        });
    }
}