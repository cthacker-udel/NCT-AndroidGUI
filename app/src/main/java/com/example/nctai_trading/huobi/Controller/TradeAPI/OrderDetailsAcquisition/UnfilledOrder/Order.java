package com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition.UnfilledOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("order_price_type")
    @Expose
    private String orderPriceType;
    @SerializedName("order_type")
    @Expose
    private Integer orderType;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("lever_rate")
    @Expose
    private Integer leverRate;
    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("client_order_id")
    @Expose
    private Object clientOrderId;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("trade_volume")
    @Expose
    private Integer tradeVolume;
    @SerializedName("trade_turnover")
    @Expose
    private Integer tradeTurnover;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("trade_avg_price")
    @Expose
    private Object tradeAvgPrice;
    @SerializedName("margin_frozen")
    @Expose
    private Double marginFrozen;
    @SerializedName("profit")
    @Expose
    private Integer profit;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("order_source")
    @Expose
    private String orderSource;
    @SerializedName("order_id_str")
    @Expose
    private String orderIdStr;
    @SerializedName("fee_asset")
    @Expose
    private String feeAsset;
    @SerializedName("liquidation_type")
    @Expose
    private Object liquidationType;
    @SerializedName("canceled_at")
    @Expose
    private Object canceledAt;
    @SerializedName("is_tpsl")
    @Expose
    private Integer isTpsl;
    @SerializedName("update_time")
    @Expose
    private Long updateTime;
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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(String orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Object getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(Object clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Integer tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Integer getTradeTurnover() {
        return tradeTurnover;
    }

    public void setTradeTurnover(Integer tradeTurnover) {
        this.tradeTurnover = tradeTurnover;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Object getTradeAvgPrice() {
        return tradeAvgPrice;
    }

    public void setTradeAvgPrice(Object tradeAvgPrice) {
        this.tradeAvgPrice = tradeAvgPrice;
    }

    public Double getMarginFrozen() {
        return marginFrozen;
    }

    public void setMarginFrozen(Double marginFrozen) {
        this.marginFrozen = marginFrozen;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderIdStr() {
        return orderIdStr;
    }

    public void setOrderIdStr(String orderIdStr) {
        this.orderIdStr = orderIdStr;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public Object getLiquidationType() {
        return liquidationType;
    }

    public void setLiquidationType(Object liquidationType) {
        this.liquidationType = liquidationType;
    }

    public Object getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Object canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Integer getIsTpsl() {
        return isTpsl;
    }

    public void setIsTpsl(Integer isTpsl) {
        this.isTpsl = isTpsl;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRealProfit() {
        return realProfit;
    }

    public void setRealProfit(Integer realProfit) {
        this.realProfit = realProfit;
    }

}
