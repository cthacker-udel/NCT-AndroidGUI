package com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapIndexPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("index_price")
    @Expose
    private Double indexPrice;
    @SerializedName("index_ts")
    @Expose
    private Long indexTs;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;

    public Double getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(Double indexPrice) {
        this.indexPrice = indexPrice;
    }

    public Long getIndexTs() {
        return indexTs;
    }

    public void setIndexTs(Long indexTs) {
        this.indexTs = indexTs;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

}
