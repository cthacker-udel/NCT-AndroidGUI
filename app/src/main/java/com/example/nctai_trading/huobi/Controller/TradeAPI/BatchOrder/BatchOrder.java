package com.example.nctai_trading.huobi.Controller.TradeAPI.BatchOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BatchOrder {

    @SerializedName("orders_data")
    @Expose
    private List<OrdersDatum> ordersData = null;

    public List<OrdersDatum> getOrdersData() {
        return ordersData;
    }

    public void setOrdersData(List<OrdersDatum> ordersData) {
        this.ordersData = ordersData;
    }

}
