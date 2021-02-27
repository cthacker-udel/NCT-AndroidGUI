package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitforexCancelOrderResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Boolean data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }

}
