package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitmexInstrumentCompositeIndex {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("indexSymbol")
    @Expose
    private String indexSymbol;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("lastPrice")
    @Expose
    private Integer lastPrice;
    @SerializedName("sourcePrice")
    @Expose
    private Integer sourcePrice;
    @SerializedName("conversionIndex")
    @Expose
    private String conversionIndex;
    @SerializedName("conversionIndexPrice")
    @Expose
    private Integer conversionIndexPrice;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("logged")
    @Expose
    private String logged;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIndexSymbol() {
        return indexSymbol;
    }

    public void setIndexSymbol(String indexSymbol) {
        this.indexSymbol = indexSymbol;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getSourcePrice() {
        return sourcePrice;
    }

    public void setSourcePrice(Integer sourcePrice) {
        this.sourcePrice = sourcePrice;
    }

    public String getConversionIndex() {
        return conversionIndex;
    }

    public void setConversionIndex(String conversionIndex) {
        this.conversionIndex = conversionIndex;
    }

    public Integer getConversionIndexPrice() {
        return conversionIndexPrice;
    }

    public void setConversionIndexPrice(Integer conversionIndexPrice) {
        this.conversionIndexPrice = conversionIndexPrice;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }


}
