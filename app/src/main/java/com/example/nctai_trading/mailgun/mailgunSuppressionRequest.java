package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunSuppressionRequest {

    @SerializedName("items")
    @Expose
    private List<mailgunSuppressionItem> items = null;
    @SerializedName("paging")
    @Expose
    private mailgunSuppressionPaging paging;

    public List<mailgunSuppressionItem> getItems() {
        return items;
    }

    public void setItems(List<mailgunSuppressionItem> items) {
        this.items = items;
    }

    public mailgunSuppressionPaging getPaging() {
        return paging;
    }

    public void setPaging(mailgunSuppressionPaging paging) {
        this.paging = paging;
    }

}
