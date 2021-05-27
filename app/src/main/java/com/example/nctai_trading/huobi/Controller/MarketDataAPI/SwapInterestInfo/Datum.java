package com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapInterestInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("volume")
    @Expose
    private Double volume;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("trade_amount")
    @Expose
    private Double tradeAmount;
    @SerializedName("trade_volume")
    @Expose
    private Integer tradeVolume;
    @SerializedName("trade_turnover")
    @Expose
    private Double tradeTurnover;

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Integer getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Integer tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Double getTradeTurnover() {
        return tradeTurnover;
    }

    public void setTradeTurnover(Double tradeTurnover) {
        this.tradeTurnover = tradeTurnover;
    }

}
