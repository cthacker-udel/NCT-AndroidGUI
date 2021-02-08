package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleLockProductFirmware {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desired_firmware_version")
    @Expose
    private Integer desiredFirmwareVersion;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDesiredFirmwareVersion() {
        return desiredFirmwareVersion;
    }

    public void setDesiredFirmwareVersion(Integer desiredFirmwareVersion) {
        this.desiredFirmwareVersion = desiredFirmwareVersion;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
