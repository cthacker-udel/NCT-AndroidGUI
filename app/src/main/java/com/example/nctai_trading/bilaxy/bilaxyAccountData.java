package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxyAccountData {

    @SerializedName("symbol")
    @Expose
    private Integer symbol;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("frozen")
    @Expose
    private String frozen;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
