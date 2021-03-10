package com.example.nctai_trading.bibox;

import java.util.HashMap;
import java.util.Map;

public class V2ParamsUtils
{
    public static Map<String, Object> createAssetsTransferSpotCmd(String symbol, double amount, TransferSpotTypeEnum type)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        params.put("amount", amount);
        params.put("type", type.getFlag());
        return params;
    }
}
