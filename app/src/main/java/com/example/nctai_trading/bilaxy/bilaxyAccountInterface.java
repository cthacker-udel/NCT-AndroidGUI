package com.example.nctai_trading.bilaxy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface bilaxyAccountInterface {

    @GET("https://api.bilaxy.com/v1/balances")
    Call<List<bilaxyAccount>> getAccountInformation(@Header("key") String key, @Header("sign") String signature);

}
