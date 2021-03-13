package com.example.nctai_trading.bkex.orderHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class orderHistoryData {

    @SerializedName("data")
    @Expose
    private List<orderHistoryDatum> data = null;
    @SerializedName("pageRequest")
    @Expose
    private orderHistoryPageRequest pageRequest;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<orderHistoryDatum> getData() {
        return data;
    }

    public void setData(List<orderHistoryDatum> data) {
        this.data = data;
    }

    public orderHistoryPageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(orderHistoryPageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
