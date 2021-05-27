package com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("close")
    @Expose
    private Integer close;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("vol")
    @Expose
    private Integer vol;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getClose() {
        return close;
    }

    public void setClose(Integer close) {
        this.close = close;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

}
