package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseProPaymentMethodSell {

    @SerializedName("period_in_days")
    @Expose
    private Integer periodInDays;
    @SerializedName("total")
    @Expose
    private coinbasePaymentMethodTotal__ total;
    @SerializedName("remaining")
    @Expose
    private coinbasePaymentMethodRemaining__ remaining;

    public Integer getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(Integer periodInDays) {
        this.periodInDays = periodInDays;
    }

    public coinbasePaymentMethodTotal__ getTotal() {
        return total;
    }

    public void setTotal(coinbasePaymentMethodTotal__ total) {
        this.total = total;
    }

    public coinbasePaymentMethodRemaining__ getRemaining() {
        return remaining;
    }

    public void setRemaining(coinbasePaymentMethodRemaining__ remaining) {
        this.remaining = remaining;
    }

}
