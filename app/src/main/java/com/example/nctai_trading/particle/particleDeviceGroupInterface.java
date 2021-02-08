package com.example.nctai_trading.particle;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface particleDeviceGroupInterface {

    @GET("https://api.particle.io/v1/products/{productId}/groups/{groupName}")
    Call<particleGetDeviceGroup> getDeviceGroup(@Path("productId") String productId, @Path("groupName") String groupName, @QueryMap Map<String,String> queryMap);

    @GET("https://api.particle.io/v1/products/{productId}/groups")
    Call<List<particleDeviceGroupList>> getDeviceGroupList(@Path("productId") String productId, @QueryMap Map<String,String> queryMap);

    @POST("https://api.particle.io/v1/products/{productId}")
    Call<particleGetDeviceGroup> createDeviceGroup(@Path("productId") String productId, @Body Map<String,String> body);

    @PUT("https://api.particle.io/v1/products/{productId}/groups/{groupName}")
    Call<particleGetDeviceGroup> editDeviceGroup(@Path("productId") String produtId, @Path("groupName") String groupName, @Body Map<String,String> body);

    @DELETE("https://api.particle.io/v1/products/{productId}/groups/{groupName}")
    Response delteDeviceGroup(@Path("productId") String productId, @Path("groupName") String groupName, @Body Map<String,String> body);

    @PUT("https://api.particle.io/v1/products/{productId}/devices/{deviceId}")
    Call<particleDeviceGroupAssignGroupsToDeviceResponse> assignGroupsToDevice(@Path("productId") String productId, @Path("deviceId") String deviceId,@Body Map<String,Object> body);


}
