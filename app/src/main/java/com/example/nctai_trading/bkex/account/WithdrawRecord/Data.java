package com.example.nctai_trading.bkex.account.WithdrawRecord;

import com.example.nctai_trading.bkex.account.DepositRecord.PageRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("pageRequest")
    @Expose
    private PageRequest pageRequest;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
