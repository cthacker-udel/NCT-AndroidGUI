package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiMarketDetailBatch {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ticks")
    @Expose
    private List<huobiMarketDetailBatchTick> ticks = null;
    @SerializedName("ts")
    @Expose
    private Integer ts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<huobiMarketDetailBatchTick> getTicks() {
        return ticks;
    }

    public void setTicks(List<huobiMarketDetailBatchTick> ticks) {
        this.ticks = ticks;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

}
