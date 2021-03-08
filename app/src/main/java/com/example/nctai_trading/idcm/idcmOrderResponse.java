package com.example.nctai_trading.idcm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class idcmOrderResponse {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("data")
    @Expose
    private Object data;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
