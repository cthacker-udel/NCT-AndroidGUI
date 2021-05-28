package com.example.nctai_trading.bittrexV2;

public class BittrexKeys extends BittrexClient{

    private String apiKey;
    private String secretKey;

    public BittrexKeys(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
