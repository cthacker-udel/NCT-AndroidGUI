package com.example.nctai_trading.binanceUS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.RoundingMode;

public class serverTime {

    @SerializedName("serverTime")
    @Expose
    private Long serverTime;

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

}
