package com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketBBO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tick {

    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("ask")
    @Expose
    private List<Integer> ask = null;
    @SerializedName("bid")
    @Expose
    private List<Integer> bid = null;
    @SerializedName("mrid")
    @Expose
    private Integer mrid;
    @SerializedName("ts")
    @Expose
    private Long ts;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public List<Integer> getAsk() {
        return ask;
    }

    public void setAsk(List<Integer> ask) {
        this.ask = ask;
    }

    public List<Integer> getBid() {
        return bid;
    }

    public void setBid(List<Integer> bid) {
        this.bid = bid;
    }

    public Integer getMrid() {
        return mrid;
    }

    public void setMrid(Integer mrid) {
        this.mrid = mrid;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }


}
