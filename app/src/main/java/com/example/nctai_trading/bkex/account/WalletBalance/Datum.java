package com.example.nctai_trading.bkex.account.WalletBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("coinType")
    @Expose
    private String coinType;
    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("frozen")
    @Expose
    private Integer frozen;
    @SerializedName("total")
    @Expose
    private Integer total;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
