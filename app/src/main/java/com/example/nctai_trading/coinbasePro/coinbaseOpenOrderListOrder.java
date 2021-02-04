package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseOpenOrderListOrder {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("stp")
    @Expose
    private String stp;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("time_in_force")
    @Expose
    private String timeInForce;
    @SerializedName("post_only")
    @Expose
    private Boolean postOnly;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("fill_fees")
    @Expose
    private String fillFees;
    @SerializedName("filled_size")
    @Expose
    private String filledSize;
    @SerializedName("executed_value")
    @Expose
    private String executedValue;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("settled")
    @Expose
    private Boolean settled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getStp() {
        return stp;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Boolean getPostOnly() {
        return postOnly;
    }

    public void setPostOnly(Boolean postOnly) {
        this.postOnly = postOnly;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFillFees() {
        return fillFees;
    }

    public void setFillFees(String fillFees) {
        this.fillFees = fillFees;
    }

    public String getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(String filledSize) {
        this.filledSize = filledSize;
    }

    public String getExecutedValue() {
        return executedValue;
    }

    public void setExecutedValue(String executedValue) {
        this.executedValue = executedValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }

}
