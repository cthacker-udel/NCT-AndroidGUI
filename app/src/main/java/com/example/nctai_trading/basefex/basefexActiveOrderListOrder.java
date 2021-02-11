package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexActiveOrderListOrder {

    @SerializedName("liquidateUserId")
    @Expose
    private Object liquidateUserId;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("notional")
    @Expose
    private Integer notional;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("filledNotional")
    @Expose
    private Integer filledNotional;
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
    @SerializedName("meta")
    @Expose
    private Object meta;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("avgPrice")
    @Expose
    private Integer avgPrice;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("conditional")
    @Expose
    private basefexActiveOrderListConditional conditional;
    @SerializedName("id")
    @Expose
    private String id;

    public Object getLiquidateUserId() {
        return liquidateUserId;
    }

    public void setLiquidateUserId(Object liquidateUserId) {
        this.liquidateUserId = liquidateUserId;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNotional() {
        return notional;
    }

    public void setNotional(Integer notional) {
        this.notional = notional;
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

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public basefexActiveOrderListConditional getConditional() {
        return conditional;
    }

    public void setConditional(basefexActiveOrderListConditional conditional) {
        this.conditional = conditional;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
