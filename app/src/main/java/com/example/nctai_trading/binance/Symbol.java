package com.example.nctai_trading.binance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Symbol {

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
    private Integer baseAssetPrecision;
    @SerializedName("quoteAsset")
    @Expose
    private String quoteAsset;
    @SerializedName("quotePrecision")
    @Expose
    private Integer quotePrecision;
    @SerializedName("quoteAssetPrecision")
    @Expose
    private Integer quoteAssetPrecision;
    @SerializedName("baseCommissionPrecision")
    @Expose
    private Integer baseCommissionPrecision;
    @SerializedName("quoteCommissionPrecision")
    @Expose
    private Integer quoteCommissionPrecision;
    @SerializedName("orderTypes")
    @Expose
    private List<String> orderTypes = null;
    @SerializedName("icebergAllowed")
    @Expose
    private Boolean icebergAllowed;
    @SerializedName("ocoAllowed")
    @Expose
    private Boolean ocoAllowed;
    @SerializedName("quoteOrderQtyMarketAllowed")
    @Expose
    private Boolean quoteOrderQtyMarketAllowed;
    @SerializedName("isSpotTradingAllowed")
    @Expose
    private Boolean isSpotTradingAllowed;
    @SerializedName("isMarginTradingAllowed")
    @Expose
    private Boolean isMarginTradingAllowed;
    @SerializedName("filters")
    @Expose
    private List<Object> filters = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;

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

    public Integer getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Integer baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Integer getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Integer quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public Integer getQuoteAssetPrecision() {
        return quoteAssetPrecision;
    }

    public void setQuoteAssetPrecision(Integer quoteAssetPrecision) {
        this.quoteAssetPrecision = quoteAssetPrecision;
    }

    public Integer getBaseCommissionPrecision() {
        return baseCommissionPrecision;
    }

    public void setBaseCommissionPrecision(Integer baseCommissionPrecision) {
        this.baseCommissionPrecision = baseCommissionPrecision;
    }

    public Integer getQuoteCommissionPrecision() {
        return quoteCommissionPrecision;
    }

    public void setQuoteCommissionPrecision(Integer quoteCommissionPrecision) {
        this.quoteCommissionPrecision = quoteCommissionPrecision;
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

    public Boolean getOcoAllowed() {
        return ocoAllowed;
    }

    public void setOcoAllowed(Boolean ocoAllowed) {
        this.ocoAllowed = ocoAllowed;
    }

    public Boolean getQuoteOrderQtyMarketAllowed() {
        return quoteOrderQtyMarketAllowed;
    }

    public void setQuoteOrderQtyMarketAllowed(Boolean quoteOrderQtyMarketAllowed) {
        this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
    }

    public Boolean getIsSpotTradingAllowed() {
        return isSpotTradingAllowed;
    }

    public void setIsSpotTradingAllowed(Boolean isSpotTradingAllowed) {
        this.isSpotTradingAllowed = isSpotTradingAllowed;
    }

    public Boolean getIsMarginTradingAllowed() {
        return isMarginTradingAllowed;
    }

    public void setIsMarginTradingAllowed(Boolean isMarginTradingAllowed) {
        this.isMarginTradingAllowed = isMarginTradingAllowed;
    }

    public List<Object> getFilters() {
        return filters;
    }

    public void setFilters(List<Object> filters) {
        this.filters = filters;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }


}
