package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexGetAccountCashAndPositionDetailCash {

    @SerializedName("orderMargin")
    @Expose
    private Double orderMargin;
    @SerializedName("balances")
    @Expose
    private Integer balances;
    @SerializedName("marginRate")
    @Expose
    private Integer marginRate;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("leverage")
    @Expose
    private Integer leverage;
    @SerializedName("marginBalances")
    @Expose
    private Integer marginBalances;
    @SerializedName("positionMargin")
    @Expose
    private Integer positionMargin;
    @SerializedName("available")
    @Expose
    private Double available;
    @SerializedName("unrealizedPnl")
    @Expose
    private Integer unrealizedPnl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("margin")
    @Expose
    private Integer margin;

    public Double getOrderMargin() {
        return orderMargin;
    }

    public void setOrderMargin(Double orderMargin) {
        this.orderMargin = orderMargin;
    }

    public Integer getBalances() {
        return balances;
    }

    public void setBalances(Integer balances) {
        this.balances = balances;
    }

    public Integer getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(Integer marginRate) {
        this.marginRate = marginRate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLeverage() {
        return leverage;
    }

    public void setLeverage(Integer leverage) {
        this.leverage = leverage;
    }

    public Integer getMarginBalances() {
        return marginBalances;
    }

    public void setMarginBalances(Integer marginBalances) {
        this.marginBalances = marginBalances;
    }

    public Integer getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(Integer positionMargin) {
        this.positionMargin = positionMargin;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Integer getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public void setUnrealizedPnl(Integer unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

}
