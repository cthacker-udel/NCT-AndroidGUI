package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleListFirmwareAllPlatformsPlatforms {

    @SerializedName("Core")
    @Expose
    private Integer core;
    @SerializedName("Photon")
    @Expose
    private Integer photon;
    @SerializedName("P1")
    @Expose
    private Integer p1;
    @SerializedName("Electron")
    @Expose
    private Integer electron;

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Integer getPhoton() {
        return photon;
    }

    public void setPhoton(Integer photon) {
        this.photon = photon;
    }

    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    public Integer getElectron() {
        return electron;
    }

    public void setElectron(Integer electron) {
        this.electron = electron;
    }

}
