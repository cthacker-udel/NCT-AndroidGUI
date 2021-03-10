package com.example.nctai_trading.bibox;

public enum OrderSideEnum
{

    //买
    BID(1),

    //卖
    ASK(2);

    int flag;

    OrderSideEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
