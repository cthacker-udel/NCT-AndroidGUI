package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("indicator")
    @Expose
    private String indicator;
    @SerializedName("description")
    @Expose
    private String description;

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
