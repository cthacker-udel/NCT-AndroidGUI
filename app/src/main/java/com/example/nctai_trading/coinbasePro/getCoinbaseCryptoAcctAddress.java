package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface getCoinbaseCryptoAcctAddress {

    @POST("https://api.pro.coinbase.com/coinbase-account/{id}/addresses")
    Call<coinbaseCryptoDepositAddress> getCoinbaseCryptoDepositAddress(@HeaderMap Map<String,String> authMap);//, @Body Map<String,Object> body);

}
