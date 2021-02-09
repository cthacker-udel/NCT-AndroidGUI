package com.example.nctai_trading.bithumb;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface bithumbWithdrawInterface {

    @POST("https://global-openapi.bithumb.pro/openapi/v1/withdraw")
    Call<bithumbWithdrawResponse> withdraw(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/transfer")
    Call<bithumbWithdrawResponse> transferAccount(@HeaderMap Map<String,String> authHeader);

    @POST("https://global-openapi.bithumb.pro/openapi/v1/wallet/withdrawHistory")
    Call<bithumbWithdrawResponse> getWithdrawHistory(@HeaderMap Map<String,String> authHeader);

}
