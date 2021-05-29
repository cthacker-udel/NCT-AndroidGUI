package com.example.nctai_trading.bybit.openOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtFields {

    @SerializedName("o_req_num")
    @Expose
    private Integer oReqNum;
    @SerializedName("xreq_type")
    @Expose
    private String xreqType;

    public Integer getoReqNum() {
        return oReqNum;
    }

    public void setoReqNum(Integer oReqNum) {
        this.oReqNum = oReqNum;
    }

    public String getXreqType() {
        return xreqType;
    }

    public void setXreqType(String xreqType) {
        this.xreqType = xreqType;
    }

}
