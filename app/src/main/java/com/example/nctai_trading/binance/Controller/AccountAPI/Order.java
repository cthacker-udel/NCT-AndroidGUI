package com.example.nctai_trading.binance.Controller.AccountAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

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
    @SerializedName("stopPrice")
    @Expose
    private String stopPrice;
    @SerializedName("icebergQty")
    @Expose
    private String icebergQty;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("updateTime")
    @Expose
    private Long updateTime;
    @SerializedName("isWorking")
    @Expose
    private Boolean isWorking;
    @SerializedName("origQuoteOrderQty")
    @Expose
    private String origQuoteOrderQty;

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

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getIcebergQty() {
        return icebergQty;
    }

    public void setIcebergQty(String icebergQty) {
        this.icebergQty = icebergQty;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    public String getOrigQuoteOrderQty() {
        return origQuoteOrderQty;
    }

    public void setOrigQuoteOrderQty(String origQuoteOrderQty) {
        this.origQuoteOrderQty = origQuoteOrderQty;
    }

}
