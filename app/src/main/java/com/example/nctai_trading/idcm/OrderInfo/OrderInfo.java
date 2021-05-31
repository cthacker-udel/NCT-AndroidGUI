package com.example.nctai_trading.idcm.OrderInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderInfo {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


}
