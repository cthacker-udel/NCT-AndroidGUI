package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbTickerResponseData {

    @SerializedName("c")
    @Expose
    private String c;
    @SerializedName("h")
    @Expose
    private String h;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("p")
    @Expose
    private String p;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("s")
    @Expose
    private String s;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}
