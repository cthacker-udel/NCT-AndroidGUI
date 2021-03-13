package com.example.nctai_trading.btse;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class btseMethods {

    //String apiKey = "275f34a3dbd1f390936be6bce69a8ffe50c04e399186cc50dc50b0b92e45fb5b";
    String secretKey = "f626e3e7a72ebdca08f964b664941d9eece308355f201eb2cb001458eb719ae0";
    String apiKey = "11641183c2aac9e895743e6b70dcc4727c52ec806dd4eb33a68b816e874a4b0f";
    //String secretKey = "c3078b36858560175bd0c7703a82e6cf264d5c9e56f7e67482ba772dd52c0095";
    String baseUrl = "https://testapi.btse.io/spot"; //https://api.btse.com/spot

    public String generateSignature(String urlPath, String timeStamp, Map<String,Object> params) throws InvalidKeyException, NoSuchAlgorithmException {
        HMAC256 hmac256 = new HMAC256();
        String jsonBody = jsonStringifyMap(params);
        return hmac256.HMAC256Algorithm(secretKey,urlPath + timeStamp + jsonBody);

    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Long generateTimestamp(){
        return Instant.now().getEpochSecond();
    }


    public class orderRequests{
        @RequiresApi(api = Build.VERSION_CODES.O)
        public btseOrderResponse placeOrder(String symbol, String side, Double size, Integer price, String type) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
            String url = baseUrl + "/api/v3.2/order/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            btseOrderInterface btseOrderInterface = retrofit.create(com.example.nctai_trading.btse.btseOrderInterface.class);


            Map<String,Object> params = new LinkedHashMap<>();
            params.put("symbol",symbol);
            params.put("side",side);
            params.put("size",size);
            params.put("price",price);
            params.put("type",type);


            Long timestamp = generateTimestamp() * 1000;

            Call<btseOrderResponse> call = btseOrderInterface.placeOrder(params,timestamp,apiKey,generateSignature("/api/v3.2/order",timestamp+"",params));

            Response<btseOrderResponse> response = call.execute();

            return response.body();


        }

    }


}
