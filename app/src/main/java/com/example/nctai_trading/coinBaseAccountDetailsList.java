package com.example.nctai_trading;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class coinBaseAccountDetailsList {


    /*

    /accounts/account/<ledger> returns List<AccountDetailsList>

     */

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("details")
    @Expose
    private List<com.example.nctai_trading.coinBaseAccountDetails> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<coinBaseAccountDetails> getDetails() {
        return details;
    }

    public void setDetails(List<com.example.nctai_trading.coinBaseAccountDetails> details) {
        this.details = details;
    }
}
