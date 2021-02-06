package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleDeviceInformationVariables {

    @SerializedName("Gongs")
    @Expose
    private String gongs;

    public String getGongs() {
        return gongs;
    }

    public void setGongs(String gongs) {
        this.gongs = gongs;
    }

}
