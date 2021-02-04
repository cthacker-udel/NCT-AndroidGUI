package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseCryptoDepositAddress {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("destination_tag")
    @Expose
    private String destinationTag;
    @SerializedName("address_info")
    @Expose
    private coinbaseCryptoDepositAddressInfo addressInfo;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("deposit_uri")
    @Expose
    private String depositUri;
    @SerializedName("exchange_deposit_address")
    @Expose
    private Boolean exchangeDepositAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDestinationTag() {
        return destinationTag;
    }

    public void setDestinationTag(String destinationTag) {
        this.destinationTag = destinationTag;
    }

    public coinbaseCryptoDepositAddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(coinbaseCryptoDepositAddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDepositUri() {
        return depositUri;
    }

    public void setDepositUri(String depositUri) {
        this.depositUri = depositUri;
    }

    public Boolean getExchangeDepositAddress() {
        return exchangeDepositAddress;
    }

    public void setExchangeDepositAddress(Boolean exchangeDepositAddress) {
        this.exchangeDepositAddress = exchangeDepositAddress;
    }

}
