package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteForex {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("bidPriceInDouble")
    @Expose
    private Integer bidPriceInDouble;
    @SerializedName("askPriceInDouble")
    @Expose
    private Integer askPriceInDouble;
    @SerializedName("lastPriceInDouble")
    @Expose
    private Integer lastPriceInDouble;
    @SerializedName("highPriceInDouble")
    @Expose
    private Integer highPriceInDouble;
    @SerializedName("lowPriceInDouble")
    @Expose
    private Integer lowPriceInDouble;
    @SerializedName("closePriceInDouble")
    @Expose
    private Integer closePriceInDouble;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("openPriceInDouble")
    @Expose
    private Integer openPriceInDouble;
    @SerializedName("changeInDouble")
    @Expose
    private Integer changeInDouble;
    @SerializedName("percentChange")
    @Expose
    private Integer percentChange;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("digits")
    @Expose
    private Integer digits;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;
    @SerializedName("tick")
    @Expose
    private Integer tick;
    @SerializedName("tickAmount")
    @Expose
    private Integer tickAmount;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("tradingHours")
    @Expose
    private String tradingHours;
    @SerializedName("isTradable")
    @Expose
    private Boolean isTradable;
    @SerializedName("marketMaker")
    @Expose
    private String marketMaker;
    @SerializedName("52WkHighInDouble")
    @Expose
    private Integer _52WkHighInDouble;
    @SerializedName("52WkLowInDouble")
    @Expose
    private Integer _52WkLowInDouble;
    @SerializedName("mark")
    @Expose
    private Integer mark;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getBidPriceInDouble() {
        return bidPriceInDouble;
    }

    public void setBidPriceInDouble(Integer bidPriceInDouble) {
        this.bidPriceInDouble = bidPriceInDouble;
    }

    public Integer getAskPriceInDouble() {
        return askPriceInDouble;
    }

    public void setAskPriceInDouble(Integer askPriceInDouble) {
        this.askPriceInDouble = askPriceInDouble;
    }

    public Integer getLastPriceInDouble() {
        return lastPriceInDouble;
    }

    public void setLastPriceInDouble(Integer lastPriceInDouble) {
        this.lastPriceInDouble = lastPriceInDouble;
    }

    public Integer getHighPriceInDouble() {
        return highPriceInDouble;
    }

    public void setHighPriceInDouble(Integer highPriceInDouble) {
        this.highPriceInDouble = highPriceInDouble;
    }

    public Integer getLowPriceInDouble() {
        return lowPriceInDouble;
    }

    public void setLowPriceInDouble(Integer lowPriceInDouble) {
        this.lowPriceInDouble = lowPriceInDouble;
    }

    public Integer getClosePriceInDouble() {
        return closePriceInDouble;
    }

    public void setClosePriceInDouble(Integer closePriceInDouble) {
        this.closePriceInDouble = closePriceInDouble;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOpenPriceInDouble() {
        return openPriceInDouble;
    }

    public void setOpenPriceInDouble(Integer openPriceInDouble) {
        this.openPriceInDouble = openPriceInDouble;
    }

    public Integer getChangeInDouble() {
        return changeInDouble;
    }

    public void setChangeInDouble(Integer changeInDouble) {
        this.changeInDouble = changeInDouble;
    }

    public Integer getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Integer percentChange) {
        this.percentChange = percentChange;
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

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public Integer getTick() {
        return tick;
    }

    public void setTick(Integer tick) {
        this.tick = tick;
    }

    public Integer getTickAmount() {
        return tickAmount;
    }

    public void setTickAmount(Integer tickAmount) {
        this.tickAmount = tickAmount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTradingHours() {
        return tradingHours;
    }

    public void setTradingHours(String tradingHours) {
        this.tradingHours = tradingHours;
    }

    public Boolean getIsTradable() {
        return isTradable;
    }

    public void setIsTradable(Boolean isTradable) {
        this.isTradable = isTradable;
    }

    public String getMarketMaker() {
        return marketMaker;
    }

    public void setMarketMaker(String marketMaker) {
        this.marketMaker = marketMaker;
    }

    public Integer get52WkHighInDouble() {
        return _52WkHighInDouble;
    }

    public void set52WkHighInDouble(Integer _52WkHighInDouble) {
        this._52WkHighInDouble = _52WkHighInDouble;
    }

    public Integer get52WkLowInDouble() {
        return _52WkLowInDouble;
    }

    public void set52WkLowInDouble(Integer _52WkLowInDouble) {
        this._52WkLowInDouble = _52WkLowInDouble;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }


}
