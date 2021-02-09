package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbKlineData {

    @SerializedName("c")
    @Expose
    private String c;
    @SerializedName("h")
    @Expose
    private String h;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("o")
    @Expose
    private String o;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("v")
    @Expose
    private String v;

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

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

}
