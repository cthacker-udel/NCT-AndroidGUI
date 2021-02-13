package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private Integer fundingRate;
    @SerializedName("fundingRateDaily")
    @Expose
    private Integer fundingRateDaily;

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

    public Integer getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(Integer fundingRate) {
        this.fundingRate = fundingRate;
    }

    public Integer getFundingRateDaily() {
        return fundingRateDaily;
    }

    public void setFundingRateDaily(Integer fundingRateDaily) {
        this.fundingRateDaily = fundingRateDaily;
    }

}
