package com.example.nctai_trading.huobiApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class huobiMarketDetail {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tick")
    @Expose
    private huobiMarketDetailTick tick;
    @SerializedName("ts")
    @Expose
    private Integer ts;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public huobiMarketDetailTick getTick() {
        return tick;
    }

    public void setTick(huobiMarketDetailTick tick) {
        this.tick = tick;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

}
