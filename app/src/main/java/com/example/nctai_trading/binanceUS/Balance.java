package com.example.nctai_trading.binanceUS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balance {

    @SerializedName("asset")
    @Expose
    private String asset;
    @SerializedName("free")
    @Expose
    private String free;
    @SerializedName("locked")
    @Expose
    private String locked;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }


}
