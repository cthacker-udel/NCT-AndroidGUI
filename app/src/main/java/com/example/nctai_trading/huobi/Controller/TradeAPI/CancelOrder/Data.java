package com.example.nctai_trading.huobi.Controller.TradeAPI.CancelOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("errors")
    @Expose
    private List<Error> errors = null;
    @SerializedName("successes")
    @Expose
    private String successes;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public String getSuccesses() {
        return successes;
    }

    public void setSuccesses(String successes) {
        this.successes = successes;
    }

}
