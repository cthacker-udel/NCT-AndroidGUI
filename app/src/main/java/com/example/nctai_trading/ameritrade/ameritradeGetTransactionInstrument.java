package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetTransactionInstrument {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("underlyingSymbol")
    @Expose
    private String underlyingSymbol;
    @SerializedName("optionExpirationDate")
    @Expose
    private String optionExpirationDate;
    @SerializedName("optionStrikePrice")
    @Expose
    private Integer optionStrikePrice;
    @SerializedName("putCall")
    @Expose
    private String putCall;
    @SerializedName("cusip")
    @Expose
    private String cusip;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("bondMaturityDate")
    @Expose
    private String bondMaturityDate;
    @SerializedName("bondInterestRate")
    @Expose
    private Integer bondInterestRate;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    public void setUnderlyingSymbol(String underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol;
    }

    public String getOptionExpirationDate() {
        return optionExpirationDate;
    }

    public void setOptionExpirationDate(String optionExpirationDate) {
        this.optionExpirationDate = optionExpirationDate;
    }

    public Integer getOptionStrikePrice() {
        return optionStrikePrice;
    }

    public void setOptionStrikePrice(Integer optionStrikePrice) {
        this.optionStrikePrice = optionStrikePrice;
    }

    public String getPutCall() {
        return putCall;
    }

    public void setPutCall(String putCall) {
        this.putCall = putCall;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(String bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    public Integer getBondInterestRate() {
        return bondInterestRate;
    }

    public void setBondInterestRate(Integer bondInterestRate) {
        this.bondInterestRate = bondInterestRate;
    }

}
