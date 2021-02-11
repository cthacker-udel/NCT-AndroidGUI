package com.example.nctai_trading.alpaca;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface alpacaAssetInterface {

    @GET("https://paper-api.alpaca.markets/v2/assets")
    Call<List<alpacaAsset>> getAssets(@Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

    @GET("https://paper-api.alpaca.markets/v2/assets/{symbol}")
    Call<alpacaAsset> getAsset(@Path("symbol") String symbol, @Header("APCA-API-KEY-ID") String apiKey, @Header("APCA-API-SECRET-KEY") String secretKey);

}
