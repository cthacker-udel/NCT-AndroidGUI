package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.particle.android.sdk.cloud.models.AccountInfo;

public class particleGetCurrentUserResponse {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("subscription_ids")
    @Expose
    private List<Object> subscriptionIds = null;
    @SerializedName("account_info")
    @Expose
    private particleGetCurrentUserResponseAccountInfo accountInfo;
    @SerializedName("mfa")
    @Expose
    private particleGetCurrentUserMfa mfa;
    @SerializedName("wifi_device_count")
    @Expose
    private Integer wifiDeviceCount;
    @SerializedName("cellular_device_count")
    @Expose
    private Integer cellularDeviceCount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Object> getSubscriptionIds() {
        return subscriptionIds;
    }

    public void setSubscriptionIds(List<Object> subscriptionIds) {
        this.subscriptionIds = subscriptionIds;
    }

    public particleGetCurrentUserResponseAccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(particleGetCurrentUserResponseAccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public particleGetCurrentUserMfa getMfa() {
        return mfa;
    }

    public void setMfa(particleGetCurrentUserMfa mfa) {
        this.mfa = mfa;
    }

    public Integer getWifiDeviceCount() {
        return wifiDeviceCount;
    }

    public void setWifiDeviceCount(Integer wifiDeviceCount) {
        this.wifiDeviceCount = wifiDeviceCount;
    }

    public Integer getCellularDeviceCount() {
        return cellularDeviceCount;
    }

    public void setCellularDeviceCount(Integer cellularDeviceCount) {
        this.cellularDeviceCount = cellularDeviceCount;
    }

}
