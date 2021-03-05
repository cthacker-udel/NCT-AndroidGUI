package com.example.nctai_trading.exante;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exanteOrderResponse {

    @SerializedName("orderType")
    @Expose
    private String orderType;
    @SerializedName("gttExpiration")
    @Expose
    private String gttExpiration;
    @SerializedName("ocoGroup")
    @Expose
    private String ocoGroup;
    @SerializedName("stopLoss")
    @Expose
    private String stopLoss;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("placeInterval")
    @Expose
    private String placeInterval;
    @SerializedName("ifDoneParentId")
    @Expose
    private String ifDoneParentId;
    @SerializedName("priceDistance")
    @Expose
    private String priceDistance;
    @SerializedName("stopPrice")
    @Expose
    private String stopPrice;
    @SerializedName("partQuantity")
    @Expose
    private String partQuantity;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("takeProfit")
    @Expose
    private String takeProfit;
    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("clientTag")
    @Expose
    private String clientTag;
    @SerializedName("instrument")
    @Expose
    private String instrument;
    @SerializedName("symbolId")
    @Expose
    private String symbolId;
    @SerializedName("limitPrice")
    @Expose
    private String limitPrice;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getGttExpiration() {
        return gttExpiration;
    }

    public void setGttExpiration(String gttExpiration) {
        this.gttExpiration = gttExpiration;
    }

    public String getOcoGroup() {
        return ocoGroup;
    }

    public void setOcoGroup(String ocoGroup) {
        this.ocoGroup = ocoGroup;
    }

    public String getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(String stopLoss) {
        this.stopLoss = stopLoss;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlaceInterval() {
        return placeInterval;
    }

    public void setPlaceInterval(String placeInterval) {
        this.placeInterval = placeInterval;
    }

    public String getIfDoneParentId() {
        return ifDoneParentId;
    }

    public void setIfDoneParentId(String ifDoneParentId) {
        this.ifDoneParentId = ifDoneParentId;
    }

    public String getPriceDistance() {
        return priceDistance;
    }

    public void setPriceDistance(String priceDistance) {
        this.priceDistance = priceDistance;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getPartQuantity() {
        return partQuantity;
    }

    public void setPartQuantity(String partQuantity) {
        this.partQuantity = partQuantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getClientTag() {
        return clientTag;
    }

    public void setClientTag(String clientTag) {
        this.clientTag = clientTag;
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

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

}
