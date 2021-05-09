package com.example.nctai_trading.bkex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.example.nctai_trading.bkex.order.placeOrderResponse;
import com.example.nctai_trading.bkex.orderHistory.orderHistoryResponse;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bkexMethods {

    String apikey = "7deb2a0c2e0801c4e3a24ba7fb2a425a01552c3d120c98b5ce054ba87b53d237";
    String secretKey = "f575bf4218d62f0f328cf61a5a514bbc4f7fca095999133954675d014a2390ac";
    String baseUrl = "https://api.bkex.com";

    public bkexMethods(String apikey, String secretKey){
        this.apikey = apikey;
        this.secretKey = secretKey;
    }

    public String getSignature(String params) throws InvalidKeyException, NoSuchAlgorithmException {
        HMAC256 hmac256 = new HMAC256();
        return hmac256.HMAC256Algorithm(secretKey,params);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateQueryString(Map<String,Object> params){

        ArrayList<String> paramList = new ArrayList<>();
        for(String eachKey: params.keySet()){
            paramList.add(String.format("%s=%s",eachKey,params.get(eachKey)));
        }
        return String.join("&",paramList);
    }



    public class exchangeRequests{

        public void getExchangeInfo(){

            String url = baseUrl + "/v1/exchangeInfo/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();




        }



    }

    public class orderRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public placeOrderResponse createOrder(String pair, Double price, Double amount) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/v1/u/trade/order/create/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bkexOrderInterface bkexOrderInterface = retrofit.create(com.example.nctai_trading.bkex.bkexOrderInterface.class);

            Map<String,Object> params = new TreeMap<>();

            params.put("pair",pair);
            params.put("price",price);
            params.put("amount",amount);

            String signature = getSignature(generateQueryString(params));

            Call<placeOrderResponse> call = bkexOrderInterface.placeOrder(params,apikey,signature);

            Response<placeOrderResponse> response = call.execute();

            return response.body();




        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public boolean cancelOrder(String pair, String orderNumber) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/v1/u/trade/order/cancel/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> params = new TreeMap<>();
            params.put("pair",pair);
            params.put("orderNo",orderNumber);

            String signature = getSignature(generateQueryString(params));

            bkexOrderInterface bkexOrderInterface = retrofit.create(com.example.nctai_trading.bkex.bkexOrderInterface.class);

            Call<Object> call = bkexOrderInterface.cancelOrder(params,apikey,signature);

            Response<Object> response = call.execute();

            return response.isSuccessful();

        }


        public orderHistoryResponse getAllFinishedOrders() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/v1/u/trade/order/history/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bkexOrderInterface bkexOrderInterface = retrofit.create(com.example.nctai_trading.bkex.bkexOrderInterface.class);

            String signature = getSignature("");

            Call<Object> call = bkexOrderInterface.getOrderHistory(apikey,signature);

            Response<Object> response = call.execute();

            return (orderHistoryResponse) response.body();


        }

        public orderHistoryResponse getAllOpenOrders() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/v1/u/trade/order/listUnfinished/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bkexOrderInterface bkexOrderInterface = retrofit.create(com.example.nctai_trading.bkex.bkexOrderInterface.class);

            String signature = getSignature("");

            Call<Object> call = bkexOrderInterface.getOpenOrders(apikey,signature);

            Response<Object> response = call.execute();

            return (orderHistoryResponse) response.body();


        }

    }



}
