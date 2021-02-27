package com.example.nctai_trading.robinhood.http.client;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HTTPResult {
    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    private final int statusCode;
    private final Map<String, String> headers;
    private final String body;

    public HTTPResult(int theStatus, Map<String,String> theHeaders, String theBody){
        this.statusCode = theStatus;
        this.headers = theHeaders;
        this.body = theBody;
    }

    public boolean isOk() {
        return statusCode == 200;
    }
}