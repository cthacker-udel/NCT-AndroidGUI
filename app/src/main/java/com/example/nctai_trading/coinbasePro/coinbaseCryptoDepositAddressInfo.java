package com.example.nctai_trading.coinbasePro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coinbaseCryptoDepositAddressInfo {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("destination_tag")
    @Expose
    private String destinationTag;

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

}
