package com.example.nctai_trading.bibox;

public class TradeParams
{
    //交易对
    private String pair;
    //账户类型 1-信用账户
    private AccountTypeEnum accountType;
    //交易类型 2-限价单
    private OrderTypeEnum orderType;
    //交易方向 1-买，2-卖
    private OrderSideEnum orderSide;
    //委托价格
    private double price;
    //委托数量
    private double amount;
    //用户自定义随机数
    private String index;

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
    }

    public AccountTypeEnum getAccountType()
    {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType)
    {
        this.accountType = accountType;
    }

    public OrderTypeEnum getOrderType()
    {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType)
    {
        this.orderType = orderType;
    }

    public OrderSideEnum getOrderSide()
    {
        return orderSide;
    }

    public void setOrderSide(OrderSideEnum orderSide)
    {
        this.orderSide = orderSide;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getIndex()
    {
        return index;
    }

    public void setIndex(String index)
    {
        this.index = index;
    }
}
