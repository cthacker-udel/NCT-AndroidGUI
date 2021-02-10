package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ameritradePriceHistoryResponse {

    @SerializedName("candles")
    @Expose
    private List<ameritradePriceHistoryCandle> candles = null;
    @SerializedName("empty")
    @Expose
    private Boolean empty;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public List<ameritradePriceHistoryCandle> getCandles() {
        return candles;
    }

    public void setCandles(List<ameritradePriceHistoryCandle> candles) {
        this.candles = candles;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
