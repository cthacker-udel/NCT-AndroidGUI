package com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trade {

    @SerializedName("trade_id")
    @Expose
    private Long tradeId;
    @SerializedName("trade_price")
    @Expose
    private Double tradePrice;
    @SerializedName("trade_volume")
    @Expose
    private Double tradeVolume;
    @SerializedName("trade_turnover")
    @Expose
    private Double tradeTurnover;
    @SerializedName("trade_fee")
    @Expose
    private Double tradeFee;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("fee_asset")
    @Expose
    private String feeAsset;
    @SerializedName("real_profit")
    @Expose
    private Integer realProfit;
    @SerializedName("profit")
    @Expose
    private Double profit;
    @SerializedName("id")
    @Expose
    private String id;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Double getTradeTurnover() {
        return tradeTurnover;
    }

    public void setTradeTurnover(Double tradeTurnover) {
        this.tradeTurnover = tradeTurnover;
    }

    public Double getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(Double tradeFee) {
        this.tradeFee = tradeFee;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public Integer getRealProfit() {
        return realProfit;
    }

    public void setRealProfit(Integer realProfit) {
        this.realProfit = realProfit;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
