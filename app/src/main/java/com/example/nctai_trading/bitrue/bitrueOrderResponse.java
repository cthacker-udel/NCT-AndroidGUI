package com.example.nctai_trading.bitrue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitrueOrderResponse {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("clientOrderId")
    @Expose
    private String clientOrderId;
    @SerializedName("transactTime")
    @Expose
    private Integer transactTime;

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

    public Integer getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(Integer transactTime) {
        this.transactTime = transactTime;
    }


}
