package com.example.nctai_trading.bitforex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bitforexSymbolInterface {

    @GET("https://api.bitforex.com/api/v1/market/symbols")
    Call<bitforexMarketSymbols> getSymbolInformation();

}
