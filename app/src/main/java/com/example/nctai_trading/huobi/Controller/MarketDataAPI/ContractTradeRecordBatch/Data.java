package com.example.nctai_trading.huobi.Controller.MarketDataAPI.ContractTradeRecordBatch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("ts")
    @Expose
    private Long ts;
    @SerializedName("quantity")
    @Expose
    private Double quantity;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
