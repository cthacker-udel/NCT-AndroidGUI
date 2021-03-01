package com.example.nctai_trading.bitrue.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exchangeInfoRateLimit {

    @SerializedName("rateLimitType")
    @Expose
    private String rateLimitType;
    @SerializedName("interval")
    @Expose
    private String interval;
    @SerializedName("limit")
    @Expose
    private Double limit;

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

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

}
