package com.example.nctai_trading.bitforex;

import com.example.nctai_trading.bitforex.AccountAsset.AccountAssets;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface accountInterface {

    @POST("https://api.bitforex.com/api/v1/fund/allAccount")
    Call<List<AccountAssets>> getAccountAssets(@Query("accessKey") String apiKey, @Query("nonce") Long nonce, @Query("signData") String signature);

}
