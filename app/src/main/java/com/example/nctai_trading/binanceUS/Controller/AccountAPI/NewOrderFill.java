package com.example.nctai_trading.binanceUS.Controller.AccountAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewOrderFill {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("commission")
    @Expose
    private String commission;
    @SerializedName("commissionAsset")
    @Expose
    private String commissionAsset;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCommissionAsset() {
        return commissionAsset;
    }

    public void setCommissionAsset(String commissionAsset) {
        this.commissionAsset = commissionAsset;
    }

}
