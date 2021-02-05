package com.example.nctai_trading.squareSDK;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import sqip.Call;
import sqip.Callback;

public class ChargeCall implements Call<ChargeResult> {

    public static class Factory{
        private final ChargeService service;
        private final Converter<ResponseBody,ChargeService.ChargeErrorResponse> errorConverter;


        public Factory(Retrofit retrofit){
            service = retrofit.create(ChargeService.class);
            Annotation[] noAnnotations = {};
            Type errorResponseType = ChargeService.ChargeErrorResponse.class;
            errorConverter = retrofit.responseBodyConverter(errorResponseType,noAnnotations);
        }

        public Call<ChargeResult> create(String nonce){
            return new ChargeCall(this,nonce);
        }

    }

    private final ChargeCall.Factory factory;
    private final String nonce;
    private final retrofit2.Call<Void> call;


    private ChargeCall(ChargeCall.Factory factory, String nonce){
        this.factory = factory;
        this.nonce = nonce;
        call = factory.service.charge(new ChargeService.ChargeRequest(nonce));
    }

    @Override
    public void cancel() {
        call.cancel();
    }

    @NotNull
    @Override
    public Call<ChargeResult> clone() {
        return factory.create(nonce);
    }

    @Override
    public void enqueue(@NotNull Callback<ChargeResult> callback) {
        call.enqueue(new retrofit2.Callback<Void>() {
            @Override
            public void onResponse(retrofit2.Call<Void> call, Response<Void> response) {
                callback.onResult(responseToResult(response));
            }

            @Override
            public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                if(t instanceof IOException){
                    callback.onResult(ChargeResult.networkError());
                }
                else{
                    throw new RuntimeException("Unexpected exception");
                }
            }
        });
    }

    @Override
    public ChargeResult execute() {
        Response<Void> response;
        try{
            response = call.execute();
        }
        catch(IOException e){
            return ChargeResult.networkError();
        }
        return responseToResult(response);
    }

    @Override
    public boolean isCanceled() {
        return call.isCanceled();
    }

    @Override
    public boolean isExecuted() {
        return call.isExecuted();
    }

    private ChargeResult responseToResult(Response<Void> response){
        if(response.isSuccessful()){
            return ChargeResult.success();
        }
        try{
            ResponseBody errorBody = response.errorBody();
            ChargeService.ChargeErrorResponse errorResponse = factory.errorConverter.convert(errorBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ChargeResult.networkError();
    }

}
