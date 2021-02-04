package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseProWithdrawl {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("completed_at")
    @Expose
    private String completedAt;
    @SerializedName("canceled_at")
    @Expose
    private Object canceledAt;
    @SerializedName("processed_at")
    @Expose
    private String processedAt;
    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_nonce")
    @Expose
    private String userNonce;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("details")
    @Expose
    private coinbaseWithdrawlDetails details;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public Object getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Object canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNonce() {
        return userNonce;
    }

    public void setUserNonce(String userNonce) {
        this.userNonce = userNonce;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public coinbaseWithdrawlDetails getDetails() {
        return details;
    }

    public void setDetails(coinbaseWithdrawlDetails details) {
        this.details = details;
    }


}
