package com.example.nctai_trading.bittrexV2.Interfaces;

import com.example.nctai_trading.bittrexV2.Controller.accountBalances.accountBalance;
import com.example.nctai_trading.bittrexV2.Controller.accountOrderHistory.accountOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface accountInterface {

    @GET("https://api.bittrex.com/api/v1.1/account/getbalances")
    Call<List<accountBalance>> getAccountBalances(@Header("apisign") String signature, @Query("message") String nonce, @Query("apikey") String apiKey);

    @GET("https://api.bittrex.com/api/v1.1/account/getorderhistory")
    Call<accountOrder> getAccountOrderHistory(@Header("apisign") String signature, @Query("message") String nonce, @Query("apikey") String apiKey);

}
