package com.example.nctai_trading.particle;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface particleFirmwareInterface {

    @PUT("https://api.particle.io/v1/devices/{deviceId}")
    Response updateDeviceFirmware(@Path("deviceId") String deviceId);

    @GET("https://api.particle.io/v1/build_targets")
    Call<particleListFirmwareAllPlatformsResponse> listAllProductFirmware(@Body Map<String,String> body, @QueryMap Map<String,String> queryString);

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Call<particleLockProductFirmware> lockProductFirmware(@Path("productId") String productId, @Path("deviceId") String deviceId, @Query("desired_firmware_version") String desiredFirmwareVersion,
                                                          @Query("access_token") String accessToken);

    @FormUrlEncoded
    @PUT("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Call<particleLockProductFirmware> unlockProductFirmware(@Path("productId") String productId, @Path("deviceId") String deviceId, @Query("desired_firmware_version") String desiredFirmwareVersion,
                                                            @Query("access_token") String accessToken);

    @PUT("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Call<particleLockProductFirmware> markProductDevelopmentDevice(@Path("productId") String productId, @Path("deviceId") String deviceId, @Query("development") boolean value,
                                                                   @Query("access_token") String accessToken);

    @GET("https://api.particle.io/v1/products/{productId}/firmware/{version}")
    Call<particleProductFirmwareResponse> getProductFirmware(@Path("productId") String productId, @Path("version") String verison, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/products/{productId}/firmware")
    Call<List<particleProductListAllFirmwareResponse>> getAllProductFirmware(@Path("productId") String productId, @QueryMap Map<String,String> queryMap);



}
