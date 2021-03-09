package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

public class MFHolding {
    @SerializedName("quantity")
    public double quantity;
    @SerializedName("fund")
    public String fund;
    @SerializedName("folio")
    public String folio;
    @SerializedName("average_price")
    public double averagePrice;
    @SerializedName("tradingsymbol")
    public String tradingsymbol;
    @SerializedName("last_price")
    public double lastPrice;
    @SerializedName("pnl")
    public double pnl;

}

