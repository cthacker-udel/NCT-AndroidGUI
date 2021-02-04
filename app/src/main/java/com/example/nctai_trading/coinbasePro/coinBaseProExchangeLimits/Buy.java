package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Buy {

    @SerializedName("BAT")
    @Expose
    private BAT_________ bAT;

    public BAT_________ getBAT() {
        return bAT;
    }

    public void setBAT(BAT_________ bAT) {
        this.bAT = bAT;
    }

}
