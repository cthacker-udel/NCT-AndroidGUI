package com.example.nctai_trading.basefex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface basefexAccountInterface {

    @GET("https://api.basefex.com/accounts")
    Call<List<basefexGetAccountCashAndPositionDetail>> getAccountCashAndDetail(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://api.basefex.com/accounts/transactions")
    Call<List<basefexAccountDepositWithdrawHistory>> getAccountDepositWithdrawHistory(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://api.basefex.com/accounts/transactions/count")
    Call<basefexCountTransactions> getAccountTransactions(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

}
