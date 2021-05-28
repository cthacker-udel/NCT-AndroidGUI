package com.example.nctai_trading.bittrexV2;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.bittrexV2.Controller.accountBalances.accountBalance;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.accountOrder;
import com.example.nctai_trading.bittrexV2.Interfaces.accountInterface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BittrexRestAPI {

    String baseUrl = "https://api.bittrex.com/api/v1.1";

    /*

    Account Methods

     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<accountBalance> getAccountBalances(BittrexClient client) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        String url = baseUrl + "/acocunt/balances/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.bittrexV2.Interfaces.accountInterface.class);

        Call<List<accountBalance>> call = accountInterface.getAccountBalances(client.getAuthMethods().calculateHash(client.getAuthKeys().getSecretKey(),url,"HmacSHA512"),client.getAuthMethods().generateNonce(),client.getAuthKeys().getApiKey());

        Response<List<accountBalance>> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public accountOrder getAccountOrderHistory(BittrexClient client) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String url = baseUrl + "/account/getorderhistory/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.bittrexV2.Interfaces.accountInterface.class);

        Call<accountOrder> call = accountInterface.getAccountOrderHistory(client.getAuthMethods().calculateHash(client.getAuthKeys().getSecretKey(),url,"HmacSHA512"),client.getAuthMethods().generateNonce(),client.getAuthKeys().getApiKey());

        Response<accountOrder> response = call.execute();

        return response.body();

    }





}
