package com.example.nctai_trading.kiteConnect;

public class DataException extends KiteException {

    // initialize 2fa exception and call constructor of Base Exception
    public DataException(String message, int code){
        super(message, code);
    }
}
