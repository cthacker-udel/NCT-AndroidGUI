package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbVirtualCoinOrder {

    @SerializedName("data")
    @Expose
    private bithumbVirtualCoinOrderData data;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("params")
    @Expose
    private List<Object> params = null;

    public bithumbVirtualCoinOrderData getData() {
        return data;
    }

    public void setData(bithumbVirtualCoinOrderData data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

}
