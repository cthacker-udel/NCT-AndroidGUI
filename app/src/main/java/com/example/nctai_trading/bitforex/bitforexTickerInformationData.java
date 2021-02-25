package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitforexTickerInformationData {

    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("buy")
    @Expose
    private Double buy;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("last")
    @Expose
    private Double last;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("sell")
    @Expose
    private Double sell;
    @SerializedName("vol")
    @Expose
    private Integer vol;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

}
