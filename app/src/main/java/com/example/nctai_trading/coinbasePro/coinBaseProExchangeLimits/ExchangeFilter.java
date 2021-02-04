package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExchangeFilter {

    @SerializedName("limit_currency")
    @Expose
    private String limitCurrency;
    @SerializedName("transfer_limits")
    @Expose
    private TransferLimits transferLimits;

    public String getLimitCurrency() {
        return limitCurrency;
    }

    public void setLimitCurrency(String limitCurrency) {
        this.limitCurrency = limitCurrency;
    }

    public TransferLimits getTransferLimits() {
        return transferLimits;
    }

    public void setTransferLimits(TransferLimits transferLimits) {
        this.transferLimits = transferLimits;
    }

}
