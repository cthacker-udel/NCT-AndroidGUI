package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiSwapMarketDepthTick {

    @SerializedName("mrid")
    @Expose
    private Double mrid;
    @SerializedName("id")
    @Expose
    private Double id;
    @SerializedName("bids")
    @Expose
    private List<List<Double>> bids = null;
    @SerializedName("asks")
    @Expose
    private List<List<Double>> asks = null;
    @SerializedName("ts")
    @Expose
    private Double ts;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("ch")
    @Expose
    private String ch;

    public Double getMrid() {
        return mrid;
    }

    public void setMrid(Double mrid) {
        this.mrid = mrid;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
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

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
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
