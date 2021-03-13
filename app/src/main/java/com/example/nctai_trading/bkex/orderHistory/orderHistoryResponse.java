package com.example.nctai_trading.bkex.orderHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class orderHistoryResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private orderHistoryData data;
    @SerializedName("msg")
    @Expose
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public orderHistoryData getData() {
        return data;
    }

    public void setData(orderHistoryData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
