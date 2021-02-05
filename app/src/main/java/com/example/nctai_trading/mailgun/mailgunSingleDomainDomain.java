package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunSingleDomainDomain {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("smtp_login")
    @Expose
    private String smtpLogin;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("smtp_password")
    @Expose
    private String smtpPassword;
    @SerializedName("wildcard")
    @Expose
    private Boolean wildcard;
    @SerializedName("spam_action")
    @Expose
    private String spamAction;
    @SerializedName("state")
    @Expose
    private String state;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSmtpLogin() {
        return smtpLogin;
    }

    public void setSmtpLogin(String smtpLogin) {
        this.smtpLogin = smtpLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public Boolean getWildcard() {
        return wildcard;
    }

    public void setWildcard(Boolean wildcard) {
        this.wildcard = wildcard;
    }

    public String getSpamAction() {
        return spamAction;
    }

    public void setSpamAction(String spamAction) {
        this.spamAction = spamAction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
