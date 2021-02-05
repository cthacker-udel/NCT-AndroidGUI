package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatTemporary {

    @SerializedName("espblock")
    @Expose
    private Integer espblock;

    public Integer getEspblock() {
        return espblock;
    }

    public void setEspblock(Integer espblock) {
        this.espblock = espblock;
    }

}
