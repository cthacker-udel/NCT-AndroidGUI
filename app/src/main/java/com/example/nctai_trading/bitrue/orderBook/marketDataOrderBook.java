package com.example.nctai_trading.bitrue.orderBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class marketDataOrderBook {

    @SerializedName("lastUpdateId")
    @Expose
    private Double lastUpdateId;
    @SerializedName("bids")
    @Expose
    private List<List<Object>> bids = null;
    @SerializedName("asks")
    @Expose
    private List<List<Object>> asks = null;

    public Double getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Double lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public List<List<Object>> getBids() {
        return bids;
    }

    public void setBids(List<List<Object>> bids) {
        this.bids = bids;
    }

    public List<List<Object>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Object>> asks) {
        this.asks = asks;
    }

}
