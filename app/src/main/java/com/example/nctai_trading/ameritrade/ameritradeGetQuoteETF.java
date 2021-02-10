package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteETF {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("bidPrice")
    @Expose
    private Integer bidPrice;
    @SerializedName("bidSize")
    @Expose
    private Integer bidSize;
    @SerializedName("bidId")
    @Expose
    private String bidId;
    @SerializedName("askPrice")
    @Expose
    private Integer askPrice;
    @SerializedName("askSize")
    @Expose
    private Integer askSize;
    @SerializedName("askId")
    @Expose
    private String askId;
    @SerializedName("lastPrice")
    @Expose
    private Integer lastPrice;
    @SerializedName("lastSize")
    @Expose
    private Integer lastSize;
    @SerializedName("lastId")
    @Expose
    private String lastId;
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
    @SerializedName("quoteTimeInLong")
    @Expose
    private Integer quoteTimeInLong;
    @SerializedName("tradeTimeInLong")
    @Expose
    private Integer tradeTimeInLong;
    @SerializedName("mark")
    @Expose
    private Integer mark;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("marginable")
    @Expose
    private Boolean marginable;
    @SerializedName("shortable")
    @Expose
    private Boolean shortable;
    @SerializedName("volatility")
    @Expose
    private Integer volatility;
    @SerializedName("digits")
    @Expose
    private Integer digits;
    @SerializedName("52WkHigh")
    @Expose
    private Integer _52WkHigh;
    @SerializedName("52WkLow")
    @Expose
    private Integer _52WkLow;
    @SerializedName("peRatio")
    @Expose
    private Integer peRatio;
    @SerializedName("divAmount")
    @Expose
    private Integer divAmount;
    @SerializedName("divYield")
    @Expose
    private Integer divYield;
    @SerializedName("divDate")
    @Expose
    private String divDate;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;
    @SerializedName("regularMarketLastPrice")
    @Expose
    private Integer regularMarketLastPrice;
    @SerializedName("regularMarketLastSize")
    @Expose
    private Integer regularMarketLastSize;
    @SerializedName("regularMarketNetChange")
    @Expose
    private Integer regularMarketNetChange;
    @SerializedName("regularMarketTradeTimeInLong")
    @Expose
    private Integer regularMarketTradeTimeInLong;

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

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Integer getBidSize() {
        return bidSize;
    }

    public void setBidSize(Integer bidSize) {
        this.bidSize = bidSize;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public Integer getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Integer askPrice) {
        this.askPrice = askPrice;
    }

    public Integer getAskSize() {
        return askSize;
    }

    public void setAskSize(Integer askSize) {
        this.askSize = askSize;
    }

    public String getAskId() {
        return askId;
    }

    public void setAskId(String askId) {
        this.askId = askId;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getLastSize() {
        return lastSize;
    }

    public void setLastSize(Integer lastSize) {
        this.lastSize = lastSize;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
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

    public Integer getQuoteTimeInLong() {
        return quoteTimeInLong;
    }

    public void setQuoteTimeInLong(Integer quoteTimeInLong) {
        this.quoteTimeInLong = quoteTimeInLong;
    }

    public Integer getTradeTimeInLong() {
        return tradeTimeInLong;
    }

    public void setTradeTimeInLong(Integer tradeTimeInLong) {
        this.tradeTimeInLong = tradeTimeInLong;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
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

    public Boolean getMarginable() {
        return marginable;
    }

    public void setMarginable(Boolean marginable) {
        this.marginable = marginable;
    }

    public Boolean getShortable() {
        return shortable;
    }

    public void setShortable(Boolean shortable) {
        this.shortable = shortable;
    }

    public Integer getVolatility() {
        return volatility;
    }

    public void setVolatility(Integer volatility) {
        this.volatility = volatility;
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

    public Integer getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Integer peRatio) {
        this.peRatio = peRatio;
    }

    public Integer getDivAmount() {
        return divAmount;
    }

    public void setDivAmount(Integer divAmount) {
        this.divAmount = divAmount;
    }

    public Integer getDivYield() {
        return divYield;
    }

    public void setDivYield(Integer divYield) {
        this.divYield = divYield;
    }

    public String getDivDate() {
        return divDate;
    }

    public void setDivDate(String divDate) {
        this.divDate = divDate;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public Integer getRegularMarketLastPrice() {
        return regularMarketLastPrice;
    }

    public void setRegularMarketLastPrice(Integer regularMarketLastPrice) {
        this.regularMarketLastPrice = regularMarketLastPrice;
    }

    public Integer getRegularMarketLastSize() {
        return regularMarketLastSize;
    }

    public void setRegularMarketLastSize(Integer regularMarketLastSize) {
        this.regularMarketLastSize = regularMarketLastSize;
    }

    public Integer getRegularMarketNetChange() {
        return regularMarketNetChange;
    }

    public void setRegularMarketNetChange(Integer regularMarketNetChange) {
        this.regularMarketNetChange = regularMarketNetChange;
    }

    public Integer getRegularMarketTradeTimeInLong() {
        return regularMarketTradeTimeInLong;
    }

    public void setRegularMarketTradeTimeInLong(Integer regularMarketTradeTimeInLong) {
        this.regularMarketTradeTimeInLong = regularMarketTradeTimeInLong;
    }

}
