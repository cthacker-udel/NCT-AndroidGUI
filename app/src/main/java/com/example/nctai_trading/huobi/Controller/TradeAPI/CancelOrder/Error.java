package com.example.nctai_trading.huobi.Controller.TradeAPI.CancelOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("err_code")
    @Expose
    private Integer errCode;
    @SerializedName("err_msg")
    @Expose
    private String errMsg;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
