package com.example.nctai_trading.alpaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class alpacaGetAccountResponse {

    @SerializedName("account_blocked")
    @Expose
    private Boolean accountBlocked;
    @SerializedName("account_number")
    @Expose
    private String accountNumber;
    @SerializedName("buying_power")
    @Expose
    private String buyingPower;
    @SerializedName("cash")
    @Expose
    private String cash;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("daytrade_count")
    @Expose
    private Integer daytradeCount;
    @SerializedName("daytrading_buying_power")
    @Expose
    private String daytradingBuyingPower;
    @SerializedName("equity")
    @Expose
    private String equity;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("initial_margin")
    @Expose
    private String initialMargin;
    @SerializedName("last_equity")
    @Expose
    private String lastEquity;
    @SerializedName("last_maintenance_margin")
    @Expose
    private String lastMaintenanceMargin;
    @SerializedName("long_market_value")
    @Expose
    private String longMarketValue;
    @SerializedName("maintenance_margin")
    @Expose
    private String maintenanceMargin;
    @SerializedName("multiplier")
    @Expose
    private String multiplier;
    @SerializedName("pattern_day_trader")
    @Expose
    private Boolean patternDayTrader;
    @SerializedName("portfolio_value")
    @Expose
    private String portfolioValue;
    @SerializedName("regt_buying_power")
    @Expose
    private String regtBuyingPower;
    @SerializedName("short_market_value")
    @Expose
    private String shortMarketValue;
    @SerializedName("shorting_enabled")
    @Expose
    private Boolean shortingEnabled;
    @SerializedName("sma")
    @Expose
    private String sma;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("trade_suspended_by_user")
    @Expose
    private Boolean tradeSuspendedByUser;
    @SerializedName("trading_blocked")
    @Expose
    private Boolean tradingBlocked;
    @SerializedName("transfers_blocked")
    @Expose
    private Boolean transfersBlocked;

    public Boolean getAccountBlocked() {
        return accountBlocked;
    }

    public void setAccountBlocked(Boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(String buyingPower) {
        this.buyingPower = buyingPower;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDaytradeCount() {
        return daytradeCount;
    }

    public void setDaytradeCount(Integer daytradeCount) {
        this.daytradeCount = daytradeCount;
    }

    public String getDaytradingBuyingPower() {
        return daytradingBuyingPower;
    }

    public void setDaytradingBuyingPower(String daytradingBuyingPower) {
        this.daytradingBuyingPower = daytradingBuyingPower;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
    }

    public String getLastEquity() {
        return lastEquity;
    }

    public void setLastEquity(String lastEquity) {
        this.lastEquity = lastEquity;
    }

    public String getLastMaintenanceMargin() {
        return lastMaintenanceMargin;
    }

    public void setLastMaintenanceMargin(String lastMaintenanceMargin) {
        this.lastMaintenanceMargin = lastMaintenanceMargin;
    }

    public String getLongMarketValue() {
        return longMarketValue;
    }

    public void setLongMarketValue(String longMarketValue) {
        this.longMarketValue = longMarketValue;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public void setMaintenanceMargin(String maintenanceMargin) {
        this.maintenanceMargin = maintenanceMargin;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public Boolean getPatternDayTrader() {
        return patternDayTrader;
    }

    public void setPatternDayTrader(Boolean patternDayTrader) {
        this.patternDayTrader = patternDayTrader;
    }

    public String getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(String portfolioValue) {
        this.portfolioValue = portfolioValue;
    }

    public String getRegtBuyingPower() {
        return regtBuyingPower;
    }

    public void setRegtBuyingPower(String regtBuyingPower) {
        this.regtBuyingPower = regtBuyingPower;
    }

    public String getShortMarketValue() {
        return shortMarketValue;
    }

    public void setShortMarketValue(String shortMarketValue) {
        this.shortMarketValue = shortMarketValue;
    }

    public Boolean getShortingEnabled() {
        return shortingEnabled;
    }

    public void setShortingEnabled(Boolean shortingEnabled) {
        this.shortingEnabled = shortingEnabled;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTradeSuspendedByUser() {
        return tradeSuspendedByUser;
    }

    public void setTradeSuspendedByUser(Boolean tradeSuspendedByUser) {
        this.tradeSuspendedByUser = tradeSuspendedByUser;
    }

    public Boolean getTradingBlocked() {
        return tradingBlocked;
    }

    public void setTradingBlocked(Boolean tradingBlocked) {
        this.tradingBlocked = tradingBlocked;
    }

    public Boolean getTransfersBlocked() {
        return transfersBlocked;
    }

    public void setTransfersBlocked(Boolean transfersBlocked) {
        this.transfersBlocked = transfersBlocked;
    }

}
