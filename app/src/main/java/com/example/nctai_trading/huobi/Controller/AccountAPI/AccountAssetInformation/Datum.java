package com.example.nctai_trading.huobi.Controller.AccountAPI.AccountAssetInformation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("margin_balance")
    @Expose
    private Double marginBalance;
    @SerializedName("margin_position")
    @Expose
    private Double marginPosition;
    @SerializedName("margin_frozen")
    @Expose
    private Double marginFrozen;
    @SerializedName("margin_available")
    @Expose
    private Double marginAvailable;
    @SerializedName("profit_real")
    @Expose
    private Integer profitReal;
    @SerializedName("profit_unreal")
    @Expose
    private Double profitUnreal;
    @SerializedName("risk_rate")
    @Expose
    private Double riskRate;
    @SerializedName("withdraw_available")
    @Expose
    private Double withdrawAvailable;
    @SerializedName("liquidation_price")
    @Expose
    private Double liquidationPrice;
    @SerializedName("lever_rate")
    @Expose
    private Integer leverRate;
    @SerializedName("adjust_factor")
    @Expose
    private Double adjustFactor;
    @SerializedName("margin_static")
    @Expose
    private Double marginStatic;
    @SerializedName("positions")
    @Expose
    private List<Position> positions = null;

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

    public Double getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(Double marginBalance) {
        this.marginBalance = marginBalance;
    }

    public Double getMarginPosition() {
        return marginPosition;
    }

    public void setMarginPosition(Double marginPosition) {
        this.marginPosition = marginPosition;
    }

    public Double getMarginFrozen() {
        return marginFrozen;
    }

    public void setMarginFrozen(Double marginFrozen) {
        this.marginFrozen = marginFrozen;
    }

    public Double getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(Double marginAvailable) {
        this.marginAvailable = marginAvailable;
    }

    public Integer getProfitReal() {
        return profitReal;
    }

    public void setProfitReal(Integer profitReal) {
        this.profitReal = profitReal;
    }

    public Double getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(Double profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public Double getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(Double riskRate) {
        this.riskRate = riskRate;
    }

    public Double getWithdrawAvailable() {
        return withdrawAvailable;
    }

    public void setWithdrawAvailable(Double withdrawAvailable) {
        this.withdrawAvailable = withdrawAvailable;
    }

    public Double getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(Double liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public Double getAdjustFactor() {
        return adjustFactor;
    }

    public void setAdjustFactor(Double adjustFactor) {
        this.adjustFactor = adjustFactor;
    }

    public Double getMarginStatic() {
        return marginStatic;
    }

    public void setMarginStatic(Double marginStatic) {
        this.marginStatic = marginStatic;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }


}
