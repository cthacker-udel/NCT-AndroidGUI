package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiSwapMarketKlineData {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("data")
    @Expose
    private List<huobiSwapMarketKlineDataData> data = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ts")
    @Expose
    private Double ts;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public List<huobiSwapMarketKlineDataData> getData() {
        return data;
    }

    public void setData(List<huobiSwapMarketKlineDataData> data) {
        this.data = data;
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

}
