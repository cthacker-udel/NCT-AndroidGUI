package com.example.nctai_trading.basefex;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface basefexPositionInterface {

    @PUT("https://api.basefex.com/positions/{symbol}/margin")
    Call<basefexAdjustLeverage> adjustLeverage(@Path("symbol") String symbol, @Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @PUT("https://api.basefex.com/positions/{symbol}/risk-limit")
    Call<basefexSetRiskLimit> setRiskLimit(@Path("symbol") String symbol, @Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature, @Body Map<String,Object> body);

}
