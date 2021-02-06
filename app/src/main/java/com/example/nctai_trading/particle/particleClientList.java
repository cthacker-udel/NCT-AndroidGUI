package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class particleClientList {

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("clients")
    @Expose
    private List<particleClientListClient> clients = null;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public List<particleClientListClient> getClients() {
        return clients;
    }

    public void setClients(List<particleClientListClient> clients) {
        this.clients = clients;
    }

}
