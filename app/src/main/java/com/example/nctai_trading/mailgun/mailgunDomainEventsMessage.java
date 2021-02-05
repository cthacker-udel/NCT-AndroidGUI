package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunDomainEventsMessage {

    @SerializedName("headers")
    @Expose
    private mailgunDomainHeaders headers;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = null;
    @SerializedName("recipients")
    @Expose
    private List<String> recipients = null;
    @SerializedName("size")
    @Expose
    private Integer size;

    public mailgunDomainHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(mailgunDomainHeaders headers) {
        this.headers = headers;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
