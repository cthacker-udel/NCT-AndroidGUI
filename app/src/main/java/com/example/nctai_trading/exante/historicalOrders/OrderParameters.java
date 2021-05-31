package com.example.nctai_trading.exante.historicalOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderParameters {

    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("ocoGroup")
    @Expose
    private String ocoGroup;
    @SerializedName("ifDoneParentId")
    @Expose
    private String ifDoneParentId;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("orderType")
    @Expose
    private String orderType;
    @SerializedName("stopPrice")
    @Expose
    private String stopPrice;
    @SerializedName("limitPrice")
    @Expose
    private String limitPrice;
    @SerializedName("partQuantity")
    @Expose
    private String partQuantity;
    @SerializedName("placeInterval")
    @Expose
    private String placeInterval;
    @SerializedName("priceDistance")
    @Expose
    private String priceDistance;
    @SerializedName("gttExpiration")
    @Expose
    private String gttExpiration;
    @SerializedName("instrument")
    @Expose
    private String instrument;
    @SerializedName("symbolId")
    @Expose
    private String symbolId;

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOcoGroup() {
        return ocoGroup;
    }

    public void setOcoGroup(String ocoGroup) {
        this.ocoGroup = ocoGroup;
    }

    public String getIfDoneParentId() {
        return ifDoneParentId;
    }

    public void setIfDoneParentId(String ifDoneParentId) {
        this.ifDoneParentId = ifDoneParentId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getPartQuantity() {
        return partQuantity;
    }

    public void setPartQuantity(String partQuantity) {
        this.partQuantity = partQuantity;
    }

    public String getPlaceInterval() {
        return placeInterval;
    }

    public void setPlaceInterval(String placeInterval) {
        this.placeInterval = placeInterval;
    }

    public String getPriceDistance() {
        return priceDistance;
    }

    public void setPriceDistance(String priceDistance) {
        this.priceDistance = priceDistance;
    }

    public String getGttExpiration() {
        return gttExpiration;
    }

    public void setGttExpiration(String gttExpiration) {
        this.gttExpiration = gttExpiration;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }


}
