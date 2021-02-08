package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleListFirmwareAllPlatformsResponse {

    @SerializedName("targets")
    @Expose
    private List<particleListFirmwareAllPlatformsTarget> targets = null;
    @SerializedName("platforms")
    @Expose
    private particleListFirmwareAllPlatformsPlatforms platforms;

    public List<particleListFirmwareAllPlatformsTarget> getTargets() {
        return targets;
    }

    public void setTargets(List<particleListFirmwareAllPlatformsTarget> targets) {
        this.targets = targets;
    }

    public particleListFirmwareAllPlatformsPlatforms getPlatforms() {
        return platforms;
    }

    public void setPlatforms(particleListFirmwareAllPlatformsPlatforms platforms) {
        this.platforms = platforms;
    }

}
