package com.example.nctai_trading.bkex.account.DepositRecord;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageRequest {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("asc")
    @Expose
    private Boolean asc;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getAsc() {
        return asc;
    }

    public void setAsc(Boolean asc) {
        this.asc = asc;
    }


}
