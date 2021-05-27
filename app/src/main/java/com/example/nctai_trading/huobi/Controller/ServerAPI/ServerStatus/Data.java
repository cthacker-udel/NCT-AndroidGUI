package com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("heartbeat")
    @Expose
    private Integer heartbeat;
    @SerializedName("estimated_recovery_time")
    @Expose
    private Object estimatedRecoveryTime;
    @SerializedName("swap_heartbeat")
    @Expose
    private Integer swapHeartbeat;
    @SerializedName("swap_estimated_recovery_time")
    @Expose
    private Object swapEstimatedRecoveryTime;
    @SerializedName("option_heartbeat")
    @Expose
    private Integer optionHeartbeat;
    @SerializedName("option_estimated_recovery_time")
    @Expose
    private Object optionEstimatedRecoveryTime;
    @SerializedName("linear_swap_heartbeat")
    @Expose
    private Integer linearSwapHeartbeat;
    @SerializedName("linear_swap_estimated_recovery_time")
    @Expose
    private Object linearSwapEstimatedRecoveryTime;

    public Integer getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public Object getEstimatedRecoveryTime() {
        return estimatedRecoveryTime;
    }

    public void setEstimatedRecoveryTime(Object estimatedRecoveryTime) {
        this.estimatedRecoveryTime = estimatedRecoveryTime;
    }

    public Integer getSwapHeartbeat() {
        return swapHeartbeat;
    }

    public void setSwapHeartbeat(Integer swapHeartbeat) {
        this.swapHeartbeat = swapHeartbeat;
    }

    public Object getSwapEstimatedRecoveryTime() {
        return swapEstimatedRecoveryTime;
    }

    public void setSwapEstimatedRecoveryTime(Object swapEstimatedRecoveryTime) {
        this.swapEstimatedRecoveryTime = swapEstimatedRecoveryTime;
    }

    public Integer getOptionHeartbeat() {
        return optionHeartbeat;
    }

    public void setOptionHeartbeat(Integer optionHeartbeat) {
        this.optionHeartbeat = optionHeartbeat;
    }

    public Object getOptionEstimatedRecoveryTime() {
        return optionEstimatedRecoveryTime;
    }

    public void setOptionEstimatedRecoveryTime(Object optionEstimatedRecoveryTime) {
        this.optionEstimatedRecoveryTime = optionEstimatedRecoveryTime;
    }

    public Integer getLinearSwapHeartbeat() {
        return linearSwapHeartbeat;
    }

    public void setLinearSwapHeartbeat(Integer linearSwapHeartbeat) {
        this.linearSwapHeartbeat = linearSwapHeartbeat;
    }

    public Object getLinearSwapEstimatedRecoveryTime() {
        return linearSwapEstimatedRecoveryTime;
    }

    public void setLinearSwapEstimatedRecoveryTime(Object linearSwapEstimatedRecoveryTime) {
        this.linearSwapEstimatedRecoveryTime = linearSwapEstimatedRecoveryTime;
    }

}
