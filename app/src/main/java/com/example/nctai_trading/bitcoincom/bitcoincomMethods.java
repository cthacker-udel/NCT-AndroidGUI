package com.example.nctai_trading.bitcoincom;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class bitcoincomMethods {

    String baseUrl = "https://api.exchange.bitcoin.com/api/2";
    String apiKey = "";
    String secretKey = "";
    String authHeader = String.format("Basic %s", Base64.getEncoder().encodeToString((apiKey + secretKey).getBytes()));


    public class orderRequests{

        public bitcoincomOrderResponse placeOrder(String symbol, String side, String type, Integer quantity) throws IOException {
            String url = baseUrl + "/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> params = new LinkedHashMap<>();
            params.put("symbol",symbol);
            params.put("side",side);
            params.put("quantity",quantity);
            params.put("type",type);

            bitcoincomOrderInterface bitcoincomOrderInterface = retrofit.create(com.example.nctai_trading.bitcoincom.bitcoincomOrderInterface.class);

            Call<bitcoincomOrderResponse> call = bitcoincomOrderInterface.placeOrder(authHeader,params);

            Response<bitcoincomOrderResponse> response = call.execute();

            return response.body();
        }


    }

}
