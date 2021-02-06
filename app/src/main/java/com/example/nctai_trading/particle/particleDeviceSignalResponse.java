package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleDeviceSignalResponse {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("connected")
    @Expose
    private Boolean connected;
    @SerializedName("signaling")
    @Expose
    private Boolean signaling;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Boolean getSignaling() {
        return signaling;
    }

    public void setSignaling(Boolean signaling) {
        this.signaling = signaling;
    }

}
