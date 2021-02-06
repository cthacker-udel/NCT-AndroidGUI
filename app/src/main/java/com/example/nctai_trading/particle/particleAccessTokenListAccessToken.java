package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleAccessTokenListAccessToken {


    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("client")
    @Expose
    private String client;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

}
