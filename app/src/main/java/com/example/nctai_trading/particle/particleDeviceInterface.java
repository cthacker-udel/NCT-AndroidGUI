package com.example.nctai_trading.particle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface particleDeviceInterface {

    @GET("https://api.particle.io/v1/devices")
    Call<List<particleDeviceListDevice>> getDeviceList();

}
