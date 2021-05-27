package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServerStatus {

    @SerializedName("page")
    @Expose
    private Page page;
    @SerializedName("components")
    @Expose
    private List<Component> components = null;
    @SerializedName("incidents")
    @Expose
    private List<Incident> incidents = null;
    @SerializedName("scheduled_maintenances")
    @Expose
    private List<ScheduledMaintenance> scheduledMaintenances = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public List<ScheduledMaintenance> getScheduledMaintenances() {
        return scheduledMaintenances;
    }

    public void setScheduledMaintenances(List<ScheduledMaintenance> scheduledMaintenances) {
        this.scheduledMaintenances = scheduledMaintenances;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
