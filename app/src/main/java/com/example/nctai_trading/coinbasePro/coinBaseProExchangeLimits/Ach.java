package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ach {

    @SerializedName("BAT")
    @Expose
    private BAT bAT;

    public BAT getBAT() {
        return bAT;
    }

    public void setBAT(BAT bAT) {
        this.bAT = bAT;
    }

}
