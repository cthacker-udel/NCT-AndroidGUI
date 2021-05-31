package com.example.nctai_trading.exante.historicalOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class historicalOrder {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("placeTime")
    @Expose
    private String placeTime;
    @SerializedName("currentModificationId")
    @Expose
    private String currentModificationId;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("clientTag")
    @Expose
    private String clientTag;
    @SerializedName("orderState")
    @Expose
    private OrderState orderState;
    @SerializedName("orderParameters")
    @Expose
    private OrderParameters orderParameters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(String placeTime) {
        this.placeTime = placeTime;
    }

    public String getCurrentModificationId() {
        return currentModificationId;
    }

    public void setCurrentModificationId(String currentModificationId) {
        this.currentModificationId = currentModificationId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientTag() {
        return clientTag;
    }

    public void setClientTag(String clientTag) {
        this.clientTag = clientTag;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public OrderParameters getOrderParameters() {
        return orderParameters;
    }

    public void setOrderParameters(OrderParameters orderParameters) {
        this.orderParameters = orderParameters;
    }

}
