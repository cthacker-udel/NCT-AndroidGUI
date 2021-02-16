package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bitmexInstrumentActiveIntervals {

    @SerializedName("intervals")
    @Expose
    private List<String> intervals = null;
    @SerializedName("symbols")
    @Expose
    private List<String> symbols = null;

    public List<String> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<String> intervals) {
        this.intervals = intervals;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

}
