package com.example.nctai_trading.bibox;

public class CQueryOrderListParams
{
    //合约符号
    private String pair;
    //第几页
    private Integer page;
    //多少条
    private Integer size;
    //开始时间
    private long beginTime;
    //结束时间
    private long endTime;
    //成交类型 1开仓, 2平仓, 3爆仓, 4减仓
    CTypeEnum type;

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
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

    public long getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(long beginTime)
    {
        this.beginTime = beginTime;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public void setEndTime(long endTime)
    {
        this.endTime = endTime;
    }

    public CTypeEnum getType()
    {
        return type;
    }

    public void setType(CTypeEnum type)
    {
        this.type = type;
    }
}
