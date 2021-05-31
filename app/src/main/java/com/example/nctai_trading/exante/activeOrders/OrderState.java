package com.example.nctai_trading.exante.activeOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderState {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;
    @SerializedName("fills")
    @Expose
    private List<Object> fills = null;
    @SerializedName("reason")
    @Expose
    private String reason;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Object> getFills() {
        return fills;
    }

    public void setFills(List<Object> fills) {
        this.fills = fills;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
