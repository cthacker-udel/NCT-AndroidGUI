package com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview.Batch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketDataOverviewBatch {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ticks")
    @Expose
    private List<Tick> ticks = null;
    @SerializedName("ts")
    @Expose
    private Long ts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Tick> getTicks() {
        return ticks;
    }

    public void setTicks(List<Tick> ticks) {
        this.ticks = ticks;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

}
