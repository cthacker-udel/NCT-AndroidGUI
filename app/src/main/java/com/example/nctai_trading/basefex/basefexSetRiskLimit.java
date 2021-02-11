package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexSetRiskLimit {

    @SerializedName("notional")
    @Expose
    private Integer notional;
    @SerializedName("IMR")
    @Expose
    private Double iMR;

    public Integer getNotional() {
        return notional;
    }

    public void setNotional(Integer notional) {
        this.notional = notional;
    }

    public Double getIMR() {
        return iMR;
    }

    public void setIMR(Double iMR) {
        this.iMR = iMR;
    }

}
