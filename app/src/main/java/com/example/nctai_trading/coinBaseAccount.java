package com.example.nctai_trading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinBaseAccount {

    /*

    /accounts/<account-id>

     */

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("holds")
    @Expose
    private String holds;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getHolds() {
        return holds;
    }

    public void setHolds(String holds) {
        this.holds = holds;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
