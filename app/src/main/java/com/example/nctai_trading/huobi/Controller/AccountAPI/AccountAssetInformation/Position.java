package com.example.nctai_trading.huobi.Controller.AccountAPI.AccountAssetInformation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("volume")
    @Expose
    private Double volume;
    @SerializedName("available")
    @Expose
    private Double available;
    @SerializedName("frozen")
    @Expose
    private Integer frozen;
    @SerializedName("cost_open")
    @Expose
    private Double costOpen;
    @SerializedName("cost_hold")
    @Expose
    private Double costHold;
    @SerializedName("profit_unreal")
    @Expose
    private Double profitUnreal;
    @SerializedName("profit_rate")
    @Expose
    private Double profitRate;
    @SerializedName("lever_rate")
    @Expose
    private Integer leverRate;
    @SerializedName("position_margin")
    @Expose
    private Double positionMargin;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("profit")
    @Expose
    private Double profit;
    @SerializedName("last_price")
    @Expose
    private Double lastPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public Double getCostOpen() {
        return costOpen;
    }

    public void setCostOpen(Double costOpen) {
        this.costOpen = costOpen;
    }

    public Double getCostHold() {
        return costHold;
    }

    public void setCostHold(Double costHold) {
        this.costHold = costHold;
    }

    public Double getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(Double profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Double profitRate) {
        this.profitRate = profitRate;
    }

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public Double getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(Double positionMargin) {
        this.positionMargin = positionMargin;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }


}
