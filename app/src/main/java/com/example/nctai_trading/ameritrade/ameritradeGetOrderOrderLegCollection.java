package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetOrderOrderLegCollection {


    @SerializedName("orderLegType")
    @Expose
    private String orderLegType;
    @SerializedName("legId")
    @Expose
    private Integer legId;
    @SerializedName("instrument")
    @Expose
    private String instrument;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("positionEffect")
    @Expose
    private String positionEffect;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("quantityType")
    @Expose
    private String quantityType;

    public String getOrderLegType() {
        return orderLegType;
    }

    public void setOrderLegType(String orderLegType) {
        this.orderLegType = orderLegType;
    }

    public Integer getLegId() {
        return legId;
    }

    public void setLegId(Integer legId) {
        this.legId = legId;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getPositionEffect() {
        return positionEffect;
    }

    public void setPositionEffect(String positionEffect) {
        this.positionEffect = positionEffect;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

}
