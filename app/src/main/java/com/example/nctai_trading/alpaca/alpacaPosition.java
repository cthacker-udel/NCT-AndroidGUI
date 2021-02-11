package com.example.nctai_trading.alpaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class alpacaPosition {

    @SerializedName("asset_id")
    @Expose
    private String assetId;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("asset_class")
    @Expose
    private String assetClass;
    @SerializedName("avg_entry_price")
    @Expose
    private String avgEntryPrice;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("market_value")
    @Expose
    private String marketValue;
    @SerializedName("cost_basis")
    @Expose
    private String costBasis;
    @SerializedName("unrealized_pl")
    @Expose
    private String unrealizedPl;
    @SerializedName("unrealized_plpc")
    @Expose
    private String unrealizedPlpc;
    @SerializedName("unrealized_intraday_pl")
    @Expose
    private String unrealizedIntradayPl;
    @SerializedName("unrealized_intraday_plpc")
    @Expose
    private String unrealizedIntradayPlpc;
    @SerializedName("current_price")
    @Expose
    private String currentPrice;
    @SerializedName("lastday_price")
    @Expose
    private String lastdayPrice;
    @SerializedName("change_today")
    @Expose
    private String changeToday;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getAvgEntryPrice() {
        return avgEntryPrice;
    }

    public void setAvgEntryPrice(String avgEntryPrice) {
        this.avgEntryPrice = avgEntryPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(String costBasis) {
        this.costBasis = costBasis;
    }

    public String getUnrealizedPl() {
        return unrealizedPl;
    }

    public void setUnrealizedPl(String unrealizedPl) {
        this.unrealizedPl = unrealizedPl;
    }

    public String getUnrealizedPlpc() {
        return unrealizedPlpc;
    }

    public void setUnrealizedPlpc(String unrealizedPlpc) {
        this.unrealizedPlpc = unrealizedPlpc;
    }

    public String getUnrealizedIntradayPl() {
        return unrealizedIntradayPl;
    }

    public void setUnrealizedIntradayPl(String unrealizedIntradayPl) {
        this.unrealizedIntradayPl = unrealizedIntradayPl;
    }

    public String getUnrealizedIntradayPlpc() {
        return unrealizedIntradayPlpc;
    }

    public void setUnrealizedIntradayPlpc(String unrealizedIntradayPlpc) {
        this.unrealizedIntradayPlpc = unrealizedIntradayPlpc;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getLastdayPrice() {
        return lastdayPrice;
    }

    public void setLastdayPrice(String lastdayPrice) {
        this.lastdayPrice = lastdayPrice;
    }

    public String getChangeToday() {
        return changeToday;
    }

    public void setChangeToday(String changeToday) {
        this.changeToday = changeToday;
    }

}
