package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Incident {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("monitoring_at")
    @Expose
    private Object monitoringAt;
    @SerializedName("resolved_at")
    @Expose
    private Object resolvedAt;
    @SerializedName("impact")
    @Expose
    private String impact;
    @SerializedName("shortlink")
    @Expose
    private String shortlink;
    @SerializedName("started_at")
    @Expose
    private String startedAt;
    @SerializedName("page_id")
    @Expose
    private String pageId;
    @SerializedName("incident_updates")
    @Expose
    private List<IncidentUpdate> incidentUpdates = null;
    @SerializedName("components")
    @Expose
    private List<Component> components = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Object getMonitoringAt() {
        return monitoringAt;
    }

    public void setMonitoringAt(Object monitoringAt) {
        this.monitoringAt = monitoringAt;
    }

    public Object getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(Object resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getShortlink() {
        return shortlink;
    }

    public void setShortlink(String shortlink) {
        this.shortlink = shortlink;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public List<IncidentUpdate> getIncidentUpdates() {
        return incidentUpdates;
    }

    public void setIncidentUpdates(List<IncidentUpdate> incidentUpdates) {
        this.incidentUpdates = incidentUpdates;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

}
