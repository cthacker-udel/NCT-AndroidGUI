package com.example.nctai_trading.bybit.tradeRecords;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trade {

    @SerializedName("closed_size")
    @Expose
    private Integer closedSize;
    @SerializedName("cross_seq")
    @Expose
    private Integer crossSeq;
    @SerializedName("exec_fee")
    @Expose
    private String execFee;
    @SerializedName("exec_id")
    @Expose
    private String execId;
    @SerializedName("exec_price")
    @Expose
    private String execPrice;
    @SerializedName("exec_qty")
    @Expose
    private Integer execQty;
    @SerializedName("exec_time")
    @Expose
    private String execTime;
    @SerializedName("exec_type")
    @Expose
    private String execType;
    @SerializedName("exec_value")
    @Expose
    private String execValue;
    @SerializedName("fee_rate")
    @Expose
    private String feeRate;
    @SerializedName("last_liquidity_ind")
    @Expose
    private String lastLiquidityInd;
    @SerializedName("leaves_qty")
    @Expose
    private Integer leavesQty;
    @SerializedName("nth_fill")
    @Expose
    private Integer nthFill;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("order_link_id")
    @Expose
    private String orderLinkId;
    @SerializedName("order_price")
    @Expose
    private String orderPrice;
    @SerializedName("order_qty")
    @Expose
    private Integer orderQty;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("trade_time_ms")
    @Expose
    private Long tradeTimeMs;

    public Integer getClosedSize() {
        return closedSize;
    }

    public void setClosedSize(Integer closedSize) {
        this.closedSize = closedSize;
    }

    public Integer getCrossSeq() {
        return crossSeq;
    }

    public void setCrossSeq(Integer crossSeq) {
        this.crossSeq = crossSeq;
    }

    public String getExecFee() {
        return execFee;
    }

    public void setExecFee(String execFee) {
        this.execFee = execFee;
    }

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public String getExecPrice() {
        return execPrice;
    }

    public void setExecPrice(String execPrice) {
        this.execPrice = execPrice;
    }

    public Integer getExecQty() {
        return execQty;
    }

    public void setExecQty(Integer execQty) {
        this.execQty = execQty;
    }

    public String getExecTime() {
        return execTime;
    }

    public void setExecTime(String execTime) {
        this.execTime = execTime;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getExecValue() {
        return execValue;
    }

    public void setExecValue(String execValue) {
        this.execValue = execValue;
    }

    public String getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }

    public String getLastLiquidityInd() {
        return lastLiquidityInd;
    }

    public void setLastLiquidityInd(String lastLiquidityInd) {
        this.lastLiquidityInd = lastLiquidityInd;
    }

    public Integer getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(Integer leavesQty) {
        this.leavesQty = leavesQty;
    }

    public Integer getNthFill() {
        return nthFill;
    }

    public void setNthFill(Integer nthFill) {
        this.nthFill = nthFill;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTradeTimeMs() {
        return tradeTimeMs;
    }

    public void setTradeTimeMs(Long tradeTimeMs) {
        this.tradeTimeMs = tradeTimeMs;
    }


}
