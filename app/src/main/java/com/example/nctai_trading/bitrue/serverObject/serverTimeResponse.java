package com.example.nctai_trading.bitrue.serverObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class serverTimeResponse {

    @SerializedName("serverTime")
    @Expose
    private Double serverTime;

    public Double getServerTime() {
        return serverTime;
    }

    public void setServerTime(Double serverTime) {
        this.serverTime = serverTime;
    }

}
