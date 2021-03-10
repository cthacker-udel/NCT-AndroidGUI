package com.example.nctai_trading.bibox;

public enum LendOrderStatusEnum
{
    WAIT_GET(0), DEAL_PART_GET(1), DEAL_ALL_GET(2);
    int flag;

    LendOrderStatusEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}

