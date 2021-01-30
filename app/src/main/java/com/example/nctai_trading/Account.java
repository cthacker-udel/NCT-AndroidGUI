package com.example.nctai_trading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Account {

    @SerializedName("makerCommission")
    @Expose
    private Integer makerCommission;
    @SerializedName("takerCommission")
    @Expose
    private Integer takerCommission;
    @SerializedName("buyerCommission")
    @Expose
    private Integer buyerCommission;
    @SerializedName("sellerCommission")
    @Expose
    private Integer sellerCommission;
    @SerializedName("canTrade")
    @Expose
    private Boolean canTrade;
    @SerializedName("canWithdraw")
    @Expose
    private Boolean canWithdraw;
    @SerializedName("canDeposit")
    @Expose
    private Boolean canDeposit;
    @SerializedName("updateTime")
    @Expose
    private Integer updateTime;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("balances")
    @Expose
    private List<Balance> balances = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;

    public Integer getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(Integer makerCommission) {
        this.makerCommission = makerCommission;
    }

    public Integer getTakerCommission() {
        return takerCommission;
    }

    public void setTakerCommission(Integer takerCommission) {
        this.takerCommission = takerCommission;
    }

    public Integer getBuyerCommission() {
        return buyerCommission;
    }

    public void setBuyerCommission(Integer buyerCommission) {
        this.buyerCommission = buyerCommission;
    }

    public Integer getSellerCommission() {
        return sellerCommission;
    }

    public void setSellerCommission(Integer sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    public Boolean getCanTrade() {
        return canTrade;
    }

    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }


}
