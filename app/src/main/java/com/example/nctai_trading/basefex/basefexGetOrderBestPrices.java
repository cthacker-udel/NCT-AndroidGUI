package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexGetOrderBestPrices {

    @SerializedName("ask")
    @Expose
    private Object ask;
    @SerializedName("bid")
    @Expose
    private Object bid;

    public Object getAsk() {
        return ask;
    }

    public void setAsk(Object ask) {
        this.ask = ask;
    }

    public Object getBid() {
        return bid;
    }

    public void setBid(Object bid) {
        this.bid = bid;
    }

}
