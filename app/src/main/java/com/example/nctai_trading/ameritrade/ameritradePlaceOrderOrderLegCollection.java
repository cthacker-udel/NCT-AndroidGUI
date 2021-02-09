package com.example.nctai_trading.ameritrade;

import java.util.HashMap;
import java.util.Map;

public class ameritradePlaceOrderOrderLegCollection {

    Map<String,Object> result = new HashMap<>();

    private String instruction;
    private long quantity;
    private Map<String,String> instrument;

    public ameritradePlaceOrderOrderLegCollection(String instruction, long quantity, Map<String,String> instrument){
        this.instruction = instruction;
        this.quantity = quantity;
        this.instrument = instrument;
        this.result.put("instruction",instruction);
        this.result.put("quantity",quantity);
        this.result.put("instrument",instrument);
    }

    public Map<String,Object> getOrderLegCollection(){

        return this.result;

    }



}
