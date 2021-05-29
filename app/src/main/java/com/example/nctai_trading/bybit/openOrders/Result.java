package com.example.nctai_trading.bybit.openOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

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
    private String price;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("time_in_force")
    @Expose
    private String timeInForce;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("ext_fields")
    @Expose
    private ExtFields extFields;
    @SerializedName("last_exec_time")
    @Expose
    private String lastExecTime;
    @SerializedName("leaves_qty")
    @Expose
    private Integer leavesQty;
    @SerializedName("leaves_value")
    @Expose
    private String leavesValue;
    @SerializedName("cum_exec_qty")
    @Expose
    private Integer cumExecQty;
    @SerializedName("cum_exec_value")
    @Expose
    private String cumExecValue;
    @SerializedName("cum_exec_fee")
    @Expose
    private String cumExecFee;
    @SerializedName("reject_reason")
    @Expose
    private String rejectReason;
    @SerializedName("cancel_type")
    @Expose
    private String cancelType;
    @SerializedName("order_link_id")
    @Expose
    private String orderLinkId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("order_id")
    @Expose
    private String orderId;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public ExtFields getExtFields() {
        return extFields;
    }

    public void setExtFields(ExtFields extFields) {
        this.extFields = extFields;
    }

    public String getLastExecTime() {
        return lastExecTime;
    }

    public void setLastExecTime(String lastExecTime) {
        this.lastExecTime = lastExecTime;
    }

    public Integer getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(Integer leavesQty) {
        this.leavesQty = leavesQty;
    }

    public String getLeavesValue() {
        return leavesValue;
    }

    public void setLeavesValue(String leavesValue) {
        this.leavesValue = leavesValue;
    }

    public Integer getCumExecQty() {
        return cumExecQty;
    }

    public void setCumExecQty(Integer cumExecQty) {
        this.cumExecQty = cumExecQty;
    }

    public String getCumExecValue() {
        return cumExecValue;
    }

    public void setCumExecValue(String cumExecValue) {
        this.cumExecValue = cumExecValue;
    }

    public String getCumExecFee() {
        return cumExecFee;
    }

    public void setCumExecFee(String cumExecFee) {
        this.cumExecFee = cumExecFee;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
