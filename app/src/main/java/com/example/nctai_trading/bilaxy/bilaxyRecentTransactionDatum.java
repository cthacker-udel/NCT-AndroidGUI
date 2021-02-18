package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxyRecentTransactionDatum {

    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
