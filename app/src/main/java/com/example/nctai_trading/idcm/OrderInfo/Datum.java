package com.example.nctai_trading.idcm.OrderInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("avgprice")
    @Expose
    private Double avgprice;
    @SerializedName("side")
    @Expose
    private Integer side;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("executedamount")
    @Expose
    private Integer executedamount;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Double avgprice) {
        this.avgprice = avgprice;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getExecutedamount() {
        return executedamount;
    }

    public void setExecutedamount(Integer executedamount) {
        this.executedamount = executedamount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
