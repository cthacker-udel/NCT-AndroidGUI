package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinBaseListFillsFill {

    @SerializedName("trade_id")
    @Expose
    private Integer tradeId;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("liquidity")
    @Expose
    private String liquidity;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("settled")
    @Expose
    private Boolean settled;
    @SerializedName("side")
    @Expose
    private String side;

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLiquidity() {
        return liquidity;
    }

    public void setLiquidity(String liquidity) {
        this.liquidity = liquidity;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
