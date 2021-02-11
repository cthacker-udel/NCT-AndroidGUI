package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexGetAccountCashAndPositionDetail {

    @SerializedName("cash")
    @Expose
    private basefexGetAccountCashAndPositionDetailCash cash;

    public basefexGetAccountCashAndPositionDetailCash getCash() {
        return cash;
    }

    public void setCash(basefexGetAccountCashAndPositionDetailCash cash) {
        this.cash = cash;
    }

}
