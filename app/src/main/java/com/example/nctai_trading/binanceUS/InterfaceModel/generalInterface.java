package com.example.nctai_trading.binanceUS.InterfaceModel;

import com.example.nctai_trading.binanceUS.Controller.GeneralEndpointAPI.ExchangeInfo.ExchangeInfoRoot;
import com.example.nctai_trading.binanceUS.Controller.GeneralEndpointAPI.ServerTime;
import retrofit2.Call;
import retrofit2.http.GET;

public interface generalInterface {

    @GET("https://api.binance.us/api/v3/ping")
    Call<Void> testConnectivity();

    @GET("https://api.binance.us/api/v3/time")
    Call<ServerTime> getServerTime();

    @GET("https://api.binance.us/api/v3/exchangeInfo")
    Call<ExchangeInfoRoot> getExchangeInformation();

}
