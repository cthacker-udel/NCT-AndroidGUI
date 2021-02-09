package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbConfigContractConfig {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("makerFeeRate")
    @Expose
    private String makerFeeRate;
    @SerializedName("takerFeeRate")
    @Expose
    private String takerFeeRate;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMakerFeeRate() {
        return makerFeeRate;
    }

    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public String getTakerFeeRate() {
        return takerFeeRate;
    }

    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

}
