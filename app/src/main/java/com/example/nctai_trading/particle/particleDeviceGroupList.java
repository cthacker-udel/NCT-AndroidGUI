package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleDeviceGroupList {

    @SerializedName("groups")
    @Expose
    List<particleGetDeviceGroup> groupList;

    public List<particleGetDeviceGroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<particleGetDeviceGroup> groupList) {
        this.groupList = groupList;
    }



}
