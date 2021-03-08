package com.example.nctai_trading.idcm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class idcmOrderResponseData {

    @SerializedName("orderid")
    @Expose
    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

}
