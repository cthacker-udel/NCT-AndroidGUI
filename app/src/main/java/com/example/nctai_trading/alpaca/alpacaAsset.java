package com.example.nctai_trading.alpaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class alpacaAsset {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tradable")
    @Expose
    private Boolean tradable;
    @SerializedName("marginable")
    @Expose
    private Boolean marginable;
    @SerializedName("shortable")
    @Expose
    private Boolean shortable;
    @SerializedName("easy_to_borrow")
    @Expose
    private Boolean easyToBorrow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTradable() {
        return tradable;
    }

    public void setTradable(Boolean tradable) {
        this.tradable = tradable;
    }

    public Boolean getMarginable() {
        return marginable;
    }

    public void setMarginable(Boolean marginable) {
        this.marginable = marginable;
    }

    public Boolean getShortable() {
        return shortable;
    }

    public void setShortable(Boolean shortable) {
        this.shortable = shortable;
    }

    public Boolean getEasyToBorrow() {
        return easyToBorrow;
    }

    public void setEasyToBorrow(Boolean easyToBorrow) {
        this.easyToBorrow = easyToBorrow;
    }

}
