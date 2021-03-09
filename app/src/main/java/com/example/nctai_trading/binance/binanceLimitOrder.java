package com.example.nctai_trading.binance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class binanceLimitOrder {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("orderListId")
    @Expose
    private Integer orderListId;
    @SerializedName("clientOrderId")
    @Expose
    private String clientOrderId;
    @SerializedName("transactTime")
    @Expose
    private Integer transactTime;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("origQty")
    @Expose
    private String origQty;
    @SerializedName("executedQty")
    @Expose
    private String executedQty;
    @SerializedName("cummulativeQuoteQty")
    @Expose
    private String cummulativeQuoteQty;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timeInForce")
    @Expose
    private String timeInForce;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("side")
    @Expose
    private String side;

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

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrigQty() {
        return origQty;
    }

    public void setOrigQty(String origQty) {
        this.origQty = origQty;
    }

    public String getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(String executedQty) {
        this.executedQty = executedQty;
    }

    public String getCummulativeQuoteQty() {
        return cummulativeQuoteQty;
    }

    public void setCummulativeQuoteQty(String cummulativeQuoteQty) {
        this.cummulativeQuoteQty = cummulativeQuoteQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
