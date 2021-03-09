package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

public class TriggerRange {

    @SerializedName("lower")
    public double lower;
    @SerializedName("upper")
    public double upper;
    @SerializedName("percentage")
    public double percentage;
}
