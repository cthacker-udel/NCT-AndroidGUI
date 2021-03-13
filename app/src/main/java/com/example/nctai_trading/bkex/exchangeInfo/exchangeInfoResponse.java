package com.example.nctai_trading.bkex.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exchangeInfoResponse {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private exchangeInfoData data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public exchangeInfoData getData() {
        return data;
    }

    public void setData(exchangeInfoData data) {
        this.data = data;
    }

}
