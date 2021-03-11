package com.example.nctai_trading.bidesk.domain.general;

public enum TradeType {

    TOKEN("token"),
    OPTIONS("options"),
    CONTRACTS("contracts");

    private final String value;

    TradeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
