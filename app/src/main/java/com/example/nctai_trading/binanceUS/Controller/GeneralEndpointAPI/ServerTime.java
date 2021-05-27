package com.example.nctai_trading.binanceUS.Controller.GeneralEndpointAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServerTime {

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
