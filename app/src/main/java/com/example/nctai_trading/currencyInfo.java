package com.example.nctai_trading;

import java.util.HashMap;
import java.util.TreeMap;

public class currencyInfo {

    TreeMap<String,String> currList = new TreeMap<>();

    public currencyInfo(){
        currList = currencyList();
    }

    public static TreeMap<String,String> currencyList(){
        TreeMap<String,String> currencyList = new TreeMap<>();
        currencyList.put("Bitcoin","BTC");
        currencyList.put("Ethereum","ETH");
        //currencyList.put("The Graph","GRT");
        //currencyList.put("1inch","1INCH");
        currencyList.put("Chainlink","LINK");
        //currencyList.put("Yearn.finance","YFI");
        currencyList.put("Pax Gold","PAXG");
        //currencyList.put("DFI.Money","YFII");
        currencyList.put("Maker","MKR");
        currencyList.put("Bitcoin Cash","BCH");
        //currencyList.put("Aave","AAVE");
        currencyList.put("Compound","COMP");
        //currencyList.put("Monero","XMR");
        currencyList.put("Litecoin","LTC");
        currencyList.put("Dash","DASH");
        //currencyList.put("Kusama","KSM");
        currencyList.put("Zcash","ZEC");
        //currencyList.put("Decred","DCR");
        currencyList.put("Elrond","EGLD");
        //currencyList.put("Wrapped NXM","WNXM");
        currencyList.put("Binance Coin","BNB");
        currencyList.put("Horizen","ZEN");
        //currencyList.put("Tellor","TRB");
        currencyList.put("Neo","NEO");
        //currencyList.put("Filecoin","FIL");
        //currencyList.put("Balancer","BAL");
        currencyList.put("Augur","REP");
        currencyList.put("Dogecoin","DOGE");
        currencyList.put("Harmony","ONE");
        currencyList.put("Orchid","OXT");
        currencyList.put("Helium","HNT");
        currencyList.put("Decentraland","MANA");
        currencyList.put("Band Protocol","BAND");
        currencyList.put("DAI","DAI");
        currencyList.put("Solana","SOL");
        currencyList.put("MIOTA","IOTA");
        currencyList.put("Storj","STORJ");
        currencyList.put("BUSD","BUSD");
        currencyList.put("Basic Attention Token","BAT");
        currencyList.put("Tezos","XTZ");
        currencyList.put("Algorand","ALGO");
        currencyList.put("Cosmos","ATOM");
        currencyList.put("ChainLink","LINK");
        currencyList.put("VeChain","VET");
        currencyList.put("0x","ZRX");
        currencyList.put("Cardano","ADA");
        currencyList.put("Stellar Lumens","XLM");
        currencyList.put("Enjin Coin","ENJ");
        currencyList.put("Zilliqa","ZIL");
        currencyList.put("Ravencoin","RVN");
        currencyList.put("Ontology","ONT");
        currencyList.put("Hedera Hashgraph","HBAR");
        currencyList.put("Matic Network","MATIC");
        currencyList.put("Augur v2","REP");
        currencyList.put("OMG Network","OMG");
        currencyList.put("NANO","NANO");
        currencyList.put("TetherUS","USDT");
        currencyList.put("Waves","WAVES");
        currencyList.put("NEO","NEO");
        currencyList.put("KyberNetwork","KNC");
        currencyList.put("VeThor Token","VTHO");
        currencyList.put("EOS","EOS");
        currencyList.put("QTUM","QTUM");
        currencyList.put("ICON","ICX");
        currencyList.put("Uniswap","UNI");

        return currencyList;

        // <-- throws exception when called
    }

}
