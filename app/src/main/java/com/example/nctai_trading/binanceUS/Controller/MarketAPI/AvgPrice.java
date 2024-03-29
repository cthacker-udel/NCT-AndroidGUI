package com.example.nctai_trading.binanceUS.Controller.MarketAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvgPrice {

    @SerializedName("mins")
    @Expose
    private Integer mins;
    @SerializedName("price")
    @Expose
    private String price;

    public Integer getMins() {
        return mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
