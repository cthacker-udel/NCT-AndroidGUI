package com.example.nctai_trading.bitrue.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exchangeInfoFilters {

    @SerializedName("filterType")
    @Expose
    private String filterType;
    @SerializedName("minPrice")
    @Expose
    private String minPrice;
    @SerializedName("maxPrice")
    @Expose
    private String maxPrice;
    @SerializedName("tickSize")
    @Expose
    private String tickSize;
    @SerializedName("minQty")
    @Expose
    private String minQty;
    @SerializedName("maxQty")
    @Expose
    private String maxQty;
    @SerializedName("stepSize")
    @Expose
    private String stepSize;
    @SerializedName("minNotional")
    @Expose
    private String minNotional;

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getTickSize() {
        return tickSize;
    }

    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    public String getMinQty() {
        return minQty;
    }

    public void setMinQty(String minQty) {
        this.minQty = minQty;
    }

    public String getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(String maxQty) {
        this.maxQty = maxQty;
    }

    public String getStepSize() {
        return stepSize;
    }

    public void setStepSize(String stepSize) {
        this.stepSize = stepSize;
    }

    public String getMinNotional() {
        return minNotional;
    }

    public void setMinNotional(String minNotional) {
        this.minNotional = minNotional;
    }

}
