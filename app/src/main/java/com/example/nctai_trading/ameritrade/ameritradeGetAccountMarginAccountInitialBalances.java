package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetAccountMarginAccountInitialBalances {

    @SerializedName("accruedInterest")
    @Expose
    private Integer accruedInterest;
    @SerializedName("availableFundsNonMarginableTrade")
    @Expose
    private Integer availableFundsNonMarginableTrade;
    @SerializedName("bondValue")
    @Expose
    private Integer bondValue;
    @SerializedName("buyingPower")
    @Expose
    private Integer buyingPower;
    @SerializedName("cashBalance")
    @Expose
    private Integer cashBalance;
    @SerializedName("cashAvailableForTrading")
    @Expose
    private Integer cashAvailableForTrading;
    @SerializedName("cashReceipts")
    @Expose
    private Integer cashReceipts;
    @SerializedName("dayTradingBuyingPower")
    @Expose
    private Integer dayTradingBuyingPower;
    @SerializedName("dayTradingBuyingPowerCall")
    @Expose
    private Integer dayTradingBuyingPowerCall;
    @SerializedName("dayTradingEquityCall")
    @Expose
    private Integer dayTradingEquityCall;
    @SerializedName("equity")
    @Expose
    private Integer equity;
    @SerializedName("equityPercentage")
    @Expose
    private Integer equityPercentage;
    @SerializedName("liquidationValue")
    @Expose
    private Integer liquidationValue;
    @SerializedName("longMarginValue")
    @Expose
    private Integer longMarginValue;
    @SerializedName("longOptionMarketValue")
    @Expose
    private Integer longOptionMarketValue;
    @SerializedName("longStockValue")
    @Expose
    private Integer longStockValue;
    @SerializedName("maintenanceCall")
    @Expose
    private Integer maintenanceCall;
    @SerializedName("maintenanceRequirement")
    @Expose
    private Integer maintenanceRequirement;
    @SerializedName("margin")
    @Expose
    private Integer margin;
    @SerializedName("marginEquity")
    @Expose
    private Integer marginEquity;
    @SerializedName("moneyMarketFund")
    @Expose
    private Integer moneyMarketFund;
    @SerializedName("mutualFundValue")
    @Expose
    private Integer mutualFundValue;
    @SerializedName("regTCall")
    @Expose
    private Integer regTCall;
    @SerializedName("shortMarginValue")
    @Expose
    private Integer shortMarginValue;
    @SerializedName("shortOptionMarketValue")
    @Expose
    private Integer shortOptionMarketValue;
    @SerializedName("shortStockValue")
    @Expose
    private Integer shortStockValue;
    @SerializedName("totalCash")
    @Expose
    private Integer totalCash;
    @SerializedName("isInCall")
    @Expose
    private Boolean isInCall;
    @SerializedName("unsettledCash")
    @Expose
    private Integer unsettledCash;
    @SerializedName("pendingDeposits")
    @Expose
    private Integer pendingDeposits;
    @SerializedName("marginBalance")
    @Expose
    private Integer marginBalance;
    @SerializedName("shortBalance")
    @Expose
    private Integer shortBalance;
    @SerializedName("accountValue")
    @Expose
    private Integer accountValue;

    public Integer getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(Integer accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public Integer getAvailableFundsNonMarginableTrade() {
        return availableFundsNonMarginableTrade;
    }

    public void setAvailableFundsNonMarginableTrade(Integer availableFundsNonMarginableTrade) {
        this.availableFundsNonMarginableTrade = availableFundsNonMarginableTrade;
    }

    public Integer getBondValue() {
        return bondValue;
    }

    public void setBondValue(Integer bondValue) {
        this.bondValue = bondValue;
    }

    public Integer getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(Integer buyingPower) {
        this.buyingPower = buyingPower;
    }

    public Integer getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Integer cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Integer getCashAvailableForTrading() {
        return cashAvailableForTrading;
    }

    public void setCashAvailableForTrading(Integer cashAvailableForTrading) {
        this.cashAvailableForTrading = cashAvailableForTrading;
    }

    public Integer getCashReceipts() {
        return cashReceipts;
    }

    public void setCashReceipts(Integer cashReceipts) {
        this.cashReceipts = cashReceipts;
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

    public Integer getDayTradingEquityCall() {
        return dayTradingEquityCall;
    }

    public void setDayTradingEquityCall(Integer dayTradingEquityCall) {
        this.dayTradingEquityCall = dayTradingEquityCall;
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

    public Integer getLiquidationValue() {
        return liquidationValue;
    }

    public void setLiquidationValue(Integer liquidationValue) {
        this.liquidationValue = liquidationValue;
    }

    public Integer getLongMarginValue() {
        return longMarginValue;
    }

    public void setLongMarginValue(Integer longMarginValue) {
        this.longMarginValue = longMarginValue;
    }

    public Integer getLongOptionMarketValue() {
        return longOptionMarketValue;
    }

    public void setLongOptionMarketValue(Integer longOptionMarketValue) {
        this.longOptionMarketValue = longOptionMarketValue;
    }

    public Integer getLongStockValue() {
        return longStockValue;
    }

    public void setLongStockValue(Integer longStockValue) {
        this.longStockValue = longStockValue;
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

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public Integer getMarginEquity() {
        return marginEquity;
    }

    public void setMarginEquity(Integer marginEquity) {
        this.marginEquity = marginEquity;
    }

    public Integer getMoneyMarketFund() {
        return moneyMarketFund;
    }

    public void setMoneyMarketFund(Integer moneyMarketFund) {
        this.moneyMarketFund = moneyMarketFund;
    }

    public Integer getMutualFundValue() {
        return mutualFundValue;
    }

    public void setMutualFundValue(Integer mutualFundValue) {
        this.mutualFundValue = mutualFundValue;
    }

    public Integer getRegTCall() {
        return regTCall;
    }

    public void setRegTCall(Integer regTCall) {
        this.regTCall = regTCall;
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

    public Integer getShortStockValue() {
        return shortStockValue;
    }

    public void setShortStockValue(Integer shortStockValue) {
        this.shortStockValue = shortStockValue;
    }

    public Integer getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(Integer totalCash) {
        this.totalCash = totalCash;
    }

    public Boolean getIsInCall() {
        return isInCall;
    }

    public void setIsInCall(Boolean isInCall) {
        this.isInCall = isInCall;
    }

    public Integer getUnsettledCash() {
        return unsettledCash;
    }

    public void setUnsettledCash(Integer unsettledCash) {
        this.unsettledCash = unsettledCash;
    }

    public Integer getPendingDeposits() {
        return pendingDeposits;
    }

    public void setPendingDeposits(Integer pendingDeposits) {
        this.pendingDeposits = pendingDeposits;
    }

    public Integer getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(Integer marginBalance) {
        this.marginBalance = marginBalance;
    }

    public Integer getShortBalance() {
        return shortBalance;
    }

    public void setShortBalance(Integer shortBalance) {
        this.shortBalance = shortBalance;
    }

    public Integer getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(Integer accountValue) {
        this.accountValue = accountValue;
    }


}
