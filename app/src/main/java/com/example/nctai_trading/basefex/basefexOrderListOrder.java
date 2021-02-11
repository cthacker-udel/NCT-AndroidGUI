package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexOrderListOrder {

    @SerializedName("liquidateUserId")
    @Expose
    private Object liquidateUserId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("filledNotional")
    @Expose
    private Integer filledNotional;
    @SerializedName("notional")
    @Expose
    private Double notional;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("isLiquidate")
    @Expose
    private Boolean isLiquidate;
    @SerializedName("reduceOnly")
    @Expose
    private Boolean reduceOnly;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("seqNo")
    @Expose
    private Object seqNo;
    @SerializedName("filled")
    @Expose
    private Integer filled;
    @SerializedName("conditional")
    @Expose
    private Object conditional;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("avgPrice")
    @Expose
    private Integer avgPrice;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("meta")
    @Expose
    private basefexOrderListOrderMeta meta;

    public Object getLiquidateUserId() {
        return liquidateUserId;
    }

    public void setLiquidateUserId(Object liquidateUserId) {
        this.liquidateUserId = liquidateUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getFilledNotional() {
        return filledNotional;
    }

    public void setFilledNotional(Integer filledNotional) {
        this.filledNotional = filledNotional;
    }

    public Double getNotional() {
        return notional;
    }

    public void setNotional(Double notional) {
        this.notional = notional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsLiquidate() {
        return isLiquidate;
    }

    public void setIsLiquidate(Boolean isLiquidate) {
        this.isLiquidate = isLiquidate;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Object getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Object seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getFilled() {
        return filled;
    }

    public void setFilled(Integer filled) {
        this.filled = filled;
    }

    public Object getConditional() {
        return conditional;
    }

    public void setConditional(Object conditional) {
        this.conditional = conditional;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Integer avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public basefexOrderListOrderMeta getMeta() {
        return meta;
    }

    public void setMeta(basefexOrderListOrderMeta meta) {
        this.meta = meta;
    }

}
