package com.example.nctai_trading.alpaca;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface alpacaPositionInterface {


    @GET("https://paper-api.alpaca.markets/v2/positions")
    Call<List<alpacaPosition>> getOpenPositions(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @GET("https://paper-api.alpaca.markets/v2/positions/{symbol}")
    Call<alpacaPosition> getOpenPositionSymbol(@Path("symbol") String symbol, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @DELETE("https://paper-api.alpaca.markets/v2/positions")
    Response closeAllPositions(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-SECRET-KEY") String secretKey);

    @DELETE("https://paper-api.alpaca.markets/v2/positions/{symbol}")
    Response closePosition(@Path("symbol") String symbol, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-SECRET-KEY") String secretKey);

}
