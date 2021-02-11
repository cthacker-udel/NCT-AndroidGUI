package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexOrderListOrderMeta {

    @SerializedName("bestPrice")
    @Expose
    private Integer bestPrice;
    @SerializedName("markPrice")
    @Expose
    private Double markPrice;
    @SerializedName("bestPrices")
    @Expose
    private basefexOrderListOrderBestPrices bestPrices;

    public Integer getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(Integer bestPrice) {
        this.bestPrice = bestPrice;
    }

    public Double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }

    public basefexOrderListOrderBestPrices getBestPrices() {
        return bestPrices;
    }

    public void setBestPrices(basefexOrderListOrderBestPrices bestPrices) {
        this.bestPrices = bestPrices;
    }

}
