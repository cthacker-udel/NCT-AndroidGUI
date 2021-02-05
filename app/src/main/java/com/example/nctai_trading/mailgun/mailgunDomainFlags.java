package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainFlags {

    @SerializedName("is-authenticated")
    @Expose
    private Boolean isAuthenticated;
    @SerializedName("is-test-mode")
    @Expose
    private Boolean isTestMode;

    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public Boolean getIsTestMode() {
        return isTestMode;
    }

    public void setIsTestMode(Boolean isTestMode) {
        this.isTestMode = isTestMode;
    }

}
