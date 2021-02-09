package com.example.nctai_trading.ameritrade;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ameritradeSearchInstrumentFundamentalFundamental {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("high52")
    @Expose
    private Integer high52;
    @SerializedName("low52")
    @Expose
    private Integer low52;
    @SerializedName("dividendAmount")
    @Expose
    private Integer dividendAmount;
    @SerializedName("dividendYield")
    @Expose
    private Integer dividendYield;
    @SerializedName("dividendDate")
    @Expose
    private String dividendDate;
    @SerializedName("peRatio")
    @Expose
    private Integer peRatio;
    @SerializedName("pegRatio")
    @Expose
    private Integer pegRatio;
    @SerializedName("pbRatio")
    @Expose
    private Integer pbRatio;
    @SerializedName("prRatio")
    @Expose
    private Integer prRatio;
    @SerializedName("pcfRatio")
    @Expose
    private Integer pcfRatio;
    @SerializedName("grossMarginTTM")
    @Expose
    private Integer grossMarginTTM;
    @SerializedName("grossMarginMRQ")
    @Expose
    private Integer grossMarginMRQ;
    @SerializedName("netProfitMarginTTM")
    @Expose
    private Integer netProfitMarginTTM;
    @SerializedName("netProfitMarginMRQ")
    @Expose
    private Integer netProfitMarginMRQ;
    @SerializedName("operatingMarginTTM")
    @Expose
    private Integer operatingMarginTTM;
    @SerializedName("operatingMarginMRQ")
    @Expose
    private Integer operatingMarginMRQ;
    @SerializedName("returnOnEquity")
    @Expose
    private Integer returnOnEquity;
    @SerializedName("returnOnAssets")
    @Expose
    private Integer returnOnAssets;
    @SerializedName("returnOnInvestment")
    @Expose
    private Integer returnOnInvestment;
    @SerializedName("quickRatio")
    @Expose
    private Integer quickRatio;
    @SerializedName("currentRatio")
    @Expose
    private Integer currentRatio;
    @SerializedName("interestCoverage")
    @Expose
    private Integer interestCoverage;
    @SerializedName("totalDebtToCapital")
    @Expose
    private Integer totalDebtToCapital;
    @SerializedName("ltDebtToEquity")
    @Expose
    private Integer ltDebtToEquity;
    @SerializedName("totalDebtToEquity")
    @Expose
    private Integer totalDebtToEquity;
    @SerializedName("epsTTM")
    @Expose
    private Integer epsTTM;
    @SerializedName("epsChangePercentTTM")
    @Expose
    private Integer epsChangePercentTTM;
    @SerializedName("epsChangeYear")
    @Expose
    private Integer epsChangeYear;
    @SerializedName("epsChange")
    @Expose
    private Integer epsChange;
    @SerializedName("revChangeYear")
    @Expose
    private Integer revChangeYear;
    @SerializedName("revChangeTTM")
    @Expose
    private Integer revChangeTTM;
    @SerializedName("revChangeIn")
    @Expose
    private Integer revChangeIn;
    @SerializedName("sharesOutstanding")
    @Expose
    private Integer sharesOutstanding;
    @SerializedName("marketCapFloat")
    @Expose
    private Integer marketCapFloat;
    @SerializedName("marketCap")
    @Expose
    private Integer marketCap;
    @SerializedName("bookValuePerShare")
    @Expose
    private Integer bookValuePerShare;
    @SerializedName("shortIntToFloat")
    @Expose
    private Integer shortIntToFloat;
    @SerializedName("shortIntDayToCover")
    @Expose
    private Integer shortIntDayToCover;
    @SerializedName("divGrowthRate3Year")
    @Expose
    private Integer divGrowthRate3Year;
    @SerializedName("dividendPayAmount")
    @Expose
    private Integer dividendPayAmount;
    @SerializedName("dividendPayDate")
    @Expose
    private String dividendPayDate;
    @SerializedName("beta")
    @Expose
    private Integer beta;
    @SerializedName("vol1DayAvg")
    @Expose
    private Integer vol1DayAvg;
    @SerializedName("vol10DayAvg")
    @Expose
    private Integer vol10DayAvg;
    @SerializedName("vol3MonthAvg")
    @Expose
    private Integer vol3MonthAvg;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getHigh52() {
        return high52;
    }

    public void setHigh52(Integer high52) {
        this.high52 = high52;
    }

    public Integer getLow52() {
        return low52;
    }

    public void setLow52(Integer low52) {
        this.low52 = low52;
    }

    public Integer getDividendAmount() {
        return dividendAmount;
    }

    public void setDividendAmount(Integer dividendAmount) {
        this.dividendAmount = dividendAmount;
    }

    public Integer getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(Integer dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getDividendDate() {
        return dividendDate;
    }

    public void setDividendDate(String dividendDate) {
        this.dividendDate = dividendDate;
    }

    public Integer getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Integer peRatio) {
        this.peRatio = peRatio;
    }

    public Integer getPegRatio() {
        return pegRatio;
    }

    public void setPegRatio(Integer pegRatio) {
        this.pegRatio = pegRatio;
    }

    public Integer getPbRatio() {
        return pbRatio;
    }

    public void setPbRatio(Integer pbRatio) {
        this.pbRatio = pbRatio;
    }

    public Integer getPrRatio() {
        return prRatio;
    }

    public void setPrRatio(Integer prRatio) {
        this.prRatio = prRatio;
    }

    public Integer getPcfRatio() {
        return pcfRatio;
    }

    public void setPcfRatio(Integer pcfRatio) {
        this.pcfRatio = pcfRatio;
    }

    public Integer getGrossMarginTTM() {
        return grossMarginTTM;
    }

    public void setGrossMarginTTM(Integer grossMarginTTM) {
        this.grossMarginTTM = grossMarginTTM;
    }

    public Integer getGrossMarginMRQ() {
        return grossMarginMRQ;
    }

    public void setGrossMarginMRQ(Integer grossMarginMRQ) {
        this.grossMarginMRQ = grossMarginMRQ;
    }

    public Integer getNetProfitMarginTTM() {
        return netProfitMarginTTM;
    }

    public void setNetProfitMarginTTM(Integer netProfitMarginTTM) {
        this.netProfitMarginTTM = netProfitMarginTTM;
    }

    public Integer getNetProfitMarginMRQ() {
        return netProfitMarginMRQ;
    }

    public void setNetProfitMarginMRQ(Integer netProfitMarginMRQ) {
        this.netProfitMarginMRQ = netProfitMarginMRQ;
    }

    public Integer getOperatingMarginTTM() {
        return operatingMarginTTM;
    }

    public void setOperatingMarginTTM(Integer operatingMarginTTM) {
        this.operatingMarginTTM = operatingMarginTTM;
    }

    public Integer getOperatingMarginMRQ() {
        return operatingMarginMRQ;
    }

    public void setOperatingMarginMRQ(Integer operatingMarginMRQ) {
        this.operatingMarginMRQ = operatingMarginMRQ;
    }

    public Integer getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Integer returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public Integer getReturnOnAssets() {
        return returnOnAssets;
    }

    public void setReturnOnAssets(Integer returnOnAssets) {
        this.returnOnAssets = returnOnAssets;
    }

    public Integer getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public void setReturnOnInvestment(Integer returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment;
    }

    public Integer getQuickRatio() {
        return quickRatio;
    }

    public void setQuickRatio(Integer quickRatio) {
        this.quickRatio = quickRatio;
    }

    public Integer getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(Integer currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Integer getInterestCoverage() {
        return interestCoverage;
    }

    public void setInterestCoverage(Integer interestCoverage) {
        this.interestCoverage = interestCoverage;
    }

    public Integer getTotalDebtToCapital() {
        return totalDebtToCapital;
    }

    public void setTotalDebtToCapital(Integer totalDebtToCapital) {
        this.totalDebtToCapital = totalDebtToCapital;
    }

    public Integer getLtDebtToEquity() {
        return ltDebtToEquity;
    }

    public void setLtDebtToEquity(Integer ltDebtToEquity) {
        this.ltDebtToEquity = ltDebtToEquity;
    }

    public Integer getTotalDebtToEquity() {
        return totalDebtToEquity;
    }

    public void setTotalDebtToEquity(Integer totalDebtToEquity) {
        this.totalDebtToEquity = totalDebtToEquity;
    }

    public Integer getEpsTTM() {
        return epsTTM;
    }

    public void setEpsTTM(Integer epsTTM) {
        this.epsTTM = epsTTM;
    }

    public Integer getEpsChangePercentTTM() {
        return epsChangePercentTTM;
    }

    public void setEpsChangePercentTTM(Integer epsChangePercentTTM) {
        this.epsChangePercentTTM = epsChangePercentTTM;
    }

    public Integer getEpsChangeYear() {
        return epsChangeYear;
    }

    public void setEpsChangeYear(Integer epsChangeYear) {
        this.epsChangeYear = epsChangeYear;
    }

    public Integer getEpsChange() {
        return epsChange;
    }

    public void setEpsChange(Integer epsChange) {
        this.epsChange = epsChange;
    }

    public Integer getRevChangeYear() {
        return revChangeYear;
    }

    public void setRevChangeYear(Integer revChangeYear) {
        this.revChangeYear = revChangeYear;
    }

    public Integer getRevChangeTTM() {
        return revChangeTTM;
    }

    public void setRevChangeTTM(Integer revChangeTTM) {
        this.revChangeTTM = revChangeTTM;
    }

    public Integer getRevChangeIn() {
        return revChangeIn;
    }

    public void setRevChangeIn(Integer revChangeIn) {
        this.revChangeIn = revChangeIn;
    }

    public Integer getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(Integer sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public Integer getMarketCapFloat() {
        return marketCapFloat;
    }

    public void setMarketCapFloat(Integer marketCapFloat) {
        this.marketCapFloat = marketCapFloat;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    public Integer getBookValuePerShare() {
        return bookValuePerShare;
    }

    public void setBookValuePerShare(Integer bookValuePerShare) {
        this.bookValuePerShare = bookValuePerShare;
    }

    public Integer getShortIntToFloat() {
        return shortIntToFloat;
    }

    public void setShortIntToFloat(Integer shortIntToFloat) {
        this.shortIntToFloat = shortIntToFloat;
    }

    public Integer getShortIntDayToCover() {
        return shortIntDayToCover;
    }

    public void setShortIntDayToCover(Integer shortIntDayToCover) {
        this.shortIntDayToCover = shortIntDayToCover;
    }

    public Integer getDivGrowthRate3Year() {
        return divGrowthRate3Year;
    }

    public void setDivGrowthRate3Year(Integer divGrowthRate3Year) {
        this.divGrowthRate3Year = divGrowthRate3Year;
    }

    public Integer getDividendPayAmount() {
        return dividendPayAmount;
    }

    public void setDividendPayAmount(Integer dividendPayAmount) {
        this.dividendPayAmount = dividendPayAmount;
    }

    public String getDividendPayDate() {
        return dividendPayDate;
    }

    public void setDividendPayDate(String dividendPayDate) {
        this.dividendPayDate = dividendPayDate;
    }

    public Integer getBeta() {
        return beta;
    }

    public void setBeta(Integer beta) {
        this.beta = beta;
    }

    public Integer getVol1DayAvg() {
        return vol1DayAvg;
    }

    public void setVol1DayAvg(Integer vol1DayAvg) {
        this.vol1DayAvg = vol1DayAvg;
    }

    public Integer getVol10DayAvg() {
        return vol10DayAvg;
    }

    public void setVol10DayAvg(Integer vol10DayAvg) {
        this.vol10DayAvg = vol10DayAvg;
    }

    public Integer getVol3MonthAvg() {
        return vol3MonthAvg;
    }

    public void setVol3MonthAvg(Integer vol3MonthAvg) {
        this.vol3MonthAvg = vol3MonthAvg;
    }

}
