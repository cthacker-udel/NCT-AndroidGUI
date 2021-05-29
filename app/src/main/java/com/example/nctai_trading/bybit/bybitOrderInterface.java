package com.example.nctai_trading.bybit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import com.example.nctai_trading.bybit.openOrders.openOrder;
import com.example.nctai_trading.bybit.tradeRecords.tradeRecord;
import com.example.nctai_trading.bybit.walletFunds.walletFund;

public interface bybitOrderInterface {

    @POST("https://api-testnet.bybit.com/private/linear/order/create")
    Call<bybitOrderResponse> placeOrder(@Header("api_key") String api, @Header("timestamp") Object timestamp, @Header("sign") String signature, @Body Map<String,String> body);

    @GET("https://api.bybit.com/v2/private/order")
    Call<openOrder> getOpenOrders(@Header("api_key") String apikey, @Header("timestamp") Object timetamp, @Header("sign") String signature, @QueryMap Map<String,String> queries);

    @GET("https://api.bybit.com/v2/private/execution/list")
    Call<tradeRecord> getTradeRecords(@Header("api_key") String apiKey, @Header("timestamp") Object timestamp, @Header("sign") String signature, @QueryMap Map<String,String> queries);

    @GET("https://api.bybit.com/v2/private/wallet/fund/records")
    Call<walletFund> getWalletFunds(@Header("api_key") String apiKey, @Header("timestamp") Object timestamp, @Header("sign") String signature);

}
