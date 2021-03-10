package com.example.nctai_trading.bibox;

public class BorrowOrderBookParams
{
    //交易币种
    private String coinSymbol;
    //交易对
    private String pair;
    //借款数量
    private String amount;
    //借款利率
    private double interestRate;

    public String getCoinSymbol()
    {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol)
    {
        this.coinSymbol = coinSymbol;
    }

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }
}
