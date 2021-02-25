package com.example.nctai_trading.bitforex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bitforexMarketSymbols {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<bitforexMarketSymbolsDatum> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<bitforexMarketSymbolsDatum> getData() {
        return data;
    }

    public void setData(List<bitforexMarketSymbolsDatum> data) {
        this.data = data;
    }

}
