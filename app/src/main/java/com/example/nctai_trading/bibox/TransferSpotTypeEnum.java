package com.example.nctai_trading.bibox;

public enum TransferSpotTypeEnum
{
    COIN(0), WALLET(1);
    int flag;

    TransferSpotTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}

