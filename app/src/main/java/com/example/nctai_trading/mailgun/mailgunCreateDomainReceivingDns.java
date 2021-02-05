package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mailgunCreateDomainReceivingDns {

    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("record_type")
    @Expose
    private String recordType;
    @SerializedName("valid")
    @Expose
    private String valid;
    @SerializedName("value")
    @Expose
    private String value;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
