package com.example.nctai_trading.bitcoincom.AccountBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountBalance {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("reserved")
    @Expose
    private String reserved;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }


}
