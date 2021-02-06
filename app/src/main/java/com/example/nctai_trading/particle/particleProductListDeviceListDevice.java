package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleProductListDeviceListDevice {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_ip_address")
    @Expose
    private String lastIpAddress;
    @SerializedName("last_heard")
    @Expose
    private String lastHeard;
    @SerializedName("last_handshake_at")
    @Expose
    private String lastHandshakeAt;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("online")
    @Expose
    private Boolean online;
    @SerializedName("platform_id")
    @Expose
    private Integer platformId;
    @SerializedName("cellular")
    @Expose
    private Boolean cellular;
    @SerializedName("functions")
    @Expose
    private List<String> functions = null;
    @SerializedName("variables")
    @Expose
    private particleProductListDeviceListVariables variables;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("system_firmware_version")
    @Expose
    private String systemFirmwareVersion;
    @SerializedName("firmware_product_id")
    @Expose
    private Integer firmwareProductId;
    @SerializedName("groups")
    @Expose
    private List<String> groups = null;
    @SerializedName("firmware_version")
    @Expose
    private Integer firmwareVersion;
    @SerializedName("desired_firmware_version")
    @Expose
    private Object desiredFirmwareVersion;
    @SerializedName("targeted_firmware_release_version")
    @Expose
    private Integer targetedFirmwareReleaseVersion;
    @SerializedName("development")
    @Expose
    private Boolean development;
    @SerializedName("quarantined")
    @Expose
    private Boolean quarantined;
    @SerializedName("denied")
    @Expose
    private Boolean denied;
    @SerializedName("owner")
    @Expose
    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastIpAddress() {
        return lastIpAddress;
    }

    public void setLastIpAddress(String lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }

    public String getLastHeard() {
        return lastHeard;
    }

    public void setLastHeard(String lastHeard) {
        this.lastHeard = lastHeard;
    }

    public String getLastHandshakeAt() {
        return lastHandshakeAt;
    }

    public void setLastHandshakeAt(String lastHandshakeAt) {
        this.lastHandshakeAt = lastHandshakeAt;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Boolean getCellular() {
        return cellular;
    }

    public void setCellular(Boolean cellular) {
        this.cellular = cellular;
    }

    public List<String> getFunctions() {
        return functions;
    }

    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

    public particleProductListDeviceListVariables getVariables() {
        return variables;
    }

    public void setVariables(particleProductListDeviceListVariables variables) {
        this.variables = variables;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemFirmwareVersion() {
        return systemFirmwareVersion;
    }

    public void setSystemFirmwareVersion(String systemFirmwareVersion) {
        this.systemFirmwareVersion = systemFirmwareVersion;
    }

    public Integer getFirmwareProductId() {
        return firmwareProductId;
    }

    public void setFirmwareProductId(Integer firmwareProductId) {
        this.firmwareProductId = firmwareProductId;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public Integer getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(Integer firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Object getDesiredFirmwareVersion() {
        return desiredFirmwareVersion;
    }

    public void setDesiredFirmwareVersion(Object desiredFirmwareVersion) {
        this.desiredFirmwareVersion = desiredFirmwareVersion;
    }

    public Integer getTargetedFirmwareReleaseVersion() {
        return targetedFirmwareReleaseVersion;
    }

    public void setTargetedFirmwareReleaseVersion(Integer targetedFirmwareReleaseVersion) {
        this.targetedFirmwareReleaseVersion = targetedFirmwareReleaseVersion;
    }

    public Boolean getDevelopment() {
        return development;
    }

    public void setDevelopment(Boolean development) {
        this.development = development;
    }

    public Boolean getQuarantined() {
        return quarantined;
    }

    public void setQuarantined(Boolean quarantined) {
        this.quarantined = quarantined;
    }

    public Boolean getDenied() {
        return denied;
    }

    public void setDenied(Boolean denied) {
        this.denied = denied;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
