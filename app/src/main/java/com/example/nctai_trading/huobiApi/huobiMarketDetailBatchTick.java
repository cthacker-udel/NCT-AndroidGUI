package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class huobiMarketDetailBatchTick {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("ask")
    @Expose
    private List<Integer> ask = null;
    @SerializedName("bid")
    @Expose
    private List<Integer> bid = null;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("open")
    @Expose
    private String open;
    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("vol")
    @Expose
    private String vol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

}
