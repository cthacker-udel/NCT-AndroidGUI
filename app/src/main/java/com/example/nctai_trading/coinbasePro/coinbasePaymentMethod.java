package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbasePaymentMethod {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("primary_buy")
    @Expose
    private Boolean primaryBuy;
    @SerializedName("primary_sell")
    @Expose
    private Boolean primarySell;
    @SerializedName("allow_buy")
    @Expose
    private Boolean allowBuy;
    @SerializedName("allow_sell")
    @Expose
    private Boolean allowSell;
    @SerializedName("allow_deposit")
    @Expose
    private Boolean allowDeposit;
    @SerializedName("allow_withdraw")
    @Expose
    private Boolean allowWithdraw;
    @SerializedName("limits")
    @Expose
    private coinbasePaymentMethodLimits limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPrimaryBuy() {
        return primaryBuy;
    }

    public void setPrimaryBuy(Boolean primaryBuy) {
        this.primaryBuy = primaryBuy;
    }

    public Boolean getPrimarySell() {
        return primarySell;
    }

    public void setPrimarySell(Boolean primarySell) {
        this.primarySell = primarySell;
    }

    public Boolean getAllowBuy() {
        return allowBuy;
    }

    public void setAllowBuy(Boolean allowBuy) {
        this.allowBuy = allowBuy;
    }

    public Boolean getAllowSell() {
        return allowSell;
    }

    public void setAllowSell(Boolean allowSell) {
        this.allowSell = allowSell;
    }

    public Boolean getAllowDeposit() {
        return allowDeposit;
    }

    public void setAllowDeposit(Boolean allowDeposit) {
        this.allowDeposit = allowDeposit;
    }

    public Boolean getAllowWithdraw() {
        return allowWithdraw;
    }

    public void setAllowWithdraw(Boolean allowWithdraw) {
        this.allowWithdraw = allowWithdraw;
    }

    public coinbasePaymentMethodLimits getLimits() {
        return limits;
    }

    public void setLimits(coinbasePaymentMethodLimits limits) {
        this.limits = limits;
    }

}
