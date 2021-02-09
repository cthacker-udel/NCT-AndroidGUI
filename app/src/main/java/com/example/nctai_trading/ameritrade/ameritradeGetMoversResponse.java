package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeGetMoversResponse {

    @SerializedName("change")
    @Expose
    private Integer change;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("last")
    @Expose
    private Integer last;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("totalVolume")
    @Expose
    private Integer totalVolume;

    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }

}
