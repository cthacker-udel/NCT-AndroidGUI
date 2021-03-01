package com.example.nctai_trading.bitrue.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class exchangeInfoSymbol {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("baseAsset")
    @Expose
    private String baseAsset;
    @SerializedName("baseAssetPrecision")
    @Expose
    private Double baseAssetPrecision;
    @SerializedName("quoteAsset")
    @Expose
    private String quoteAsset;
    @SerializedName("quotePrecision")
    @Expose
    private Double quotePrecision;
    @SerializedName("orderTypes")
    @Expose
    private List<String> orderTypes = null;
    @SerializedName("icebergAllowed")
    @Expose
    private Boolean icebergAllowed;
    @SerializedName("filters")
    @Expose
    private List<exchangeInfoFilters> filters = null;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public Double getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Double baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Double getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Double quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public List<String> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public Boolean getIcebergAllowed() {
        return icebergAllowed;
    }

    public void setIcebergAllowed(Boolean icebergAllowed) {
        this.icebergAllowed = icebergAllowed;
    }

    public List<exchangeInfoFilters> getFilters() {
        return filters;
    }

    public void setFilters(List<exchangeInfoFilters> filters) {
        this.filters = filters;
    }

}
