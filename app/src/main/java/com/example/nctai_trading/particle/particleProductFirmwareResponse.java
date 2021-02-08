package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleProductFirmwareResponse {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("product_default")
    @Expose
    private Boolean productDefault;
    @SerializedName("uploaded_on")
    @Expose
    private String uploadedOn;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("mandatory")
    @Expose
    private Boolean mandatory;
    @SerializedName("uploaded_by")
    @Expose
    private particleProductFirmwareUploadedBy uploadedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getProductDefault() {
        return productDefault;
    }

    public void setProductDefault(Boolean productDefault) {
        this.productDefault = productDefault;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(String uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public particleProductFirmwareUploadedBy getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(particleProductFirmwareUploadedBy uploadedBy) {
        this.uploadedBy = uploadedBy;
    }


}
