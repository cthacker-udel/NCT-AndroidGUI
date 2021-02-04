package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseProDepositDetails {

    @SerializedName("crypto_address")
    @Expose
    private String cryptoAddress;
    @SerializedName("destination_tag")
    @Expose
    private String destinationTag;
    @SerializedName("coinbase_account_id")
    @Expose
    private String coinbaseAccountId;
    @SerializedName("destination_tag_name")
    @Expose
    private String destinationTagName;
    @SerializedName("crypto_transaction_id")
    @Expose
    private String cryptoTransactionId;
    @SerializedName("coinbase_transaction_id")
    @Expose
    private String coinbaseTransactionId;
    @SerializedName("crypto_transaction_hash")
    @Expose
    private String cryptoTransactionHash;

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public void setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public String getDestinationTag() {
        return destinationTag;
    }

    public void setDestinationTag(String destinationTag) {
        this.destinationTag = destinationTag;
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

    public String getCryptoTransactionId() {
        return cryptoTransactionId;
    }

    public void setCryptoTransactionId(String cryptoTransactionId) {
        this.cryptoTransactionId = cryptoTransactionId;
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

}
