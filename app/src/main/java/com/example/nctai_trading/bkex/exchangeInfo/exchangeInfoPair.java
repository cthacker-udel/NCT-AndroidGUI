package com.example.nctai_trading.bkex.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exchangeInfoPair {

    @SerializedName("pair")
    @Expose
    private String pair;
    @SerializedName("isSupportTrade")
    @Expose
    private Boolean isSupportTrade;
    @SerializedName("pricePrecision")
    @Expose
    private Integer pricePrecision;
    @SerializedName("amountPrecision")
    @Expose
    private Integer amountPrecision;
    @SerializedName("minimumTradeAmount")
    @Expose
    private Double minimumTradeAmount;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Boolean getIsSupportTrade() {
        return isSupportTrade;
    }

    public void setIsSupportTrade(Boolean isSupportTrade) {
        this.isSupportTrade = isSupportTrade;
    }

    public Integer getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Integer pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Integer getAmountPrecision() {
        return amountPrecision;
    }

    public void setAmountPrecision(Integer amountPrecision) {
        this.amountPrecision = amountPrecision;
    }

    public Double getMinimumTradeAmount() {
        return minimumTradeAmount;
    }

    public void setMinimumTradeAmount(Double minimumTradeAmount) {
        this.minimumTradeAmount = minimumTradeAmount;
    }

}
