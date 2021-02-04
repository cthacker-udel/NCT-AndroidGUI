package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditDebitCard {

    @SerializedName("BAT")
    @Expose
    private BAT__ bAT;

    public BAT__ getBAT() {
        return bAT;
    }

    public void setBAT(BAT__ bAT) {
        this.bAT = bAT;
    }

}
