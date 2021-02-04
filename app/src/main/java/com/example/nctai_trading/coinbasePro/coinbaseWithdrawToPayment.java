package com.example.nctai_trading.coinbasePro;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface coinbaseWithdrawToPayment {

    @GET("https://api.pro.coinbase.com/withdrawls/payment-method")
    Call<coinbaseProWithdrawToPaymentResponse> withdrawToPayment(@HeaderMap Map<String,String> authMap, @Body Map<String,Object> body);

}
