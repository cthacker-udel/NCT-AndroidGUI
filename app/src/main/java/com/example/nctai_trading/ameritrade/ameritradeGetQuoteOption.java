package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteOption {

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
    @SerializedName("askPrice")
    @Expose
    private Integer askPrice;
    @SerializedName("askSize")
    @Expose
    private Integer askSize;
    @SerializedName("lastPrice")
    @Expose
    private Integer lastPrice;
    @SerializedName("lastSize")
    @Expose
    private Integer lastSize;
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
    @SerializedName("openInterest")
    @Expose
    private Integer openInterest;
    @SerializedName("volatility")
    @Expose
    private Integer volatility;
    @SerializedName("moneyIntrinsicValue")
    @Expose
    private Integer moneyIntrinsicValue;
    @SerializedName("multiplier")
    @Expose
    private Integer multiplier;
    @SerializedName("strikePrice")
    @Expose
    private Integer strikePrice;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("underlying")
    @Expose
    private String underlying;
    @SerializedName("timeValue")
    @Expose
    private Integer timeValue;
    @SerializedName("deliverables")
    @Expose
    private String deliverables;
    @SerializedName("delta")
    @Expose
    private Integer delta;
    @SerializedName("gamma")
    @Expose
    private Integer gamma;
    @SerializedName("theta")
    @Expose
    private Integer theta;
    @SerializedName("vega")
    @Expose
    private Integer vega;
    @SerializedName("rho")
    @Expose
    private Integer rho;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;
    @SerializedName("theoreticalOptionValue")
    @Expose
    private Integer theoreticalOptionValue;
    @SerializedName("underlyingPrice")
    @Expose
    private Integer underlyingPrice;
    @SerializedName("uvExpirationType")
    @Expose
    private String uvExpirationType;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("settlementType")
    @Expose
    private String settlementType;

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

    public Integer getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(Integer openInterest) {
        this.openInterest = openInterest;
    }

    public Integer getVolatility() {
        return volatility;
    }

    public void setVolatility(Integer volatility) {
        this.volatility = volatility;
    }

    public Integer getMoneyIntrinsicValue() {
        return moneyIntrinsicValue;
    }

    public void setMoneyIntrinsicValue(Integer moneyIntrinsicValue) {
        this.moneyIntrinsicValue = moneyIntrinsicValue;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    public Integer getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(Integer strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public Integer getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Integer timeValue) {
        this.timeValue = timeValue;
    }

    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public Integer getGamma() {
        return gamma;
    }

    public void setGamma(Integer gamma) {
        this.gamma = gamma;
    }

    public Integer getTheta() {
        return theta;
    }

    public void setTheta(Integer theta) {
        this.theta = theta;
    }

    public Integer getVega() {
        return vega;
    }

    public void setVega(Integer vega) {
        this.vega = vega;
    }

    public Integer getRho() {
        return rho;
    }

    public void setRho(Integer rho) {
        this.rho = rho;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public Integer getTheoreticalOptionValue() {
        return theoreticalOptionValue;
    }

    public void setTheoreticalOptionValue(Integer theoreticalOptionValue) {
        this.theoreticalOptionValue = theoreticalOptionValue;
    }

    public Integer getUnderlyingPrice() {
        return underlyingPrice;
    }

    public void setUnderlyingPrice(Integer underlyingPrice) {
        this.underlyingPrice = underlyingPrice;
    }

    public String getUvExpirationType() {
        return uvExpirationType;
    }

    public void setUvExpirationType(String uvExpirationType) {
        this.uvExpirationType = uvExpirationType;
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

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

}
