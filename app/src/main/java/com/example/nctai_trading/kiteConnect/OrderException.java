package com.example.nctai_trading.kiteConnect;

public class OrderException extends KiteException {

    // initialize Order Exception and call base exception constructor
    public OrderException(String message, int code){
        super(message, code);
    }
}
