package com.example.nctai_trading.alpaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class alpacaOrderListOrder {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("client_order_id")
    @Expose
    private String clientOrderId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("submitted_at")
    @Expose
    private String submittedAt;
    @SerializedName("filled_at")
    @Expose
    private String filledAt;
    @SerializedName("expired_at")
    @Expose
    private String expiredAt;
    @SerializedName("canceled_at")
    @Expose
    private String canceledAt;
    @SerializedName("failed_at")
    @Expose
    private String failedAt;
    @SerializedName("replaced_at")
    @Expose
    private String replacedAt;
    @SerializedName("replaced_by")
    @Expose
    private String replacedBy;
    @SerializedName("replaces")
    @Expose
    private Object replaces;
    @SerializedName("asset_id")
    @Expose
    private String assetId;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("asset_class")
    @Expose
    private String assetClass;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("filled_qty")
    @Expose
    private String filledQty;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("time_in_force")
    @Expose
    private String timeInForce;
    @SerializedName("limit_price")
    @Expose
    private String limitPrice;
    @SerializedName("stop_price")
    @Expose
    private String stopPrice;
    @SerializedName("filled_avg_price")
    @Expose
    private String filledAvgPrice;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("extended_hours")
    @Expose
    private Boolean extendedHours;
    @SerializedName("legs")
    @Expose
    private Object legs;
    @SerializedName("trail_price")
    @Expose
    private String trailPrice;
    @SerializedName("trail_percent")
    @Expose
    private Object trailPercent;
    @SerializedName("hwm")
    @Expose
    private String hwm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
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

    public String getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getFilledAt() {
        return filledAt;
    }

    public void setFilledAt(String filledAt) {
        this.filledAt = filledAt;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(String failedAt) {
        this.failedAt = failedAt;
    }

    public String getReplacedAt() {
        return replacedAt;
    }

    public void setReplacedAt(String replacedAt) {
        this.replacedAt = replacedAt;
    }

    public String getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(String replacedBy) {
        this.replacedBy = replacedBy;
    }

    public Object getReplaces() {
        return replaces;
    }

    public void setReplaces(Object replaces) {
        this.replaces = replaces;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getFilledQty() {
        return filledQty;
    }

    public void setFilledQty(String filledQty) {
        this.filledQty = filledQty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getFilledAvgPrice() {
        return filledAvgPrice;
    }

    public void setFilledAvgPrice(String filledAvgPrice) {
        this.filledAvgPrice = filledAvgPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getExtendedHours() {
        return extendedHours;
    }

    public void setExtendedHours(Boolean extendedHours) {
        this.extendedHours = extendedHours;
    }

    public Object getLegs() {
        return legs;
    }

    public void setLegs(Object legs) {
        this.legs = legs;
    }

    public String getTrailPrice() {
        return trailPrice;
    }

    public void setTrailPrice(String trailPrice) {
        this.trailPrice = trailPrice;
    }

    public Object getTrailPercent() {
        return trailPercent;
    }

    public void setTrailPercent(Object trailPercent) {
        this.trailPercent = trailPercent;
    }

    public String getHwm() {
        return hwm;
    }

    public void setHwm(String hwm) {
        this.hwm = hwm;
    }

}
