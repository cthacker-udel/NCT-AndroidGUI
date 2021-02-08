package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleGetDeviceGroup {

    @SerializedName("group")
    @Expose
    private particleGetDeviceGroupGroup group;

    public particleGetDeviceGroupGroup getGroup() {
        return group;
    }

    public void setGroup(particleGetDeviceGroupGroup group) {
        this.group = group;
    }

}
