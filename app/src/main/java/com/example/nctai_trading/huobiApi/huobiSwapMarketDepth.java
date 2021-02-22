package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class huobiSwapMarketDepth {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ts")
    @Expose
    private Double ts;
    @SerializedName("tick")
    @Expose
    private huobiSwapMarketDepthTick tick;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

    public huobiSwapMarketDepthTick getTick() {
        return tick;
    }

    public void setTick(huobiSwapMarketDepthTick tick) {
        this.tick = tick;
    }

}
