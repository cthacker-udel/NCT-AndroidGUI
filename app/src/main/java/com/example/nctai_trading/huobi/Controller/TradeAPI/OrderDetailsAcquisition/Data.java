package com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("instrument_price")
    @Expose
    private Integer instrumentPrice;
    @SerializedName("final_interest")
    @Expose
    private Integer finalInterest;
    @SerializedName("adjust_value")
    @Expose
    private Integer adjustValue;
    @SerializedName("lever_rate")
    @Expose
    private Integer leverRate;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("volume")
    @Expose
    private Double volume;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("canceled_at")
    @Expose
    private Integer canceledAt;
    @SerializedName("order_source")
    @Expose
    private String orderSource;
    @SerializedName("order_price_type")
    @Expose
    private String orderPriceType;
    @SerializedName("margin_frozen")
    @Expose
    private Integer marginFrozen;
    @SerializedName("profit")
    @Expose
    private Double profit;
    @SerializedName("trades")
    @Expose
    private List<Trade> trades = null;
    @SerializedName("total_page")
    @Expose
    private Integer totalPage;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("total_size")
    @Expose
    private Integer totalSize;
    @SerializedName("liquidation_type")
    @Expose
    private String liquidationType;
    @SerializedName("fee_asset")
    @Expose
    private String feeAsset;
    @SerializedName("fee")
    @Expose
    private Double fee;
    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("order_id_str")
    @Expose
    private String orderIdStr;
    @SerializedName("client_order_id")
    @Expose
    private Object clientOrderId;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("trade_avg_price")
    @Expose
    private Double tradeAvgPrice;
    @SerializedName("trade_turnover")
    @Expose
    private Double tradeTurnover;
    @SerializedName("trade_volume")
    @Expose
    private Double tradeVolume;
    @SerializedName("is_tpsl")
    @Expose
    private Integer isTpsl;
    @SerializedName("real_profit")
    @Expose
    private Integer realProfit;

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

    public Integer getInstrumentPrice() {
        return instrumentPrice;
    }

    public void setInstrumentPrice(Integer instrumentPrice) {
        this.instrumentPrice = instrumentPrice;
    }

    public Integer getFinalInterest() {
        return finalInterest;
    }

    public void setFinalInterest(Integer finalInterest) {
        this.finalInterest = finalInterest;
    }

    public Integer getAdjustValue() {
        return adjustValue;
    }

    public void setAdjustValue(Integer adjustValue) {
        this.adjustValue = adjustValue;
    }

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Integer canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(String orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Integer getMarginFrozen() {
        return marginFrozen;
    }

    public void setMarginFrozen(Integer marginFrozen) {
        this.marginFrozen = marginFrozen;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public String getLiquidationType() {
        return liquidationType;
    }

    public void setLiquidationType(String liquidationType) {
        this.liquidationType = liquidationType;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderIdStr() {
        return orderIdStr;
    }

    public void setOrderIdStr(String orderIdStr) {
        this.orderIdStr = orderIdStr;
    }

    public Object getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(Object clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTradeAvgPrice() {
        return tradeAvgPrice;
    }

    public void setTradeAvgPrice(Double tradeAvgPrice) {
        this.tradeAvgPrice = tradeAvgPrice;
    }

    public Double getTradeTurnover() {
        return tradeTurnover;
    }

    public void setTradeTurnover(Double tradeTurnover) {
        this.tradeTurnover = tradeTurnover;
    }

    public Double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Integer getIsTpsl() {
        return isTpsl;
    }

    public void setIsTpsl(Integer isTpsl) {
        this.isTpsl = isTpsl;
    }

    public Integer getRealProfit() {
        return realProfit;
    }

    public void setRealProfit(Integer realProfit) {
        this.realProfit = realProfit;
    }

}
