package com.example.nctai_trading.bithumb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bithumbConfigResponse {

    @SerializedName("coinConfig")
    @Expose
    private List<bithumbConfigCoinConfig> coinConfig = null;
    @SerializedName("contractConfig")
    @Expose
    private List<bithumbConfigContractConfig> contractConfig = null;
    @SerializedName("spotConfig")
    @Expose
    private List<bithumbConfigResponseDetails> spotConfig = null;

    public List<bithumbConfigCoinConfig> getCoinConfig() {
        return coinConfig;
    }

    public void setCoinConfig(List<bithumbConfigCoinConfig> coinConfig) {
        this.coinConfig = coinConfig;
    }

    public List<bithumbConfigContractConfig> getContractConfig() {
        return contractConfig;
    }

    public void setContractConfig(List<bithumbConfigContractConfig> contractConfig) {
        this.contractConfig = contractConfig;
    }

    public List<bithumbConfigResponseDetails> getSpotConfig() {
        return spotConfig;
    }

    public void setSpotConfig(List<bithumbConfigResponseDetails> spotConfig) {
        this.spotConfig = spotConfig;
    }

}
