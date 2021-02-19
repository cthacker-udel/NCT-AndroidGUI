package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxyOrderQuery {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
