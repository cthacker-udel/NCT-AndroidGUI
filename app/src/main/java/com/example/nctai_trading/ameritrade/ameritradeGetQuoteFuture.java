package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteFuture {

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
    @SerializedName("bidId")
    @Expose
    private String bidId;
    @SerializedName("askId")
    @Expose
    private String askId;
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
    @SerializedName("lastId")
    @Expose
    private String lastId;
    @SerializedName("openPriceInDouble")
    @Expose
    private Integer openPriceInDouble;
    @SerializedName("changeInDouble")
    @Expose
    private Integer changeInDouble;
    @SerializedName("futurePercentChange")
    @Expose
    private Integer futurePercentChange;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;
    @SerializedName("openInterest")
    @Expose
    private Integer openInterest;
    @SerializedName("mark")
    @Expose
    private Integer mark;
    @SerializedName("tick")
    @Expose
    private Integer tick;
    @SerializedName("tickAmount")
    @Expose
    private Integer tickAmount;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("futurePriceFormat")
    @Expose
    private String futurePriceFormat;
    @SerializedName("futureTradingHours")
    @Expose
    private String futureTradingHours;
    @SerializedName("futureIsTradable")
    @Expose
    private Boolean futureIsTradable;
    @SerializedName("futureMultiplier")
    @Expose
    private Integer futureMultiplier;
    @SerializedName("futureIsActive")
    @Expose
    private Boolean futureIsActive;
    @SerializedName("futureSettlementPrice")
    @Expose
    private Integer futureSettlementPrice;
    @SerializedName("futureActiveSymbol")
    @Expose
    private String futureActiveSymbol;
    @SerializedName("futureExpirationDate")
    @Expose
    private String futureExpirationDate;

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

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getAskId() {
        return askId;
    }

    public void setAskId(String askId) {
        this.askId = askId;
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

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
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

    public Integer getFuturePercentChange() {
        return futurePercentChange;
    }

    public void setFuturePercentChange(Integer futurePercentChange) {
        this.futurePercentChange = futurePercentChange;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public Integer getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(Integer openInterest) {
        this.openInterest = openInterest;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
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

    public String getFuturePriceFormat() {
        return futurePriceFormat;
    }

    public void setFuturePriceFormat(String futurePriceFormat) {
        this.futurePriceFormat = futurePriceFormat;
    }

    public String getFutureTradingHours() {
        return futureTradingHours;
    }

    public void setFutureTradingHours(String futureTradingHours) {
        this.futureTradingHours = futureTradingHours;
    }

    public Boolean getFutureIsTradable() {
        return futureIsTradable;
    }

    public void setFutureIsTradable(Boolean futureIsTradable) {
        this.futureIsTradable = futureIsTradable;
    }

    public Integer getFutureMultiplier() {
        return futureMultiplier;
    }

    public void setFutureMultiplier(Integer futureMultiplier) {
        this.futureMultiplier = futureMultiplier;
    }

    public Boolean getFutureIsActive() {
        return futureIsActive;
    }

    public void setFutureIsActive(Boolean futureIsActive) {
        this.futureIsActive = futureIsActive;
    }

    public Integer getFutureSettlementPrice() {
        return futureSettlementPrice;
    }

    public void setFutureSettlementPrice(Integer futureSettlementPrice) {
        this.futureSettlementPrice = futureSettlementPrice;
    }

    public String getFutureActiveSymbol() {
        return futureActiveSymbol;
    }

    public void setFutureActiveSymbol(String futureActiveSymbol) {
        this.futureActiveSymbol = futureActiveSymbol;
    }

    public String getFutureExpirationDate() {
        return futureExpirationDate;
    }

    public void setFutureExpirationDate(String futureExpirationDate) {
        this.futureExpirationDate = futureExpirationDate;
    }

}
