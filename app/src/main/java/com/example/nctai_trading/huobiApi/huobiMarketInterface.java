package com.example.nctai_trading.huobiApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface huobiMarketInterface {

    @GET("https://api.hbdm.com/swap-api/v1/swap_contract_info")
    Call<swapMarketInfo> getSwapMarketInfo();

}
