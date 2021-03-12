package com.example.nctai_trading.bittrex;

public interface InvocationResult<T> {
    void complete(T result);
}
