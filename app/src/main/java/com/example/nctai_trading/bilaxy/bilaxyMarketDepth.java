package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxyMarketDepth {

    @SerializedName("data")
    @Expose
    private bilaxyMarketDepthData data;

    public bilaxyMarketDepthData getData() {
        return data;
    }

    public void setData(bilaxyMarketDepthData data) {
        this.data = data;
    }

}
