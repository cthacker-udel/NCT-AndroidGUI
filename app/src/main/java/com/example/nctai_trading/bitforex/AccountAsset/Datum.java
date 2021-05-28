package com.example.nctai_trading.bitforex.AccountAsset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("fix")
    @Expose
    private Integer fix;
    @SerializedName("frozen")
    @Expose
    private Integer frozen;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getFix() {
        return fix;
    }

    public void setFix(Integer fix) {
        this.fix = fix;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }


}
