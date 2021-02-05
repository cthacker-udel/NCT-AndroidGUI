package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunDomainEvents {

    @SerializedName("items")
    @Expose
    private List<mailgunDomainItem> items = null;
    @SerializedName("paging")
    @Expose
    private mailgunDomainEventsPaging paging;

    public List<mailgunDomainItem> getItems() {
        return items;
    }

    public void setItems(List<mailgunDomainItem> items) {
        this.items = items;
    }

    public mailgunDomainEventsPaging getPaging() {
        return paging;
    }

    public void setPaging(mailgunDomainEventsPaging paging) {
        this.paging = paging;
    }

}
