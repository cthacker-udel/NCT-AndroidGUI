package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BAT____ {

    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("remaining")
    @Expose
    private String remaining;
    @SerializedName("period_in_days")
    @Expose
    private Integer periodInDays;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public Integer getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(Integer periodInDays) {
        this.periodInDays = periodInDays;
    }

}
