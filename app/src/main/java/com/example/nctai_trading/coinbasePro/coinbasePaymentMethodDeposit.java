package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbasePaymentMethodDeposit {

    @SerializedName("period_in_days")
    @Expose
    private Integer periodInDays;
    @SerializedName("total")
    @Expose
    private coinbasePaymentMethodTotal___ total;
    @SerializedName("remaining")
    @Expose
    private coinbasePaymentMethodRemaining___ remaining;

    public Integer getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(Integer periodInDays) {
        this.periodInDays = periodInDays;
    }

    public coinbasePaymentMethodTotal___ getTotal() {
        return total;
    }

    public void setTotal(coinbasePaymentMethodTotal___ total) {
        this.total = total;
    }

    public coinbasePaymentMethodRemaining___ getRemaining() {
        return remaining;
    }

    public void setRemaining(coinbasePaymentMethodRemaining___ remaining) {
        this.remaining = remaining;
    }

}
