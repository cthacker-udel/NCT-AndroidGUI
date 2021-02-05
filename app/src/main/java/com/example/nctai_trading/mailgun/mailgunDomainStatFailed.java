package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatFailed {

    @SerializedName("permanent")
    @Expose
    private mailgunDomainStatPermanent permanent;
    @SerializedName("temporary")
    @Expose
    private mailgunDomainStatTemporary temporary;

    public mailgunDomainStatPermanent getPermanent() {
        return permanent;
    }

    public void setPermanent(mailgunDomainStatPermanent permanent) {
        this.permanent = permanent;
    }

    public mailgunDomainStatTemporary getTemporary() {
        return temporary;
    }

    public void setTemporary(mailgunDomainStatTemporary temporary) {
        this.temporary = temporary;
    }

}
