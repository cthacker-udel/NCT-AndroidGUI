package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bilaxyAccount {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private List<bilaxyAccountData> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<bilaxyAccountData> getData() {
        return data;
    }

    public void setData(List<bilaxyAccountData> data) {
        this.data = data;
    }

}
