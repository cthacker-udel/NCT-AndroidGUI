package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseFees {

    @SerializedName("maker_fee_rate")
    @Expose
    private String makerFeeRate;
    @SerializedName("taker_fee_rate")
    @Expose
    private String takerFeeRate;
    @SerializedName("usd_volume")
    @Expose
    private String usdVolume;

    public String getMakerFeeRate() {
        return makerFeeRate;
    }

    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public String getTakerFeeRate() {
        return takerFeeRate;
    }

    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

    public String getUsdVolume() {
        return usdVolume;
    }

    public void setUsdVolume(String usdVolume) {
        this.usdVolume = usdVolume;
    }

}
