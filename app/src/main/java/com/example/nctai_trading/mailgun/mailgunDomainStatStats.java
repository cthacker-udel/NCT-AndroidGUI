package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatStats {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("accepted")
    @Expose
    private mailgunDomainStatAccepted accepted;
    @SerializedName("delivered")
    @Expose
    private mailgunDomainStatDelivered delivered;
    @SerializedName("failed")
    @Expose
    private mailgunDomainStatFailed failed;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public mailgunDomainStatAccepted getAccepted() {
        return accepted;
    }

    public void setAccepted(mailgunDomainStatAccepted accepted) {
        this.accepted = accepted;
    }

    public mailgunDomainStatDelivered getDelivered() {
        return delivered;
    }

    public void setDelivered(mailgunDomainStatDelivered delivered) {
        this.delivered = delivered;
    }

    public mailgunDomainStatFailed getFailed() {
        return failed;
    }

    public void setFailed(mailgunDomainStatFailed failed) {
        this.failed = failed;
    }

}
