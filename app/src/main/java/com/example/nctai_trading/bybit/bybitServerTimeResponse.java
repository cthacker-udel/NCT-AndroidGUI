package com.example.nctai_trading.bybit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bybitServerTimeResponse {

    @SerializedName("ret_code")
    @Expose
    private Integer retCode;
    @SerializedName("ret_msg")
    @Expose
    private String retMsg;
    @SerializedName("ext_code")
    @Expose
    private String extCode;
    @SerializedName("ext_info")
    @Expose
    private String extInfo;
    @SerializedName("result")
    @Expose
    private bybitServerTimeResponseResult result;
    @SerializedName("time_now")
    @Expose
    private String timeNow;

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

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public bybitServerTimeResponseResult getResult() {
        return result;
    }

    public void setResult(bybitServerTimeResponseResult result) {
        this.result = result;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

}
