package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class particleCreateClientResponse {

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("client")
    @Expose
    private particleCreateClientClient client;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public particleCreateClientClient getClient() {
        return client;
    }

    public void setClient(particleCreateClientClient client) {
        this.client = client;
    }

}
