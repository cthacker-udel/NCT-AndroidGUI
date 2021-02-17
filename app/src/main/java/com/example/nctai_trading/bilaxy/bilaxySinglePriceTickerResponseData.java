package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxySinglePriceTickerResponseData {

    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("vol")
    @Expose
    private Double vol;
    @SerializedName("last")
    @Expose
    private Double last;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("buy")
    @Expose
    private Double buy;
    @SerializedName("sell")
    @Expose
    private Double sell;

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
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

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }


}
