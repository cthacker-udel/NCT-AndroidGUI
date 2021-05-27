package com.example.nctai_trading.huobi.Client;

import com.example.nctai_trading.huobi.ClientModel.*;

public class HuobiClient extends HuobiRestAPI{

    HuobiAuth auth;
    Market market;
    Account account;
    Trade trade;

    public HuobiClient(){
        super();
    }

    public HuobiClient(String apiKey, String secretKey){
        auth = new HuobiAuth(apiKey,secretKey);
        market = new Market();
        account = new Account();
        trade = new Trade();
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public HuobiAuth getAuth() {
        return auth;
    }

    public void setAuth(HuobiAuth auth) {
        this.auth = auth;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
