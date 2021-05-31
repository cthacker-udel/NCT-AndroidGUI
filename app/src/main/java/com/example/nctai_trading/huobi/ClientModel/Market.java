package com.example.nctai_trading.huobi.ClientModel;

import com.example.nctai_trading.huobi.Client.HuobiClient;

import java.util.TreeMap;

public class Market extends HuobiClient {

    private String contractCode;

    private String type;

    private String period;

    private Integer size;

    private Long from;

    private Long to;

    public TreeMap<String,Object> generateQueryParams(){

        TreeMap<String,Object> params = new TreeMap<>();
        if(this.contractCode != null){
            params.put("contract_code",this.contractCode);
        }
        if(this.type != null){
            params.put("type",this.type);
        }
        if(this.period != null){
            params.put("period",this.period);
        }
        if(this.size != null){
            params.put("size",this.size);
        }
        if(this.from != null){
            params.put("from",this.from);
        }
        if(this.to != null){
            params.put("to",this.to);
        }
        return params;
    }

    public void clearParams(){

        this.contractCode = null;
        this.type = null;
        this.period = null;
        this.size = null;
        this.from = null;
        this.to = null;

    }


}
