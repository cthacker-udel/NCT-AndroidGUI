package com.example.nctai_trading.bitrue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitrueCancelOrder {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("origClientOrderId")
    @Expose
    private String origClientOrderId;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("clientOrderId")
    @Expose
    private String clientOrderId;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public void setOrigClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
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
