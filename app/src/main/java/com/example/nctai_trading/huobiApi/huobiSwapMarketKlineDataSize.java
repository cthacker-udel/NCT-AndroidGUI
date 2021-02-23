package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiSwapMarketKlineDataSize {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("data")
    @Expose
    private List<huobiSwapMarketKlineDataSizeDatum> data = null;
    @SerializedName("ts")
    @Expose
    private Integer ts;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public List<huobiSwapMarketKlineDataSizeDatum> getData() {
        return data;
    }

    public void setData(List<huobiSwapMarketKlineDataSizeDatum> data) {
        this.data = data;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

}
