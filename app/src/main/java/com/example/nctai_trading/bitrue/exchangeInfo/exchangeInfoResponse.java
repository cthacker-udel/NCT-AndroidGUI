package com.example.nctai_trading.bitrue.exchangeInfo;

import com.example.nctai_trading.binanceUS.RateLimit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class exchangeInfoResponse {

    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("serverTime")
    @Expose
    private Double serverTime;
    @SerializedName("rateLimits")
    @Expose
    private List<RateLimit> rateLimits = null;
    @SerializedName("exchangeFilters")
    @Expose
    private List<Object> exchangeFilters = null;
    @SerializedName("symbols")
    @Expose
    private List<exchangeInfoSymbol> symbols = null;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getServerTime() {
        return serverTime;
    }

    public void setServerTime(Double serverTime) {
        this.serverTime = serverTime;
    }

    public List<RateLimit> getRateLimits() {
        return rateLimits;
    }

    public void setRateLimits(List<RateLimit> rateLimits) {
        this.rateLimits = rateLimits;
    }

    public List<Object> getExchangeFilters() {
        return exchangeFilters;
    }

    public void setExchangeFilters(List<Object> exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }

    public List<exchangeInfoSymbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<exchangeInfoSymbol> symbols) {
        this.symbols = symbols;
    }

}
