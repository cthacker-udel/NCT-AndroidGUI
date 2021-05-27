package com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.MarkPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarkPrice {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("ts")
    @Expose
    private Long ts;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }


}
