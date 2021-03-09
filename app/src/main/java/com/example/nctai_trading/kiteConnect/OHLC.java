package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

public class OHLC {

    @SerializedName("high")
    public double high;
    @SerializedName("low")
    public double low;
    @SerializedName("close")
    public double close;
    @SerializedName("open")
    public double open;
}
