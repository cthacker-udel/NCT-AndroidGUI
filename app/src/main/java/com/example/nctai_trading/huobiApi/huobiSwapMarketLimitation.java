package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiSwapMarketLimitation {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<huobiSwapMarketLimitationData> data = null;
    @SerializedName("ts")
    @Expose
    private Double ts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<huobiSwapMarketLimitationData> getData() {
        return data;
    }

    public void setData(List<huobiSwapMarketLimitationData> data) {
        this.data = data;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

}
