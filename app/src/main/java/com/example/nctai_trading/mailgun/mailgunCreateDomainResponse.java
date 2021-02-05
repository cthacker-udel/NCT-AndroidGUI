package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunCreateDomainResponse {

    @SerializedName("domain")
    @Expose
    private mailgunCreateDomainDomain domain;
    @SerializedName("receiving_dns_records")
    @Expose
    private List<mailgunCreateDomainReceivingDns> receivingDnsRecords = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("sending_dns_records")
    @Expose
    private List<mailgunCreateDomainSendingDns> sendingDnsRecords = null;

    public mailgunCreateDomainDomain getDomain() {
        return domain;
    }

    public void setDomain(mailgunCreateDomainDomain domain) {
        this.domain = domain;
    }

    public List<mailgunCreateDomainReceivingDns> getReceivingDnsRecords() {
        return receivingDnsRecords;
    }

    public void setReceivingDnsRecords(List<mailgunCreateDomainReceivingDns> receivingDnsRecords) {
        this.receivingDnsRecords = receivingDnsRecords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<mailgunCreateDomainSendingDns> getSendingDnsRecords() {
        return sendingDnsRecords;
    }

    public void setSendingDnsRecords(List<mailgunCreateDomainSendingDns> sendingDnsRecords) {
        this.sendingDnsRecords = sendingDnsRecords;
    }

}
