package com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketDepth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tick {

    @SerializedName("mrid")
    @Expose
    private Long mrid;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("bids")
    @Expose
    private List<List<Double>> bids = null;
    @SerializedName("asks")
    @Expose
    private List<List<Double>> asks = null;
    @SerializedName("ts")
    @Expose
    private Long ts;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("ch")
    @Expose
    private String ch;

    public Long getMrid() {
        return mrid;
    }

    public void setMrid(Long mrid) {
        this.mrid = mrid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<List<Double>> getBids() {
        return bids;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }

    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

}
