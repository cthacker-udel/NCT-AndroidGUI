package com.example.nctai_trading.bybit.cancelAll;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("clOrdID")
    @Expose
    private String clOrdID;
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
    @SerializedName("create_type")
    @Expose
    private String createType;
    @SerializedName("cancel_type")
    @Expose
    private String cancelType;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("leaves_qty")
    @Expose
    private Integer leavesQty;
    @SerializedName("leaves_value")
    @Expose
    private String leavesValue;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cross_status")
    @Expose
    private String crossStatus;
    @SerializedName("cross_seq")
    @Expose
    private Integer crossSeq;

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
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

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getCrossStatus() {
        return crossStatus;
    }

    public void setCrossStatus(String crossStatus) {
        this.crossStatus = crossStatus;
    }

    public Integer getCrossSeq() {
        return crossSeq;
    }

    public void setCrossSeq(Integer crossSeq) {
        this.crossSeq = crossSeq;
    }

}
