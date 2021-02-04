package com.example.nctai_trading.coinbasePro.coinBaseProExchangeLimits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransferLimits {

    @SerializedName("ach")
    @Expose
    private Ach ach;
    @SerializedName("ach_no_balance")
    @Expose
    private AchNoBalance achNoBalance;
    @SerializedName("credit_debit_card")
    @Expose
    private CreditDebitCard creditDebitCard;
    @SerializedName("ach_curm")
    @Expose
    private AchCurm achCurm;
    @SerializedName("secure3d_buy")
    @Expose
    private Secure3dBuy secure3dBuy;
    @SerializedName("exchange_withdraw")
    @Expose
    private ExchangeWithdraw exchangeWithdraw;
    @SerializedName("exchange_ach")
    @Expose
    private ExchangeAch exchangeAch;
    @SerializedName("paypal_withdrawal")
    @Expose
    private PaypalWithdrawal paypalWithdrawal;
    @SerializedName("instant_ach_withdrawal")
    @Expose
    private InstantAchWithdrawal instantAchWithdrawal;
    @SerializedName("buy")
    @Expose
    private Buy buy;
    @SerializedName("sell")
    @Expose
    private Sell sell;

    public Ach getAch() {
        return ach;
    }

    public void setAch(Ach ach) {
        this.ach = ach;
    }

    public AchNoBalance getAchNoBalance() {
        return achNoBalance;
    }

    public void setAchNoBalance(AchNoBalance achNoBalance) {
        this.achNoBalance = achNoBalance;
    }

    public CreditDebitCard getCreditDebitCard() {
        return creditDebitCard;
    }

    public void setCreditDebitCard(CreditDebitCard creditDebitCard) {
        this.creditDebitCard = creditDebitCard;
    }

    public AchCurm getAchCurm() {
        return achCurm;
    }

    public void setAchCurm(AchCurm achCurm) {
        this.achCurm = achCurm;
    }

    public Secure3dBuy getSecure3dBuy() {
        return secure3dBuy;
    }

    public void setSecure3dBuy(Secure3dBuy secure3dBuy) {
        this.secure3dBuy = secure3dBuy;
    }

    public ExchangeWithdraw getExchangeWithdraw() {
        return exchangeWithdraw;
    }

    public void setExchangeWithdraw(ExchangeWithdraw exchangeWithdraw) {
        this.exchangeWithdraw = exchangeWithdraw;
    }

    public ExchangeAch getExchangeAch() {
        return exchangeAch;
    }

    public void setExchangeAch(ExchangeAch exchangeAch) {
        this.exchangeAch = exchangeAch;
    }

    public PaypalWithdrawal getPaypalWithdrawal() {
        return paypalWithdrawal;
    }

    public void setPaypalWithdrawal(PaypalWithdrawal paypalWithdrawal) {
        this.paypalWithdrawal = paypalWithdrawal;
    }

    public InstantAchWithdrawal getInstantAchWithdrawal() {
        return instantAchWithdrawal;
    }

    public void setInstantAchWithdrawal(InstantAchWithdrawal instantAchWithdrawal) {
        this.instantAchWithdrawal = instantAchWithdrawal;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

}
