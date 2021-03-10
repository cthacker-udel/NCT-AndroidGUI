package com.example.nctai_trading.bibox;

public enum AccountTypeEnum
{
    //0 现货
    MAIN(0),

    //1 信用账户
    CREDIT(1),

    //2 合约账户
    CONTRACT(2);

    int flag;

    AccountTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
