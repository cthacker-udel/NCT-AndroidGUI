package com.example.nctai_trading.kiteConnect;

public class NetworkException extends KiteException {

    // initialize Kite Network exception and call Base Exception constructor
    public NetworkException(String message, int code){
        super(message, code);
    }
}
