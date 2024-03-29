package com.example.nctai_trading.alpaca;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface alpacaAccountInterface {

    @GET("https://paper-api.alpaca.markets/v2/account")
    Call<alpacaGetAccountResponse> getAccount(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @GET("https://api.alpaca.markets/v2/assets")
    Call<List<alpacaAsset>> getAccountAssets(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @GET("https://api.alpaca.markets/v2/account/activites")
    Call<List<NonTradeActivity>> getAccountNonTradeActivity(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey, @Query("activity_types") String activityTypes);

}
