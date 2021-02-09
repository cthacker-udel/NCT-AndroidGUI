package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bithumbVirtualCoinAssetData {

    @SerializedName("coinType")
    @Expose
    private String coinType;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("frozen")
    @Expose
    private String frozen;
    @SerializedName("btcQuantity")
    @Expose
    private String btcQuantity;
    @SerializedName("type")
    @Expose
    private String type;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getBtcQuantity() {
        return btcQuantity;
    }

    public void setBtcQuantity(String btcQuantity) {
        this.btcQuantity = btcQuantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
