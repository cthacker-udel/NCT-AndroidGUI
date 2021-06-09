package com.example.nctai_trading.bitcoincom;

import com.example.nctai_trading.bitcoincom.AccountBalance.AccountBalance;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bitcoincomAccountInterface {

    @GET("https://api.exchange.bitcoin.com/api/2/account/balance")
    Call<List<AccountBalance>> getAccountBalances(@Header("Authorization") String auth);

}
