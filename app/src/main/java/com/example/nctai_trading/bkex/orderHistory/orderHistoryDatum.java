package com.example.nctai_trading.bkex.orderHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class orderHistoryDatum {

    @SerializedName("createdTime")
    @Expose
    private Integer createdTime;
    @SerializedName("dealAmount")
    @Expose
    private Integer dealAmount;
    @SerializedName("dealAvgPrice")
    @Expose
    private Integer dealAvgPrice;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("frozenAmountByOrder")
    @Expose
    private Integer frozenAmountByOrder;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("orderType")
    @Expose
    private String orderType;
    @SerializedName("pair")
    @Expose
    private String pair;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("totalAmount")
    @Expose
    private Integer totalAmount;
    @SerializedName("updateTime")
    @Expose
    private Integer updateTime;

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Integer dealAmount) {
        this.dealAmount = dealAmount;
    }

    public Integer getDealAvgPrice() {
        return dealAvgPrice;
    }

    public void setDealAvgPrice(Integer dealAvgPrice) {
        this.dealAvgPrice = dealAvgPrice;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getFrozenAmountByOrder() {
        return frozenAmountByOrder;
    }

    public void setFrozenAmountByOrder(Integer frozenAmountByOrder) {
        this.frozenAmountByOrder = frozenAmountByOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

}
