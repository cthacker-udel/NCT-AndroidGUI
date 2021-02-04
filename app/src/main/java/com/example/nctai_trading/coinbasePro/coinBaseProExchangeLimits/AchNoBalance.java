package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AchNoBalance {

    @SerializedName("BAT")
    @Expose
    private BAT_ bAT;

    public BAT_ getBAT() {
        return bAT;
    }

    public void setBAT(BAT_ bAT) {
        this.bAT = bAT;
    }

}
