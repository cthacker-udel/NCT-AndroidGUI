package com.example.nctai_trading.binanceUS.Controller.AccountAPI.OCO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OCOTrade {

    @SerializedName("orderListId")
    @Expose
    private Integer orderListId;
    @SerializedName("contingencyType")
    @Expose
    private String contingencyType;
    @SerializedName("listStatusType")
    @Expose
    private String listStatusType;
    @SerializedName("listOrderStatus")
    @Expose
    private String listOrderStatus;
    @SerializedName("listClientOrderId")
    @Expose
    private String listClientOrderId;
    @SerializedName("transactionTime")
    @Expose
    private Long transactionTime;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("orders")
    @Expose
    private List<OCOOrder> orders = null;
    @SerializedName("orderReports")
    @Expose
    private List<OCOOrderReport> orderReports = null;

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public String getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
    }

    public String getListStatusType() {
        return listStatusType;
    }

    public void setListStatusType(String listStatusType) {
        this.listStatusType = listStatusType;
    }

    public String getListOrderStatus() {
        return listOrderStatus;
    }

    public void setListOrderStatus(String listOrderStatus) {
        this.listOrderStatus = listOrderStatus;
    }

    public String getListClientOrderId() {
        return listClientOrderId;
    }

    public void setListClientOrderId(String listClientOrderId) {
        this.listClientOrderId = listClientOrderId;
    }

    public Long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<OCOOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<OCOOrder> orders) {
        this.orders = orders;
    }

    public List<OCOOrderReport> getOrderReports() {
        return orderReports;
    }

    public void setOrderReports(List<OCOOrderReport> orderReports) {
        this.orderReports = orderReports;
    }


}
