package com.example.nctai_trading.btse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class btseOrderResponse{

        @SerializedName("averageFillPrice")
        @Expose
        private Integer averageFillPrice;
        @SerializedName("clOrderID")
        @Expose
        private String clOrderID;
        @SerializedName("deviation")
        @Expose
        private Integer deviation;
        @SerializedName("fillSize")
        @Expose
        private Integer fillSize;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("orderID")
        @Expose
        private String orderID;
        @SerializedName("orderType")
        @Expose
        private Integer orderType;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("side")
        @Expose
        private String side;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("stealth")
        @Expose
        private Integer stealth;
        @SerializedName("stopPrice")
        @Expose
        private Integer stopPrice;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("timestamp")
        @Expose
        private Integer timestamp;
        @SerializedName("trigger")
        @Expose
        private Boolean trigger;
        @SerializedName("triggerPrice")
        @Expose
        private Integer triggerPrice;

        public Integer getAverageFillPrice() {
            return averageFillPrice;
        }

        public void setAverageFillPrice(Integer averageFillPrice) {
            this.averageFillPrice = averageFillPrice;
        }

        public String getClOrderID() {
            return clOrderID;
        }

        public void setClOrderID(String clOrderID) {
            this.clOrderID = clOrderID;
        }

        public Integer getDeviation() {
            return deviation;
        }

        public void setDeviation(Integer deviation) {
            this.deviation = deviation;
        }

        public Integer getFillSize() {
            return fillSize;
        }

        public void setFillSize(Integer fillSize) {
            this.fillSize = fillSize;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOrderID() {
            return orderID;
        }

        public void setOrderID(String orderID) {
            this.orderID = orderID;
        }

        public Integer getOrderType() {
            return orderType;
        }

        public void setOrderType(Integer orderType) {
            this.orderType = orderType;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getStealth() {
            return stealth;
        }

        public void setStealth(Integer stealth) {
            this.stealth = stealth;
        }

        public Integer getStopPrice() {
            return stopPrice;
        }

        public void setStopPrice(Integer stopPrice) {
            this.stopPrice = stopPrice;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Integer getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Integer timestamp) {
            this.timestamp = timestamp;
        }

        public Boolean getTrigger() {
            return trigger;
        }

        public void setTrigger(Boolean trigger) {
            this.trigger = trigger;
        }

        public Integer getTriggerPrice() {
            return triggerPrice;
        }

        public void setTriggerPrice(Integer triggerPrice) {
            this.triggerPrice = triggerPrice;
        }

}
