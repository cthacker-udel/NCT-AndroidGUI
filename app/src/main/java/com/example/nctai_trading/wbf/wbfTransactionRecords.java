package com.example.nctai_trading.wbf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class wbfTransactionRecords {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("resultList")
    @Expose
    private List<wbfTransactionRecordResultList> resultList = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<wbfTransactionRecordResultList> getResultList() {
        return resultList;
    }

    public void setResultList(List<wbfTransactionRecordResultList> resultList) {
        this.resultList = resultList;
    }

}
