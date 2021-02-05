package com.example.nctai_trading.mailgun;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mailgunDomainStat {

    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("resolution")
    @Expose
    private String resolution;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("stats")
    @Expose
    private List<mailgunDomainStatStats> stats = null;

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<mailgunDomainStatStats> getStats() {
        return stats;
    }

    public void setStats(List<mailgunDomainStatStats> stats) {
        this.stats = stats;
    }

}
