package com.example.nctai_trading.adminMethods;

import com.example.nctai_trading.alpaca.alpacaMethods;
import com.example.nctai_trading.basefex.basefexMethods;
import com.example.nctai_trading.bibox.BiBoxHttpClient;
import com.example.nctai_trading.bibox.BiBoxHttpClientConfig;

import java.util.ArrayList;

public class exchangesList {

    public ArrayList<String> exchangesList = new ArrayList<>();



    public ArrayList<String> getExchangesList(){

        exchangesList.add("alpaca");
        exchangesList.add("basefex");
        exchangesList.add("bibox");
        exchangesList.add("bidesk");
        exchangesList.add("bilaxy");
        exchangesList.add("binance");
        exchangesList.add("binanceUS");
        exchangesList.add("bitcoincom");
        exchangesList.add("bitforex");
        exchangesList.add("bithumb");
        exchangesList.add("bitMEX");
        exchangesList.add("bitrue");
        exchangesList.add("bittrex");
        exchangesList.add("bkex");
        exchangesList.add("btse");
        exchangesList.add("bybit");
        exchangesList.add("coinBase");
        exchangesList.add("digifinex");
        exchangesList.add("huobi");
        exchangesList.add("idcm");
        exchangesList.add("interactiveBrokers");
        exchangesList.add("kite");
        exchangesList.add("kraken");
        exchangesList.add("wbf");
        return exchangesList;

    }

}
