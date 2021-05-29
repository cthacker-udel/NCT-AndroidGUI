package com.example.nctai_trading.btse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class historyTrade {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("clOrderID")
    @Expose
    private String clOrderID;
    @SerializedName("feeAmount")
    @Expose
    private Integer feeAmount;
    @SerializedName("feeCurrency")
    @Expose
    private String feeCurrency;
    @SerializedName("filledPrice")
    @Expose
    private Integer filledPrice;
    @SerializedName("filledSize")
    @Expose
    private Integer filledSize;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("orderType")
    @Expose
    private Integer orderType;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("realizedPnl")
    @Expose
    private Integer realizedPnl;
    @SerializedName("serialId")
    @Expose
    private Integer serialId;
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
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("tradeId")
    @Expose
    private String tradeId;
    @SerializedName("triggerPrice")
    @Expose
    private Integer triggerPrice;
    @SerializedName("triggerType")
    @Expose
    private Integer triggerType;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("wallet")
    @Expose
    private String wallet;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getClOrderID() {
        return clOrderID;
    }

    public void setClOrderID(String clOrderID) {
        this.clOrderID = clOrderID;
    }

    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public Integer getFilledPrice() {
        return filledPrice;
    }

    public void setFilledPrice(Integer filledPrice) {
        this.filledPrice = filledPrice;
    }

    public Integer getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(Integer filledSize) {
        this.filledSize = filledSize;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Integer getRealizedPnl() {
        return realizedPnl;
    }

    public void setRealizedPnl(Integer realizedPnl) {
        this.realizedPnl = realizedPnl;
    }

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(Integer triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public Integer getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Integer triggerType) {
        this.triggerType = triggerType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }


}
