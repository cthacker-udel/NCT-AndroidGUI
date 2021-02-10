package com.example.nctai_trading.ameritrade;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface ameritradeTransactionInterface {

    @GET("https://api.tdameritrade.com/v1/accounts/{accountId}/transactions/{transactionId}")
    Call<ameritradeGetTransactionResponse> getSpecificTransaction(@Path("accountId") String accountId, @Path("transactionId") String transactionId, @HeaderMap Map<String,String> authHeader);

}
