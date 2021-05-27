package com.example.nctai_trading.binanceUS.Client;

public class BinanceClientKeys extends BinanceClient {

    private String apiKey;
    private String secretKey;

    public BinanceClientKeys(){
        this.apiKey = "defaultApiKey";
        this.secretKey = "defaultSecretKey";
    }

    public BinanceClientKeys(String newApiKey, String newSecretKey){
        this.apiKey = newApiKey;
        this.secretKey = newSecretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
