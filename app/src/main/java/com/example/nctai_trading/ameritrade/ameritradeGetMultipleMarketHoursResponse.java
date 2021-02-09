package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetMultipleMarketHoursResponse {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("isOpen")
    @Expose
    private Boolean isOpen;
    @SerializedName("marketType")
    @Expose
    private String marketType;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("sessionHours")
    @Expose
    private String sessionHours;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSessionHours() {
        return sessionHours;
    }

    public void setSessionHours(String sessionHours) {
        this.sessionHours = sessionHours;
    }

}
