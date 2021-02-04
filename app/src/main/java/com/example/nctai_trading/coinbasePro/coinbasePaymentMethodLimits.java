package com.example.nctai_trading.coinbasePro;

import com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits.Buy;
import com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits.Sell;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class coinbasePaymentMethodLimits {

    @Expose
    private List<Buy> buy = null;
    @SerializedName("instant_buy")
    @Expose
    private List<coinbasePaymentMethodInstantBuy> instantBuy = null;
    @SerializedName("sell")
    @Expose
    private List<Sell> sell = null;
    @SerializedName("deposit")
    @Expose
    private List<coinbasePaymentMethodDeposit> deposit = null;

    public List<Buy> getBuy() {
        return buy;
    }

    public void setBuy(List<Buy> buy) {
        this.buy = buy;
    }

    public List<coinbasePaymentMethodInstantBuy> getInstantBuy() {
        return instantBuy;
    }

    public void setInstantBuy(List<coinbasePaymentMethodInstantBuy> instantBuy) {
        this.instantBuy = instantBuy;
    }

    public List<Sell> getSell() {
        return sell;
    }

    public void setSell(List<Sell> sell) {
        this.sell = sell;
    }

    public List<coinbasePaymentMethodDeposit> getDeposit() {
        return deposit;
    }

    public void setDeposit(List<coinbasePaymentMethodDeposit> deposit) {
        this.deposit = deposit;
    }

}
