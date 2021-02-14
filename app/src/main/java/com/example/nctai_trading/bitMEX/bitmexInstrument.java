package com.example.nctai_trading.bitMEX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bitmexInstrument {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("rootSymbol")
    @Expose
    private String rootSymbol;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("typ")
    @Expose
    private String typ;
    @SerializedName("listing")
    @Expose
    private String listing;
    @SerializedName("front")
    @Expose
    private String front;
    @SerializedName("expiry")
    @Expose
    private String expiry;
    @SerializedName("settle")
    @Expose
    private String settle;
    @SerializedName("listedSettle")
    @Expose
    private String listedSettle;
    @SerializedName("relistInterval")
    @Expose
    private String relistInterval;
    @SerializedName("inverseLeg")
    @Expose
    private String inverseLeg;
    @SerializedName("sellLeg")
    @Expose
    private String sellLeg;
    @SerializedName("buyLeg")
    @Expose
    private String buyLeg;
    @SerializedName("optionStrikePcnt")
    @Expose
    private Double optionStrikePcnt;
    @SerializedName("optionStrikeRound")
    @Expose
    private Double optionStrikeRound;
    @SerializedName("optionStrikePrice")
    @Expose
    private Double optionStrikePrice;
    @SerializedName("optionMultiplier")
    @Expose
    private Double optionMultiplier;
    @SerializedName("positionCurrency")
    @Expose
    private String positionCurrency;
    @SerializedName("underlying")
    @Expose
    private String underlying;
    @SerializedName("quoteCurrency")
    @Expose
    private String quoteCurrency;
    @SerializedName("underlyingSymbol")
    @Expose
    private String underlyingSymbol;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("referenceSymbol")
    @Expose
    private String referenceSymbol;
    @SerializedName("calcInterval")
    @Expose
    private String calcInterval;
    @SerializedName("publishInterval")
    @Expose
    private String publishInterval;
    @SerializedName("publishTime")
    @Expose
    private String publishTime;
    @SerializedName("maxOrderQty")
    @Expose
    private Double maxOrderQty;
    @SerializedName("maxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("lotSize")
    @Expose
    private Double lotSize;
    @SerializedName("tickSize")
    @Expose
    private Double tickSize;
    @SerializedName("multiplier")
    @Expose
    private Double multiplier;
    @SerializedName("settlCurrency")
    @Expose
    private String settlCurrency;
    @SerializedName("underlyingToPositionMultiplier")
    @Expose
    private Double underlyingToPositionMultiplier;
    @SerializedName("underlyingToSettleMultiplier")
    @Expose
    private Double underlyingToSettleMultiplier;
    @SerializedName("quoteToSettleMultiplier")
    @Expose
    private Double quoteToSettleMultiplier;
    @SerializedName("isQuanto")
    @Expose
    private Boolean isQuanto;
    @SerializedName("isInverse")
    @Expose
    private Boolean isInverse;
    @SerializedName("initMargin")
    @Expose
    private Double initMargin;
    @SerializedName("maintMargin")
    @Expose
    private Double maintMargin;
    @SerializedName("riskLimit")
    @Expose
    private Double riskLimit;
    @SerializedName("riskStep")
    @Expose
    private Double riskStep;
    @SerializedName("limit")
    @Expose
    private Double limit;
    @SerializedName("capped")
    @Expose
    private Boolean capped;
    @SerializedName("taxed")
    @Expose
    private Boolean taxed;
    @SerializedName("deleverage")
    @Expose
    private Boolean deleverage;
    @SerializedName("makerFee")
    @Expose
    private Double makerFee;
    @SerializedName("takerFee")
    @Expose
    private Double takerFee;
    @SerializedName("settlementFee")
    @Expose
    private Double settlementFee;
    @SerializedName("insuranceFee")
    @Expose
    private Double insuranceFee;
    @SerializedName("fundingBaseSymbol")
    @Expose
    private String fundingBaseSymbol;
    @SerializedName("fundingQuoteSymbol")
    @Expose
    private String fundingQuoteSymbol;
    @SerializedName("fundingPremiumSymbol")
    @Expose
    private String fundingPremiumSymbol;
    @SerializedName("fundingTimestamp")
    @Expose
    private String fundingTimestamp;
    @SerializedName("fundingInterval")
    @Expose
    private String fundingInterval;
    @SerializedName("fundingRate")
    @Expose
    private Double fundingRate;
    @SerializedName("indicativeFundingRate")
    @Expose
    private Double indicativeFundingRate;
    @SerializedName("rebalanceTimestamp")
    @Expose
    private String rebalanceTimestamp;
    @SerializedName("rebalanceInterval")
    @Expose
    private String rebalanceInterval;
    @SerializedName("openingTimestamp")
    @Expose
    private String openingTimestamp;
    @SerializedName("closingTimestamp")
    @Expose
    private String closingTimestamp;
    @SerializedName("sessionInterval")
    @Expose
    private String sessionInterval;
    @SerializedName("prevClosePrice")
    @Expose
    private Double prevClosePrice;
    @SerializedName("limitDownPrice")
    @Expose
    private Double limitDownPrice;
    @SerializedName("limitUpPrice")
    @Expose
    private Double limitUpPrice;
    @SerializedName("bankruptLimitDownPrice")
    @Expose
    private Double bankruptLimitDownPrice;
    @SerializedName("bankruptLimitUpPrice")
    @Expose
    private Double bankruptLimitUpPrice;
    @SerializedName("prevTotalVolume")
    @Expose
    private Double prevTotalVolume;
    @SerializedName("totalVolume")
    @Expose
    private Double totalVolume;
    @SerializedName("volume")
    @Expose
    private Double volume;
    @SerializedName("volume24h")
    @Expose
    private Double volume24h;
    @SerializedName("prevTotalTurnover")
    @Expose
    private Double prevTotalTurnover;
    @SerializedName("totalTurnover")
    @Expose
    private Double totalTurnover;
    @SerializedName("turnover")
    @Expose
    private Double turnover;
    @SerializedName("turnover24h")
    @Expose
    private Double turnover24h;
    @SerializedName("homeNotional24h")
    @Expose
    private Double homeNotional24h;
    @SerializedName("foreignNotional24h")
    @Expose
    private Double foreignNotional24h;
    @SerializedName("prevPrice24h")
    @Expose
    private Double prevPrice24h;
    @SerializedName("vwap")
    @Expose
    private Double vwap;
    @SerializedName("highPrice")
    @Expose
    private Double highPrice;
    @SerializedName("lowPrice")
    @Expose
    private Double lowPrice;
    @SerializedName("lastPrice")
    @Expose
    private Double lastPrice;
    @SerializedName("lastPriceProtected")
    @Expose
    private Double lastPriceProtected;
    @SerializedName("lastTickDirection")
    @Expose
    private String lastTickDirection;
    @SerializedName("lastChangePcnt")
    @Expose
    private Double lastChangePcnt;
    @SerializedName("bidPrice")
    @Expose
    private Double bidPrice;
    @SerializedName("midPrice")
    @Expose
    private Double midPrice;
    @SerializedName("askPrice")
    @Expose
    private Double askPrice;
    @SerializedName("impactBidPrice")
    @Expose
    private Double impactBidPrice;
    @SerializedName("impactMidPrice")
    @Expose
    private Double impactMidPrice;
    @SerializedName("impactAskPrice")
    @Expose
    private Double impactAskPrice;
    @SerializedName("hasLiquidity")
    @Expose
    private Boolean hasLiquidity;
    @SerializedName("openInterest")
    @Expose
    private Double openInterest;
    @SerializedName("openValue")
    @Expose
    private Double openValue;
    @SerializedName("fairMethod")
    @Expose
    private String fairMethod;
    @SerializedName("fairBasisRate")
    @Expose
    private Double fairBasisRate;
    @SerializedName("fairBasis")
    @Expose
    private Double fairBasis;
    @SerializedName("fairPrice")
    @Expose
    private Double fairPrice;
    @SerializedName("markMethod")
    @Expose
    private String markMethod;
    @SerializedName("markPrice")
    @Expose
    private Double markPrice;
    @SerializedName("indicativeTaxRate")
    @Expose
    private Double indicativeTaxRate;
    @SerializedName("indicativeSettlePrice")
    @Expose
    private Double indicativeSettlePrice;
    @SerializedName("optionUnderlyingPrice")
    @Expose
    private Double optionUnderlyingPrice;
    @SerializedName("settledPriceAdjustmentRate")
    @Expose
    private Double settledPriceAdjustmentRate;
    @SerializedName("settledPrice")
    @Expose
    private Double settledPrice;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRootSymbol() {
        return rootSymbol;
    }

    public void setRootSymbol(String rootSymbol) {
        this.rootSymbol = rootSymbol;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getSettle() {
        return settle;
    }

    public void setSettle(String settle) {
        this.settle = settle;
    }

    public String getListedSettle() {
        return listedSettle;
    }

    public void setListedSettle(String listedSettle) {
        this.listedSettle = listedSettle;
    }

    public String getRelistInterval() {
        return relistInterval;
    }

    public void setRelistInterval(String relistInterval) {
        this.relistInterval = relistInterval;
    }

    public String getInverseLeg() {
        return inverseLeg;
    }

    public void setInverseLeg(String inverseLeg) {
        this.inverseLeg = inverseLeg;
    }

    public String getSellLeg() {
        return sellLeg;
    }

    public void setSellLeg(String sellLeg) {
        this.sellLeg = sellLeg;
    }

    public String getBuyLeg() {
        return buyLeg;
    }

    public void setBuyLeg(String buyLeg) {
        this.buyLeg = buyLeg;
    }

    public Double getOptionStrikePcnt() {
        return optionStrikePcnt;
    }

    public void setOptionStrikePcnt(Double optionStrikePcnt) {
        this.optionStrikePcnt = optionStrikePcnt;
    }

    public Double getOptionStrikeRound() {
        return optionStrikeRound;
    }

    public void setOptionStrikeRound(Double optionStrikeRound) {
        this.optionStrikeRound = optionStrikeRound;
    }

    public Double getOptionStrikePrice() {
        return optionStrikePrice;
    }

    public void setOptionStrikePrice(Double optionStrikePrice) {
        this.optionStrikePrice = optionStrikePrice;
    }

    public Double getOptionMultiplier() {
        return optionMultiplier;
    }

    public void setOptionMultiplier(Double optionMultiplier) {
        this.optionMultiplier = optionMultiplier;
    }

    public String getPositionCurrency() {
        return positionCurrency;
    }

    public void setPositionCurrency(String positionCurrency) {
        this.positionCurrency = positionCurrency;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public String getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    public void setUnderlyingSymbol(String underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceSymbol() {
        return referenceSymbol;
    }

    public void setReferenceSymbol(String referenceSymbol) {
        this.referenceSymbol = referenceSymbol;
    }

    public String getCalcInterval() {
        return calcInterval;
    }

    public void setCalcInterval(String calcInterval) {
        this.calcInterval = calcInterval;
    }

    public String getPublishInterval() {
        return publishInterval;
    }

    public void setPublishInterval(String publishInterval) {
        this.publishInterval = publishInterval;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Double getMaxOrderQty() {
        return maxOrderQty;
    }

    public void setMaxOrderQty(Double maxOrderQty) {
        this.maxOrderQty = maxOrderQty;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getLotSize() {
        return lotSize;
    }

    public void setLotSize(Double lotSize) {
        this.lotSize = lotSize;
    }

    public Double getTickSize() {
        return tickSize;
    }

    public void setTickSize(Double tickSize) {
        this.tickSize = tickSize;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public String getSettlCurrency() {
        return settlCurrency;
    }

    public void setSettlCurrency(String settlCurrency) {
        this.settlCurrency = settlCurrency;
    }

    public Double getUnderlyingToPositionMultiplier() {
        return underlyingToPositionMultiplier;
    }

    public void setUnderlyingToPositionMultiplier(Double underlyingToPositionMultiplier) {
        this.underlyingToPositionMultiplier = underlyingToPositionMultiplier;
    }

    public Double getUnderlyingToSettleMultiplier() {
        return underlyingToSettleMultiplier;
    }

    public void setUnderlyingToSettleMultiplier(Double underlyingToSettleMultiplier) {
        this.underlyingToSettleMultiplier = underlyingToSettleMultiplier;
    }

    public Double getQuoteToSettleMultiplier() {
        return quoteToSettleMultiplier;
    }

    public void setQuoteToSettleMultiplier(Double quoteToSettleMultiplier) {
        this.quoteToSettleMultiplier = quoteToSettleMultiplier;
    }

    public Boolean getIsQuanto() {
        return isQuanto;
    }

    public void setIsQuanto(Boolean isQuanto) {
        this.isQuanto = isQuanto;
    }

    public Boolean getIsInverse() {
        return isInverse;
    }

    public void setIsInverse(Boolean isInverse) {
        this.isInverse = isInverse;
    }

    public Double getInitMargin() {
        return initMargin;
    }

    public void setInitMargin(Double initMargin) {
        this.initMargin = initMargin;
    }

    public Double getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(Double maintMargin) {
        this.maintMargin = maintMargin;
    }

    public Double getRiskLimit() {
        return riskLimit;
    }

    public void setRiskLimit(Double riskLimit) {
        this.riskLimit = riskLimit;
    }

    public Double getRiskStep() {
        return riskStep;
    }

    public void setRiskStep(Double riskStep) {
        this.riskStep = riskStep;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Boolean getCapped() {
        return capped;
    }

    public void setCapped(Boolean capped) {
        this.capped = capped;
    }

    public Boolean getTaxed() {
        return taxed;
    }

    public void setTaxed(Boolean taxed) {
        this.taxed = taxed;
    }

    public Boolean getDeleverage() {
        return deleverage;
    }

    public void setDeleverage(Boolean deleverage) {
        this.deleverage = deleverage;
    }

    public Double getMakerFee() {
        return makerFee;
    }

    public void setMakerFee(Double makerFee) {
        this.makerFee = makerFee;
    }

    public Double getTakerFee() {
        return takerFee;
    }

    public void setTakerFee(Double takerFee) {
        this.takerFee = takerFee;
    }

    public Double getSettlementFee() {
        return settlementFee;
    }

    public void setSettlementFee(Double settlementFee) {
        this.settlementFee = settlementFee;
    }

    public Double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public String getFundingBaseSymbol() {
        return fundingBaseSymbol;
    }

    public void setFundingBaseSymbol(String fundingBaseSymbol) {
        this.fundingBaseSymbol = fundingBaseSymbol;
    }

    public String getFundingQuoteSymbol() {
        return fundingQuoteSymbol;
    }

    public void setFundingQuoteSymbol(String fundingQuoteSymbol) {
        this.fundingQuoteSymbol = fundingQuoteSymbol;
    }

    public String getFundingPremiumSymbol() {
        return fundingPremiumSymbol;
    }

    public void setFundingPremiumSymbol(String fundingPremiumSymbol) {
        this.fundingPremiumSymbol = fundingPremiumSymbol;
    }

    public String getFundingTimestamp() {
        return fundingTimestamp;
    }

    public void setFundingTimestamp(String fundingTimestamp) {
        this.fundingTimestamp = fundingTimestamp;
    }

    public String getFundingInterval() {
        return fundingInterval;
    }

    public void setFundingInterval(String fundingInterval) {
        this.fundingInterval = fundingInterval;
    }

    public Double getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(Double fundingRate) {
        this.fundingRate = fundingRate;
    }

    public Double getIndicativeFundingRate() {
        return indicativeFundingRate;
    }

    public void setIndicativeFundingRate(Double indicativeFundingRate) {
        this.indicativeFundingRate = indicativeFundingRate;
    }

    public String getRebalanceTimestamp() {
        return rebalanceTimestamp;
    }

    public void setRebalanceTimestamp(String rebalanceTimestamp) {
        this.rebalanceTimestamp = rebalanceTimestamp;
    }

    public String getRebalanceInterval() {
        return rebalanceInterval;
    }

    public void setRebalanceInterval(String rebalanceInterval) {
        this.rebalanceInterval = rebalanceInterval;
    }

    public String getOpeningTimestamp() {
        return openingTimestamp;
    }

    public void setOpeningTimestamp(String openingTimestamp) {
        this.openingTimestamp = openingTimestamp;
    }

    public String getClosingTimestamp() {
        return closingTimestamp;
    }

    public void setClosingTimestamp(String closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public String getSessionInterval() {
        return sessionInterval;
    }

    public void setSessionInterval(String sessionInterval) {
        this.sessionInterval = sessionInterval;
    }

    public Double getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(Double prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public Double getLimitDownPrice() {
        return limitDownPrice;
    }

    public void setLimitDownPrice(Double limitDownPrice) {
        this.limitDownPrice = limitDownPrice;
    }

    public Double getLimitUpPrice() {
        return limitUpPrice;
    }

    public void setLimitUpPrice(Double limitUpPrice) {
        this.limitUpPrice = limitUpPrice;
    }

    public Double getBankruptLimitDownPrice() {
        return bankruptLimitDownPrice;
    }

    public void setBankruptLimitDownPrice(Double bankruptLimitDownPrice) {
        this.bankruptLimitDownPrice = bankruptLimitDownPrice;
    }

    public Double getBankruptLimitUpPrice() {
        return bankruptLimitUpPrice;
    }

    public void setBankruptLimitUpPrice(Double bankruptLimitUpPrice) {
        this.bankruptLimitUpPrice = bankruptLimitUpPrice;
    }

    public Double getPrevTotalVolume() {
        return prevTotalVolume;
    }

    public void setPrevTotalVolume(Double prevTotalVolume) {
        this.prevTotalVolume = prevTotalVolume;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Double volume24h) {
        this.volume24h = volume24h;
    }

    public Double getPrevTotalTurnover() {
        return prevTotalTurnover;
    }

    public void setPrevTotalTurnover(Double prevTotalTurnover) {
        this.prevTotalTurnover = prevTotalTurnover;
    }

    public Double getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(Double totalTurnover) {
        this.totalTurnover = totalTurnover;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getTurnover24h() {
        return turnover24h;
    }

    public void setTurnover24h(Double turnover24h) {
        this.turnover24h = turnover24h;
    }

    public Double getHomeNotional24h() {
        return homeNotional24h;
    }

    public void setHomeNotional24h(Double homeNotional24h) {
        this.homeNotional24h = homeNotional24h;
    }

    public Double getForeignNotional24h() {
        return foreignNotional24h;
    }

    public void setForeignNotional24h(Double foreignNotional24h) {
        this.foreignNotional24h = foreignNotional24h;
    }

    public Double getPrevPrice24h() {
        return prevPrice24h;
    }

    public void setPrevPrice24h(Double prevPrice24h) {
        this.prevPrice24h = prevPrice24h;
    }

    public Double getVwap() {
        return vwap;
    }

    public void setVwap(Double vwap) {
        this.vwap = vwap;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getLastPriceProtected() {
        return lastPriceProtected;
    }

    public void setLastPriceProtected(Double lastPriceProtected) {
        this.lastPriceProtected = lastPriceProtected;
    }

    public String getLastTickDirection() {
        return lastTickDirection;
    }

    public void setLastTickDirection(String lastTickDirection) {
        this.lastTickDirection = lastTickDirection;
    }

    public Double getLastChangePcnt() {
        return lastChangePcnt;
    }

    public void setLastChangePcnt(Double lastChangePcnt) {
        this.lastChangePcnt = lastChangePcnt;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getMidPrice() {
        return midPrice;
    }

    public void setMidPrice(Double midPrice) {
        this.midPrice = midPrice;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Double getImpactBidPrice() {
        return impactBidPrice;
    }

    public void setImpactBidPrice(Double impactBidPrice) {
        this.impactBidPrice = impactBidPrice;
    }

    public Double getImpactMidPrice() {
        return impactMidPrice;
    }

    public void setImpactMidPrice(Double impactMidPrice) {
        this.impactMidPrice = impactMidPrice;
    }

    public Double getImpactAskPrice() {
        return impactAskPrice;
    }

    public void setImpactAskPrice(Double impactAskPrice) {
        this.impactAskPrice = impactAskPrice;
    }

    public Boolean getHasLiquidity() {
        return hasLiquidity;
    }

    public void setHasLiquidity(Boolean hasLiquidity) {
        this.hasLiquidity = hasLiquidity;
    }

    public Double getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(Double openInterest) {
        this.openInterest = openInterest;
    }

    public Double getOpenValue() {
        return openValue;
    }

    public void setOpenValue(Double openValue) {
        this.openValue = openValue;
    }

    public String getFairMethod() {
        return fairMethod;
    }

    public void setFairMethod(String fairMethod) {
        this.fairMethod = fairMethod;
    }

    public Double getFairBasisRate() {
        return fairBasisRate;
    }

    public void setFairBasisRate(Double fairBasisRate) {
        this.fairBasisRate = fairBasisRate;
    }

    public Double getFairBasis() {
        return fairBasis;
    }

    public void setFairBasis(Double fairBasis) {
        this.fairBasis = fairBasis;
    }

    public Double getFairPrice() {
        return fairPrice;
    }

    public void setFairPrice(Double fairPrice) {
        this.fairPrice = fairPrice;
    }

    public String getMarkMethod() {
        return markMethod;
    }

    public void setMarkMethod(String markMethod) {
        this.markMethod = markMethod;
    }

    public Double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }

    public Double getIndicativeTaxRate() {
        return indicativeTaxRate;
    }

    public void setIndicativeTaxRate(Double indicativeTaxRate) {
        this.indicativeTaxRate = indicativeTaxRate;
    }

    public Double getIndicativeSettlePrice() {
        return indicativeSettlePrice;
    }

    public void setIndicativeSettlePrice(Double indicativeSettlePrice) {
        this.indicativeSettlePrice = indicativeSettlePrice;
    }

    public Double getOptionUnderlyingPrice() {
        return optionUnderlyingPrice;
    }

    public void setOptionUnderlyingPrice(Double optionUnderlyingPrice) {
        this.optionUnderlyingPrice = optionUnderlyingPrice;
    }

    public Double getSettledPriceAdjustmentRate() {
        return settledPriceAdjustmentRate;
    }

    public void setSettledPriceAdjustmentRate(Double settledPriceAdjustmentRate) {
        this.settledPriceAdjustmentRate = settledPriceAdjustmentRate;
    }

    public Double getSettledPrice() {
        return settledPrice;
    }

    public void setSettledPrice(Double settledPrice) {
        this.settledPrice = settledPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
