package com.example.nctai_trading.binance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("clientOrderId")
    @Expose
    private String clientOrderId;

    // first converts it to an order, then uses the toJson method to convert it to a string, then passes
    // the resulting string to get signature

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

}
