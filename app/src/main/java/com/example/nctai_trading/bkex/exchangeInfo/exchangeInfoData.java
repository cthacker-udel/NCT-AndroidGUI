package com.example.nctai_trading.bkex.exchangeInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class exchangeInfoData {

    @SerializedName("coinTypes")
    @Expose
    private List<exchangeInfoCoinType> coinTypes = null;
    @SerializedName("pairs")
    @Expose
    private List<exchangeInfoPair> pairs = null;

    public List<exchangeInfoCoinType> getCoinTypes() {
        return coinTypes;
    }

    public void setCoinTypes(List<exchangeInfoCoinType> coinTypes) {
        this.coinTypes = coinTypes;
    }

    public List<exchangeInfoPair> getPairs() {
        return pairs;
    }

    public void setPairs(List<exchangeInfoPair> pairs) {
        this.pairs = pairs;
    }


}
