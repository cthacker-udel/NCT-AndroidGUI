package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbConfigSpotConfig {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("accuracy")
    @Expose
    private List<String> accuracy = null;
    @SerializedName("percentPrice")
    @Expose
    private bithumbConfigPercentPrice percentPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<String> getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(List<String> accuracy) {
        this.accuracy = accuracy;
    }

    public bithumbConfigPercentPrice getPercentPrice() {
        return percentPrice;
    }

    public void setPercentPrice(bithumbConfigPercentPrice percentPrice) {
        this.percentPrice = percentPrice;
    }

}
