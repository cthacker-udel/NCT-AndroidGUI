package com.example.nctai_trading.binance.InterfaceModel;

import com.example.nctai_trading.binance.Controller.GeneralEndpointAPI.*;
import com.example.nctai_trading.binance.Controller.GeneralEndpointAPI.ExchangeInfo.*;
import retrofit2.Call;
import retrofit2.http.GET;

public interface generalInterface {

    @GET("https://api.binance.com/api/v3/ping")
    Call<Void> testConnectivity();

    @GET("https://api.binance.com/api/v3/time")
    Call<ServerTime> getServerTime();

    @GET("https://api.binance.com/api/v3/exchangeInfo")
    Call<ExchangeInfoRoot> getExchangeInformation();

}
