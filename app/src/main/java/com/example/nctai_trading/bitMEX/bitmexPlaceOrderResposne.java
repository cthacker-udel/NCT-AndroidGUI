package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitmexPlaceOrderResposne {

    @SerializedName("orderID")
    @Expose
    private String orderID;
    @SerializedName("clOrdID")
    @Expose
    private String clOrdID;
    @SerializedName("clOrdLinkID")
    @Expose
    private String clOrdLinkID;
    @SerializedName("account")
    @Expose
    private Integer account;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("simpleOrderQty")
    @Expose
    private Integer simpleOrderQty;
    @SerializedName("orderQty")
    @Expose
    private Integer orderQty;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("displayQty")
    @Expose
    private Integer displayQty;
    @SerializedName("stopPx")
    @Expose
    private Integer stopPx;
    @SerializedName("pegOffsetValue")
    @Expose
    private Integer pegOffsetValue;
    @SerializedName("pegPriceType")
    @Expose
    private String pegPriceType;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("settlCurrency")
    @Expose
    private String settlCurrency;
    @SerializedName("ordType")
    @Expose
    private String ordType;
    @SerializedName("timeInForce")
    @Expose
    private String timeInForce;
    @SerializedName("execInst")
    @Expose
    private String execInst;
    @SerializedName("contingencyType")
    @Expose
    private String contingencyType;
    @SerializedName("exDestination")
    @Expose
    private String exDestination;
    @SerializedName("ordStatus")
    @Expose
    private String ordStatus;
    @SerializedName("triggered")
    @Expose
    private String triggered;
    @SerializedName("workingIndicator")
    @Expose
    private Boolean workingIndicator;
    @SerializedName("ordRejReason")
    @Expose
    private String ordRejReason;
    @SerializedName("simpleLeavesQty")
    @Expose
    private Integer simpleLeavesQty;
    @SerializedName("leavesQty")
    @Expose
    private Integer leavesQty;
    @SerializedName("simpleCumQty")
    @Expose
    private Integer simpleCumQty;
    @SerializedName("cumQty")
    @Expose
    private Integer cumQty;
    @SerializedName("avgPx")
    @Expose
    private Integer avgPx;
    @SerializedName("multiLegReportingType")
    @Expose
    private String multiLegReportingType;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("transactTime")
    @Expose
    private String transactTime;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public String getClOrdLinkID() {
        return clOrdLinkID;
    }

    public void setClOrdLinkID(String clOrdLinkID) {
        this.clOrdLinkID = clOrdLinkID;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
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

    public Integer getSimpleOrderQty() {
        return simpleOrderQty;
    }

    public void setSimpleOrderQty(Integer simpleOrderQty) {
        this.simpleOrderQty = simpleOrderQty;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDisplayQty() {
        return displayQty;
    }

    public void setDisplayQty(Integer displayQty) {
        this.displayQty = displayQty;
    }

    public Integer getStopPx() {
        return stopPx;
    }

    public void setStopPx(Integer stopPx) {
        this.stopPx = stopPx;
    }

    public Integer getPegOffsetValue() {
        return pegOffsetValue;
    }

    public void setPegOffsetValue(Integer pegOffsetValue) {
        this.pegOffsetValue = pegOffsetValue;
    }

    public String getPegPriceType() {
        return pegPriceType;
    }

    public void setPegPriceType(String pegPriceType) {
        this.pegPriceType = pegPriceType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSettlCurrency() {
        return settlCurrency;
    }

    public void setSettlCurrency(String settlCurrency) {
        this.settlCurrency = settlCurrency;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getExecInst() {
        return execInst;
    }

    public void setExecInst(String execInst) {
        this.execInst = execInst;
    }

    public String getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
    }

    public String getExDestination() {
        return exDestination;
    }

    public void setExDestination(String exDestination) {
        this.exDestination = exDestination;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getTriggered() {
        return triggered;
    }

    public void setTriggered(String triggered) {
        this.triggered = triggered;
    }

    public Boolean getWorkingIndicator() {
        return workingIndicator;
    }

    public void setWorkingIndicator(Boolean workingIndicator) {
        this.workingIndicator = workingIndicator;
    }

    public String getOrdRejReason() {
        return ordRejReason;
    }

    public void setOrdRejReason(String ordRejReason) {
        this.ordRejReason = ordRejReason;
    }

    public Integer getSimpleLeavesQty() {
        return simpleLeavesQty;
    }

    public void setSimpleLeavesQty(Integer simpleLeavesQty) {
        this.simpleLeavesQty = simpleLeavesQty;
    }

    public Integer getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(Integer leavesQty) {
        this.leavesQty = leavesQty;
    }

    public Integer getSimpleCumQty() {
        return simpleCumQty;
    }

    public void setSimpleCumQty(Integer simpleCumQty) {
        this.simpleCumQty = simpleCumQty;
    }

    public Integer getCumQty() {
        return cumQty;
    }

    public void setCumQty(Integer cumQty) {
        this.cumQty = cumQty;
    }

    public Integer getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(Integer avgPx) {
        this.avgPx = avgPx;
    }

    public String getMultiLegReportingType() {
        return multiLegReportingType;
    }

    public void setMultiLegReportingType(String multiLegReportingType) {
        this.multiLegReportingType = multiLegReportingType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
