package com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.MarkPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("count")
    @Expose
    private String count;
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
    @SerializedName("trade_turnover")
    @Expose
    private String tradeTurnover;
    @SerializedName("vol")
    @Expose
    private String vol;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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

    public String getTradeTurnover() {
        return tradeTurnover;
    }

    public void setTradeTurnover(String tradeTurnover) {
        this.tradeTurnover = tradeTurnover;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }


}
