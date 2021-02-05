package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunSMTPCredentials {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("items")
    @Expose
    private List<mailgunSMTPCredentialsItem> items = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<mailgunSMTPCredentialsItem> getItems() {
        return items;
    }

    public void setItems(List<mailgunSMTPCredentialsItem> items) {
        this.items = items;
    }

}
