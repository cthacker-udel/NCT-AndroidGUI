package com.example.nctai_trading.bittrexV2;

public class BittrexClient extends BittrexRestAPI{

    BittrexKeys authKeys;
    BittrexAuth authMethods;


    public BittrexClient(){
        authMethods = new BittrexAuth();
    }

    public BittrexClient(String apiKey, String secretKey){
        authKeys = new BittrexKeys(apiKey,secretKey);
        authMethods = new BittrexAuth();
    }

    public BittrexKeys getAuthKeys() {
        return authKeys;
    }

    public BittrexAuth getAuthMethods() {
        return authMethods;
    }
}
