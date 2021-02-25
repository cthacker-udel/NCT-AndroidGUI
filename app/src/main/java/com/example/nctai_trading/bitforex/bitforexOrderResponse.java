package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitforexOrderResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private bitforexOrderReponseData data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public bitforexOrderReponseData getData() {
        return data;
    }

    public void setData(bitforexOrderReponseData data) {
        this.data = data;
    }

}
