package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexTradeListTrade {

    @SerializedName("fee")
    @Expose
    private Double fee;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("feeRate")
    @Expose
    private Double feeRate;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("notional")
    @Expose
    private Double notional;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("order")
    @Expose
    private basefexTradeListTradeOrder order;
    @SerializedName("price")
    @Expose
    private Integer price;

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Double getNotional() {
        return notional;
    }

    public void setNotional(Double notional) {
        this.notional = notional;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public basefexTradeListTradeOrder getOrder() {
        return order;
    }

    public void setOrder(basefexTradeListTradeOrder order) {
        this.order = order;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
