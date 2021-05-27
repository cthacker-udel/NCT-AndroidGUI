package com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapContractInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("contract_size")
    @Expose
    private Double contractSize;
    @SerializedName("price_tick")
    @Expose
    private Double priceTick;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("delivery_time")
    @Expose
    private String deliveryTime;
    @SerializedName("contract_status")
    @Expose
    private Integer contractStatus;
    @SerializedName("settlement_date")
    @Expose
    private String settlementDate;

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

    public Double getContractSize() {
        return contractSize;
    }

    public void setContractSize(Double contractSize) {
        this.contractSize = contractSize;
    }

    public Double getPriceTick() {
        return priceTick;
    }

    public void setPriceTick(Double priceTick) {
        this.priceTick = priceTick;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }


}
