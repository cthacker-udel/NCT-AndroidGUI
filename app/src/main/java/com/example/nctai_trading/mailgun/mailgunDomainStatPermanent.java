package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatPermanent {

    @SerializedName("bounce")
    @Expose
    private Integer bounce;
    @SerializedName("delayed-bounce")
    @Expose
    private Integer delayedBounce;
    @SerializedName("suppress-bounce")
    @Expose
    private Integer suppressBounce;
    @SerializedName("suppress-unsubscribe")
    @Expose
    private Integer suppressUnsubscribe;
    @SerializedName("suppress-complaint")
    @Expose
    private Integer suppressComplaint;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getBounce() {
        return bounce;
    }

    public void setBounce(Integer bounce) {
        this.bounce = bounce;
    }

    public Integer getDelayedBounce() {
        return delayedBounce;
    }

    public void setDelayedBounce(Integer delayedBounce) {
        this.delayedBounce = delayedBounce;
    }

    public Integer getSuppressBounce() {
        return suppressBounce;
    }

    public void setSuppressBounce(Integer suppressBounce) {
        this.suppressBounce = suppressBounce;
    }

    public Integer getSuppressUnsubscribe() {
        return suppressUnsubscribe;
    }

    public void setSuppressUnsubscribe(Integer suppressUnsubscribe) {
        this.suppressUnsubscribe = suppressUnsubscribe;
    }

    public Integer getSuppressComplaint() {
        return suppressComplaint;
    }

    public void setSuppressComplaint(Integer suppressComplaint) {
        this.suppressComplaint = suppressComplaint;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
