package com.example.nctai_trading.digifinex.openOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class openOrder {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("num_per_page")
    @Expose
    private Integer numPerPage;
    @SerializedName("orders")
    @Expose
    private List<Order> orders = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
