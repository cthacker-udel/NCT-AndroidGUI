package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleDevicePingResponse {

    @SerializedName("online")
    @Expose
    private Boolean online;
    @SerializedName("ok")
    @Expose
    private Boolean ok;

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

}
