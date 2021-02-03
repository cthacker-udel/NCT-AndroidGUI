package com.example.nctai_trading;

import com.google.gson.annotations.SerializedName;

public class coinBaseBody {

    @SerializedName("price")
    private Double price;

    @SerializedName("size")
    private Double size;

    @SerializedName("side")
    private String side;

    @SerializedName("product_id")
    private String product_id;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
