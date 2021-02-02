package com.example.nctai_trading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExchangeFilter {

    @SerializedName("filterType")
    @Expose
    private String filterType;
    @SerializedName("maxNumOrders")
    @Expose
    private Integer maxNumOrders;

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Integer getMaxNumOrders() {
        return maxNumOrders;
    }

    public void setMaxNumOrders(Integer maxNumOrders) {
        this.maxNumOrders = maxNumOrders;
    }

}
