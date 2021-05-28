package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class userWalletHistory {

    @SerializedName("transactID")
    @Expose
    private String transactID;
    @SerializedName("account")
    @Expose
    private Integer account;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("transactType")
    @Expose
    private String transactType;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("transactStatus")
    @Expose
    private String transactStatus;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("tx")
    @Expose
    private String tx;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("transactTime")
    @Expose
    private String transactTime;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getTransactID() {
        return transactID;
    }

    public void setTransactID(String transactID) {
        this.transactID = transactID;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactType() {
        return transactType;
    }

    public void setTransactType(String transactType) {
        this.transactType = transactType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getTransactStatus() {
        return transactStatus;
    }

    public void setTransactStatus(String transactStatus) {
        this.transactStatus = transactStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
