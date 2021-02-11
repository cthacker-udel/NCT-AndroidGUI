package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexGetOrderMeta {

    @SerializedName("bestPrice")
    @Expose
    private Object bestPrice;
    @SerializedName("markPrice")
    @Expose
    private Double markPrice;
    @SerializedName("bestPrices")
    @Expose
    private basefexGetOrderBestPrices bestPrices;

    public Object getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(Object bestPrice) {
        this.bestPrice = bestPrice;
    }

    public Double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }

    public basefexGetOrderBestPrices getBestPrices() {
        return bestPrices;
    }

    public void setBestPrices(basefexGetOrderBestPrices bestPrices) {
        this.bestPrices = bestPrices;
    }

}
