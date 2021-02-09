package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetAccountMarginAccountCancelTime {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("shortFormat")
    @Expose
    private Boolean shortFormat;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getShortFormat() {
        return shortFormat;
    }

    public void setShortFormat(Boolean shortFormat) {
        this.shortFormat = shortFormat;
    }

}
