package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbOrderBookData {

    @SerializedName("b")
    @Expose
    private List<List<String>> b = null;
    @SerializedName("s")
    @Expose
    private List<List<String>> s = null;
    @SerializedName("ver")
    @Expose
    private String ver;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public List<List<String>> getB() {
        return b;
    }

    public void setB(List<List<String>> b) {
        this.b = b;
    }

    public List<List<String>> getS() {
        return s;
    }

    public void setS(List<List<String>> s) {
        this.s = s;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
