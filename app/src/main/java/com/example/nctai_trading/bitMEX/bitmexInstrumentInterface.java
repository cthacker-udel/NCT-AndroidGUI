package com.example.nctai_trading.bitMEX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface bitmexInstrumentInterface {

    @GET("https://www.bitmex.com/api/v1/instrument")
    Call<List<bitmexInstrument>> getInstruments(@Header("api-expires") String expires, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://www.bitmex.com/api/v1/instrument/active")
    Call<List<bitmexInstrument>> getActiveInstrument(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature);

    @GET("https://www.bitmex.com/api/v1/instrument/activeAndIndices")
    Call<List<bitmexInstrument>> getActiveIndiceInstrument(@Header("api-expires") String timestamp, @Header("api-key") String apikey, @Header("api-signature") String signature);

    @GET("https://www.bitmex.com/api/v1/instrument/activeIntervals")
    Call<bitmexInstrumentActiveIntervals> getActiveIntervals(@Header("api-expires") String timestamp, @Header("api-key") String apikey, @Header("api-signature") String signature);

    @GET("https://www.bitmex.com/api/v1/instrument/compositeIndex")
    Call<bitmexInstrumentCompositeIndex> getCompositeIndex(@Header("api-expires") String timestamp, @Header("api-key") String apikey, @Header("api-signature") String signature, @Query("symbol") String symbol);

    @POST("https://www.bitmex.com/api/v1/order")
    Call<bitmexPlaceOrderResposne> placeOrder(@Header("api-expires") String timestamp, @Header("api-key") String apiKey, @Header("api-signature") String signature, @Query("symbol") String symbol, @Query("ordType") String orderType);

}
