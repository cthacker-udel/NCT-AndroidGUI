package com.example.nctai_trading.bibox;

public enum KLinePeriodEnum
{

    MIN_1("1min"),

    MIN_3("3min"),

    MIN_5("5min"),

    MIN_15("15min"),

    MIN_30("30min"),

    HOUR_2("2hour"),

    HOUR_4("4hour"),

    HOUR_6("6hour"),

    HOUR_12("12hour"),

    DAY("day"),

    WEEK("week");

    private String period;

    KLinePeriodEnum(String period)
    {
        this.period = period;
    }

    public String getPeriod()
    {
        return period;
    }
}
