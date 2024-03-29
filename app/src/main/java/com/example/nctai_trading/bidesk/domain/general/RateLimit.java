package com.example.nctai_trading.bidesk.domain.general;


import com.example.nctai_trading.bidesk.constant.BrokerConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Rate limits.
 */
public class RateLimit {

    private RateLimitType rateLimitType;

    private RateLimitInterval interval;

    private Integer limit;

    public RateLimitType getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(RateLimitType rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public RateLimitInterval getInterval() {
        return interval;
    }

    public void setInterval(RateLimitInterval interval) {
        this.interval = interval;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BrokerConstants.TO_STRING_BUILDER_STYLE)
                .append("rateLimitType", rateLimitType)
                .append("interval", interval)
                .append("limit", limit)
                .toString();
    }
}
