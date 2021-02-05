package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunSpecificIP {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("dedicated")
    @Expose
    private Boolean dedicated;
    @SerializedName("rdns")
    @Expose
    private String rdns;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getDedicated() {
        return dedicated;
    }

    public void setDedicated(Boolean dedicated) {
        this.dedicated = dedicated;
    }

    public String getRdns() {
        return rdns;
    }

    public void setRdns(String rdns) {
        this.rdns = rdns;
    }

}
