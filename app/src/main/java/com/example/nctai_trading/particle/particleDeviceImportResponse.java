package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleDeviceImportResponse {

    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("nonmemberDeviceIds")
    @Expose
    private List<Object> nonmemberDeviceIds = null;
    @SerializedName("invalidDeviceIds")
    @Expose
    private List<Object> invalidDeviceIds = null;

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public List<Object> getNonmemberDeviceIds() {
        return nonmemberDeviceIds;
    }

    public void setNonmemberDeviceIds(List<Object> nonmemberDeviceIds) {
        this.nonmemberDeviceIds = nonmemberDeviceIds;
    }

    public List<Object> getInvalidDeviceIds() {
        return invalidDeviceIds;
    }

    public void setInvalidDeviceIds(List<Object> invalidDeviceIds) {
        this.invalidDeviceIds = invalidDeviceIds;
    }

}
