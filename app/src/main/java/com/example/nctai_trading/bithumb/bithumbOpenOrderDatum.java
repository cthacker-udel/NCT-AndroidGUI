package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbOpenOrderDatum {

    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("list")
    @Expose
    private java.util.List<bithumbOpenOrderList> list = null;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public java.util.List<bithumbOpenOrderList> getList() {
        return list;
    }

    public void setList(java.util.List<bithumbOpenOrderList> list) {
        this.list = list;
    }

}
