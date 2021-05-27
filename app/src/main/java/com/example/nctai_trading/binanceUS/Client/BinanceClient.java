package com.example.nctai_trading.binanceUS.Client;


import com.example.nctai_trading.binanceUS.ClientModel.Market;
import com.example.nctai_trading.binanceUS.ClientModel.Account;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 *
 * @author - Cameron Thacker - cthacker-udel
 *
 */



public class BinanceClient extends BinanceRestAPI {

    BinanceClientKeys clientKeys;

    BinanceSignature signatureMethods;

    com.example.nctai_trading.binanceUS.ClientModel.Market market;

    com.example.nctai_trading.binanceUS.ClientModel.Account account;

    public BinanceClient(){
        super();
    }

    public BinanceClient(String newApiKey, String newSecretKey){
        super();
        this.clientKeys = new BinanceClientKeys(newApiKey,newSecretKey);
        this.signatureMethods = new BinanceSignature();
        this.market = new Market();
        this.account = new Account();
    }

    public String generateSignature(HashMap<String,Object> params) throws NoSuchAlgorithmException, InvalidKeyException {
        return this.signatureMethods.generateSignature(this.clientKeys.getSecretKey(),params);
    }

    public BinanceClientKeys getClientKeys() {
        return clientKeys;
    }

    public BinanceSignature getSignatureMethods() {
        return signatureMethods;
    }

    public Market getMarket() {
        return market;
    }

    public Account getAccount() {
        return account;
    }
}