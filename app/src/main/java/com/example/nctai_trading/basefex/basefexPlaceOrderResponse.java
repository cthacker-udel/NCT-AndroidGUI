package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexPlaceOrderResponse {

    @SerializedName("meta")
    @Expose
    private Object meta;
    @SerializedName("reduceOnly")
    @Expose
    private Boolean reduceOnly;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("liquidateUserId")
    @Expose
    private Object liquidateUserId;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("notional")
    @Expose
    private Integer notional;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("filledNotional")
    @Expose
    private Integer filledNotional;
    @SerializedName("seqNo")
    @Expose
    private Object seqNo;
    @SerializedName("filled")
    @Expose
    private Integer filled;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("conditional")
    @Expose
    private basefexPlaceOrderResponseConditional conditional;

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getLiquidateUserId() {
        return liquidateUserId;
    }

    public void setLiquidateUserId(Object liquidateUserId) {
        this.liquidateUserId = liquidateUserId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getFilledNotional() {
        return filledNotional;
    }

    public void setFilledNotional(Integer filledNotional) {
        this.filledNotional = filledNotional;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public basefexPlaceOrderResponseConditional getConditional() {
        return conditional;
    }

    public void setConditional(basefexPlaceOrderResponseConditional conditional) {
        this.conditional = conditional;
    }

}
