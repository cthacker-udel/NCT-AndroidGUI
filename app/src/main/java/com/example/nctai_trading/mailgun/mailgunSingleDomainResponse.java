package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunSingleDomainResponse {

    @SerializedName("domain")
    @Expose
    private mailgunSingleDomainDomain domain;
    @SerializedName("receiving_dns_records")
    @Expose
    private List<mailgunSingleDomainReceivingDnsRecord> receivingDnsRecords = null;
    @SerializedName("sending_dns_records")
    @Expose
    private List<mailgunSingleDomainSendingDnsRecord> sendingDnsRecords = null;

    public mailgunSingleDomainDomain getDomain() {
        return domain;
    }

    public void setDomain(mailgunSingleDomainDomain domain) {
        this.domain = domain;
    }

    public List<mailgunSingleDomainReceivingDnsRecord> getReceivingDnsRecords() {
        return receivingDnsRecords;
    }

    public void setReceivingDnsRecords(List<mailgunSingleDomainReceivingDnsRecord> receivingDnsRecords) {
        this.receivingDnsRecords = receivingDnsRecords;
    }

    public List<mailgunSingleDomainSendingDnsRecord> getSendingDnsRecords() {
        return sendingDnsRecords;
    }

    public void setSendingDnsRecords(List<mailgunSingleDomainSendingDnsRecord> sendingDnsRecords) {
        this.sendingDnsRecords = sendingDnsRecords;
    }

}
