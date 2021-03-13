package com.example.nctai_trading.bkex.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class exchangeInfoCoinType {

    @SerializedName("coinType")
    @Expose
    private String coinType;
    @SerializedName("isSupportDeposit")
    @Expose
    private Boolean isSupportDeposit;
    @SerializedName("isSupportWithdraw")
    @Expose
    private Boolean isSupportWithdraw;
    @SerializedName("isSupportTrade")
    @Expose
    private Boolean isSupportTrade;
    @SerializedName("minWithdrawSingle")
    @Expose
    private Integer minWithdrawSingle;
    @SerializedName("maxWithdrawSingle")
    @Expose
    private Integer maxWithdrawSingle;
    @SerializedName("maxWithdrawOneDay")
    @Expose
    private Integer maxWithdrawOneDay;
    @SerializedName("withdrawFee")
    @Expose
    private Double withdrawFee;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public Boolean getIsSupportDeposit() {
        return isSupportDeposit;
    }

    public void setIsSupportDeposit(Boolean isSupportDeposit) {
        this.isSupportDeposit = isSupportDeposit;
    }

    public Boolean getIsSupportWithdraw() {
        return isSupportWithdraw;
    }

    public void setIsSupportWithdraw(Boolean isSupportWithdraw) {
        this.isSupportWithdraw = isSupportWithdraw;
    }

    public Boolean getIsSupportTrade() {
        return isSupportTrade;
    }

    public void setIsSupportTrade(Boolean isSupportTrade) {
        this.isSupportTrade = isSupportTrade;
    }

    public Integer getMinWithdrawSingle() {
        return minWithdrawSingle;
    }

    public void setMinWithdrawSingle(Integer minWithdrawSingle) {
        this.minWithdrawSingle = minWithdrawSingle;
    }

    public Integer getMaxWithdrawSingle() {
        return maxWithdrawSingle;
    }

    public void setMaxWithdrawSingle(Integer maxWithdrawSingle) {
        this.maxWithdrawSingle = maxWithdrawSingle;
    }

    public Integer getMaxWithdrawOneDay() {
        return maxWithdrawOneDay;
    }

    public void setMaxWithdrawOneDay(Integer maxWithdrawOneDay) {
        this.maxWithdrawOneDay = maxWithdrawOneDay;
    }

    public Double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }


}
