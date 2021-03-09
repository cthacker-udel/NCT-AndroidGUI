package com.example.nctai_trading.binance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateLimit {

    @SerializedName("rateLimitType")
    @Expose
    private String rateLimitType;
    @SerializedName("interval")
    @Expose
    private String interval;
    @SerializedName("intervalNum")
    @Expose
    private Integer intervalNum;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public String getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Integer getIntervalNum() {
        return intervalNum;
    }

    public void setIntervalNum(Integer intervalNum) {
        this.intervalNum = intervalNum;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
