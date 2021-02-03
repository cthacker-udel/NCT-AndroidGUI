package com.example.nctai_trading;

import java.math.BigDecimal;

public class NewMarketOrderSingle{

    private double size;
    private String side;
    private String type;
    private String product_id;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public NewMarketOrderSingle(double size) {
        this.size = size;
        this.type = "market";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}