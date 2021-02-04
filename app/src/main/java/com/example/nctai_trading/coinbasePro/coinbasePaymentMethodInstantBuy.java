package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbasePaymentMethodInstantBuy {

    @SerializedName("period_in_days")
    @Expose
    private Integer periodInDays;
    @SerializedName("total")
    @Expose
    private coinbasePaymentMethodTotal_ total;
    @SerializedName("remaining")
    @Expose
    private coinbasePaymentMethodRemaining_ remaining;

    public Integer getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(Integer periodInDays) {
        this.periodInDays = periodInDays;
    }

    public coinbasePaymentMethodTotal_ getTotal() {
        return total;
    }

    public void setTotal(coinbasePaymentMethodTotal_ total) {
        this.total = total;
    }

    public coinbasePaymentMethodRemaining_ getRemaining() {
        return remaining;
    }

    public void setRemaining(coinbasePaymentMethodRemaining_ remaining) {
        this.remaining = remaining;
    }

}
