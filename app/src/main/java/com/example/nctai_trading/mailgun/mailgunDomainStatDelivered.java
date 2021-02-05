package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunDomainStatDelivered {

    @SerializedName("smtp")
    @Expose
    private Integer smtp;
    @SerializedName("http")
    @Expose
    private Integer http;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getSmtp() {
        return smtp;
    }

    public void setSmtp(Integer smtp) {
        this.smtp = smtp;
    }

    public Integer getHttp() {
        return http;
    }

    public void setHttp(Integer http) {
        this.http = http;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
