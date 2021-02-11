package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexAdjustLeverage {

    @SerializedName("margin")
    @Expose
    private Integer margin;
    @SerializedName("leverage")
    @Expose
    private Integer leverage;
    @SerializedName("isCross")
    @Expose
    private Boolean isCross;

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public Integer getLeverage() {
        return leverage;
    }

    public void setLeverage(Integer leverage) {
        this.leverage = leverage;
    }

    public Boolean getIsCross() {
        return isCross;
    }

    public void setIsCross(Boolean isCross) {
        this.isCross = isCross;
    }

}
