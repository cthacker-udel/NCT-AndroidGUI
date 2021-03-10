package com.example.nctai_trading.bibox;

public class OrderPendingListParams
{
    //交易对
    private String pair;
    //账户类型
    private AccountTypeEnum accountType;
    //交易方向
    private OrderSideEnum orderSide;
    //交易币种
    private String coinSymbol;
    //定价币种
    private String currencySymbol;
    //第几页
    private Integer page;
    //每页数量
    private Integer size;

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

    public OrderSideEnum getOrderSide()
    {
        return orderSide;
    }

    public void setOrderSide(OrderSideEnum orderSide)
    {
        this.orderSide = orderSide;
    }

    public String getCoinSymbol()
    {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol)
    {
        this.coinSymbol = coinSymbol;
    }

    public String getCurrencySymbol()
    {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol)
    {
        this.currencySymbol = currencySymbol;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }
}
