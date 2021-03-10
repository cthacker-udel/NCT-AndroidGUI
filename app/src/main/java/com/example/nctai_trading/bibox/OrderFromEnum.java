package com.example.nctai_trading.bibox;

public enum OrderFromEnum
{
    WEB(1), ANDROID(2), IOS(3), PC(4), SYSTEM(5), API_KEY(6);
    int flag;

    OrderFromEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}

