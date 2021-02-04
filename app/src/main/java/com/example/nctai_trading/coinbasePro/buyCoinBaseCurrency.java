package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface buyCoinBaseCurrency {

    @POST("https://api.pro.coinbase.com/orders")
    Call<coinBaseProPurchase> buyCoinBasePro(@HeaderMap Map<String,String> authMap, @Body Map<String,Object> body);

}
