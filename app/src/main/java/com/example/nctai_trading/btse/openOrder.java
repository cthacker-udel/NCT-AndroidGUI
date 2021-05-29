package com.example.nctai_trading.btse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class openOrder {

    @SerializedName("averageFillPrice")
    @Expose
    private Integer averageFillPrice;
    @SerializedName("cancelDuration")
    @Expose
    private Integer cancelDuration;
    @SerializedName("clOrderID")
    @Expose
    private String clOrderID;
    @SerializedName("fillSize")
    @Expose
    private Integer fillSize;
    @SerializedName("filledSize")
    @Expose
    private Integer filledSize;
    @SerializedName("orderID")
    @Expose
    private String orderID;
    @SerializedName("orderState")
    @Expose
    private String orderState;
    @SerializedName("orderType")
    @Expose
    private Integer orderType;
    @SerializedName("orderValue")
    @Expose
    private Double orderValue;
    @SerializedName("pegPriceDeviation")
    @Expose
    private Integer pegPriceDeviation;
    @SerializedName("pegPriceMax")
    @Expose
    private Integer pegPriceMax;
    @SerializedName("pegPriceMin")
    @Expose
    private Integer pegPriceMin;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("trailValue")
    @Expose
    private Integer trailValue;
    @SerializedName("triggerOrder")
    @Expose
    private Boolean triggerOrder;
    @SerializedName("triggerOrderType")
    @Expose
    private Integer triggerOrderType;
    @SerializedName("triggerOriginalPrice")
    @Expose
    private Integer triggerOriginalPrice;
    @SerializedName("triggerPrice")
    @Expose
    private Integer triggerPrice;
    @SerializedName("triggerStopPrice")
    @Expose
    private Integer triggerStopPrice;
    @SerializedName("triggerTrailingStopDeviation")
    @Expose
    private Integer triggerTrailingStopDeviation;
    @SerializedName("triggered")
    @Expose
    private Boolean triggered;

    public Integer getAverageFillPrice() {
        return averageFillPrice;
    }

    public void setAverageFillPrice(Integer averageFillPrice) {
        this.averageFillPrice = averageFillPrice;
    }

    public Integer getCancelDuration() {
        return cancelDuration;
    }

    public void setCancelDuration(Integer cancelDuration) {
        this.cancelDuration = cancelDuration;
    }

    public String getClOrderID() {
        return clOrderID;
    }

    public void setClOrderID(String clOrderID) {
        this.clOrderID = clOrderID;
    }

    public Integer getFillSize() {
        return fillSize;
    }

    public void setFillSize(Integer fillSize) {
        this.fillSize = fillSize;
    }

    public Integer getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(Integer filledSize) {
        this.filledSize = filledSize;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public Integer getPegPriceDeviation() {
        return pegPriceDeviation;
    }

    public void setPegPriceDeviation(Integer pegPriceDeviation) {
        this.pegPriceDeviation = pegPriceDeviation;
    }

    public Integer getPegPriceMax() {
        return pegPriceMax;
    }

    public void setPegPriceMax(Integer pegPriceMax) {
        this.pegPriceMax = pegPriceMax;
    }

    public Integer getPegPriceMin() {
        return pegPriceMin;
    }

    public void setPegPriceMin(Integer pegPriceMin) {
        this.pegPriceMin = pegPriceMin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTrailValue() {
        return trailValue;
    }

    public void setTrailValue(Integer trailValue) {
        this.trailValue = trailValue;
    }

    public Boolean getTriggerOrder() {
        return triggerOrder;
    }

    public void setTriggerOrder(Boolean triggerOrder) {
        this.triggerOrder = triggerOrder;
    }

    public Integer getTriggerOrderType() {
        return triggerOrderType;
    }

    public void setTriggerOrderType(Integer triggerOrderType) {
        this.triggerOrderType = triggerOrderType;
    }

    public Integer getTriggerOriginalPrice() {
        return triggerOriginalPrice;
    }

    public void setTriggerOriginalPrice(Integer triggerOriginalPrice) {
        this.triggerOriginalPrice = triggerOriginalPrice;
    }

    public Integer getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(Integer triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public Integer getTriggerStopPrice() {
        return triggerStopPrice;
    }

    public void setTriggerStopPrice(Integer triggerStopPrice) {
        this.triggerStopPrice = triggerStopPrice;
    }

    public Integer getTriggerTrailingStopDeviation() {
        return triggerTrailingStopDeviation;
    }

    public void setTriggerTrailingStopDeviation(Integer triggerTrailingStopDeviation) {
        this.triggerTrailingStopDeviation = triggerTrailingStopDeviation;
    }

    public Boolean getTriggered() {
        return triggered;
    }

    public void setTriggered(Boolean triggered) {
        this.triggered = triggered;
    }


}
