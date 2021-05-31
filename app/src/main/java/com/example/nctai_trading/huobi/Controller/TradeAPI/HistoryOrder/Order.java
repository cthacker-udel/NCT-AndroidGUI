package com.example.nctai_trading.huobi.Controller.TradeAPI.HistoryOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("symbol")
    @Expose
    private String symbol;
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
    @SerializedName("create_date")
    @Expose
    private Long createDate;
    @SerializedName("update_time")
    @Expose
    private Long updateTime;
    @SerializedName("order_source")
    @Expose
    private String orderSource;
    @SerializedName("order_price_type")
    @Expose
    private Integer orderPriceType;
    @SerializedName("order_type")
    @Expose
    private Integer orderType;
    @SerializedName("margin_frozen")
    @Expose
    private Double marginFrozen;
    @SerializedName("profit")
    @Expose
    private Integer profit;
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
    private Integer tradeAvgPrice;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("order_id_str")
    @Expose
    private String orderIdStr;
    @SerializedName("fee_asset")
    @Expose
    private String feeAsset;
    @SerializedName("liquidation_type")
    @Expose
    private String liquidationType;
    @SerializedName("is_tpsl")
    @Expose
    private Integer isTpsl;
    @SerializedName("real_profit")
    @Expose
    private Integer realProfit;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(Integer orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public Integer getTradeAvgPrice() {
        return tradeAvgPrice;
    }

    public void setTradeAvgPrice(Integer tradeAvgPrice) {
        this.tradeAvgPrice = tradeAvgPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getLiquidationType() {
        return liquidationType;
    }

    public void setLiquidationType(String liquidationType) {
        this.liquidationType = liquidationType;
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
