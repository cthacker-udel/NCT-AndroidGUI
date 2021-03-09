package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketDepth {
    @SerializedName("buy")
    public List<Depth> buy;
    @SerializedName("sell")
    public List<Depth> sell;
}
