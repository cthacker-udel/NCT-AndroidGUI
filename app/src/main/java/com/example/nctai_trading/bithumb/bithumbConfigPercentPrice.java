package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbConfigPercentPrice {

    @SerializedName("multiplierDown")
    @Expose
    private String multiplierDown;
    @SerializedName("multiplierUp")
    @Expose
    private String multiplierUp;

    public String getMultiplierDown() {
        return multiplierDown;
    }

    public void setMultiplierDown(String multiplierDown) {
        this.multiplierDown = multiplierDown;
    }

    public String getMultiplierUp() {
        return multiplierUp;
    }

    public void setMultiplierUp(String multiplierUp) {
        this.multiplierUp = multiplierUp;
    }

}
