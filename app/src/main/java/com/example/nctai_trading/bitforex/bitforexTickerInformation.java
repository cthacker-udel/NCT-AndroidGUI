package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitforexTickerInformation {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private bitforexTickerInformationData data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public bitforexTickerInformationData getData() {
        return data;
    }

    public void setData(bitforexTickerInformationData data) {
        this.data = data;
    }

}
