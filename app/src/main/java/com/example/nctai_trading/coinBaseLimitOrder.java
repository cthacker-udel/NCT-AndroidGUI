package com.example.nctai_trading;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface coinBaseLimitOrder {

    /*

    @author - Preethi

     */

    @POST("/orders")
    Call<coinBaseProPurchase> createorder2(@Body coinBaseNewLimitOrderSingle2 order);

}
