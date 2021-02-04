package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sell {

    @SerializedName("BAT")
    @Expose
    private BAT__________ bAT;

    public BAT__________ getBAT() {
        return bAT;
    }

    public void setBAT(BAT__________ bAT) {
        this.bAT = bAT;
    }

}
