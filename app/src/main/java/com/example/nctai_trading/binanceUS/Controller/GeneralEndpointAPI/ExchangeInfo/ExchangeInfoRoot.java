package com.example.nctai_trading.binanceUS.Controller.GeneralEndpointAPI.ExchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExchangeInfoRoot {

    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("serverTime")
    @Expose
    private Long serverTime;
    @SerializedName("rateLimits")
    @Expose
    private List<RateLimit> rateLimits = null;
    @SerializedName("exchangeFilters")
    @Expose
    private List<Object> exchangeFilters = null;
    @SerializedName("symbols")
    @Expose
    private List<Symbol> symbols = null;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
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

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

}
