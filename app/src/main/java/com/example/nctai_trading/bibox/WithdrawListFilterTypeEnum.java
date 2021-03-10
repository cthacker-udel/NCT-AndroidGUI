package com.example.nctai_trading.bibox;

public enum WithdrawListFilterTypeEnum
{

    CHECK_FAIL(-2),

    USER_CANCEL(-1),

    WAIT_CHECK(0),

    CHECK_PASS(1),

    PROCESSING(2),

    FINISH(3);

    int flag;

    WithdrawListFilterTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}

