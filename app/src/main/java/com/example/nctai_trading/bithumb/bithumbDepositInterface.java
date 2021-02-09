package com.example.nctai_trading.bithumb;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface bithumbDepositInterface {

    @POST("https://global-openapi.bithumb.pro/openapi/v1/wallet/depositHistory")
    Call<bithumbWithdrawResponse> getDepositHistory(@HeaderMap Map<String,String> authHeader);

}
