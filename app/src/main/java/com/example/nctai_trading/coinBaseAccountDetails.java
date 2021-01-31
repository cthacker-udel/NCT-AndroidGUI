package com.example.nctai_trading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinBaseAccountDetails {

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("trade_id")
    @Expose
    private String tradeId;
    @SerializedName("product_id")
    @Expose
    private String productId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
