package com.example.nctai_trading.digifinex.orderHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("created_date")
    @Expose
    private Integer createdDate;
    @SerializedName("finished_date")
    @Expose
    private Integer finishedDate;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("executed_amount")
    @Expose
    private Double executedAmount;
    @SerializedName("cash_amount")
    @Expose
    private Double cashAmount;
    @SerializedName("avg_price")
    @Expose
    private Double avgPrice;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Integer finishedDate) {
        this.finishedDate = finishedDate;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(Double executedAmount) {
        this.executedAmount = executedAmount;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
