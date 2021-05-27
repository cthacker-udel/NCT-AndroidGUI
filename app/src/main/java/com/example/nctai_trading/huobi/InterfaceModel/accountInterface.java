package com.example.nctai_trading.huobi.InterfaceModel;

import com.example.nctai_trading.huobi.Controller.AccountAPI.AccountAssetInformation.AccountAssetInformation;
import com.example.nctai_trading.huobi.Controller.AccountAPI.AccountInformation.AccountInformation;
import com.example.nctai_trading.huobi.Controller.AccountAPI.AssetValuation.AssetValuation;
import com.example.nctai_trading.huobi.Controller.AccountAPI.PositionInformation.AccountPositionInformation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.TreeMap;

public interface accountInterface {

    @POST("https://api.hbdm.com/swap-api/v1/swap_balance_valuation")
    Call<AssetValuation> queryAssetValuation(@Body TreeMap<String,Object> body);

    @POST("https://api.hbdm.com/swap-api/v1/swap_account_info")
    Call<AccountInformation> queryAccountInformation(@Body TreeMap<String,Object> body);

    @POST("https://api.hbdm.com/swap-api/v1/swap_position_info")
    Call<AccountPositionInformation> queryAccountPositionInformation(@Body TreeMap<String,Object> body);

    @POST("https://api.hbdm.com/swap-api/v1/swap_account_position_info")
    Call<AccountAssetInformation> queryAccountAssetInformation(@Body TreeMap<String,Object> body);

}
