package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbTradeRecordData {

    @SerializedName("p")
    @Expose
    private String p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("v")
    @Expose
    private String v;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

}
