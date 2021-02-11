package com.example.nctai_trading.basefex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class basefexAccountDepositWithdrawHistory {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("foreignTxId")
    @Expose
    private String foreignTxId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subtype")
    @Expose
    private Object subtype;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("balances")
    @Expose
    private Object balances;
    @SerializedName("ts")
    @Expose
    private Integer ts;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("readableId")
    @Expose
    private Object readableId;
    @SerializedName("audit")
    @Expose
    private Object audit;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getForeignTxId() {
        return foreignTxId;
    }

    public void setForeignTxId(String foreignTxId) {
        this.foreignTxId = foreignTxId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getSubtype() {
        return subtype;
    }

    public void setSubtype(Object subtype) {
        this.subtype = subtype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Object getBalances() {
        return balances;
    }

    public void setBalances(Object balances) {
        this.balances = balances;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getReadableId() {
        return readableId;
    }

    public void setReadableId(Object readableId) {
        this.readableId = readableId;
    }

    public Object getAudit() {
        return audit;
    }

    public void setAudit(Object audit) {
        this.audit = audit;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
