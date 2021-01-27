package com.example.nctai_trading;

import java.util.HashMap;

public class currencyInfo {

    public static HashMap<String,String> currencyList(){
        HashMap<String,String> currencyList = new HashMap<>();
        currencyList.put("BTC","Bitcoin");
        currencyList.put("ETH","Ethereum");
        currencyList.put("GRT","The Graph");
        currencyList.put("1INCH","1inch");
        currencyList.put("LINK","Chainlink");
        currencyList.put("YFI","Yearn.finance");
        currencyList.put("PAXG","PAX Gold");
        currencyList.put("YFII","DFI.Money");
        currencyList.put("MKR","Maker");
        currencyList.put("BCH","Bitcoin Cash");
        currencyList.put("AAVE","Aave");
        currencyList.put("COMP","Compound");
        currencyList.put("XMR","Monero");
        currencyList.put("LTC","Litecoin");
        currencyList.put("DASH","Dash");
        currencyList.put("KSM","Kusama");
        currencyList.put("ZEC","Zcash");
        currencyList.put("DCR","Decred");
        currencyList.put("EGLD","Elrond");
        currencyList.put("WNXM","Wrapped NXM");
        currencyList.put("BNB","Binance Coin");
        currencyList.put("ZEN","Horizen");
        currencyList.put("TRB","Tellor");
        currencyList.put("NMR","Numeraire");
        currencyList.put("NEO","Neo");
        currencyList.put("FIL","Filecoin");
        currencyList.put("BAL","Balancer");
        currencyList.put("REP","Augur");
        return currencyList;
    }

}
