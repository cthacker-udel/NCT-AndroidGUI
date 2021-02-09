package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ameritradeGetAccountMarginAccount {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("roundTrips")
    @Expose
    private Integer roundTrips;
    @SerializedName("isDayTrader")
    @Expose
    private Boolean isDayTrader;
    @SerializedName("isClosingOnlyRestricted")
    @Expose
    private Boolean isClosingOnlyRestricted;
    @SerializedName("positions")
    @Expose
    private List<ameritradeGetAccountMarginAccountPosition> positions = null;
    @SerializedName("orderStrategies")
    @Expose
    private List<ameritradeGetAccountMarginAccountOrderStrategy> orderStrategies = null;
    @SerializedName("initialBalances")
    @Expose
    private ameritradeGetAccountMarginAccountInitialBalances initialBalances;
    @SerializedName("currentBalances")
    @Expose
    private ameritradeGetAccountMarginAccountCurrentBalances currentBalances;
    @SerializedName("projectedBalances")
    @Expose
    private ameritradeGetAccountMarginAccountProjectedBalances projectedBalances;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getRoundTrips() {
        return roundTrips;
    }

    public void setRoundTrips(Integer roundTrips) {
        this.roundTrips = roundTrips;
    }

    public Boolean getIsDayTrader() {
        return isDayTrader;
    }

    public void setIsDayTrader(Boolean isDayTrader) {
        this.isDayTrader = isDayTrader;
    }

    public Boolean getIsClosingOnlyRestricted() {
        return isClosingOnlyRestricted;
    }

    public void setIsClosingOnlyRestricted(Boolean isClosingOnlyRestricted) {
        this.isClosingOnlyRestricted = isClosingOnlyRestricted;
    }

    public List<ameritradeGetAccountMarginAccountPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<ameritradeGetAccountMarginAccountPosition> positions) {
        this.positions = positions;
    }

    public List<ameritradeGetAccountMarginAccountOrderStrategy> getOrderStrategies() {
        return orderStrategies;
    }

    public void setOrderStrategies(List<ameritradeGetAccountMarginAccountOrderStrategy> orderStrategies) {
        this.orderStrategies = orderStrategies;
    }

    public ameritradeGetAccountMarginAccountInitialBalances getInitialBalances() {
        return initialBalances;
    }

    public void setInitialBalances(ameritradeGetAccountMarginAccountInitialBalances initialBalances) {
        this.initialBalances = initialBalances;
    }

    public ameritradeGetAccountMarginAccountCurrentBalances getCurrentBalances() {
        return currentBalances;
    }

    public void setCurrentBalances(ameritradeGetAccountMarginAccountCurrentBalances currentBalances) {
        this.currentBalances = currentBalances;
    }

    public ameritradeGetAccountMarginAccountProjectedBalances getProjectedBalances() {
        return projectedBalances;
    }

    public void setProjectedBalances(ameritradeGetAccountMarginAccountProjectedBalances projectedBalances) {
        this.projectedBalances = projectedBalances;
    }


}
