package com.example.nctai_trading.huobi.Controller.AccountAPI.AssetValuation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("valuation_asset")
    @Expose
    private String valuationAsset;
    @SerializedName("balance")
    @Expose
    private String balance;

    public String getValuationAsset() {
        return valuationAsset;
    }

    public void setValuationAsset(String valuationAsset) {
        this.valuationAsset = valuationAsset;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
