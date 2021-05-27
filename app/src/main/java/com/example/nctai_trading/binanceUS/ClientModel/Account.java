package com.example.nctai_trading.binanceUS.ClientModel;

import com.example.nctai_trading.binanceUS.Client.BinanceClient;

import java.math.BigDecimal;
import java.util.HashMap;

public class Account extends BinanceClient {

    private String symbol;
    private String side;
    private String type;
    private String timeInForce;
    private Double quantity;
    private Double quoteOrderQuantity;
    private Double price;
    private String newClientOrderId;
    private Double stopPrice;
    private Double icebergQuantity;
    private String newOrderResponseType;
    private Long receiveWindow;
    private Long timeStamp;
    private String origClientOrderId;
    private String orderId;
    private String listClientOrderId;
    private String limitClientOrderId;
    private Double limitIcebergQty;
    private String stopClientOrderId;
    private Double stopLimitPrice;
    private Double stopIcebergQty;
    private String stopLimitTimeInForce;
    private String newOrderRespType;
    private Long orderListId;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer limit;

    public HashMap<String,Object> generateQueries(){
        HashMap<String,Object> queries = new HashMap<>();
        if(this.symbol != null){
            queries.put("symbol",this.symbol);
        }
        if(this.side != null){
            queries.put("side",this.side);
        }
        if(this.type != null){
            queries.put("type",this.type);
        }
        if(this.timeInForce != null){
            queries.put("timeInForce",this.timeInForce);
        }
        if(this.quantity != null){
            queries.put("quantity",this.quantity);
        }
        if(this.quoteOrderQuantity != null){
            queries.put("quoteOrderQty",this.quoteOrderQuantity);
        }
        if(this.price != null){
            queries.put("price",this.price);
        }
        if(this.newClientOrderId != null){
            queries.put("newClientOrderId",this.newClientOrderId);
        }
        if(this.stopPrice != null){
            queries.put("stopPrice",this.stopPrice);
        }
        if(this.icebergQuantity != null){
            queries.put("icebergQty",this.icebergQuantity);
        }
        if(this.newOrderResponseType != null){
            queries.put("newOrderRespType",this.newOrderResponseType);
        }
        if(this.receiveWindow != null){
            queries.put("recvWindow",this.receiveWindow);
        }
        if(this.timeStamp != null){
            queries.put("timestamp",this.timeStamp);
        }
        if(this.orderId != null){
            queries.put("orderId",this.orderId);
        }
        if(this.origClientOrderId != null){
            queries.put("origClientOrderId",this.origClientOrderId);
        }
        if(this.listClientOrderId != null){
            queries.put("listClientOrderId",this.listClientOrderId);
        }
        if(this.limitClientOrderId != null){
            queries.put("limitClientOrderId",this.limitClientOrderId);
        }
        if(this.limitIcebergQty != null){
            queries.put("limitIcebergQty",this.limitIcebergQty);
        }
        if(this.stopClientOrderId != null){
            queries.put("stopClientOrderId",this.stopClientOrderId);
        }
        if(this.stopLimitPrice != null){
            queries.put("stopLimitPrice",this.stopLimitPrice);
        }
        if(this.stopIcebergQty != null){
            queries.put("stopIcebergQty",this.stopIcebergQty);
        }
        if(this.stopLimitTimeInForce != null){
            queries.put("stopLimitTimeInForce",this.stopLimitTimeInForce);
        }
        if(this.newOrderResponseType != null){
            queries.put("newOrderRespType",this.newOrderResponseType);
        }
        if(this.orderListId != null){
            queries.put("orderListId",this.orderListId);
        }
        if(this.startTime != null){
            queries.put("startTime",this.startTime);
        }
        if(this.endTime != null){
            queries.put("endTime",this.endTime);
        }
        if(this.fromId != null){
            queries.put("fromId",this.fromId);
        }
        if(this.limit != null){
            queries.put("limit",this.limit);
        }
        return queries;
    }

    public void clearQueries(){
        this.symbol = null;
        this.side = null;
        this.type = null;
        this.timeInForce = null;
        this.quantity = null;
        this.quoteOrderQuantity = null;
        this.price = null;
        this.newClientOrderId = null;
        this.stopPrice = null;
        this.icebergQuantity = null;
        this.newOrderResponseType = null;
        this.receiveWindow = null;
        this.timeStamp = null;
        this.origClientOrderId = null;
        this.orderId = null;
        this.listClientOrderId = null;
        this.limitClientOrderId = null;
        this.limitIcebergQty = null;
        this.stopClientOrderId = null;
        this.stopLimitPrice = null;
        this.stopIcebergQty = null;
        this.stopLimitTimeInForce = null;
        this.newOrderRespType = null;
        this.orderListId = null;
        this.startTime = null;
        this.endTime = null;
        this.fromId = null;
        this.limit = null;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public void setOrigClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getListClientOrderId() {
        return listClientOrderId;
    }

    public void setListClientOrderId(String listClientOrderId) {
        this.listClientOrderId = listClientOrderId;
    }

    public String getLimitClientOrderId() {
        return limitClientOrderId;
    }

    public void setLimitClientOrderId(String limitClientOrderId) {
        this.limitClientOrderId = limitClientOrderId;
    }

    public Double getLimitIcebergQty() {
        return limitIcebergQty;
    }

    public void setLimitIcebergQty(Double limitIcebergQty) {
        this.limitIcebergQty = limitIcebergQty;
    }

    public String getStopClientOrderId() {
        return stopClientOrderId;
    }

    public void setStopClientOrderId(String stopClientOrderId) {
        this.stopClientOrderId = stopClientOrderId;
    }

    public Double getStopLimitPrice() {
        return stopLimitPrice;
    }

    public void setStopLimitPrice(Double stopLimitPrice) {
        this.stopLimitPrice = stopLimitPrice;
    }

    public Double getStopIcebergQty() {
        return stopIcebergQty;
    }

    public void setStopIcebergQty(Double stopIcebergQty) {
        this.stopIcebergQty = stopIcebergQty;
    }

    public String getStopLimitTimeInForce() {
        return stopLimitTimeInForce;
    }

    public void setStopLimitTimeInForce(String stopLimitTimeInForce) {
        this.stopLimitTimeInForce = stopLimitTimeInForce;
    }

    public String getNewOrderRespType() {
        return newOrderRespType;
    }

    public void setNewOrderRespType(String newOrderRespType) {
        this.newOrderRespType = newOrderRespType;
    }

    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuoteOrderQuantity() {
        return quoteOrderQuantity;
    }

    public void setQuoteOrderQuantity(Double quoteOrderQuantity) {
        this.quoteOrderQuantity = quoteOrderQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNewClientOrderId() {
        return newClientOrderId;
    }

    public void setNewClientOrderId(String newClientOrderId) {
        this.newClientOrderId = newClientOrderId;
    }

    public Double getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Double stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Double getIcebergQuantity() {
        return icebergQuantity;
    }

    public void setIcebergQuantity(Double icebergQuantity) {
        this.icebergQuantity = icebergQuantity;
    }

    public String getNewOrderResponseType() {
        return newOrderResponseType;
    }

    public void setNewOrderResponseType(String newOrderResponseType) {
        this.newOrderResponseType = newOrderResponseType;
    }

    public Long getReceiveWindow() {
        return receiveWindow;
    }

    public void setReceiveWindow(Long receiveWindow) {
        this.receiveWindow = receiveWindow;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
