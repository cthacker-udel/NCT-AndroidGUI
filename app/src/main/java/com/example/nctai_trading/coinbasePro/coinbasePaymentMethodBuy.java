package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbasePaymentMethodBuy {

    @SerializedName("period_in_days")
    @Expose
    private Integer periodInDays;
    @SerializedName("total")
    @Expose
    private coinbasePaymentMethodTotal total;
    @SerializedName("remaining")
    @Expose
    private coinbasePaymentMethodRemaining remaining;

    public Integer getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(Integer periodInDays) {
        this.periodInDays = periodInDays;
    }

    public coinbasePaymentMethodTotal getTotal() {
        return total;
    }

    public void setTotal(coinbasePaymentMethodTotal total) {
        this.total = total;
    }

    public coinbasePaymentMethodRemaining getRemaining() {
        return remaining;
    }

    public void setRemaining(coinbasePaymentMethodRemaining remaining) {
        this.remaining = remaining;
    }

}
