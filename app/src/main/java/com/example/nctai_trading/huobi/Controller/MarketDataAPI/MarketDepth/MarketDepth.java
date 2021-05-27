package com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketDepth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketDepth {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ts")
    @Expose
    private Long ts;
    @SerializedName("tick")
    @Expose
    private Tick tick;

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

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Tick getTick() {
        return tick;
    }

    public void setTick(Tick tick) {
        this.tick = tick;
    }

}
