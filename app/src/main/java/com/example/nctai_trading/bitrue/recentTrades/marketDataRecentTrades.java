package com.example.nctai_trading.bitrue.recentTrades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class marketDataRecentTrades {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("isBuyerMaker")
    @Expose
    private Boolean isBuyerMaker;
    @SerializedName("isBestMatch")
    @Expose
    private Boolean isBestMatch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getIsBuyerMaker() {
        return isBuyerMaker;
    }

    public void setIsBuyerMaker(Boolean isBuyerMaker) {
        this.isBuyerMaker = isBuyerMaker;
    }

    public Boolean getIsBestMatch() {
        return isBestMatch;
    }

    public void setIsBestMatch(Boolean isBestMatch) {
        this.isBestMatch = isBestMatch;
    }

}
