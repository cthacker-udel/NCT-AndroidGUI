package com.example.nctai_trading.coinbasePro;

import com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits.TransferLimits;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface getCoinBaseProExchangeLimits {

    @GET("https://api.pro.coinbase.com/users/self/exchange-limits")
    Call<TransferLimits> getExchangeLimits(@HeaderMap Map<String,String> authMap);

}
