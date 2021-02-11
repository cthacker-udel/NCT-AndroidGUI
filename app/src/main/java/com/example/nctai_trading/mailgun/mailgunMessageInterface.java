package com.example.nctai_trading.mailgun;

import android.database.Observable;

import org.spongycastle.asn1.ocsp.ResponseData;

import java.util.Map;

import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface mailgunMessageInterface {

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST("https://api.mailgun.net/v3/sales.nextcapitaltech.com/messages")
    Call<mailgunMessageResponse> sendMessage(@Header("Authorization") String apiKey, @Field("from") String from, @Field("to") String to, @Field("subject") String subject, @Field("text") String text);

}
