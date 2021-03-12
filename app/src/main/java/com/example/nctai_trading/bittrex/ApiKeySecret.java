package com.example.nctai_trading.bittrex;

public class ApiKeySecret {
    
    private String key;
    private String secret;

    public ApiKeySecret(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }
}
