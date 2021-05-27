package com.example.nctai_trading.binance.Controller.MarketAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderBookTicker {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("bidPrice")
    @Expose
    private String bidPrice;
    @SerializedName("bidQty")
    @Expose
    private String bidQty;
    @SerializedName("askPrice")
    @Expose
    private String askPrice;
    @SerializedName("askQty")
    @Expose
    private String askQty;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidQty() {
        return bidQty;
    }

    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public String getAskQty() {
        return askQty;
    }

    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }


}
