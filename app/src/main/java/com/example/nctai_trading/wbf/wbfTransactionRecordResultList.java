package com.example.nctai_trading.wbf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class wbfTransactionRecordResultList {

    @SerializedName("volume")
    @Expose
    private String volume;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("feeCoin")
    @Expose
    private String feeCoin;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("ctime")
    @Expose
    private Integer ctime;
    @SerializedName("deal_price")
    @Expose
    private String dealPrice;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("bid_id")
    @Expose
    private Integer bidId;
    @SerializedName("ask_id")
    @Expose
    private Integer askId;
    @SerializedName("bid_user_id")
    @Expose
    private Integer bidUserId;
    @SerializedName("ask_user_id")
    @Expose
    private Integer askUserId;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getFeeCoin() {
        return feeCoin;
    }

    public void setFeeCoin(String feeCoin) {
        this.feeCoin = feeCoin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getAskId() {
        return askId;
    }

    public void setAskId(Integer askId) {
        this.askId = askId;
    }

    public Integer getBidUserId() {
        return bidUserId;
    }

    public void setBidUserId(Integer bidUserId) {
        this.bidUserId = bidUserId;
    }

    public Integer getAskUserId() {
        return askUserId;
    }

    public void setAskUserId(Integer askUserId) {
        this.askUserId = askUserId;
    }

}
