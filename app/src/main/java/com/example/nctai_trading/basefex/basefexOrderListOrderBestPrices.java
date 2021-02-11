package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexOrderListOrderBestPrices {

    @SerializedName("ask")
    @Expose
    private Integer ask;
    @SerializedName("bid")
    @Expose
    private Double bid;

    public Integer getAsk() {
        return ask;
    }

    public void setAsk(Integer ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

}
