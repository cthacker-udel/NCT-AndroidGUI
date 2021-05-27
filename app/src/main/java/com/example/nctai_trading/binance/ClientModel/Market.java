package com.example.nctai_trading.binance.ClientModel;

import Client.BinanceClient;

import java.util.HashMap;
import java.util.Map;

public class Market extends BinanceClient {

    private String symbol;
    private Integer limit;
    private Long fromId;
    private Long startTime;
    private Long endTime;
    private String interval;

    public HashMap<String,Object> generateQueries(){
        HashMap<String,Object> queries = new HashMap<String,Object>();
        if(this.symbol != null){
            queries.put("symbol",this.symbol);
        }
        if(this.limit != null){
            queries.put("limit",this.limit);
        }
        if(this.fromId != null){
            queries.put("fromId",this.fromId);
        }
        if(this.startTime != null){
            queries.put("startTime",this.startTime);
        }
        if(this.endTime != null){
            queries.put("endTime",this.endTime);
        }
        if(this.interval != null){
            queries.put("interval",this.interval);
        }
        return queries;
    }

    public void clearQueries(){
        this.symbol = null;
        this.limit = null;
        this.fromId = null;
        this.startTime = null;
        this.endTime = null;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
