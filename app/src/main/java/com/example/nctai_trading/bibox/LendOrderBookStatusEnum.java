package com.example.nctai_trading.bibox;

public enum LendOrderBookStatusEnum
{
    WAIT_DEAL(0), DEAL_PART(1), DEAL_ALL(2);
    int flag;

    LendOrderBookStatusEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
