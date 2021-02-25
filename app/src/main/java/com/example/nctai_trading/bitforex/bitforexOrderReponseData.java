package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitforexOrderReponseData {

    @SerializedName("orderId")
    @Expose
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}
