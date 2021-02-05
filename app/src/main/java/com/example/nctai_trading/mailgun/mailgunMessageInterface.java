package com.example.nctai_trading.mailgun;

import android.database.Observable;

import org.spongycastle.asn1.ocsp.ResponseData;

import java.util.Map;

import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface mailgunMessageInterface {

    @POST("https://api.mailgun.net/v3/sales.nextcapitaltech.com/messages")
    Call<mailgunMessageResponse> sendMessage(@HeaderMap Map<String,String> authMap, @Body Map<String,String> data);

}
