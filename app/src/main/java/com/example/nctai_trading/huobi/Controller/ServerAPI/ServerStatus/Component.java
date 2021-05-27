package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Component {

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
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("showcase")
    @Expose
    private Boolean showcase;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("page_id")
    @Expose
    private String pageId;
    @SerializedName("group")
    @Expose
    private Boolean group;
    @SerializedName("only_show_if_degraded")
    @Expose
    private Boolean onlyShowIfDegraded;

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getShowcase() {
        return showcase;
    }

    public void setShowcase(Boolean showcase) {
        this.showcase = showcase;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Boolean getGroup() {
        return group;
    }

    public void setGroup(Boolean group) {
        this.group = group;
    }

    public Boolean getOnlyShowIfDegraded() {
        return onlyShowIfDegraded;
    }

    public void setOnlyShowIfDegraded(Boolean onlyShowIfDegraded) {
        this.onlyShowIfDegraded = onlyShowIfDegraded;
    }

}
