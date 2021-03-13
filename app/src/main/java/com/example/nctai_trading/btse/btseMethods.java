package com.example.nctai_trading.btse;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class btseMethods {

    String apiKey = "275f34a3dbd1f390936be6bce69a8ffe50c04e399186cc50dc50b0b92e45fb5b";
    String secretKey = "c3078b36858560175bd0c7703a82e6cf264d5c9e56f7e67482ba772dd52c0095";
    String baseUrl = "https://testapi.btse.io/spot"; //https://api.btse.com/spot

    public String generateSignature(String urlPath, String timeStamp, Map<String,Object> params) throws InvalidKeyException, NoSuchAlgorithmException {
        HMAC256 hmac256 = new HMAC256();
        String jsonBody = jsonStringifyMap(params);
        return hmac256.HMAC256Algorithm(secretKey,urlPath + timeStamp + jsonBody);

    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }


    public class orderRequests{
        public void placeOrder(String side, Double size) {
            String url = baseUrl + "/api/v3.2/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

    }


}
