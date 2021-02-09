package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbConfigCoinConfig {

    @SerializedName("makerFeeRate")
    @Expose
    private String makerFeeRate;
    @SerializedName("minWithdraw")
    @Expose
    private String minWithdraw;
    @SerializedName("withdrawFee")
    @Expose
    private String withdrawFee;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("depositStatus")
    @Expose
    private String depositStatus;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("takerFeeRate")
    @Expose
    private String takerFeeRate;
    @SerializedName("withdrawStatus")
    @Expose
    private String withdrawStatus;

    public String getMakerFeeRate() {
        return makerFeeRate;
    }

    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public String getMinWithdraw() {
        return minWithdraw;
    }

    public void setMinWithdraw(String minWithdraw) {
        this.minWithdraw = minWithdraw;
    }

    public String getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(String withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTakerFeeRate() {
        return takerFeeRate;
    }

    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

    public String getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(String withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }


}
