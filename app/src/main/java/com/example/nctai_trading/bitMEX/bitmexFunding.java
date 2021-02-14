package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class bitmexFunding {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("fundingInterval")
    @Expose
    private String fundingInterval;
    @SerializedName("fundingRate")
    @Expose
    private BigDecimal fundingRate;
    @SerializedName("fundingRateDaily")
    @Expose
    private BigDecimal fundingRateDaily;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFundingInterval() {
        return fundingInterval;
    }

    public void setFundingInterval(String fundingInterval) {
        this.fundingInterval = fundingInterval;
    }

    public BigDecimal getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(BigDecimal fundingRate) {
        this.fundingRate = fundingRate;
    }

    public BigDecimal getFundingRateDaily() {
        return fundingRateDaily;
    }

    public void setFundingRateDaily(BigDecimal fundingRateDaily) {
        this.fundingRateDaily = fundingRateDaily;
    }

}
