package com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tick {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("ask")
    @Expose
    private List<Double> ask = null;
    @SerializedName("bid")
    @Expose
    private List<Double> bid = null;
    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("open")
    @Expose
    private String open;
    @SerializedName("ts")
    @Expose
    private Long ts;
    @SerializedName("vol")
    @Expose
    private String vol;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Double> getAsk() {
        return ask;
    }

    public void setAsk(List<Double> ask) {
        this.ask = ask;
    }

    public List<Double> getBid() {
        return bid;
    }

    public void setBid(List<Double> bid) {
        this.bid = bid;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

}
