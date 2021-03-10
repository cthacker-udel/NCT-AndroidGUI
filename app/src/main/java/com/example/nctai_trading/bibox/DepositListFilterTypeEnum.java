package com.example.nctai_trading.bibox;

public enum DepositListFilterTypeEnum
{

    PROCESSING(1),

    FINISH(2),

    FAIL(3),

    ALL(0);

    int flag;

    DepositListFilterTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
