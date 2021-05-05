package com.example.nctai_trading.exante;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class exanteMethods {

    String applicationID = "2e97ef4d-ad68-46dd-ba17-3851a857c0c6";
    String access_key = "6ZxHHjl8qnRWscZubtSU";
    String baseUrl = "https://api-demo.exante.eu/";

    public exanteMethods(String apiKey, String secretKey){

    }

    public class orderRequests{

        public exanteOrderResponse placeOrder(String accountId, String instrument, String side, String quantity, String orderType, String duration) throws IOException {

            String url = baseUrl + "trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> params = new LinkedHashMap<>();
            params.put("orderType",orderType);
            params.put("side",side);
            params.put("quantity",quantity);
            params.put("duration",duration);

            exanteOrderInterface exanteOrderInterface = retrofit.create(com.example.nctai_trading.exante.exanteOrderInterface.class);

            Call<exanteOrderResponse> call = exanteOrderInterface.placeOrder(applicationID,access_key,params);

            Response<exanteOrderResponse> response = call.execute();

            return response.body();



        }



    }
}
