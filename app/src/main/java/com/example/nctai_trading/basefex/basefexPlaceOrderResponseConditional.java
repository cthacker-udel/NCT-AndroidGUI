package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexPlaceOrderResponseConditional {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("priceType")
    @Expose
    private String priceType;
    @SerializedName("price")
    @Expose
    private Integer price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
