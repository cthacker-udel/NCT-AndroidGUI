package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class huobiSwapMarketIndexData {

    @SerializedName("index_price")
    @Expose
    private Double indexPrice;
    @SerializedName("index_ts")
    @Expose
    private Double indexTs;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;

    public Double getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(Double indexPrice) {
        this.indexPrice = indexPrice;
    }

    public Double getIndexTs() {
        return indexTs;
    }

    public void setIndexTs(Double indexTs) {
        this.indexTs = indexTs;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

}
