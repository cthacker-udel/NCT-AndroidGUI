package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ameritradeGetOrderResponse {

    @SerializedName("session")
    @Expose
    private String session;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("orderType")
    @Expose
    private String orderType;
    @SerializedName("cancelTime")
    @Expose
    private ameritradeGetOrderCancelTime cancelTime;
    @SerializedName("complexOrderStrategyType")
    @Expose
    private String complexOrderStrategyType;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("filledQuantity")
    @Expose
    private Integer filledQuantity;
    @SerializedName("remainingQuantity")
    @Expose
    private Integer remainingQuantity;
    @SerializedName("requestedDestination")
    @Expose
    private String requestedDestination;
    @SerializedName("destinationLinkName")
    @Expose
    private String destinationLinkName;
    @SerializedName("releaseTime")
    @Expose
    private String releaseTime;
    @SerializedName("stopPrice")
    @Expose
    private Integer stopPrice;
    @SerializedName("stopPriceLinkBasis")
    @Expose
    private String stopPriceLinkBasis;
    @SerializedName("stopPriceLinkType")
    @Expose
    private String stopPriceLinkType;
    @SerializedName("stopPriceOffset")
    @Expose
    private Integer stopPriceOffset;
    @SerializedName("stopType")
    @Expose
    private String stopType;
    @SerializedName("priceLinkBasis")
    @Expose
    private String priceLinkBasis;
    @SerializedName("priceLinkType")
    @Expose
    private String priceLinkType;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("taxLotMethod")
    @Expose
    private String taxLotMethod;
    @SerializedName("orderLegCollection")
    @Expose
    private List<ameritradeGetOrderOrderLegCollection> orderLegCollection = null;
    @SerializedName("activationPrice")
    @Expose
    private Integer activationPrice;
    @SerializedName("specialInstruction")
    @Expose
    private String specialInstruction;
    @SerializedName("orderStrategyType")
    @Expose
    private String orderStrategyType;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("cancelable")
    @Expose
    private Boolean cancelable;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("enteredTime")
    @Expose
    private String enteredTime;
    @SerializedName("closeTime")
    @Expose
    private String closeTime;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("orderActivityCollection")
    @Expose
    private List<Object> orderActivityCollection = null;
    @SerializedName("replacingOrderCollection")
    @Expose
    private List<ameritradeGetOrderReplacingOrderCollection> replacingOrderCollection = null;
    @SerializedName("childOrderStrategies")
    @Expose
    private List<ameritradeGetOrderChildOrderStrategy> childOrderStrategies = null;
    @SerializedName("statusDescription")
    @Expose
    private String statusDescription;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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

    public ameritradeGetOrderCancelTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(ameritradeGetOrderCancelTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getComplexOrderStrategyType() {
        return complexOrderStrategyType;
    }

    public void setComplexOrderStrategyType(String complexOrderStrategyType) {
        this.complexOrderStrategyType = complexOrderStrategyType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFilledQuantity() {
        return filledQuantity;
    }

    public void setFilledQuantity(Integer filledQuantity) {
        this.filledQuantity = filledQuantity;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public String getRequestedDestination() {
        return requestedDestination;
    }

    public void setRequestedDestination(String requestedDestination) {
        this.requestedDestination = requestedDestination;
    }

    public String getDestinationLinkName() {
        return destinationLinkName;
    }

    public void setDestinationLinkName(String destinationLinkName) {
        this.destinationLinkName = destinationLinkName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Integer stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getStopPriceLinkBasis() {
        return stopPriceLinkBasis;
    }

    public void setStopPriceLinkBasis(String stopPriceLinkBasis) {
        this.stopPriceLinkBasis = stopPriceLinkBasis;
    }

    public String getStopPriceLinkType() {
        return stopPriceLinkType;
    }

    public void setStopPriceLinkType(String stopPriceLinkType) {
        this.stopPriceLinkType = stopPriceLinkType;
    }

    public Integer getStopPriceOffset() {
        return stopPriceOffset;
    }

    public void setStopPriceOffset(Integer stopPriceOffset) {
        this.stopPriceOffset = stopPriceOffset;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    public String getPriceLinkBasis() {
        return priceLinkBasis;
    }

    public void setPriceLinkBasis(String priceLinkBasis) {
        this.priceLinkBasis = priceLinkBasis;
    }

    public String getPriceLinkType() {
        return priceLinkType;
    }

    public void setPriceLinkType(String priceLinkType) {
        this.priceLinkType = priceLinkType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTaxLotMethod() {
        return taxLotMethod;
    }

    public void setTaxLotMethod(String taxLotMethod) {
        this.taxLotMethod = taxLotMethod;
    }

    public List<ameritradeGetOrderOrderLegCollection> getOrderLegCollection() {
        return orderLegCollection;
    }

    public void setOrderLegCollection(List<ameritradeGetOrderOrderLegCollection> orderLegCollection) {
        this.orderLegCollection = orderLegCollection;
    }

    public Integer getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(Integer activationPrice) {
        this.activationPrice = activationPrice;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getOrderStrategyType() {
        return orderStrategyType;
    }

    public void setOrderStrategyType(String orderStrategyType) {
        this.orderStrategyType = orderStrategyType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Boolean getCancelable() {
        return cancelable;
    }

    public void setCancelable(Boolean cancelable) {
        this.cancelable = cancelable;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnteredTime() {
        return enteredTime;
    }

    public void setEnteredTime(String enteredTime) {
        this.enteredTime = enteredTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<Object> getOrderActivityCollection() {
        return orderActivityCollection;
    }

    public void setOrderActivityCollection(List<Object> orderActivityCollection) {
        this.orderActivityCollection = orderActivityCollection;
    }

    public List<ameritradeGetOrderReplacingOrderCollection> getReplacingOrderCollection() {
        return replacingOrderCollection;
    }

    public void setReplacingOrderCollection(List<ameritradeGetOrderReplacingOrderCollection> replacingOrderCollection) {
        this.replacingOrderCollection = replacingOrderCollection;
    }

    public List<ameritradeGetOrderChildOrderStrategy> getChildOrderStrategies() {
        return childOrderStrategies;
    }

    public void setChildOrderStrategies(List<ameritradeGetOrderChildOrderStrategy> childOrderStrategies) {
        this.childOrderStrategies = childOrderStrategies;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}
