package com.example.nctai_trading.bibox;



public class CTradeOrderOpenParams
{
    //订单类型 1:市价,2:限价
    private OrderTypeEnum orderType;
    //杠杆倍数 全仓:0,逐仓:1,2,...
    private Integer leverage;
    //挂单方向 1:开多,2:开空
    private COrderSideEnum orderSide;
    //委托价格
    private String price;
    //合约张数
    private String contract;
    //合约符号
    private String pair;
    //6
    private Integer orderFrom;

    public OrderTypeEnum getOrderType()
    {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType)
    {
        this.orderType = orderType;
    }

    public Integer getLeverage()
    {
        return leverage;
    }

    public void setLeverage(Integer leverage)
    {
        this.leverage = leverage;
    }

    public COrderSideEnum getOrderSide()
    {
        return orderSide;
    }

    public void setOrderSide(COrderSideEnum orderSide)
    {
        this.orderSide = orderSide;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getContract()
    {
        return contract;
    }

    public void setContract(String contract)
    {
        this.contract = contract;
    }

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
    }

    public Integer getOrderFrom()
    {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom)
    {
        this.orderFrom = orderFrom;
    }
}

