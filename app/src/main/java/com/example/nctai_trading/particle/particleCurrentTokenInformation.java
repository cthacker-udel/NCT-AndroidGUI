package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleCurrentTokenInformation {

    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("client")
    @Expose
    private String client;
    @SerializedName("scopes")
    @Expose
    private List<Object> scopes = null;
    @SerializedName("orgs")
    @Expose
    private List<Object> orgs = null;

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Object> getScopes() {
        return scopes;
    }

    public void setScopes(List<Object> scopes) {
        this.scopes = scopes;
    }

    public List<Object> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<Object> orgs) {
        this.orgs = orgs;
    }

}
