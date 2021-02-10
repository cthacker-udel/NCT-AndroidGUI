package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetTransactionResponse {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("clearingReferenceNumber")
    @Expose
    private String clearingReferenceNumber;
    @SerializedName("subAccount")
    @Expose
    private String subAccount;
    @SerializedName("settlementDate")
    @Expose
    private String settlementDate;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("sma")
    @Expose
    private Integer sma;
    @SerializedName("requirementReallocationAmount")
    @Expose
    private Integer requirementReallocationAmount;
    @SerializedName("dayTradeBuyingPowerEffect")
    @Expose
    private Integer dayTradeBuyingPowerEffect;
    @SerializedName("netAmount")
    @Expose
    private Integer netAmount;
    @SerializedName("transactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("orderDate")
    @Expose
    private String orderDate;
    @SerializedName("transactionSubType")
    @Expose
    private String transactionSubType;
    @SerializedName("transactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("cashBalanceEffectFlag")
    @Expose
    private Boolean cashBalanceEffectFlag;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("achStatus")
    @Expose
    private String achStatus;
    @SerializedName("accruedInterest")
    @Expose
    private Integer accruedInterest;
    @SerializedName("fees")
    @Expose
    private String fees;
    @SerializedName("transactionItem")
    @Expose
    private ameritradeGetTransactionTransactions transactionItem;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClearingReferenceNumber() {
        return clearingReferenceNumber;
    }

    public void setClearingReferenceNumber(String clearingReferenceNumber) {
        this.clearingReferenceNumber = clearingReferenceNumber;
    }

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getSma() {
        return sma;
    }

    public void setSma(Integer sma) {
        this.sma = sma;
    }

    public Integer getRequirementReallocationAmount() {
        return requirementReallocationAmount;
    }

    public void setRequirementReallocationAmount(Integer requirementReallocationAmount) {
        this.requirementReallocationAmount = requirementReallocationAmount;
    }

    public Integer getDayTradeBuyingPowerEffect() {
        return dayTradeBuyingPowerEffect;
    }

    public void setDayTradeBuyingPowerEffect(Integer dayTradeBuyingPowerEffect) {
        this.dayTradeBuyingPowerEffect = dayTradeBuyingPowerEffect;
    }

    public Integer getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Integer netAmount) {
        this.netAmount = netAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTransactionSubType() {
        return transactionSubType;
    }

    public void setTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Boolean getCashBalanceEffectFlag() {
        return cashBalanceEffectFlag;
    }

    public void setCashBalanceEffectFlag(Boolean cashBalanceEffectFlag) {
        this.cashBalanceEffectFlag = cashBalanceEffectFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAchStatus() {
        return achStatus;
    }

    public void setAchStatus(String achStatus) {
        this.achStatus = achStatus;
    }

    public Integer getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(Integer accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public ameritradeGetTransactionTransactions getTransactionItem() {
        return transactionItem;
    }

    public void setTransactionItem(ameritradeGetTransactionTransactions transactionItem) {
        this.transactionItem = transactionItem;
    }


}
