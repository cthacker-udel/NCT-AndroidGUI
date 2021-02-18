package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bilaxyRecentTransaction {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private List<bilaxyRecentTransactionDatum> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<bilaxyRecentTransactionDatum> getData() {
        return data;
    }

    public void setData(List<bilaxyRecentTransactionDatum> data) {
        this.data = data;
    }

}
