package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinBaseProServerResponse {

    @SerializedName("iso")
    @Expose
    private String iso;

    @SerializedName("epoch")
    @Expose
    private Double epoch;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Double getEpoch() {
        return epoch;
    }

    public void setEpoch(Double epoch) {
        this.epoch = epoch;
    }




}
