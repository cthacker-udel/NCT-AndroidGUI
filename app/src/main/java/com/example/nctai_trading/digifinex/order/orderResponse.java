package com.example.nctai_trading.digifinex.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class orderResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("order_id")
    @Expose
    private String orderId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
