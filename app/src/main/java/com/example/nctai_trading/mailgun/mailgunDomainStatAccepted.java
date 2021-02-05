package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatAccepted {

    @SerializedName("outgoing")
    @Expose
    private Integer outgoing;
    @SerializedName("incoming")
    @Expose
    private Integer incoming;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Integer outgoing) {
        this.outgoing = outgoing;
    }

    public Integer getIncoming() {
        return incoming;
    }

    public void setIncoming(Integer incoming) {
        this.incoming = incoming;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
