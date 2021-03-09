package com.example.nctai_trading.kiteConnect;

public class KiteException extends Throwable {

    // variables
    public String message;
    public int code;

    // constructor that sets the message
    public KiteException(String message){
        this.message = message;
    }

    // constructor that sets the message and code
    public KiteException(String message, int code){
        this.message = message;
        this.code = code;
    }
}
