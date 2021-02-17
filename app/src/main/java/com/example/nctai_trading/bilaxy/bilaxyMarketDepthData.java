package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bilaxyMarketDepthData {

    @SerializedName("asks")
    @Expose
    private List<List<Double>> asks = null;
    @SerializedName("bids")
    @Expose
    private List<List<Double>> bids = null;

    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }

    public List<List<Double>> getBids() {
        return bids;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }

}
