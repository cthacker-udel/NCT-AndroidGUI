package com.example.nctai_trading.bybit.walletFunds;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class walletFund {

    @SerializedName("ret_code")
    @Expose
    private Integer retCode;
    @SerializedName("ret_msg")
    @Expose
    private String retMsg;
    @SerializedName("ext_code")
    @Expose
    private String extCode;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("ext_info")
    @Expose
    private Object extInfo;
    @SerializedName("time_now")
    @Expose
    private String timeNow;
    @SerializedName("rate_limit_status")
    @Expose
    private Integer rateLimitStatus;
    @SerializedName("rate_limit_reset_ms")
    @Expose
    private Long rateLimitResetMs;
    @SerializedName("rate_limit")
    @Expose
    private Integer rateLimit;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Object getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Object extInfo) {
        this.extInfo = extInfo;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

    public Integer getRateLimitStatus() {
        return rateLimitStatus;
    }

    public void setRateLimitStatus(Integer rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
    }

    public Long getRateLimitResetMs() {
        return rateLimitResetMs;
    }

    public void setRateLimitResetMs(Long rateLimitResetMs) {
        this.rateLimitResetMs = rateLimitResetMs;
    }

    public Integer getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(Integer rateLimit) {
        this.rateLimit = rateLimit;
    }

}
