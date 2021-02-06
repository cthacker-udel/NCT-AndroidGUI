package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunSingleEmailValidation {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("is_disposable_address")
    @Expose
    private Boolean isDisposableAddress;
    @SerializedName("is_role_address")
    @Expose
    private Boolean isRoleAddress;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("risk")
    @Expose
    private String risk;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsDisposableAddress() {
        return isDisposableAddress;
    }

    public void setIsDisposableAddress(Boolean isDisposableAddress) {
        this.isDisposableAddress = isDisposableAddress;
    }

    public Boolean getIsRoleAddress() {
        return isRoleAddress;
    }

    public void setIsRoleAddress(Boolean isRoleAddress) {
        this.isRoleAddress = isRoleAddress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

}
