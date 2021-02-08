package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.square.models.Customer;

import java.util.List;

public class particleProductCustomerList {

    @SerializedName("customers")
    @Expose
    private List<particleProductCustomerListCustomer> customers = null;
    @SerializedName("devices")
    @Expose
    private List<particleProductCustomerListDevice> devices = null;
    @SerializedName("meta")
    @Expose
    private particleProductCustomerListMeta meta;

    public List<particleProductCustomerListCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<particleProductCustomerListCustomer> customers) {
        this.customers = customers;
    }

    public List<particleProductCustomerListDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<particleProductCustomerListDevice> devices) {
        this.devices = devices;
    }

    public particleProductCustomerListMeta getMeta() {
        return meta;
    }

    public void setMeta(particleProductCustomerListMeta meta) {
        this.meta = meta;
    }

}
