package com.example.nctai_trading.digifinex.myPositions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Free {

    @SerializedName("usdt")
    @Expose
    private Double usdt;
    @SerializedName("btc")
    @Expose
    private Double btc;

    public Double getUsdt() {
        return usdt;
    }

    public void setUsdt(Double usdt) {
        this.usdt = usdt;
    }

    public Double getBtc() {
        return btc;
    }

    public void setBtc(Double btc) {
        this.btc = btc;
    }

}
