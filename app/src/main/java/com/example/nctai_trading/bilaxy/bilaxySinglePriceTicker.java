package com.example.nctai_trading.bilaxy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bilaxySinglePriceTicker {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private bilaxySinglePriceTickerResponseData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public bilaxySinglePriceTickerResponseData getData() {
        return data;
    }

    public void setData(bilaxySinglePriceTickerResponseData data) {
        this.data = data;
    }

}
