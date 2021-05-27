package com.example.nctai_trading.huobi.Controller.MarketDataAPI.LastContractTrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("ts")
    @Expose
    private Long ts;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("quantity")
    @Expose
    private String quantity;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
