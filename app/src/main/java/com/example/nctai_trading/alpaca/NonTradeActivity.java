package com.example.nctai_trading.alpaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NonTradeActivity {

    @SerializedName("activity_type")
    @Expose
    private String activityType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("net_amount")
    @Expose
    private String netAmount;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("per_share_amount")
    @Expose
    private String perShareAmount;

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPerShareAmount() {
        return perShareAmount;
    }

    public void setPerShareAmount(String perShareAmount) {
        this.perShareAmount = perShareAmount;
    }


}
