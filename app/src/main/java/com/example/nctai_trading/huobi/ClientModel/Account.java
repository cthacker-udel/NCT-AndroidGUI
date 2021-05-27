package com.example.nctai_trading.huobi.ClientModel;



import com.example.nctai_trading.huobi.Client.HuobiClient;

import java.util.TreeMap;

public class Account extends HuobiClient {

    private String valuation_asset;

    public TreeMap<String,Object> generate_queries(){

        TreeMap<String,Object> queries = new TreeMap<>();

        if(this.valuation_asset != null){
            queries.put("valuation_asset",this.valuation_asset);
        }
        return queries;
    }

    public void clearQueries(){

        this.valuation_asset =  null;

    }

}
