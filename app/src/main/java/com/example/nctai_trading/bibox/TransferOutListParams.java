package com.example.nctai_trading.bibox;

public class TransferOutListParams
{
    //提现记录筛选
    private WithdrawListFilterTypeEnum filterType = WithdrawListFilterTypeEnum.FINISH;
    //提现币种
    private String symbol;
    //第几页
    private Integer page;
    //每页数量
    private Integer size;

    public WithdrawListFilterTypeEnum getFilterType()
    {
        return filterType;
    }

    public void setFilterType(WithdrawListFilterTypeEnum filterType)
    {
        this.filterType = filterType;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
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
