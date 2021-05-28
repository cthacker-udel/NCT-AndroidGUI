package com.example.nctai_trading.bittrexV2.Controller.accountBalances;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Balance")
    @Expose
    private Double balance;
    @SerializedName("Available")
    @Expose
    private Double available;
    @SerializedName("Pending")
    @Expose
    private Integer pending;
    @SerializedName("CryptoAddress")
    @Expose
    private String cryptoAddress;
    @SerializedName("Requested")
    @Expose
    private Boolean requested;
    @SerializedName("Uuid")
    @Expose
    private Object uuid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public void setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public Boolean getRequested() {
        return requested;
    }

    public void setRequested(Boolean requested) {
        this.requested = requested;
    }

    public Object getUuid() {
        return uuid;
    }

    public void setUuid(Object uuid) {
        this.uuid = uuid;
    }

}
