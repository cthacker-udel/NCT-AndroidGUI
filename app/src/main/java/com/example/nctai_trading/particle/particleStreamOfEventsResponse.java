package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleStreamOfEventsResponse {

    @SerializedName("data")
    @Expose
    private particleStreamOfEventsResponseData data;

    public particleStreamOfEventsResponseData getData() {
        return data;
    }

    public void setData(particleStreamOfEventsResponseData data) {
        this.data = data;
    }

}
