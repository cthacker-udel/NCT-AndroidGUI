package com.example.nctai_trading.exante.accountDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("symbolId")
    @Expose
    private String symbolId;
    @SerializedName("symbolType")
    @Expose
    private String symbolType;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("averagePrice")
    @Expose
    private String averagePrice;
    @SerializedName("pnl")
    @Expose
    private String pnl;
    @SerializedName("convertedPnl")
    @Expose
    private String convertedPnl;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("convertedValue")
    @Expose
    private String convertedValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    public String getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(String symbolType) {
        this.symbolType = symbolType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getPnl() {
        return pnl;
    }

    public void setPnl(String pnl) {
        this.pnl = pnl;
    }

    public String getConvertedPnl() {
        return convertedPnl;
    }

    public void setConvertedPnl(String convertedPnl) {
        this.convertedPnl = convertedPnl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(String convertedValue) {
        this.convertedValue = convertedValue;
    }

}
