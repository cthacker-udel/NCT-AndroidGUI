package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncidentUpdate {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("incident_id")
    @Expose
    private String incidentId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("display_at")
    @Expose
    private String displayAt;
    @SerializedName("affected_components")
    @Expose
    private List<AffectedComponent> affectedComponents = null;
    @SerializedName("deliver_notifications")
    @Expose
    private Boolean deliverNotifications;
    @SerializedName("custom_tweet")
    @Expose
    private Object customTweet;
    @SerializedName("tweet_id")
    @Expose
    private Object tweetId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDisplayAt() {
        return displayAt;
    }

    public void setDisplayAt(String displayAt) {
        this.displayAt = displayAt;
    }

    public List<AffectedComponent> getAffectedComponents() {
        return affectedComponents;
    }

    public void setAffectedComponents(List<AffectedComponent> affectedComponents) {
        this.affectedComponents = affectedComponents;
    }

    public Boolean getDeliverNotifications() {
        return deliverNotifications;
    }

    public void setDeliverNotifications(Boolean deliverNotifications) {
        this.deliverNotifications = deliverNotifications;
    }

    public Object getCustomTweet() {
        return customTweet;
    }

    public void setCustomTweet(Object customTweet) {
        this.customTweet = customTweet;
    }

    public Object getTweetId() {
        return tweetId;
    }

    public void setTweetId(Object tweetId) {
        this.tweetId = tweetId;
    }


}
