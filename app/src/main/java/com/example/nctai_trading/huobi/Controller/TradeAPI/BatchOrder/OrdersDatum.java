package com.example.nctai_trading.huobi.Controller.TradeAPI.BatchOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdersDatum {

    @SerializedName("contract_code")
    @Expose
    private String contractCode;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("lever_rate")
    @Expose
    private Integer leverRate;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("order_price_type")
    @Expose
    private String orderPriceType;
    @SerializedName("tp_trigger_price")
    @Expose
    private Integer tpTriggerPrice;
    @SerializedName("tp_order_price")
    @Expose
    private Integer tpOrderPrice;
    @SerializedName("tp_order_price_type")
    @Expose
    private String tpOrderPriceType;
    @SerializedName("sl_trigger_price")
    @Expose
    private String slTriggerPrice;
    @SerializedName("sl_order_price")
    @Expose
    private String slOrderPrice;
    @SerializedName("sl_order_price_type")
    @Expose
    private String slOrderPriceType;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(String orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Integer getTpTriggerPrice() {
        return tpTriggerPrice;
    }

    public void setTpTriggerPrice(Integer tpTriggerPrice) {
        this.tpTriggerPrice = tpTriggerPrice;
    }

    public Integer getTpOrderPrice() {
        return tpOrderPrice;
    }

    public void setTpOrderPrice(Integer tpOrderPrice) {
        this.tpOrderPrice = tpOrderPrice;
    }

    public String getTpOrderPriceType() {
        return tpOrderPriceType;
    }

    public void setTpOrderPriceType(String tpOrderPriceType) {
        this.tpOrderPriceType = tpOrderPriceType;
    }

    public String getSlTriggerPrice() {
        return slTriggerPrice;
    }

    public void setSlTriggerPrice(String slTriggerPrice) {
        this.slTriggerPrice = slTriggerPrice;
    }

    public String getSlOrderPrice() {
        return slOrderPrice;
    }

    public void setSlOrderPrice(String slOrderPrice) {
        this.slOrderPrice = slOrderPrice;
    }

    public String getSlOrderPriceType() {
        return slOrderPriceType;
    }

    public void setSlOrderPriceType(String slOrderPriceType) {
        this.slOrderPriceType = slOrderPriceType;
    }


}
