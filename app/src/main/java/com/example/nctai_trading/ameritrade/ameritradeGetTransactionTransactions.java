package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetTransactionTransactions {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("parentOrderKey")
    @Expose
    private Integer parentOrderKey;
    @SerializedName("parentChildIndicator")
    @Expose
    private String parentChildIndicator;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("positionEffect")
    @Expose
    private String positionEffect;
    @SerializedName("instrument")
    @Expose
    private ameritradeGetTransactionInstrument instrument;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getParentOrderKey() {
        return parentOrderKey;
    }

    public void setParentOrderKey(Integer parentOrderKey) {
        this.parentOrderKey = parentOrderKey;
    }

    public String getParentChildIndicator() {
        return parentChildIndicator;
    }

    public void setParentChildIndicator(String parentChildIndicator) {
        this.parentChildIndicator = parentChildIndicator;
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

    public ameritradeGetTransactionInstrument getInstrument() {
        return instrument;
    }

    public void setInstrument(ameritradeGetTransactionInstrument instrument) {
        this.instrument = instrument;
    }

}
