package com.example.nctai_trading.idcm.UserInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("free")
    @Expose
    private Double free;
    @SerializedName("freezed")
    @Expose
    private Integer freezed;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getFree() {
        return free;
    }

    public void setFree(Double free) {
        this.free = free;
    }

    public Integer getFreezed() {
        return freezed;
    }

    public void setFreezed(Integer freezed) {
        this.freezed = freezed;
    }

}
