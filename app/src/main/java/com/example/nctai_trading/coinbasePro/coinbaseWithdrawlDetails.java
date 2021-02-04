package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseWithdrawlDetails {

    @SerializedName("destination_tag")
    @Expose
    private String destinationTag;
    @SerializedName("sent_to_address")
    @Expose
    private String sentToAddress;
    @SerializedName("coinbase_account_id")
    @Expose
    private String coinbaseAccountId;
    @SerializedName("destination_tag_name")
    @Expose
    private String destinationTagName;
    @SerializedName("coinbase_withdrawal_id")
    @Expose
    private String coinbaseWithdrawalId;
    @SerializedName("coinbase_transaction_id")
    @Expose
    private String coinbaseTransactionId;
    @SerializedName("crypto_transaction_hash")
    @Expose
    private String cryptoTransactionHash;
    @SerializedName("coinbase_payment_method_id")
    @Expose
    private String coinbasePaymentMethodId;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("subtotal")
    @Expose
    private String subtotal;

    public String getDestinationTag() {
        return destinationTag;
    }

    public void setDestinationTag(String destinationTag) {
        this.destinationTag = destinationTag;
    }

    public String getSentToAddress() {
        return sentToAddress;
    }

    public void setSentToAddress(String sentToAddress) {
        this.sentToAddress = sentToAddress;
    }

    public String getCoinbaseAccountId() {
        return coinbaseAccountId;
    }

    public void setCoinbaseAccountId(String coinbaseAccountId) {
        this.coinbaseAccountId = coinbaseAccountId;
    }

    public String getDestinationTagName() {
        return destinationTagName;
    }

    public void setDestinationTagName(String destinationTagName) {
        this.destinationTagName = destinationTagName;
    }

    public String getCoinbaseWithdrawalId() {
        return coinbaseWithdrawalId;
    }

    public void setCoinbaseWithdrawalId(String coinbaseWithdrawalId) {
        this.coinbaseWithdrawalId = coinbaseWithdrawalId;
    }

    public String getCoinbaseTransactionId() {
        return coinbaseTransactionId;
    }

    public void setCoinbaseTransactionId(String coinbaseTransactionId) {
        this.coinbaseTransactionId = coinbaseTransactionId;
    }

    public String getCryptoTransactionHash() {
        return cryptoTransactionHash;
    }

    public void setCryptoTransactionHash(String cryptoTransactionHash) {
        this.cryptoTransactionHash = cryptoTransactionHash;
    }

    public String getCoinbasePaymentMethodId() {
        return coinbasePaymentMethodId;
    }

    public void setCoinbasePaymentMethodId(String coinbasePaymentMethodId) {
        this.coinbasePaymentMethodId = coinbasePaymentMethodId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

}
