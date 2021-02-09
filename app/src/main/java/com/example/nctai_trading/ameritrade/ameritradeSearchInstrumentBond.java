package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeSearchInstrumentBond {

    @SerializedName("bondPrice")
    @Expose
    private Integer bondPrice;
    @SerializedName("cusip")
    @Expose
    private String cusip;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("assetType")
    @Expose
    private String assetType;

    public Integer getBondPrice() {
        return bondPrice;
    }

    public void setBondPrice(Integer bondPrice) {
        this.bondPrice = bondPrice;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

}
