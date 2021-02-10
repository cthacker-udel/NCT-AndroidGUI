package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetQuoteFutureOptions {

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
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("openPriceInDouble")
    @Expose
    private Integer openPriceInDouble;
    @SerializedName("netChangeInDouble")
    @Expose
    private Integer netChangeInDouble;
    @SerializedName("openInterest")
    @Expose
    private Integer openInterest;
    @SerializedName("exchangeName")
    @Expose
    private String exchangeName;
    @SerializedName("securityStatus")
    @Expose
    private String securityStatus;
    @SerializedName("volatility")
    @Expose
    private Integer volatility;
    @SerializedName("moneyIntrinsicValueInDouble")
    @Expose
    private Integer moneyIntrinsicValueInDouble;
    @SerializedName("multiplierInDouble")
    @Expose
    private Integer multiplierInDouble;
    @SerializedName("digits")
    @Expose
    private Integer digits;
    @SerializedName("strikePriceInDouble")
    @Expose
    private Integer strikePriceInDouble;
    @SerializedName("contractType")
    @Expose
    private String contractType;
    @SerializedName("underlying")
    @Expose
    private String underlying;
    @SerializedName("timeValueInDouble")
    @Expose
    private Integer timeValueInDouble;
    @SerializedName("deltaInDouble")
    @Expose
    private Integer deltaInDouble;
    @SerializedName("gammaInDouble")
    @Expose
    private Integer gammaInDouble;
    @SerializedName("thetaInDouble")
    @Expose
    private Integer thetaInDouble;
    @SerializedName("vegaInDouble")
    @Expose
    private Integer vegaInDouble;
    @SerializedName("rhoInDouble")
    @Expose
    private Integer rhoInDouble;
    @SerializedName("mark")
    @Expose
    private Integer mark;
    @SerializedName("tick")
    @Expose
    private Integer tick;
    @SerializedName("tickAmount")
    @Expose
    private Integer tickAmount;
    @SerializedName("futureIsTradable")
    @Expose
    private Boolean futureIsTradable;
    @SerializedName("futureTradingHours")
    @Expose
    private String futureTradingHours;
    @SerializedName("futurePercentChange")
    @Expose
    private Integer futurePercentChange;
    @SerializedName("futureIsActive")
    @Expose
    private Boolean futureIsActive;
    @SerializedName("futureExpirationDate")
    @Expose
    private Integer futureExpirationDate;
    @SerializedName("expirationType")
    @Expose
    private String expirationType;
    @SerializedName("exerciseType")
    @Expose
    private String exerciseType;
    @SerializedName("inTheMoney")
    @Expose
    private Boolean inTheMoney;

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

    public Integer getNetChangeInDouble() {
        return netChangeInDouble;
    }

    public void setNetChangeInDouble(Integer netChangeInDouble) {
        this.netChangeInDouble = netChangeInDouble;
    }

    public Integer getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(Integer openInterest) {
        this.openInterest = openInterest;
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

    public Integer getVolatility() {
        return volatility;
    }

    public void setVolatility(Integer volatility) {
        this.volatility = volatility;
    }

    public Integer getMoneyIntrinsicValueInDouble() {
        return moneyIntrinsicValueInDouble;
    }

    public void setMoneyIntrinsicValueInDouble(Integer moneyIntrinsicValueInDouble) {
        this.moneyIntrinsicValueInDouble = moneyIntrinsicValueInDouble;
    }

    public Integer getMultiplierInDouble() {
        return multiplierInDouble;
    }

    public void setMultiplierInDouble(Integer multiplierInDouble) {
        this.multiplierInDouble = multiplierInDouble;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public Integer getStrikePriceInDouble() {
        return strikePriceInDouble;
    }

    public void setStrikePriceInDouble(Integer strikePriceInDouble) {
        this.strikePriceInDouble = strikePriceInDouble;
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

    public Integer getTimeValueInDouble() {
        return timeValueInDouble;
    }

    public void setTimeValueInDouble(Integer timeValueInDouble) {
        this.timeValueInDouble = timeValueInDouble;
    }

    public Integer getDeltaInDouble() {
        return deltaInDouble;
    }

    public void setDeltaInDouble(Integer deltaInDouble) {
        this.deltaInDouble = deltaInDouble;
    }

    public Integer getGammaInDouble() {
        return gammaInDouble;
    }

    public void setGammaInDouble(Integer gammaInDouble) {
        this.gammaInDouble = gammaInDouble;
    }

    public Integer getThetaInDouble() {
        return thetaInDouble;
    }

    public void setThetaInDouble(Integer thetaInDouble) {
        this.thetaInDouble = thetaInDouble;
    }

    public Integer getVegaInDouble() {
        return vegaInDouble;
    }

    public void setVegaInDouble(Integer vegaInDouble) {
        this.vegaInDouble = vegaInDouble;
    }

    public Integer getRhoInDouble() {
        return rhoInDouble;
    }

    public void setRhoInDouble(Integer rhoInDouble) {
        this.rhoInDouble = rhoInDouble;
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

    public Boolean getFutureIsTradable() {
        return futureIsTradable;
    }

    public void setFutureIsTradable(Boolean futureIsTradable) {
        this.futureIsTradable = futureIsTradable;
    }

    public String getFutureTradingHours() {
        return futureTradingHours;
    }

    public void setFutureTradingHours(String futureTradingHours) {
        this.futureTradingHours = futureTradingHours;
    }

    public Integer getFuturePercentChange() {
        return futurePercentChange;
    }

    public void setFuturePercentChange(Integer futurePercentChange) {
        this.futurePercentChange = futurePercentChange;
    }

    public Boolean getFutureIsActive() {
        return futureIsActive;
    }

    public void setFutureIsActive(Boolean futureIsActive) {
        this.futureIsActive = futureIsActive;
    }

    public Integer getFutureExpirationDate() {
        return futureExpirationDate;
    }

    public void setFutureExpirationDate(Integer futureExpirationDate) {
        this.futureExpirationDate = futureExpirationDate;
    }

    public String getExpirationType() {
        return expirationType;
    }

    public void setExpirationType(String expirationType) {
        this.expirationType = expirationType;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Boolean getInTheMoney() {
        return inTheMoney;
    }

    public void setInTheMoney(Boolean inTheMoney) {
        this.inTheMoney = inTheMoney;
    }


}
