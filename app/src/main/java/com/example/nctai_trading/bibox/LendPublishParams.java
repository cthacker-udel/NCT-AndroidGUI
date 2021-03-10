package com.example.nctai_trading.bibox;

public class LendPublishParams
{
    //交易币种
    private String coinSymbol;
    //放款数量
    private double amount;
    //放款利率
    private Double interestRate;
    //是否开启保险	 0或1
    private Integer insurance;
    //1
    private Integer force;

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

    public Double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(Double interestRate)
    {
        this.interestRate = interestRate;
    }

    public Integer getInsurance()
    {
        return insurance;
    }

    public void setInsurance(Integer insurance)
    {
        this.insurance = insurance;
    }

    public Integer getForce()
    {
        return force;
    }

    public void setForce(Integer force)
    {
        this.force = force;
    }
}
