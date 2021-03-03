package com.example.nctai_trading.bybit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitbyOrderResponseResult {

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("time_in_force")
    @Expose
    private String timeInForce;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("last_exec_price")
    @Expose
    private Integer lastExecPrice;
    @SerializedName("cum_exec_qty")
    @Expose
    private Integer cumExecQty;
    @SerializedName("cum_exec_value")
    @Expose
    private Integer cumExecValue;
    @SerializedName("cum_exec_fee")
    @Expose
    private Integer cumExecFee;
    @SerializedName("reduce_only")
    @Expose
    private Boolean reduceOnly;
    @SerializedName("close_on_trigger")
    @Expose
    private Boolean closeOnTrigger;
    @SerializedName("order_link_id")
    @Expose
    private String orderLinkId;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getLastExecPrice() {
        return lastExecPrice;
    }

    public void setLastExecPrice(Integer lastExecPrice) {
        this.lastExecPrice = lastExecPrice;
    }

    public Integer getCumExecQty() {
        return cumExecQty;
    }

    public void setCumExecQty(Integer cumExecQty) {
        this.cumExecQty = cumExecQty;
    }

    public Integer getCumExecValue() {
        return cumExecValue;
    }

    public void setCumExecValue(Integer cumExecValue) {
        this.cumExecValue = cumExecValue;
    }

    public Integer getCumExecFee() {
        return cumExecFee;
    }

    public void setCumExecFee(Integer cumExecFee) {
        this.cumExecFee = cumExecFee;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public Boolean getCloseOnTrigger() {
        return closeOnTrigger;
    }

    public void setCloseOnTrigger(Boolean closeOnTrigger) {
        this.closeOnTrigger = closeOnTrigger;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
