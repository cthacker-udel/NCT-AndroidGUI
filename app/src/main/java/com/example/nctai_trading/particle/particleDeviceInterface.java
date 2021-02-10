package com.example.nctai_trading.particle;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface particleDeviceInterface {


    @GET("https://api.particle.io/v1/devices")
    Call<List<particleDeviceListDevice>> getDeviceList();

    @GET("https://api.particle.io/v1/products/{productID}/devices")
    Call<particleProductListDeviceList> getProductDevices(@Path("productID") String prodcutId, @QueryMap Map<String,String> authMap);

    @POST("https://api.particle.io/v1/products/{productID}/devices")
    Call<particleDeviceImportResponse> importProductDevice(@Path("productID") String productID, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/products/{deviceId}")
    Call<particleDeviceInformation> getDeviceInformation(@Path("deviceId") String deviceId, @QueryMap Map<String,String> map);

    @GET("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Call<particleDeviceInformation> getProductDeviceInformation(@Path("productId") String productId, @Path("deviceId") String deviceId, @QueryMap Map<String,String> map);

    @PUT("https://api.particle.io/v1/devices/{deviceId}/ping")
    Call<particleDevicePingResponse> pingDevice(@Path("deviceId") String deviceId, @Body Map<String,String> map);

    @DELETE("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Response removeDevice(@Path("productId") String productId, @Path("deviceId") String deviceId, @HeaderMap Map<String,String> authMap);

    @PUT("https://api.particle.io/v1/devices/{deviceId}")
    Call<particleDeviceSignalResponse> signalDevice(@Path("deviceId") String deviceId, @Body Map<String,String> map);



}
