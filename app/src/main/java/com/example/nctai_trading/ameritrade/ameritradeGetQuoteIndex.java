package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteIndex {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("lastPrice")
    @Expose
    private Integer lastPrice;
    @SerializedName("openPrice")
    @Expose
    private Integer openPrice;
    @SerializedName("highPrice")
    @Expose
    private Integer highPrice;
    @SerializedName("lowPrice")
    @Expose
    private Integer lowPrice;
    @SerializedName("closePrice")
    @Expose
    private Integer closePrice;
    @SerializedName("netChange")
    @Expose
    private Integer netChange;
    @SerializedName("totalVolume")
    @Expose
    private Integer totalVolume;
    @SerializedName("tradeTimeInLong")
    @Expose
    private Integer tradeTimeInLong;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("digits")
    @Expose
    private Integer digits;
    @SerializedName("52WkHigh")
    @Expose
    private Integer _52WkHigh;
    @SerializedName("52WkLow")
    @Expose
    private Integer _52WkLow;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Integer openPrice) {
        this.openPrice = openPrice;
    }

    public Integer getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Integer highPrice) {
        this.highPrice = highPrice;
    }

    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Integer closePrice) {
        this.closePrice = closePrice;
    }

    public Integer getNetChange() {
        return netChange;
    }

    public void setNetChange(Integer netChange) {
        this.netChange = netChange;
    }

    public Integer getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Integer getTradeTimeInLong() {
        return tradeTimeInLong;
    }

    public void setTradeTimeInLong(Integer tradeTimeInLong) {
        this.tradeTimeInLong = tradeTimeInLong;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public Integer get52WkHigh() {
        return _52WkHigh;
    }

    public void set52WkHigh(Integer _52WkHigh) {
        this._52WkHigh = _52WkHigh;
    }

    public Integer get52WkLow() {
        return _52WkLow;
    }

    public void set52WkLow(Integer _52WkLow) {
        this._52WkLow = _52WkLow;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

}
