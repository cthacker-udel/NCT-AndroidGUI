package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradePriceHistoryCandle {

    @SerializedName("close")
    @Expose
    private Integer close;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    @SerializedName("high")
    @Expose
    private Integer high;
    @SerializedName("low")
    @Expose
    private Integer low;
    @SerializedName("open")
    @Expose
    private Integer open;
    @SerializedName("volume")
    @Expose
    private Integer volume;

    public Integer getClose() {
        return close;
    }

    public void setClose(Integer close) {
        this.close = close;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }


}
