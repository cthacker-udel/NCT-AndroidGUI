package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleWebhookAzureResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("integration_type")
    @Expose
    private String integrationType;
    @SerializedName("hub_name")
    @Expose
    private String hubName;
    @SerializedName("policy_name")
    @Expose
    private String policyName;
    @SerializedName("policy_key")
    @Expose
    private String policyKey;
    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("integrationUrl")
    @Expose
    private String integrationUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getHubName() {
        return hubName;
    }

    public void setHubName(String hubName) {
        this.hubName = hubName;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyKey() {
        return policyKey;
    }

    public void setPolicyKey(String policyKey) {
        this.policyKey = policyKey;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getIntegrationUrl() {
        return integrationUrl;
    }

    public void setIntegrationUrl(String integrationUrl) {
        this.integrationUrl = integrationUrl;
    }

}
