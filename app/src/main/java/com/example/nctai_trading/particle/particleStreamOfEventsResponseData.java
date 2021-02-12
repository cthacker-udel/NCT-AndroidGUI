package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleStreamOfEventsResponseData {

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @SerializedName("event")
    @Expose
    private String event;

    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("ttl")
    @Expose
    private String ttl;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("coreid")
    @Expose
    private String coreid;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCoreid() {
        return coreid;
    }

    public void setCoreid(String coreid) {
        this.coreid = coreid;
    }

}
