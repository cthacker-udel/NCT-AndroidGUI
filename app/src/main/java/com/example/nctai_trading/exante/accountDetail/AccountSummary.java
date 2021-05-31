package com.example.nctai_trading.exante.accountDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountSummary {

    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("sessionDate")
    @Expose
    private String sessionDate;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("netAssetValue")
    @Expose
    private String netAssetValue;
    @SerializedName("freeMoney")
    @Expose
    private String freeMoney;
    @SerializedName("moneyUsedForMargin")
    @Expose
    private String moneyUsedForMargin;
    @SerializedName("marginUtilization")
    @Expose
    private String marginUtilization;
    @SerializedName("currencies")
    @Expose
    private List<Currency> currencies = null;
    @SerializedName("positions")
    @Expose
    private List<Position> positions = null;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(String netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public String getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(String freeMoney) {
        this.freeMoney = freeMoney;
    }

    public String getMoneyUsedForMargin() {
        return moneyUsedForMargin;
    }

    public void setMoneyUsedForMargin(String moneyUsedForMargin) {
        this.moneyUsedForMargin = moneyUsedForMargin;
    }

    public String getMarginUtilization() {
        return marginUtilization;
    }

    public void setMarginUtilization(String marginUtilization) {
        this.marginUtilization = marginUtilization;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

}
