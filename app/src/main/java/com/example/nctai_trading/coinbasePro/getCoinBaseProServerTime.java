package com.example.nctai_trading.coinbasePro;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getCoinBaseProServerTime {

    @GET("https://api.pro.coinbase.com/time")
    Call<coinBaseProServerResponse> getCoinBaseProServerTime();

}
