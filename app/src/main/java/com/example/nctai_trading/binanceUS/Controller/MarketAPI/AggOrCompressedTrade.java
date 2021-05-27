package com.example.nctai_trading.binanceUS.Controller.MarketAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AggOrCompressedTrade {

    @SerializedName("a")
    @Expose
    private Integer a;
    @SerializedName("p")
    @Expose
    private String p;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("f")
    @Expose
    private Integer f;
    @SerializedName("l")
    @Expose
    private Integer l;
    @SerializedName("T")
    @Expose
    private Long t;
    @SerializedName("m")
    @Expose
    private Boolean m;
    @SerializedName("M")
    @Expose
    private Boolean M;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
        this.l = l;
    }

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
    }

    public Boolean getm() {
        return m;
    }

    public void setm(Boolean m) {
        this.m = m;
    }

    public Boolean getM() {
        return M;
    }

    public void setM(Boolean M) {
        this.M = M;
    }

}
