package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinBaseListAccount {

    /*

    /accounts returns List<coinBaseListAccount>

     */

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("hold")
    @Expose
    private String hold;
    @SerializedName("profile_id")
    @Expose
    private String profileId;
    @SerializedName("trading_enabled")
    @Expose
    private Boolean tradingEnabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getTradingEnabled() {
        return tradingEnabled;
    }

    public void setTradingEnabled(Boolean tradingEnabled) {
        this.tradingEnabled = tradingEnabled;
    }
}
