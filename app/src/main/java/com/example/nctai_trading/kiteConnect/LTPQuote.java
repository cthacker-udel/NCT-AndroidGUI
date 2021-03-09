package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

public class LTPQuote {

    @SerializedName("instrument_token")
    public long instrumentToken;
    @SerializedName("last_price")
    public double lastPrice;

}

