package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleGetCurrentUserResponseAccountInfo {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("business_account")
    @Expose
    private Boolean businessAccount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(Boolean businessAccount) {
        this.businessAccount = businessAccount;
    }

}
