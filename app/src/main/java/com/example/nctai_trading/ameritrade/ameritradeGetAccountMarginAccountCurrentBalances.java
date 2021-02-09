package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetAccountMarginAccountCurrentBalances {

    @SerializedName("accruedInterest")
    @Expose
    private Integer accruedInterest;
    @SerializedName("cashBalance")
    @Expose
    private Integer cashBalance;
    @SerializedName("cashReceipts")
    @Expose
    private Integer cashReceipts;
    @SerializedName("longOptionMarketValue")
    @Expose
    private Integer longOptionMarketValue;
    @SerializedName("liquidationValue")
    @Expose
    private Integer liquidationValue;
    @SerializedName("longMarketValue")
    @Expose
    private Integer longMarketValue;
    @SerializedName("moneyMarketFund")
    @Expose
    private Integer moneyMarketFund;
    @SerializedName("savings")
    @Expose
    private Integer savings;
    @SerializedName("shortMarketValue")
    @Expose
    private Integer shortMarketValue;
    @SerializedName("pendingDeposits")
    @Expose
    private Integer pendingDeposits;
    @SerializedName("availableFunds")
    @Expose
    private Integer availableFunds;
    @SerializedName("availableFundsNonMarginableTrade")
    @Expose
    private Integer availableFundsNonMarginableTrade;
    @SerializedName("buyingPower")
    @Expose
    private Integer buyingPower;
    @SerializedName("buyingPowerNonMarginableTrade")
    @Expose
    private Integer buyingPowerNonMarginableTrade;
    @SerializedName("dayTradingBuyingPower")
    @Expose
    private Integer dayTradingBuyingPower;
    @SerializedName("dayTradingBuyingPowerCall")
    @Expose
    private Integer dayTradingBuyingPowerCall;
    @SerializedName("equity")
    @Expose
    private Integer equity;
    @SerializedName("equityPercentage")
    @Expose
    private Integer equityPercentage;
    @SerializedName("longMarginValue")
    @Expose
    private Integer longMarginValue;
    @SerializedName("maintenanceCall")
    @Expose
    private Integer maintenanceCall;
    @SerializedName("maintenanceRequirement")
    @Expose
    private Integer maintenanceRequirement;
    @SerializedName("marginBalance")
    @Expose
    private Integer marginBalance;
    @SerializedName("regTCall")
    @Expose
    private Integer regTCall;
    @SerializedName("shortBalance")
    @Expose
    private Integer shortBalance;
    @SerializedName("shortMarginValue")
    @Expose
    private Integer shortMarginValue;
    @SerializedName("shortOptionMarketValue")
    @Expose
    private Integer shortOptionMarketValue;
    @SerializedName("sma")
    @Expose
    private Integer sma;
    @SerializedName("mutualFundValue")
    @Expose
    private Integer mutualFundValue;
    @SerializedName("bondValue")
    @Expose
    private Integer bondValue;
    @SerializedName("isInCall")
    @Expose
    private Boolean isInCall;
    @SerializedName("stockBuyingPower")
    @Expose
    private Integer stockBuyingPower;
    @SerializedName("optionBuyingPower")
    @Expose
    private Integer optionBuyingPower;

    public Integer getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(Integer accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public Integer getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Integer cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Integer getCashReceipts() {
        return cashReceipts;
    }

    public void setCashReceipts(Integer cashReceipts) {
        this.cashReceipts = cashReceipts;
    }

    public Integer getLongOptionMarketValue() {
        return longOptionMarketValue;
    }

    public void setLongOptionMarketValue(Integer longOptionMarketValue) {
        this.longOptionMarketValue = longOptionMarketValue;
    }

    public Integer getLiquidationValue() {
        return liquidationValue;
    }

    public void setLiquidationValue(Integer liquidationValue) {
        this.liquidationValue = liquidationValue;
    }

    public Integer getLongMarketValue() {
        return longMarketValue;
    }

    public void setLongMarketValue(Integer longMarketValue) {
        this.longMarketValue = longMarketValue;
    }

    public Integer getMoneyMarketFund() {
        return moneyMarketFund;
    }

    public void setMoneyMarketFund(Integer moneyMarketFund) {
        this.moneyMarketFund = moneyMarketFund;
    }

    public Integer getSavings() {
        return savings;
    }

    public void setSavings(Integer savings) {
        this.savings = savings;
    }

    public Integer getShortMarketValue() {
        return shortMarketValue;
    }

    public void setShortMarketValue(Integer shortMarketValue) {
        this.shortMarketValue = shortMarketValue;
    }

    public Integer getPendingDeposits() {
        return pendingDeposits;
    }

    public void setPendingDeposits(Integer pendingDeposits) {
        this.pendingDeposits = pendingDeposits;
    }

    public Integer getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(Integer availableFunds) {
        this.availableFunds = availableFunds;
    }

    public Integer getAvailableFundsNonMarginableTrade() {
        return availableFundsNonMarginableTrade;
    }

    public void setAvailableFundsNonMarginableTrade(Integer availableFundsNonMarginableTrade) {
        this.availableFundsNonMarginableTrade = availableFundsNonMarginableTrade;
    }

    public Integer getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(Integer buyingPower) {
        this.buyingPower = buyingPower;
    }

    public Integer getBuyingPowerNonMarginableTrade() {
        return buyingPowerNonMarginableTrade;
    }

    public void setBuyingPowerNonMarginableTrade(Integer buyingPowerNonMarginableTrade) {
        this.buyingPowerNonMarginableTrade = buyingPowerNonMarginableTrade;
    }

    public Integer getDayTradingBuyingPower() {
        return dayTradingBuyingPower;
    }

    public void setDayTradingBuyingPower(Integer dayTradingBuyingPower) {
        this.dayTradingBuyingPower = dayTradingBuyingPower;
    }

    public Integer getDayTradingBuyingPowerCall() {
        return dayTradingBuyingPowerCall;
    }

    public void setDayTradingBuyingPowerCall(Integer dayTradingBuyingPowerCall) {
        this.dayTradingBuyingPowerCall = dayTradingBuyingPowerCall;
    }

    public Integer getEquity() {
        return equity;
    }

    public void setEquity(Integer equity) {
        this.equity = equity;
    }

    public Integer getEquityPercentage() {
        return equityPercentage;
    }

    public void setEquityPercentage(Integer equityPercentage) {
        this.equityPercentage = equityPercentage;
    }

    public Integer getLongMarginValue() {
        return longMarginValue;
    }

    public void setLongMarginValue(Integer longMarginValue) {
        this.longMarginValue = longMarginValue;
    }

    public Integer getMaintenanceCall() {
        return maintenanceCall;
    }

    public void setMaintenanceCall(Integer maintenanceCall) {
        this.maintenanceCall = maintenanceCall;
    }

    public Integer getMaintenanceRequirement() {
        return maintenanceRequirement;
    }

    public void setMaintenanceRequirement(Integer maintenanceRequirement) {
        this.maintenanceRequirement = maintenanceRequirement;
    }

    public Integer getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(Integer marginBalance) {
        this.marginBalance = marginBalance;
    }

    public Integer getRegTCall() {
        return regTCall;
    }

    public void setRegTCall(Integer regTCall) {
        this.regTCall = regTCall;
    }

    public Integer getShortBalance() {
        return shortBalance;
    }

    public void setShortBalance(Integer shortBalance) {
        this.shortBalance = shortBalance;
    }

    public Integer getShortMarginValue() {
        return shortMarginValue;
    }

    public void setShortMarginValue(Integer shortMarginValue) {
        this.shortMarginValue = shortMarginValue;
    }

    public Integer getShortOptionMarketValue() {
        return shortOptionMarketValue;
    }

    public void setShortOptionMarketValue(Integer shortOptionMarketValue) {
        this.shortOptionMarketValue = shortOptionMarketValue;
    }

    public Integer getSma() {
        return sma;
    }

    public void setSma(Integer sma) {
        this.sma = sma;
    }

    public Integer getMutualFundValue() {
        return mutualFundValue;
    }

    public void setMutualFundValue(Integer mutualFundValue) {
        this.mutualFundValue = mutualFundValue;
    }

    public Integer getBondValue() {
        return bondValue;
    }

    public void setBondValue(Integer bondValue) {
        this.bondValue = bondValue;
    }

    public Boolean getIsInCall() {
        return isInCall;
    }

    public void setIsInCall(Boolean isInCall) {
        this.isInCall = isInCall;
    }

    public Integer getStockBuyingPower() {
        return stockBuyingPower;
    }

    public void setStockBuyingPower(Integer stockBuyingPower) {
        this.stockBuyingPower = stockBuyingPower;
    }

    public Integer getOptionBuyingPower() {
        return optionBuyingPower;
    }

    public void setOptionBuyingPower(Integer optionBuyingPower) {
        this.optionBuyingPower = optionBuyingPower;
    }


}
