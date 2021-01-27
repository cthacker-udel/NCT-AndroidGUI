package com.example.nctai_trading;

import java.util.HashMap;

public class currencyInfo {

    public static HashMap<String,String> currencyList(){
        HashMap<String,String> currencyList = new HashMap<>();
        currencyList.put("Bitcoin","BTC");
        currencyList.put("Ethereum","ETH");
        currencyList.put("The Graph","GRT");
        currencyList.put("1inch","1INCH");
        currencyList.put("Chainlink","LINK");
        currencyList.put("Yearn.finance","YFI");
        currencyList.put("Pax Gold","PAXG");
        currencyList.put("DFI.Money","YFII");
        currencyList.put("Maker","MKR");
        currencyList.put("Bitcoin Cash","BCH");
        currencyList.put("Aave","AAVE");
        currencyList.put("Compound","COMP");
        currencyList.put("Monero","XMR");
        currencyList.put("Litecoin","LTC");
        currencyList.put("Dash","DASH");
        currencyList.put("Kusama","KSM");
        currencyList.put("Zcash","ZEC");
        currencyList.put("Decred","DCR");
        currencyList.put("Elrond","EGLD");
        currencyList.put("Wrapped NXM","WNXM");
        currencyList.put("Binance Coin","BNB");
        currencyList.put("Horizen","ZEN");
        currencyList.put("Tellor","TRB");
        currencyList.put("Numeraire","NMR");
        currencyList.put("Neo","NEO");
        currencyList.put("Filecoin","FIL");
        currencyList.put("Balancer","BAL");
        currencyList.put("Augur","REP");
        return currencyList;
    }

}
