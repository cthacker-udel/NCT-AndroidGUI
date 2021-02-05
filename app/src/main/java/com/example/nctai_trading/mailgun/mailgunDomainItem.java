package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunDomainItem {

    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("timestamp")
    @Expose
    private Double timestamp;
    @SerializedName("envelope")
    @Expose
    private mailgunDomainEventsEnvelope envelope;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("campaigns")
    @Expose
    private List<Object> campaigns = null;
    @SerializedName("user-variables")
    @Expose
    private mailgunDomainEventsUserVariables userVariables;
    @SerializedName("flags")
    @Expose
    private mailgunDomainFlags flags;
    @SerializedName("message")
    @Expose
    private mailgunDomainEventsMessage message;
    @SerializedName("recipient")
    @Expose
    private String recipient;
    @SerializedName("method")
    @Expose
    private String method;

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public mailgunDomainEventsEnvelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(mailgunDomainEventsEnvelope envelope) {
        this.envelope = envelope;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<Object> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Object> campaigns) {
        this.campaigns = campaigns;
    }

    public mailgunDomainEventsUserVariables getUserVariables() {
        return userVariables;
    }

    public void setUserVariables(mailgunDomainEventsUserVariables userVariables) {
        this.userVariables = userVariables;
    }

    public mailgunDomainFlags getFlags() {
        return flags;
    }

    public void setFlags(mailgunDomainFlags flags) {
        this.flags = flags;
    }

    public mailgunDomainEventsMessage getMessage() {
        return message;
    }

    public void setMessage(mailgunDomainEventsMessage message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
