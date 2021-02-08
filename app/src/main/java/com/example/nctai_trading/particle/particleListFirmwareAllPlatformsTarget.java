package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleListFirmwareAllPlatformsTarget {

    @SerializedName("platforms")
    @Expose
    private List<Integer> platforms = null;
    @SerializedName("prereleases")
    @Expose
    private List<Object> prereleases = null;
    @SerializedName("firmware_vendor")
    @Expose
    private String firmwareVendor;
    @SerializedName("version")
    @Expose
    private String version;

    public List<Integer> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Integer> platforms) {
        this.platforms = platforms;
    }

    public List<Object> getPrereleases() {
        return prereleases;
    }

    public void setPrereleases(List<Object> prereleases) {
        this.prereleases = prereleases;
    }

    public String getFirmwareVendor() {
        return firmwareVendor;
    }

    public void setFirmwareVendor(String firmwareVendor) {
        this.firmwareVendor = firmwareVendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
