package com.example.nctai_trading.huobiApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface huobiMarketInterface {

    @GET("https://api.hbdm.com/swap-api/v1/swap_contract_info")
    Call<swapMarketInfo> getSwapMarketInfo();

    @GET("https://api.hbdm.com/swap-api/v1/swap_index")
    Call<huobiSwapMarketIndex> getSwapMarketIndex();

    @GET("https://api.hbdm.com/swap-api/v1/swap_price_limit")
    Call<huobiSwapMarketLimitation> getSwapMarketLimitation(@Query("contract_code") String contractCode);

    @GET("https://api.hbdm.com/swap-api/v1/swap_open_interest")
    Call<huobiSwapMarketOpenInterest> getSwapMarketOpenInterest();

    @GET("https://api.hbdm.com/swap-ex/market/depth")
    Call<huobiSwapMarketDepth> getSwapMarketDepth(@Query("contract_code") String contractCode, @Query("type") String type);

    @GET("https://api.hbdm.com/swap-ex/market/history/kline")
    Call<huobiSwapMarketKlineData> getSwapMarketKline(@Query("contract_code") String contractCode, @Query("period") String period);

    @GET("https://api.hbdm.com/index/market/history/swap_mark_price_kline")
    Call<huobiSwapMarketKlineDataSize> getSwapMarketKlineSize(@Query("contract-code") String contractCode, @Query("period") String period, @Query("size") Integer size);

    @GET("https://api.hbdm.com/swap-ex/market/detail/merged")
    Call<huobiMarketDetail> getMarketDetail(@Query("contract-code") String contractCode);

    @GET("https://api.hbdm.com/swap-ex/market/detail/batch_merged")
    Call<huobiMarketDetailBatch> getMarketDetailBatch(@Query("contract-code") String contractCode);
}
