package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetAccountMarginAccountPosition {

    @SerializedName("shortQuantity")
    @Expose
    private Integer shortQuantity;
    @SerializedName("averagePrice")
    @Expose
    private Integer averagePrice;
    @SerializedName("currentDayProfitLoss")
    @Expose
    private Integer currentDayProfitLoss;
    @SerializedName("currentDayProfitLossPercentage")
    @Expose
    private Integer currentDayProfitLossPercentage;
    @SerializedName("longQuantity")
    @Expose
    private Integer longQuantity;
    @SerializedName("settledLongQuantity")
    @Expose
    private Integer settledLongQuantity;
    @SerializedName("settledShortQuantity")
    @Expose
    private Integer settledShortQuantity;
    @SerializedName("agedQuantity")
    @Expose
    private Integer agedQuantity;
    @SerializedName("instrument")
    @Expose
    private String instrument;
    @SerializedName("marketValue")
    @Expose
    private Integer marketValue;

    public Integer getShortQuantity() {
        return shortQuantity;
    }

    public void setShortQuantity(Integer shortQuantity) {
        this.shortQuantity = shortQuantity;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getCurrentDayProfitLoss() {
        return currentDayProfitLoss;
    }

    public void setCurrentDayProfitLoss(Integer currentDayProfitLoss) {
        this.currentDayProfitLoss = currentDayProfitLoss;
    }

    public Integer getCurrentDayProfitLossPercentage() {
        return currentDayProfitLossPercentage;
    }

    public void setCurrentDayProfitLossPercentage(Integer currentDayProfitLossPercentage) {
        this.currentDayProfitLossPercentage = currentDayProfitLossPercentage;
    }

    public Integer getLongQuantity() {
        return longQuantity;
    }

    public void setLongQuantity(Integer longQuantity) {
        this.longQuantity = longQuantity;
    }

    public Integer getSettledLongQuantity() {
        return settledLongQuantity;
    }

    public void setSettledLongQuantity(Integer settledLongQuantity) {
        this.settledLongQuantity = settledLongQuantity;
    }

    public Integer getSettledShortQuantity() {
        return settledShortQuantity;
    }

    public void setSettledShortQuantity(Integer settledShortQuantity) {
        this.settledShortQuantity = settledShortQuantity;
    }

    public Integer getAgedQuantity() {
        return agedQuantity;
    }

    public void setAgedQuantity(Integer agedQuantity) {
        this.agedQuantity = agedQuantity;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Integer getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
    }

}
