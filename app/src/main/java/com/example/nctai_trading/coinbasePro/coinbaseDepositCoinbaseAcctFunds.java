package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface coinbaseDepositCoinbaseAcctFunds {

    @POST("https://api.pro.coinbase.com/deposits/coinbase-account")
    Call<coinBaseProCoinbaseDeposit> depositCoinbaseProFunds(@HeaderMap Map<String,String> authHeader, @Body Map<String,Object> body);

}
