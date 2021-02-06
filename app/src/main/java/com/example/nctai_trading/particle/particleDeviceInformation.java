package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleDeviceInformation {

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
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("functions")
    @Expose
    private List<String> functions = null;
    @SerializedName("variables")
    @Expose
    private particleDeviceInformationVariables variables;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("serial_number")
    @Expose
    private String serialNumber;
    @SerializedName("system_firmware_version")
    @Expose
    private String systemFirmwareVersion;
    @SerializedName("firmware_updates_enabled")
    @Expose
    private Boolean firmwareUpdatesEnabled;
    @SerializedName("firmware_updates_forced")
    @Expose
    private Boolean firmwareUpdatesForced;

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

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public List<String> getFunctions() {
        return functions;
    }

    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

    public particleDeviceInformationVariables getVariables() {
        return variables;
    }

    public void setVariables(particleDeviceInformationVariables variables) {
        this.variables = variables;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSystemFirmwareVersion() {
        return systemFirmwareVersion;
    }

    public void setSystemFirmwareVersion(String systemFirmwareVersion) {
        this.systemFirmwareVersion = systemFirmwareVersion;
    }

    public Boolean getFirmwareUpdatesEnabled() {
        return firmwareUpdatesEnabled;
    }

    public void setFirmwareUpdatesEnabled(Boolean firmwareUpdatesEnabled) {
        this.firmwareUpdatesEnabled = firmwareUpdatesEnabled;
    }

    public Boolean getFirmwareUpdatesForced() {
        return firmwareUpdatesForced;
    }

    public void setFirmwareUpdatesForced(Boolean firmwareUpdatesForced) {
        this.firmwareUpdatesForced = firmwareUpdatesForced;
    }

}
