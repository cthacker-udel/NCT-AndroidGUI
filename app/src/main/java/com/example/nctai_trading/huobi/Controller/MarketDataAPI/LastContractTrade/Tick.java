package com.example.nctai_trading.huobi.Controller.MarketDataAPI.LastContractTrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tick {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("ts")
    @Expose
    private Long ts;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

}
