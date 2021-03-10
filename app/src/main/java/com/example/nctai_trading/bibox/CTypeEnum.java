package com.example.nctai_trading.bibox;

public enum CTypeEnum
{
    OPEN(1), CLOSE(2), FORCE(3), SUB(4);
    int flag;

    CTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
