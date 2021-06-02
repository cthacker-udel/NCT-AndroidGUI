package com.example.nctai_trading.digifinex.myPositions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class myPosition {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("free")
    @Expose
    private Free free;
    @SerializedName("frozen")
    @Expose
    private Frozen frozen;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Free getFree() {
        return free;
    }

    public void setFree(Free free) {
        this.free = free;
    }

    public Frozen getFrozen() {
        return frozen;
    }

    public void setFrozen(Frozen frozen) {
        this.frozen = frozen;
    }

}
