package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbOpenOrder {

    @SerializedName("data")
    @Expose
    private bithumbOpenOrderDatum data;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("params")
    @Expose
    private List<Object> params = null;

    public bithumbOpenOrderDatum getData() {
        return data;
    }

    public void setData(bithumbOpenOrderDatum data) {
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

}
