package com.example.nctai_trading.particle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.square.models.Customer;

import java.util.List;

public class particleProductListDeviceList {

    @SerializedName("devices")
    @Expose
    private List<particleProductListDeviceListDevice> devices = null;
    @SerializedName("customers")
    @Expose
    private List<Customer> customers = null;
    @SerializedName("meta")
    @Expose
    private particleProductListDeviceListMeta meta;

    public List<particleProductListDeviceListDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<particleProductListDeviceListDevice> devices) {
        this.devices = devices;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public particleProductListDeviceListMeta getMeta() {
        return meta;
    }

    public void setMeta(particleProductListDeviceListMeta meta) {
        this.meta = meta;
    }

}
