package com.example.nctai_trading.bibox;

public class CQueryOrderPendingParams
{
    private Integer page;
    private Integer size;
    //合约符号
    private String pair;

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

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
    }
}

