package com.example.nctai_trading.bibox;

public class TransferOutParams
{
    //提现币种
    private String coinSymbol;
    //提现数量
    private double amount;
    //google验证码
    private String totpCode;
    //资金密码
    private String tradePwd;
    //提现地址
    private String addr;
    //提现地址备注名称
    private String addrRemark;
    //提现标签 一些币种提现必须指定标签，与地址组合标识唯一性，比如EOS
    private String memo;

    public String getCoinSymbol()
    {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol)
    {
        this.coinSymbol = coinSymbol;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getTotpCode()
    {
        return totpCode;
    }

    public void setTotpCode(String totpCode)
    {
        this.totpCode = totpCode;
    }

    public String getTradePwd()
    {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd)
    {
        this.tradePwd = tradePwd;
    }

    public String getAddr()
    {
        return addr;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getAddrRemark()
    {
        return addrRemark;
    }

    public void setAddrRemark(String addrRemark)
    {
        this.addrRemark = addrRemark;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }
}
